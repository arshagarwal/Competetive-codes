package backtracking;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class cabdies {
	static long[] Array;
	public static boolean ispossible(long x,int k) {
		long ans=0;
		for(int i=0;i<Array.length;i++) {
			ans+=Array[i]/x;
			if(ans>=k) {
				return true;
			}
		}
		return false;
	}
	public static long distribute(int k,long s,long e) {
		long n= e-s+1;
		if(n<=1) {
			if(ispossible(s,k)) {
				return s;
			}
			else {return s-1;
			}
		}
		else {
			long mid= s+(n-1)/2;
			if(ispossible(mid,k)) {
				//System.out.println(ispossible(mid,k)+"mid="+mid+"e="+e);
				return distribute(k, mid+1, e);
			}
			else {
			//	System.out.println(ispossible(mid,k)+"mid="+mid+"s="+s);
				return distribute(k, s,mid-1);
			}
		}
	}
	public static long getMax(long[] inputArray){ 
	    long maxValue = inputArray[0]; 
	    for(int i=1;i < inputArray.length;i++){ 
	      if(inputArray[i] > maxValue){ 
	         maxValue = inputArray[i]; 
	      } 
	    } 
	    return maxValue; 
	  }
	 
	  // Method for getting the minimum value
	  public static long getMin(long[] inputArray){ 
	    long minValue = inputArray[0]; 
	    for(int i=1;i<inputArray.length;i++){ 
	      if(inputArray[i] < minValue){ 
	        minValue = inputArray[i]; 
	      } 
	    } 
	    return minValue; 
	  } 

public static void main(String[] args) {
	Scanner s= new Scanner(System.in);
	int t= s.nextInt();
	for(int y=0;y<t;y++) {
		int n= s.nextInt();
		int k=s.nextInt();
		Array =new long[n];
	for (int u=0;u<n;u++) {
		Array[u]=(long)s.nextInt();
		}
	System.out.println(distribute(k,1,getMax(Array)));
	}
	System.out.print(getMax(Array)+"  "+getMin(Array));
}
}
