package hackerrank;

import java.util.Scanner;

import javax.xml.bind.SchemaOutputResolver;

public class sherlock_cost{
	public static int solve(int[] B) {
		// creating a dp matrix of two rows and n columns
		// first row consisits of the max sum ending with 1
		// second row contains the max sum ending with B[i]
		int [][] dp= new int[2][B.length];
		dp[0][0]=1;
		dp[1][0]=B[0];
		dp[0][1]=Math.abs(1-B[0]);
		dp[1][1]=Math.abs(B[1]-1);
		for(int i=2;i<dp[0].length;i++){
			// for 0 th row
			int opt_00=dp[1][i-1]+Math.abs(1-B[i-1]);
			int opt_01=dp[0][i-1];
			dp[0][i]=Math.max(opt_00, opt_01);
			// for 1st row
			int opt_10=dp[1][i-1]+Math.abs(B[i]-B[i-1]);
			int opt_11=dp[0][i-1]+Math.abs(B[i]-1);
			dp[1][i]=Math.max(opt_10, opt_11);
		}
		return Math.max(dp[0][dp[0].length-1],dp[1][dp[0].length-1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		int t=scanner.nextInt();
		for(int i=0;i<t;i++) {
			int n=scanner.nextInt();
			int[] B=new int[n];
			for(int j=0;j<n;j++) {
				B[j]=scanner.nextInt();
			}
			System.out.println(solve(B));
			
		}

	}

}
