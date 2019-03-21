package game_theory;

import java.util.Scanner;

public class Grundy_numbers {
	public static int [] dp=new int[100000];
	public static int mex(int a,int b,int c) {
		int min=Math.min(a, Math.min(b, c));
		int max=Math.max(a, Math.max(b, c));
		if(min!=0) {
			return 0;
		}
		if(a!=1 && b!=1 && c!=1) {
			return 1;
		}
		else if (a!=2 && b!=2 && c!=2 ) {
			return 2;
		}
		else {
			return 3;
		}
	}
	public static int grundy(int n) {
		if(n==0) {
			return 0;
		}
		dp[n]= mex(grundy(n/2),grundy(n/3),grundy(n/6));
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		System.out.println(grundy(n));
		for(int i=0;i<dp.length;i++) {
		System.out.print(dp[i]+" ");}
		

	}

}
