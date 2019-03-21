import java.util.Scanner;

public class alyona_spreadsheet {
	public static int [] ans;
public static void find_ans(int [][] input) {
	int [][] dp=new int[input.length][input[0].length];
	for(int i=0;i<input[0].length;i++) {
		dp[0][i]=1;
	}
	for(int i=1;i<input.length;i++) {
		for(int j=0;j<input[0].length;j++) {
			if(input[i][j]>=input[i-1][j]) {
				dp[i][j]=dp[i-1][j];
			}
			else {
				dp[i][j]=i+1;
			}
		}
	}
	for(int i=0;i<dp.length;i++) {
		for(int j=0;j<dp[0].length;j++) {
			System.out.print(dp[i][j]+" ");
		}
		System.out.println();
	}
	System.out.println();
	ans=new int[input.length];
	for(int i=0;i<dp.length;i++) {
		int min=Integer.MAX_VALUE;
		for(int j=0;j<dp[0].length;j++) {
			if(min>dp[i][j]) {
				min=dp[i][j];
			}
		}
		ans[i]=min;
	//System.out.print(ans[i]+" ");
	}
	
	
}	
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	int m=s.nextInt();
	int[][] input=new int[n][m];
	for(int i=0;i<n;i++) {
		for(int j=0;j<m;j++) {
			input[i][j]=s.nextInt();
		}}
	find_ans(input);
		int k=s.nextInt();
		for(int i=0;i<k;i++) {
			int L=s.nextInt();
			int R=s.nextInt();
			if(R>1) {
			// because for non decreasing order is defined till r-1
			int a=ans[R-1];
			if(a>L) {System.out.println("No");}
			else {System.out.println("Yes");}
			}
		
	}
}
}
