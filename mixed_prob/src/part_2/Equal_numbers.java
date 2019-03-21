package part_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Equal_numbers {
	
	public static void  create_dp(int[][] dp,int[] A) {
		// max frequency of an index
		int[] frequency=new int[(int)Math.pow(10, 5)+1];
		// arrayList of indices with the max frequency
		ArrayList<Integer> max_frequency=new ArrayList<>();
		// initializing the dp array
		// first row
		dp[0][A[0]]=1;
		// for the general case
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				int sub_ans1=dp[i-1][j];
				int sub_ans2=0;
				// maintaining sum
				int sum=A[i];
				if(A[i]==j) {sub_ans2=dp[i-1][j]+1;
						}
				else {
				for(int k=i-1;k>=0;k--) {
					sum+=A[k];
					if(sum==j) {
						if(k!=0) {
						sub_ans2=Math.max(sub_ans2, dp[k-1][j]+1);}
						else {
							sub_ans2=1;
						}
					}
				}}
				dp[i][j]=Math.max(sub_ans1, sub_ans2);
				frequency[j]=Math.max(dp[i][j], frequency[j]);
			}
		}
		int max=0;
		for(int i=0;i<frequency.length;i++) {
			if(frequency[i]>max) {
				max=frequency[i];
			}
		}
		System.out.println(max);
		for(int i=0;i<frequency.length;i++) {
			if(frequency[i]==max) {
				System.out.print(i+" ");
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scanner=new Scanner(System.in);
    int N=scanner.nextInt();
    int[] A=new int[N];
    for(int i=0;i<A.length;i++) {
    A[i]=scanner.nextInt();}
    // row in the dp array represents till what index array A has been considered
    // column represents the no whose frequency is being calculated
	int[][] dp=new int[N][(int)Math.pow(10, 5)+1];
	create_dp(dp, A);
	}

}
