package hackerrank;

import java.net.Inet4Address;
import java.util.Scanner;

public class max_subset_sum {
	// function to calculate the max subset sum of non adjacent elements
	public static long find_subset_Sum(int n,int[] input) {
		long[] dp =new long[input.length];
		dp[0]=input[0];
		dp[1]=Math.max(input[0], input[1]);
		long max=Math.max(dp[0], dp[1]);
		for(int i=2;i<dp.length;i++) {
			dp[i]=Math.max(input[i]+dp[i-2],dp[i-1]);
			dp[i]=Math.max(dp[i], input[i]);
			if(max<dp[i])
				max=dp[i];
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] input=new int[n];
		for(int i=0;i<input.length;i++) {
			input[i]=scanner.nextInt();
		}
		System.out.println(find_subset_Sum(n, input));

	}

}
