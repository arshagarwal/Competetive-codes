package greedy_technique;

import java.util.Arrays;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Weighted_job_scheduling {
	public static class job implements Comparable<job>{
		int start;
		int end;
		int profit;
		public int compareTo(job o) {
			return this.end-o.end;
		}	
	}
	public static  int binary_search(job[] input,int time,int start,int end){
		int mid=(start+end)/2;
		if(start>=end) {
			if(input[start].end<=input[time].start) {
				return start;
			}
			else {return start-1;}
		}
		if(input[mid].end==input[time].end) {
			return mid;
		}
		else if(input[mid].end<input[time].start) {
			return binary_search(input, time, mid+1, end);
		}
		else{
			return binary_search(input, time, start, mid-1);
		}
		
	}
	public static int solve(job[] input) {
		// dp array containing the answer for first i elements
		int[] dp=new int[input.length];
		dp[0]=input[0].profit;
		for(int i=1;i<dp.length;i++) {
			// excluding the ith job
			int sub_ans1=dp[i-1];
			int sub_ans2=input[i].profit;
			// including the ith job
			/*for(int j=i;j>=0;j--) {
				if(input[j].end<=input[i].start){
					sub_ans2+=dp[j];
					break;
				}
			}*/
			int index=binary_search(input, i, 0, i);
			if(index!=-1)
			dp[i]=Math.max(sub_ans1, sub_ans2+dp[index]);
			else
				dp[i]=Math.max(sub_ans1, sub_ans2);
		}
		return dp[dp.length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		job[] input=new job[N];
		for(int i=0;i<N;i++) {
			input[i]=new job();
			input[i].start=scanner.nextInt();
			input[i].end=scanner.nextInt();
			input[i].profit=scanner.nextInt();
		}
		Arrays.sort(input);
		System.out.println(solve(input));
		
		

	}

}
