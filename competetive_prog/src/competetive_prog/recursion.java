package competetive_prog;

import java.util.Scanner;

public class recursion {
	private static int solve(int n,int x) {
		int a=n^(1/x);
		for(int i=1;i<a;i++) {
			int b = n-(i^x);
			for(int t=1;t<b;t++) {
				if(((t^x)==b) & (t!=i)) {
					return 1;
						
				}
				else {
					return 0;
				}
			}
			
		}
		
		
	}
	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		int n= Integer.parseInt(sc.nextLine());
		int x=sc.nextInt();
		int r=solve(n,x);
		System.out.println(r);
	}

}
