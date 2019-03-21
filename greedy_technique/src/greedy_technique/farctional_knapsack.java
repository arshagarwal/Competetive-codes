package greedy_technique;

import java.util.Arrays;
import java.util.Scanner;

import greedy_technique.activity_selection.activity;

public class farctional_knapsack {
	public static class workers implements Comparable<workers>{
		int time;
		int cost;
		int speed;
		@Override
		public int compareTo(workers o) {
			return (this.time-o.time);
		}
	}
	public static long solve(workers[] input,long D) {
		// current time
		int t=input[0].time;
		int Area_covered=0;
		// max speed available of worker uptill t
		int max_speed=0;
		// current cost
		int cost=Integer.MAX_VALUE;
		long total_cost=0;
		// iteration counter
		int i=0;
		while(Area_covered<D) {
			int j=i;
			int flag=0;
			// now iterating on all input values available after time t
			while(input[j].time==t){
				if(max_speed<input[j].speed) {
					flag=1;
					max_speed=input[j].speed;
				cost=input[j].cost;	
				}
				else if(input[j].cost==max_speed) {
					if(cost>input[j].cost) {
						flag=1;
						cost=input[j].cost;
					}
				}
				j++;
				if(j==input.length) {break;}
			}
			i=j;
			Area_covered+=max_speed;
			if(flag==1) {
			total_cost+=cost;}
			t++;
			if(i==input.length) {break;}
		}
		return total_cost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        long D=s.nextLong();
        workers[] input=new workers[N];
        for(int i=0;i<input.length;i++){
        	input[i]=new workers();
        	input[i].time=s.nextInt();
        	input[i].cost=s.nextInt();
        	input[i].speed=s.nextInt();
        }
        Arrays.sort(input);
       
     System.out.println(solve(input, D));   
	}

}
