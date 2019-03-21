import java.util.Scanner;

public class boring {
	//public static long mod=(int)Math.pow(10, 6)+7;
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
	public static long calculate(int N,int P) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++) {
        	int N=s.nextInt();
        	int P=s.nextInt();
        	System.out.println(calculate(N,P));
        }
	}

}
