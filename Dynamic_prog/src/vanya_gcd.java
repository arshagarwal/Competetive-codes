import java.util.Scanner;

public class vanya_gcd {
	public static int mod=(int)Math.pow(10, 9)+7;
	public static int gcd(int a,int b) {
		if(b>a) {
			return gcd(b, a);
		}
		if(b==0) { return a;}
		else if(b==1) { return 1;}
		else {  
			return gcd(b, a%b);
		}
	}
	public static int calc(int[] input) {
		int[][] dp=new int[input.length][101];
		//initializing
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=0;
			}
		}
		// for only one element type
		for(int i=0;i<input.length;i++) {
			dp[i][input[i]]=1;
		}
		//dp[0][input[0]]=1;
		// when gcd =0
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=0;
		}
		for(int i=1;i<dp.length;i++) {
			int t=i-1;
			while(t>=0) {
				if(input[i]>input[t]) {
					for(int k=1;k<dp[0].length;k++) {
						int a= gcd(k,input[i]);
						dp[i][a]=(int)((long)(dp[i][a])%mod+(dp[t][k])%mod)%mod;
					}
					t--;
				}
			}
		}
		int sum=0;
		for(int i=0;i<dp.length;i++) {
			sum=(int)((long)sum%mod+dp[i][1]%mod)%mod;
		}
		//for(int i=0;i<dp.length;i++) {
			//for(int j=0;j<dp[0].length;j++) {
				//System.out.print(dp[i][j]+" ");
			//}
			//System.out.println();
		//}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int[] input=new int[N];
		for(int i=0;i<N;i++) {
			input[i]=scanner.nextInt();
		}
		System.out.print(calc(input));

	}

}
