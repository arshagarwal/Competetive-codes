import java.util.Scanner;

public class LCS {
	public static int lcs(String s1, String s2){
		int m=s1.length();
		int n=s2.length();
		int[][] dp=new int[m+1][n+1];
		// for 1st row
		for(int i=0;i<n+1;i++) {
			dp[0][i]=0;
		}
		// for 1st column
		for(int i=0;i<m+1;i++) {
			dp[i][0]=0;
		}
		// for remaining
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(s1.charAt(m-i)==s2.charAt(n-j)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
			
		}
		
		return dp[m][n];
		}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String s1=scanner.next();
		String s2=scanner.next();
		System.out.println(lcs(s1, s2));
		
	}

}
