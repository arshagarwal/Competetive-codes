package mixed_prob;

import java.util.Scanner;

public class income {
	 static long mod=(int)Math.pow(10,9)+6;
		public static long mod_multiply(long a,long b) {
			//int mod=(int)Math.pow(10,6)+7;
			long ans=((a%mod)*(b%mod))%mod;
			return ans;
		}
		public static long find_power(int a,int x) {
			long m=(long)Math.pow(10, 9)+7;
			if(x==0) {
				return 1;
			}
			else {
				long sub_ans=find_power(a, x/2);
				long ans=((sub_ans)%m*(sub_ans)%m)%m;
				if(x%2!=0) {
					ans=((ans)%m*(a)%m)%m;
				}
				return ans;
			}
		}
		public static void multiply(long[][] A,long[][] C) {
			long value_1=(mod_multiply(A[0][0],C[0][0])+mod_multiply(A[0][1],C[1][0]))%mod;
			long value_2=(mod_multiply(A[0][0],C[0][1])+mod_multiply(A[0][1],C[1][1]))%mod;
			long value_3=(mod_multiply(A[1][0],C[0][0])+mod_multiply(A[1][1],C[1][0]))%mod;
			long value_4=(mod_multiply(A[1][0],C[0][1])+mod_multiply(A[1][1],C[1][1]))%mod;
			//int[][] B= {{value_1,value_2},{value_3,value_4}};
			A[0][0]=value_1;
			A[0][1]=value_2;
			A[1][0]=value_3;
			A[1][1]=value_4;
		}
		public static void power(long [][] A,long n) {
			if(n==1 || n==0) {}
			else {
				power(A, n/2);
				multiply(A,A);
				if(n%2!=0) {
				long[][] c= {{1,1},{1,0}};
					multiply(A,c);
				}
			}
		}
		public static long find_fib(long n) {
			long[][] A= {{1,1},{1,0}};
			if(n==0) {
				return 0;
			}
			power(A,n-1);
			
			return A[0][0];
			
		}

		public static long fib_sum(long n,long m) {
			long ans_m=find_fib(m+2);
			long ans_n=find_fib(n+1);
			
			long ans=((ans_m)-(ans_n));
			if(ans<0) {
				ans=ans+mod;
				ans=ans%mod;
			}
			
			return ans;
		}
		public static long calculate(int n,int n_0,int n_1) {
			// fibonacci of n-1( %(mod-1))
			
			long m=(long)Math.pow(10, 9)+7;
			long fib1=find_fib(n-1);
			// fibonacci of n
			long fib2=find_fib(n);
		//	System.out.println("fib1 = "+ fib1);
			//System.out.println("fib 2="+ fib2);
			long sub_ans1=find_power(n_0, (int)fib1);
			long sub_ans2=find_power(n_1, (int)fib2);
			return (sub_ans1*sub_ans2)%m-1;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t= s.nextInt();
		for(int i=0;i<t;i++) {
			int n_1=s.nextInt();
			int n_2=s.nextInt();
			int n=s.nextInt();
			if (n!=0) {
			System.out.println(calculate(n, n_1+1, n_2+1));}
			else {
				System.out.println(n_1);
			}
		}

	}

}
