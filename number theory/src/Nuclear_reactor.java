import java.util.Scanner;

public class Nuclear_reactor {
	public static long mod_power(Long a,int p,int m) {
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
	public static long mod_factorial(long N,int P) {
		if(N>=P) {
			return 0;
		}
		else {
			long ans=-1;
			for(long i=N+1;i<P;i++) {
				long temp=mod_power(i,P,P-2);
				ans=((ans)%P*(temp)%P)%P;
			}
			return ans+P;
			
		}
	}
	
	public static int mod_pow(int n,long x,int m) {
		if(x==0) {
			return 1%m;
		}
		else {
			int sub_ans=mod_pow( n,x/2,m);
			sub_ans=(int)(((long)sub_ans*sub_ans)%m);
			if(x%2!=0) {
				sub_ans=(int)((n)%m*(long)(sub_ans))%m;
			}
			return sub_ans;
		}
	}
    public static long find_energy(long t,int m) {
    	int power=mod_pow(m-1,t/m, m);
    	long factorial=(long)mod_factorial(t%m,m );
    //	System.out.println(factorial);
    //	System.out.println(power);
    	long ans = (power*factorial)%m;
    	return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        for(int i=0;i<N;i++) {
        	long t=scanner.nextInt();
        	int m=scanner.nextInt();
        	System.out.println(find_energy(t, m));
        }
	}

}
