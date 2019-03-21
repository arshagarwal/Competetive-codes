package part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tree_divisors {
	public static class edges extends ArrayList<Integer>{}
	public static boolean[] seive=new boolean[(int)Math.pow(10,6)+1];
	// this array stores the total no of divisors of a number
	public static int[] div_record =new int[(int)Math.pow(10, 6)+1];
	public static void make_seive() {
		// initializing the seive to be true
		for(int i=2;i<seive.length;i++) {
			seive[i]=true;
		}
		int sqrt=(int)Math.sqrt(seive.length);
		for(int i=2;i<sqrt;i++) {
			if(seive[i]==true) {
				for(int j=i;j<seive.length/i;j++) {
					seive[j*i]=false;
				}
			}
		}
	}
	public static void create_div_record(){
		// initializing the div_record array as 1
		for(int i=0;i<div_record.length;i++) {
			div_record[i]=1;
		}
		for(int i=2;i<seive.length/2;i++) {
			if(seive[i]){
				for(int j=1;j<seive.length/i;j++) {
					// current no to be considered
					int curr=i*j;
					// getting power of i in curr
					int pow=0;
					int c=curr;
					while(curr%i==0) {
						pow++;
						curr=curr/i;
					}
					div_record[c]=div_record[c]*(pow+1);
				}
			}
		}
	}
	// this function finds the max subset sum
	public static int max_subset_sum(int max,int index,edges[] edges){
	// base case when leaf node has been reached
		if(edges[index]==null) {
			return max+div_record[index];
		}
		// when included
		// children
		edges children=edges[index];
		int inc_ans=div_record[index];
		// now calling for all grandchildren
		for(int i=0;i<children.size();i++) {
			int child=children.get(i);
			if(edges[child]!=null) {
			for(int j=0;j<edges[child].size();j++) {
			inc_ans+=max_subset_sum(max, edges[child].get(j) , edges);}
		}	
		}
		
		// when excluded
		int exc_ans=0;
		// now calling for all children
		for(int i=0;i<children.size();i++) {
			int child=children.get(i);
			exc_ans+=max_subset_sum(max, child, edges);
			}
		
		return Math.max(inc_ans, exc_ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scanner=new Scanner(System.in);
    int N=scanner.nextInt();
    int[] div=div_record;
    boolean[] seve =seive;
    boolean[][] edge=new boolean[N+1][N+1];
    edges[] edges=new edges[N+1];
    for(int i=0;i<N-1;i++) {
    	int A=scanner.nextInt();
    	int B=scanner.nextInt();
    	if(edges[A]!=null) {
    		edges[A].add(B);
    	}
    	else {
    		edges put=new edges();
            put.add(B);
            edges[A]=put;
    	}
        
    }
    make_seive();
    create_div_record();
    boolean[] visited=new boolean[N+1];
    System.out.println(max_subset_sum(0, 1, edges));
    
	}

}
