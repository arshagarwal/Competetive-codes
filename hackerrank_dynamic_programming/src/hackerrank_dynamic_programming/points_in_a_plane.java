package hackerrank_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;

public class points_in_a_plane {
	public static int mod=(int)Math.pow(10, 9)+7;
	public static int[] factorial=new int[17];
	public static void factorial() {
		factorial[0]=1;
       for(int i=1
    		   ;i<factorial.length;i++) {
    	   factorial[i]=((factorial[i-1]%mod)*i%mod)%mod;
       }		
	}
	public static int c(int a ,int b) {
		int ans=factorial[a];
		ans=ans/factorial[b];
		ans=ans/factorial[a-b];
		return ans;
	}
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	public static class coordinate{
		int x;
		int y;
		boolean visited=false;
		
	}
	public static int[] calculate_turns(coordinate[] points){
		ArrayList<ArrayList<coordinate>> collinear_sets=new ArrayList<>();
		for(int i=0;i<points.length;i++) {
			
			
			if(points[i].visited==true) {
				continue;
			}
			for(int j=i+1;j<points.length;j++){
				if(points[j].visited==true) {
					continue;
				}
				ArrayList<coordinate> set =new ArrayList<>();
				set.add(points[i]);
				set.add(points[j]);
			
				for(int r=0;r<points.length;r++) {
					// collinear set
				
					
					// slope of the line
					double m=points[i].y-points[j].y;
					m=m/(points[i].x-points[j].x);
					double c=points[j].y*points[i].x-points[j].x*points[i].y;
					c=c/(points[i].x-points[j].x);
					if(r==i || r==j || points[r].visited==true) {
						continue;
					}
					else {
						if(points[r].y==(m*points[r].x+c)) {
							points[i].visited=true;
							points[j].visited=true;
							set.add(points[r]);
							points[r].visited=true;
						}
						if(points[i].x==points[j].x && points[r].x==points[i].x){
							points[i].visited=true;
							points[j].visited=true;
							set.add(points[r]);
							points[r].visited=true;
						}
					}
					
				}
				if(set.size()>2) {
					collinear_sets.add(set);
				}
			}
		}
		// no of collinear sets where size of each is atleast 3
		int size=collinear_sets.size();
		// variable to count no of odd points
		int count=0;
		for(int i=0;i<points.length;i++) {
			if(points[i].visited==false) {
				ArrayList<coordinate> set =new ArrayList<>();
				set.add(points[i]);
				count++;
				collinear_sets.add(set);
			}
		}
		int T;
		int ways=1;
		double p=points.length;
		if(size==0) {
		T=(int)Math.ceil(p/2);
		 while(true) {
			 if(p<2) {break;}
			 ways=ways*c((int)p, 2);
			 p=p-2;
		 }
		 ways=((ways%mod)*factorial[T])%mod;
		}
		else {
			T=size+(int)Math.ceil((double)count/2);
			// for odd no
			if(count%2==1) {
				ways=(int)(((long)count*(int)(p-count)*factorial[T])%mod);
				int s=1;
				p=count-1;
				while(true) {
					if(p<2) {break;}
					s=s*c((int)p, 2);
					p=p-2;
				}
				ways=(int)(((long)ways*(s%mod))%mod);
				p=count;
				s=1;
				while(true) {
					if(p<2) {break;}
					s=s*c((int)p, 2);
					p=p-2;
				}
				ways=(int)(((long)(ways%mod)+(factorial[T]*(s%mod))%mod)%mod);
			}
			else {
				ways=size;
				int s=1;
				p=count;
				while(true) {
					if(p<2) {break;}
					s=s*c((int)p, 2);
					p=p-2;
				}
				ways=(int)(((long)(s%mod)*factorial[T])%mod);
			}
		}
	    int[] ans=new int[2];
	    ans[0]=T;
	    ans[1]=ways;
	    return ans;
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factorial();
		FastReader fastReader=new FastReader();
		int T =fastReader.nextInt();
		for(int i=0;i<T;i++) {
			int N=fastReader.nextInt();
			coordinate[] points=new coordinate[N];
			for(int j=0;j<N;j++) {
				points[j]=new coordinate();
				points[j].x=fastReader.nextInt();
				points[j].y=fastReader.nextInt();
			}
			int[] ans=calculate_turns(points);
			//System.out.print("test case no"+i+"  ");
			System.out.println(ans[0]+" "+ans[1]);
			
		}

	}

}
