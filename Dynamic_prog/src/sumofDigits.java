import java.util.Scanner;

public class sumofDigits {
	// dp denotes the sum till ith digits
	public static int [] dp=new int[10];
	// dp tells the sum till i
	public static int [] dp1=new int [10];
	//this tells the sum of i digits
	public static int [] dp2=new int [10];
	
	public static void create_dp() {
		dp[0]=0;
		dp1[0]=0;
		dp2[0]=0;
		int sum=0;
		for(int i=1;i<=9;i++) {
			sum+=i;
			dp1[i]=i+dp1[i-1];
		}
		dp[1]=sum;
		dp[2]=sum;
		for(int i=2;i<dp.length;i++) {
			dp[i]=dp[i-1]+(dp2[i-1]+(int)Math.pow(10, i-1))*dp[1];
			dp2[i]=(dp2[i-1]+(int)Math.pow(10, i-1))*dp[1];
		}
	}
	public static int find_ans(String a) {
		if(a.length()==1) {
			int sum=0;
			for(int i=0;i<=Integer.parseInt(a);i++) {
				sum+=i;
			}
			return sum;
		}
		else {
			int first=Integer.parseInt(a.substring(0, 1));
			int sub_ans=dp[a.length()-1];
			int ans=sub_ans+dp1[first-1]*(dp2[a.length()-1]+(int)Math.pow(10, a.length()-1))+first*(Integer.parseInt(a.substring(1)))+find_ans(a.substring(1));
		return ans;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		create_dp();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			int a=scanner.nextInt();
			String b=scanner.next();
			if(a==-1&& b=="-1") {
				break;
			}
			else {
				System.out.println(find_ans(b)-find_ans(Integer.toString(a-1)));
			}
			
		}

	}

}
