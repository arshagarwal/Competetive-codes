package mixed_prob;

import java.util.ArrayList;
import java.util.Scanner;

public class Gcd_extreme {
	public static boolean checkprime(int n) {
		int c=(int)Math.pow(n, 0.5);
		for(int i=2;i<=c;i++) {
			if(n%i==0) {
			//	System.out.print(i);
			//	seive[n]=false;
				return false;
			}
		}
		return true;
	}
	public static int[] seive=new int[(int)Math.pow(10, 6)+1];
	public static void initialize() {
		for(int i=0;i<seive.length;i++) {
			seive[i]=i;
		}
	}
	public static ArrayList<Integer> get_pfactors(int n){
		ArrayList<Integer> ans= new ArrayList<>();
		int root=(int)Math.sqrt(n);
		for(int i=2;i<=root;i++) {
			if(checkprime(i)) {
				ans.add(i);
				if(checkprime(n/i) && n!=n/i) {
					ans.add(n/i);
				}
			}
		}
		return ans;
	}
	public static void  create_totient() {
		seive[1]=0;
		for(int i=2;i<=seive.length/2;i++) {
			if(seive[i]==i) {
				
				if(checkprime(i)) {
					//System.out.println("i ="+i);
					seive[i]--;
					
					double mult=(double)(i-1)/i;
					//System.out.println("mult= "+mult);
					for(int t=2;t<(seive.length/i);t++) {
						//System.out.println("t= "+t);
						
						seive[i*t]=(int)(seive[i*t]*mult);
					}
				}
			}
		}
		
		
	}
	public static ArrayList<Integer> find_factors(int n){
		ArrayList<Integer> ans=new ArrayList<>();
		int root=(int)Math.sqrt(n);
		for(int i=1;i<=root;i++) {
			if(n%i==0) {
				ans.add(i);
				if(n/i!=i) {
					ans.add(n/i);
				}
			}
		}
		return ans;
	} 
	public static long find_ans(int n) {
		ArrayList<Integer> factors=new ArrayList<>();
		int[] sum=new int[(int)Math.pow(10, 6)+1];
		//factors=find_factors(n);
		//System.out.println(factors);
		long ans=0;
		for(int i=1;i<=n;i++) {
			if(n/i<2) {break;}
			for(int t=1;t<=n/i;t++) {
			sum[i*t]+=i*seive[t];
		}}
		for(int k=0;k<=n;k++) {
		 ans+=sum[k];
		 }
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		initialize();
		create_totient();
	//	System.out.println(seive[2]);
		while(s.hasNext()) {
			int input=s.nextInt();
			if(input!=0) {
			System.out.println(find_ans(input));
		}}
		

	}

}
