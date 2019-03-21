package part_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class mehta_robbery {
	public static class item implements Comparable<item>{
		long profit;
		int weight;
		//public item(int weight) {
			//this.weight=weight;
		//}
		@Override
		public int compareTo(item o) {
			return (int)(this.profit-o.profit);
		}
	}
	public static long solve(item[] input,int W,int [] prime){
		int N=input.length;
		long [][][] dp=new long[N][W+1][2];
		// initializing dp[0][j][0]
		for(int j=0;j<=W;j++) {
			if(j>=input[0].weight) {
				dp[0][j][0]=input[0].profit;
			}
		}
		// initializing dp[i][j][0]
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++){
				long sub_ans1=0;
				if(input[i].weight<=j) {
				 sub_ans1=dp[i][j-input[i].weight][0]+input[i].profit;}
				long sub_ans2=dp[i-1][j][0];
				dp[i][j][0]=Math.max(sub_ans1,sub_ans2 );
			}
		}
		int flag=1;
		long max=0;
		// for the general case 
		for(int t=prime.length-1;t>=0;t--){
			// initializing dp[0][j][flag] the first row 
			for(int j=0;j<=W;j++) {
				if(j>=input[0].weight) {
					dp[0][j][flag]=input[0].profit*prime[t];
				}
			}
			for(int i=1;i<dp.length;i++) {
				for(int j=0;j<dp[0].length;j++) {
					long sub_ans1=0;
					if(input[i].weight<=j){
						sub_ans1=Math.max(input[i].profit*prime[t]+dp[i-1][j-input[i].weight][flag^1],input[i].profit+dp[i-1][j-input[i].weight][flag]);
					}
					long sub_ans2=dp[i-1][j][flag];
					dp[i][j][flag]=Math.max(sub_ans1, sub_ans2);
					//if(dp[i][j][flag]>max) {
						//max=dp[i][j][flag];
					//}
					
				}
			}
			flag=flag^1;
		}
		/*for(int j=0;j<=W;j++) {
			if(j>=input[0].weight) {
				dp[0][j][flag]=input[0].profit;
			}
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				long sub_ans1=0;
				if(input[i].weight<=j){
					sub_ans1=input[i].profit+dp[i-1][j-input[i].weight][flag^1];
				}
				long sub_ans2=dp[i-1][j][flag];
				dp[i][j][flag]=Math.max(sub_ans1, sub_ans2);
				if(dp[i][j][flag]>max) {
					max=dp[i][j][flag];
				}
				
			}
		}*/
		
		
		return dp[N-1][W][0];	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int W=scanner.nextInt();
		item[] input=new item[N];
		for(int i=0;i<N;i++) {
			item put=new item();
			put.profit=scanner.nextInt();
			put.weight=scanner.nextInt();
			input[i]=put;
		}
		Arrays.sort(input,Collections.reverseOrder());
		int[] prime=new int[11];
		prime[0]=1;
		prime[1]=2;
		prime[2]=3;
		prime[3]=5;
		prime[4]=7;
		prime[5]=11;
		prime[6]=13;
		prime[7]=17;
		prime[8]=19;
		prime[9]=23;
		prime[10]=29;
		System.out.print(solve(input, W, prime));
		

	}

}
