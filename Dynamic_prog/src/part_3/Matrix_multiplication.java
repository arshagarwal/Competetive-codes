package part_3;

import java.util.Scanner;

public class Matrix_multiplication {
   // public static int[][] dp;
    public static int min_costs(int[] input,int i,int j,int[][] dp){
    	
    	if(i==j) {
    		return 0;
    	}
    	else if(dp[i][j]!=-1) {
    		return dp[i][j];
    	}
    	else{
    		int min_cost=Integer.MAX_VALUE;
    		// c for counter
    		for(int c=i;c<j;c++){
    			int possibe_ans=min_costs(input, i,c,dp )+min_costs(input, c+1, j,dp)+input[i-1]*input[c]*input[j];
    			min_cost=Math.min(min_cost, possibe_ans);
    		}
    		dp[i][j]=min_cost;
        	return min_cost;
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] input=new int[n+1];
		for(int i=0;i<n+1;i++){
			input[i]=scanner.nextInt();
		}
		int[][] dp=new int[n+1][n+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=-1;
			}
		}
		System.out.print(min_costs(input, 1, n,dp));
		
		

	}

}
