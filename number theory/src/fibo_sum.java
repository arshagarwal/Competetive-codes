
public class fibo_sum {
	 static long mod=(int)Math.pow(10,9)+7;
	public static long mod_multiply(long a,long b) {
		//int mod=(int)Math.pow(10,6)+7;
		long ans=((a%mod)*(b%mod))%mod;
		return ans;
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


	public static void main(String[] args) {
		//System.out.println(find_fib(10246));
		//System.out.println(find_fib(1025));
		//System.out.println(find_fib(10246)-find_fib(1025));
		System.out.println(fib_sum(1024,10244));
		// TODO Auto-generated method stub

	}

}
