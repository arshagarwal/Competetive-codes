package part_2;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;

public class costly_phn_no {
	// this function assigns the minimum cost to each number
	public static int[] min_cost(int[] cost){
		// the minimum cost matrix
	int[] n_cost=new int[cost.length];
	while(!Arrays.equals(n_cost, cost)) {
		for(int i=0;i<n_cost.length;i++) {
			n_cost[i]=cost[i];
		}
	for(int i=0;i<10;i++) {
		for(int j=0;j<10;j++) {
			int sum = (i+j)%10;
			if((cost[i]+cost[j])<cost[sum]) {
				if(cost[sum]>(cost[i]+cost[j])) {
				cost[sum]=cost[i]+cost[j];}
						}
			else {
				
				//n_cost[sum]=cost[sum];
			}
		}}
	}
	return cost;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;i++) {
        // cost 
        	 int[] cost=new int[10];
        	for(int j=0;j<10;j++) {
       cost[j]=scanner.nextInt();
        	}
        	// number length
        	int length=scanner.nextInt();
        	//  number
        	String no=scanner.next();
        	int total_cost=0;
        	int [] n_cost=min_cost(cost);
        	for(int j=0;j<no.length();j++) {
        		int digit=Integer.parseInt(no.substring(j,j+1));
        		total_cost+=n_cost[digit];
        	}
        	System.out.println(total_cost);
        }
        
	}

}
