import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class cards {
	static int k;
	static 	HashMap<Integer, Integer> factors=new HashMap<>();
	static HashMap<Integer, Integer[]> seive=new HashMap<>();
	public static boolean ispossible(int i,int j,int[] a) {
	//	System.out.println("i = "+i+" j = "+j);
		//HashMap<Integer, Integer[]> seive=make_seive(a, k);
		Iterator<Integer> it=seive.keySet().iterator();
		// factors for the given test case
	//	HashMap<Integer, Integer> factors=get_factors(k);
		while(it.hasNext()) {
			int key = it.next();
			if(i!=0) {
			if(seive.get(key)[j]-seive.get(key)[i-1]<factors.get(key)) {
				return false;
			}}
			else {//System.out.println(key);
			//	System.out.print("seive- "+seive.get(key)[j]+" factors- "+factors.get(key)+" ");
				if(seive.get(key)[j]<factors.get(key)) {return false;}
			}
		}
		return true;
	}
	public static int find_ways(int[] a) {
		int i=0;
		int j=0;
		int n=a.length;
		int ans=0;
		while(i<a.length && j<a.length) {
			if(ispossible(i, j, a)) {
				//System.out.println("i = "+i+"j = "+j);
				ans+=n-j;
				i++;
			//	if(i==j) {
				//j++;}
			}
			else {
			//	System.out.println("i = "+i+"j = "+j);
			j++;}
			
		}
		return ans;
	}
	public static int getpower(int N,int t,int ans) {
	//	System.out.println("N ="+N);
		//System.out.println("t= "+t);
		 if(N%t!=0) {
	    	   return ans+0;
	       }
	       else {
	    	   ans++;
	    	   return getpower(N/t, t, ans);
	       }
	}
	public static boolean checkprime(int n) {
		int c=(int)Math.pow(n, 0.5);
		for(int i=2;i<=c;i++) {
			if(n%i==0) {
			//	System.out.print(i);
				//seive[n]=false;
				return false;
			}
		}
		return true;
	}
	public static HashMap<Integer, Integer> get_factors(int n) {
	//	HashMap<Integer, Integer> factors=new HashMap<>();
		int root=(int)Math.sqrt(n);
		for(int t=2;t<=root;t++) {
			if(n%t==0 ) {
				if(checkprime(t)==true) {
				int p=getpower(n,t,0);
				factors.put(t, p);}
				if(checkprime((int)n/t)==true) {
					int p=getpower(n,n/t,0);
					factors.put(n/t, p);
				}
				
			}
		}
		return factors;
	}
	public static void make_seive(int[] a,int k){
		//Arrays.sort(a);
		//int a_max= ;
	//	HashMap<Integer, Integer[]> ans=new HashMap<>();
		HashMap<Integer, Integer> factor_map=get_factors(k);
		Iterator<Integer> factors=get_factors(k).keySet().iterator();
		for(int m=0;factors.hasNext();m++) {
			int fac=factors.next();
			Integer[] value=new Integer[a.length];
			initialize_zero(value);
			for(int o=0;o<a.length;o++) {
				if(a[o]%fac==0) {
					//g denotes the power of fac at oth index in given sorted array
					int g= getpower(a[o], fac, 0);
					if(o!=0) {
					value[o]=g+value[o-1];}
					if(o==0) {
						value[o]=g;
					}
					seive.put(fac, value);
				}
				else {
					if(o!=0) {
						value[o]=value[o-1];
					}
				}
					
				}
			}
	//	return seive;
		}
	public static void initialize_zero(Integer[] a) {
		for(int i=0;i<a.length;i++) {
			a[i]=0;
		}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		 k=s.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=s.nextInt();}
		if(k!=1) {
		make_seive(a, k);
		get_factors(k);
		System.out.print(find_ways(a));}
		else {
			System.out.print((n*(n+1))/2);
		}
		
	}

}
