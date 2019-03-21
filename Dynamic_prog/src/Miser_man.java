import java.util.Arrays;
import java.util.Scanner;

public class Miser_man {
	public static int find_min(int[][] input) {
	
		int[][] dp=new int[input.length][input[0].length];
		for(int i=0;i<dp[0].length;i++) {
			dp[input.length-1][i]=input[input.length-1][i];
			//System.out.print(dp[input.length-1][i]+" ");
		}
		for(int i=input.length-2;i>=0;i--) {
			for(int j=0;j<dp[0].length;j++) {
				int p=j-1;
				int min=0;
				if(j>=1 && j!=dp[0].length-1) {
				 min=Math.min(dp[i+1][j], Math.min(dp[i+1][j+1], dp[i+1][j-1]));}
				else if(j==dp[0].length-1) {
				min=Math.min(dp[i+1][j], dp[i+1][j-1]);	
				}
				else {
					min=Math.min(dp[i+1][j],dp[i+1][j+1]);
				}
				//while(input[i+1][p]!=input[i][j] && input[i+1][p]!= 1+input[i][j] && input[i+1][p]!=input[i][j]-1 ) {
					//p++;
					//if(p==dp[0].length) {break;}
				//}
				//if(p<dp[0].length) {
			//	if(p<0) {p++;}
				//while(input[i+1][p]!=min) {
				//	p++;
					//if(p==dp[0].length) {break;}
					
				//}
					dp[i][j]=input[i][j]+min;
				//}
			}
		}
		for(int i=0;i<dp[0].length;i++) {
			//dp[input.length-1][i]=input[input.length-1][i];
		System.out.print(dp[input.length-3][i]+" ");
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<dp[0].length;i++) {
			if(dp[0][i]<min) {
				min=dp[0][i];
			}
		}
		return min;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		int M=s.nextInt();
		int[][] input=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				input[i][j]=s.nextInt();
			}
			//Arrays.sort(input[i]);
		}
		System.out.println(find_min(input));

	}

}
