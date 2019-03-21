package greedy_technique;

import java.util.Scanner;

public class Himani_Stocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		long[] c=new long[n+1];
		long[]x=new long [n+1];
		x[0]=0;
		for(int i=1;i<c.length;i++) {
			x[i]=((x[i-1]%m)*a+b)%(long)(Math.pow(2, 32));
			c[i]=Math.abs(x[i]/(long)(Math.pow(2, 8)));
		}
		int profit=0;
		// initial cost is
		double cost=c[1];
		for(int i=2;i<c.length;i++) {
			if(c[i]>c[i-1]) {
				
			}
			else {
				profit+=c[i-1]-cost;
				cost=c[i];
			
			}
			if(i==c.length-1) {
				if(c[c.length-1]>cost) {
					profit+=c[c.length-1]-cost;
				}
			}
		}
		System.out.println(profit);

	}

}
