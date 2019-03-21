package backtracking;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class agressive {
	public static int[] x;
	public static int C;
	//min=minimum distance
	public static boolean ispossible(int[]input,int min,int c ) {
		if(c==1) {
			for(int i=1;i<input.length;i++) {
				if(input[i]-input[0]>=min) {
					return true;
					}
				else if(input[i]-input[0]<min && i==input.length-1) {
					return false;					
				}
				else {continue;}
				}
			return false;
			}
		else {for(int i=1;i<input.length;i++) {
			if(input[i]-input[0]>=min) {
				int[] new_in =Arrays.copyOfRange(input, i, input.length);
				return ispossible(new_in,min,c-1);
			}
			else if(input[i]-input[0]<min && i==input.length-1) {
				return false;
				}
			else {continue;}
			}
		return false;
		}
		}
		
	
	public static boolean ispossible(int min) {
		return ispossible(x,min,C-1);
	}
	public static int binary_check(int s,int e) {
		int n=e-s+1;
		int mid=s+(n-1)/2;
		if(s==e) {
			if(ispossible(s)) {
			return s;}
		else {
			return s-1;
		}}
		 if(ispossible(mid)) {
		//	 System.out.println("mid="+mid);
			 return binary_check( mid+1, e);
		 }
		 else {
			 return binary_check(s, mid-1);
		 }
		
		


	}
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int N=0;
		for(int i=0;i<n;i++) {
			 N=s.nextInt();
			 C=s.nextInt();
			 x= new int[N];
			for(int t=0;t<N;t++) {
				x[t]=s.nextInt();			}
		Arrays.sort(x);
		int min =x[1]-x[0];
		int max = x[x.length-1]-x[0];
		// array of distances from min to max
	//	int[] input=new int[max-min+1];
	//	int j=0;
	//	for(int t=min;t<=max;t++) {
		//	input[j++]=t;}
		int ans= binary_check( min,max );			
	System.out.print(ans);
		}}
	}


