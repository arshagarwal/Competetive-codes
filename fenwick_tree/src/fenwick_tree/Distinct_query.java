package fenwick_tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Distinct_query {
	public static int[] fenwick_tree=new int[300001];
	public static class query implements Comparable<query>{
		int s;
		int e;
		int index;
		@Override
		public int compareTo(query a) {
			return this.e-a.e;
		}
	}
	// to subtract/add corresponding to the existing 
	public static void update(int e,int a) {
		for(;e<fenwick_tree.length;e+=e&(-e)) {
			fenwick_tree[e]+=a;
		}
	}
	public static int query(int e) {
      int value=0;
      for(;e>0;e-=e&(-e)) {
    	  value+=fenwick_tree[e];
      }
      return value;
	}
	public static void solve(query[] input_q,int[] input){
		int[] ans=new int[input_q.length];
		int [] last=new int[1000001];
		for(int i=0;i<last.length;i++) {
			last[i]=-1;
		}
		int total=0;
		int k=0;
		for(int i=0;i<input.length;i++){
	       if(last[input[i]]!=-1) {
	    	   update(last[input[i]],-1);
	       }
	       else {total++;}
		
		update(i+1,1);
		last[input[i]]=i+1;
		// query
		while(k<input_q.length&& input_q[k].e==i+1){
			ans[input_q[k].index]=total-query(input_q[k].s-1);
			k++;
		}
	}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] input=new int[n];
		for(int i=0;i<input.length;i++) {
			input[i]=scanner.nextInt();
		}
		int q=scanner.nextInt();
		query[] input_q=new query[q];
		for(int i=0;i<input_q.length;i++) {
			input_q[i]=new query();
			input_q[i].s=scanner.nextInt();
			input_q[i].e=scanner.nextInt();
			input_q[i].index=i;
		}
		Arrays.sort(input_q);
		solve(input_q, input);
		

	}

}
