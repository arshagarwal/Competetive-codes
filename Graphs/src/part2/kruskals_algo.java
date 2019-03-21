package part2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class kruskals_algo {
	public static class edge implements Comparable<edge>{
		int v1;
		int v2;
		int w=0;
		public edge(int w) {
			this.w=w;
		}
	
	@Override
	public int compareTo(edge o) {
	    return (int)(this.w - o.w);
	  }	
	}
	public static edge[] solve(edge[] input,int V){
		int[] parent = new int[V];
		// initializing parent array
		for(int i=0;i<V;i++) {
			parent[i]=i;
		}
		edge[] output=new edge[V-1];
		int count=0;
		// to iterate
		int i=0;
		while(output[output.length-1]==null){
			// checking ith edge
			int temp_v1=input[i].v1;	
			int temp_v2=input[i].v2;
			int temp_w=input[i].w;
			// getting parent of v1 and v2
			while(parent[temp_v1]!=temp_v1) {
				temp_v1=parent[temp_v1];
			}
			while(parent[temp_v2]!=temp_v2) {
				temp_v2=parent[temp_v2];
			}
			// common parents hence cyclic
			if(temp_v1==temp_v2) {i++;continue;}
			else {
				output[count++]=input[i];
				int v1=input[i].v1;
				int v2=input[i].v2;
				// parent and child variables
				int p=Math.min(v1, v2);
				int c=Math.max(v1, v2);
				//parent[p]=c;
				parent[temp_v1]=temp_v2;
				i++;
			}
		}
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int V=scanner.nextInt();
		int E=scanner.nextInt();
		edge[] input=new edge[E];
		//edge a=new edge(0);
		for(int i=0;i<E;i++){
			edge a=new edge(0);
			a.v1=scanner.nextInt();
			a.v2=scanner.nextInt();
			a.w=scanner.nextInt();
			input[i]=a;
		}
		Arrays.sort(input);
		//Collections.sort(input,Comparator<input>);
		edge[] ans=solve(input, V);
		for(int i=0;i<ans.length;i++) {
			if(ans[i].v1<ans[i].v2)
			System.out.println(ans[i].v1+" "+ans[i].v2+" "+ans[i].w);
			else 
				System.out.println(ans[i].v2+" "+ans[i].v1+" "+ans[i].w);	
		}
		

	}
	

}
