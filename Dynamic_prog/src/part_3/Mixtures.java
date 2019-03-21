package part_3;

import java.util.Scanner;

public class Mixtures {
	public static int solve(int[] input ,int[][] smoke_dp,int i,int j,int[][] comb_dp) {
		if(i==j-1){
			int ans=input[i]*input[j];
			smoke_dp[i][j]=ans;
			comb_dp[i][j]=(input[i]+input[j])%100;
			return ans;
		}
		else if(smoke_dp[i][j]!=Integer.MAX_VALUE){
			return smoke_dp[i][j];
		}
		else if(i==j) {
			smoke_dp[i][j]=0;
			comb_dp[i][j]=input[i];
			return 0;
		}
		else {
			int smoke=Integer.MAX_VALUE;
			int m=-1;
			for(int k=i;k<j;k++){
				int sub_ans1=solve(input, smoke_dp, i, k, comb_dp);
				int sub_ans2=solve(input, smoke_dp, k+1, j, comb_dp);
				int temp=sub_ans1+sub_ans2+comb_dp[i][k]*comb_dp[k+1][j];
				if(smoke>temp) {
					smoke=temp;
					m=k;
				}
			}
			smoke_dp[i][j]=smoke;
			comb_dp[i][j]=(comb_dp[i][m]+comb_dp[m+1][j])%100;
			return smoke;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] input=new int[n];
		for(int i=0;i<n;i++) {
			input[i]=scanner.nextInt();
		}
		int[][] smoke_dp=new int[n][n];
		for(int i=0;i<smoke_dp.length;i++) {
			for(int j=0;j<smoke_dp[0].length;j++) {
				smoke_dp[i][j]=Integer.MAX_VALUE;
			}
		}
		int[][] comb_dp=new int[n+1][n+1];
		System.out.println(solve(input, smoke_dp, 0, n-1, comb_dp));
		

	}

}
