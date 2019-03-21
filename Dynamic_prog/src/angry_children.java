import java.util.Arrays;
import java.util.Scanner;

import part_3.candy;

public class angry_children {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        int K=s.nextInt();
        int[] candy_no=new int[N];
        for(int i=0;i<N;i++) {
        	candy_no[i]=s.nextInt();
        }
        Arrays.sort(candy_no);
        long min=Long.MAX_VALUE;
        long cost=0;
        long sum=0;
        long t=0;
        for(int i=K-1,j=K-1;i>=0;i--, j--) {
        	cost+=(j-t)*candy_no[i];
        	sum+=candy_no[i];
        	t++;
	}
        min=cost;
        for(int i=K;i<candy_no.length;i++) {
        	cost=cost-sum+candy_no[i-K]*K;
        	sum=sum-candy_no[i-K]+candy_no[i];
        	cost=cost-sum+K*candy_no[i];
        	if(min>cost) {
        		min=cost;
        	}
        }
        System.out.println(min);

}}
