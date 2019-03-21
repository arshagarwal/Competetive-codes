package competetive_prog;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.InputMap;

public class detective {
	public static  long sumArray(int[] input,int s,int e) {
		long sum=0;
		for(int i=s;i<=e;i++) {
			sum=sum+input[i];
		}
		return sum;
	}
	public static long merge(int[] input1,int[] input2) {
		int i=0,j=0;
		long ans=0;
		while(i<input1.length && j<input2.length) {
			if(input1[i]<input2[j]) {
				long sub_ans=input1[i]*(input2.length-j);
				ans=ans+sub_ans;
				i++;
			}
			else {
				j++;
			}
		}
		return ans;
	}
	public static long solve(int[] input) {
		if(input.length==1) {
			return 0;
		}
		else{int n=input.length;
		int mid=(n-1)/2;
		int[] sub_input1=Arrays.copyOfRange(input, 0,mid+1);
		int[] sub_input2=Arrays.copyOfRange(input, mid+1,input.length);
		long sub_ans1=solve(sub_input1);
		long sub_ans2=solve(sub_input2);
		Arrays.sort(sub_input1);
		Arrays.sort(sub_input2);
		long sub_ans3=merge(sub_input1,sub_input2);
		return sub_ans1+sub_ans2+sub_ans3;
		
	}}
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int t=scanner.nextInt();
		for(int y=0;y<=t;y++) {
			int n= scanner.nextInt();
			int[] input=new int[n];
			for(int m=0;m<n;m++) {
				input[m]=scanner.nextInt();
			}
			System.out.println(solve(input));
		}
	}

}
