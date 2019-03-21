import java.util.Scanner;

public class cube_free {
	public static boolean[] seive;
	public static boolean checkprime(int n) {
		int c=(int)Math.pow(n, 0.5);
		for(int i=2;i<=c;i++) {
			if(n%i==0) {
			//	System.out.print(i);
				seive[n]=false;
				return false;
			}
		}
		return true;
	}
	public static void make_seive(int input){
		seive=new boolean[input+1];
		//	ArrayList<Integer> power=new ArrayList<>();
			for(int i=2;i<seive.length;i++) {
				seive[i]=true;
			}
			int n =(int)Math.pow(input, 0.5);
			for(int t=2;t<=n;t++) {
				if(seive[t]==true && checkprime(t)==true) {
					for(int k=t;k<=input;k++) {
						if(t*k<=input) {
							seive[t*k]=false;
						}
						else {break;}
					}
				}
			}}
	public static int getPower(int N,int t,int ans) {
		if(ans==3) {
			return 3;
		}
	       if(N%t!=0) {
	    	   return ans+0;
	       }
	       else {
	    	   ans++;
	    	   return getPower(N/t, t, ans);
	       }
	}
	// checks weather a number has a cubic factor
	// does not tell weather a number is cubic or not
	public static boolean cubic_check(int n) {
		make_seive(n);
		int cube_root=(int)(Math.cbrt(n));
		for(int i=2;i<=cube_root;i++) {
			if(seive[i]==true ) {
				if(getPower(n, i,0)>=3) {
				return true;}
			}
			else if(seive[i]==false) {
				continue;
			}
			else {
				
			}
			
		}
		return false;
	}
public static int get_position(int n) {
	//t denotes the no of non-cubic free numbers
	if(n==1) {
		return 1;
	}
	int t=0;
	int c_root=(int) Math.cbrt(n);
	//make_seive(c_root);
	
	for(int i=2;i<c_root;i++) {
		if(seive[i]==true) {
		//	System.out.println("fuck  i="+ i);
			int cube=(int)Math.pow(i, 3); 
			t+=(int)(n/cube);
		}
	}
	return n-t;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		for(int y=1;y<=n;y++) {
			int k=s.nextInt();
			if(cubic_check(k)==false) {
			//	System.out.println("fuck");
				System.out.println("Case "+y+":"+get_position(k));
			}
			else {
				System.out.println("Case "+y+":"+"Not Cube Free");
			}
		}

	}

}
