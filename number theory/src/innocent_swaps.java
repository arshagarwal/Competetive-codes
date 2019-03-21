import java.util.Scanner;

public class innocent_swaps {
	public static int mod=(int)Math.pow(10,9)+7;
	public static long mod_power(int a,int p,int m) {
		//int m=p-2;
		if(m==0) {
			return (1%p); 
		}
		else {
			long sub_ans=mod_power(a,p,m/2);
			long ans=((sub_ans)%p*(sub_ans)%p)%p;
			if(m%2!=0) {
				ans=((a)%p*(ans)%p)%p;
			}
			return ans;
		}
	}
	public static long mod_factorial(int N,int P) {
		if(N>=P) {
			return 0;
		}
		else {
			long ans=-1;
			for(int i=N+1;i<P;i++) {
				long temp=mod_power(i,P,P-2);
				ans=((ans)%P*(temp)%P)%P;
			}
			return ans+P;
			
		}
	}
	public static long calculate(int N,int K) {
		long ans_n=mod_factorial(N, (int)mod);
		long ans_k1=mod_factorial(K, (int)mod);
		ans_k1=mod_power((int)ans_k1, mod, mod-2);
		long ans_k2=mod_factorial(N-K, mod);
		ans_k2=mod_power((int)ans_k2, mod-2, mod);
		long power =mod_power(2, mod, K);
		long ans=(ans_k1*ans_k2*ans_n)%mod;
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int i=0;i<t;i++) {
			int N=scanner.nextInt();
			int K=scanner.nextInt();
			System.out.println(calculate(N, K));
		}

	}

}
