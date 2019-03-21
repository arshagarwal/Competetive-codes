package competetive_prog;

import java.util.Scanner;

public class Solution {
	public static int[] stockSpan(int[] price) {
		// Write your code here
      int n = price.length;
      int[] x=new int[n];
      x[0]=1;
      for(int i=1;i<n;i++) {
    	  int t=i-1;
    	  if(price[t]>=price[i]) {
    		  x[i]=1;
    	  }
    	  else {
    	  while(price[t]<price[i] & t!=0) {
    		  t=t-1;
    	  }
    	  int k;
    	  if(t==0) {
    	   k = i-t+1;}
    	  else {
    		  k=i-t;
    	  }
    	  x[i]=k;
    	  }}
      return x;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		int [] price= new int[n];
		for(int i=0;i<n;i++) {
			price[i]=scanner.nextInt();
			
		}
		int[] a = stockSpan(price);
		//System.out.print(a[2]);
		for(int b:a) {
			System.out.print(b+" ");
		}
		
		
	}}


