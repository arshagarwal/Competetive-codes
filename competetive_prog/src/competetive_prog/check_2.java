package competetive_prog;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class check_2 {
	public static boolean checkprime(int n) {
		int c=(int)Math.pow(n, 0.5);
		for(int i=2;i<=c;i++) {
			if(n%i==0) {
			//	System.out.print(i);
				//seive[n]=false;
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<Integer>find_factors(int n) {
		ArrayList<Integer> ans=new ArrayList<>();
		int root=(int)Math.sqrt(n);
		if(checkprime(n)) {
			ans.add(n);
			return ans;
		}
		for(int i=2;i<=root;i++) {
			if(n%i==0) {
				if(checkprime(i)) {ans.add(i);}
				if(checkprime(n/i) && n/i!=i) {ans.add(n/i);}
				
			}
			}
		return ans;
	}
	public static void main(String[] args) {
		System.out.print(find_factors(799));
	
	
	}}


