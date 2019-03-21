
public class cal_check {
	public static int mod_pow(int n,long x,int m) {
		if(x==0) {
			return 1%m;
		}
		else {
			int sub_ans=mod_pow( n,x/2,m);
			sub_ans=(int)(((long)sub_ans*sub_ans));
			
			if(x%2!=0) {
				sub_ans=(int)((n)%m*(long)(sub_ans));
			}
			int ans=sub_ans%m;
			return ans;
		}
	}
	public static boolean checkprime(long n) {
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
	public static long max_power(long a,long b) {
		double r_a=Math.log(a);
		double r_b=Math.log(b);
		return (int)(r_a/r_b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(max_power(24, 2));
	}

}
