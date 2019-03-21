import java.util.Scanner;

public class adjacent_bitcount {
	public static int[][][] dp;
	public static int mod=(int)Math.pow(10, 9)+7;
	public static void noOFNbitstrings() {
		 dp= new int[100][101][2];
		for(int i=0;i<dp[0].length;i++) {
			for(int j=0;j<2;j++) {	
			dp[0][i][j]=0;
			}}
		dp[0][0][0]=1;
		dp[0][0][1]=1;
		// for 2 bits
		for(int i=1;i<dp[0].length;i++) {
			for(int j=0;j<2;j++) {
			dp[1][i][j]=0;}
		}
		dp[1][0][0]=2;
		dp[1][0][1]=1;
		dp[1][1][1]=1;
		for(int i=2;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				//for(int t=0;t<2;t++) {
				if(j>=1) {
					dp[i][j][0]=(int)((long)(dp[i-1][j][0])%mod+(dp[i-1][j][1])%mod)%mod;
					dp[i][j][1]=(int)((long)(dp[i-1][j][0])%mod+(dp[i-1][j-1][1])%mod)%mod;}
				else {
					dp[i][j][0]=(int)((long)(dp[i-1][j][0])%mod+(dp[i-1][j][1])%mod)%mod;
					dp[i][j][1]=dp[i-1][j][0];
				}
				//}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		System.out.println();
		noOFNbitstrings();
		for(int i=0;i<t;i++) {
			int n=scanner.nextInt();
			int bits=scanner.nextInt();
			int k=scanner.nextInt();
			long ans=(dp[bits-1][k][0])%mod+(dp[bits-1][k][1])%mod;
			System.out.println(n+" "+ans%mod);}
		

	}

}
