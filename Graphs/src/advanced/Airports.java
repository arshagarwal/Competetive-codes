package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import advanced.Buglife.edges;
import part2.kruskals_algo;
import part2.kruskals_algo.edge;

public class Airports {
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
	// function that creates edge[] object for kruskals
	public static edge[] create_object(ArrayList<Integer> curr,edges[] poss_rds,int[][] cost_matrix) {
		ArrayList<edge> list=new ArrayList<>();
		for(int i=0;i<curr.size();i++){
			// curr element
			int element=curr.get(i);
			// all vertices of the current elemnt
			edges vertices=poss_rds[element];
			for(int j=0;j<vertices.size();j++) {
				if(curr.contains(vertices.get(j))) {
					edge put=new edge(0);
					put.v1=element;
					put.v2=vertices.get(j);
					put.w=cost_matrix[put.v1][put.v2];
					list.add(put);
				}
			}
		}
		edge[] ans=new edge[list.size()];
		for(int i=0;i<list.size();i++) {
			ans[i]=list.get(i);
		}
		return ans;
	}
public static class edges extends ArrayList<Integer>{}
public static void dfs(edges[] poss_rds,ArrayList<Integer>comp, boolean[] visited,int index) {
	visited[index]=true;
	comp.add(index);
	edges vertices=poss_rds[index];
	if(vertices==null) {return;}
	for(int i=0;i<vertices.size();i++){
		if(visited[vertices.get(i)]==false){
		dfs(poss_rds, comp, visited, vertices.get(i));}
	}
}
 public static ArrayList<ArrayList<Integer>> get_components(edges[] poss_rds,int N){
   boolean[] visited=new boolean[N+1];
   ArrayList<ArrayList<Integer>> output=new ArrayList<>();
   for(int i=1;i<visited.length;i++) {
	   if (visited[i]==false) {
        ArrayList<Integer> comp=new ArrayList<>();
        dfs(poss_rds,comp,visited,i);
        output.add(comp);
	}
   }
   return output;
}
 // function to calcualate MST
 public static edge[] kruskal_mst(edge[] input,int V,int N){
		int[] parent = new int[N];
		// initializing parent array
		for(int i=0;i<N;i++) {
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
 // this function simply adds the total cost of the plan that was calculated
 public static ArrayList<Integer> final_ans(edge[] input){
	 int cost=0;
	 // to count no of airports
	 int count=0;
	 for(int i=0;i<input.length;i++) {
		 cost+=input[i].w;
		 if(input[i].v1==0 || input[i].v2==0) {count++;}
	 }
	 ArrayList<Integer> ans=new ArrayList<>();
	 ans.add(cost);
	 ans.add(count);
	 return ans;
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;i++) {
        	int N=scanner.nextInt();
        	int M=scanner.nextInt();
        	int A=scanner.nextInt();
        	edge[] input=new edge[N+1];
        	int cost=0;
        	int count=0;
        	// variable for possible roads
        	edges[] poss_rds=new edges[N+1];
        	int[][] cost_matrix=new int[N+1][N+1];
        	for(int j=0;j<M;j++) {
        		int X=scanner.nextInt();
        		int Y=scanner.nextInt();
        		int C=scanner.nextInt();
        		if(cost_matrix[X][Y]==0) {
        		cost_matrix[X][Y]=C;
        		cost_matrix[Y][X]=C;}
        		else {
        			int put=Math.min(cost_matrix[X][Y], C);
        			cost_matrix[X][Y]=put;
        			cost_matrix[Y][X]=put;
        		}
        		if(poss_rds[X]!=null) {
            		poss_rds[X].add(Y);
            		}
            		else {
            			edges put=new edges();
            			put.add(Y);
            			poss_rds[X]=put;
            		}
            		if(poss_rds[Y]!=null) {
                		poss_rds[Y].add(X);
                		}
                		else {
                			edges put=new edges();
                			put.add(X);
                			poss_rds[Y]=put;
                		}
        	}
        	ArrayList<ArrayList<Integer>> conn_comp=get_components(poss_rds, N);
        	for(int h=0;h<cost_matrix.length;h++){
        		if(poss_rds[h]!=null) {
        		poss_rds[h].add(0);}
        		else {
        			edges put=new edges();
        			put.add(0);
        			poss_rds[h]=put;
        		}
        		cost_matrix[0][h]=A;
        		cost_matrix[h][0]=A;
        		
        	}
        	for(int v=0;v<conn_comp.size();v++) {
        		// curr comp
        		ArrayList<Integer> curr=new ArrayList<>();
        		curr=conn_comp.get(v);
        		curr.add(0);
        		Collections.sort(curr);
        		// function that creates edge object so that kruskals algo can be applied
        		 input=create_object(curr, poss_rds, cost_matrix);
        		 Arrays.sort(input);
        		 // calcuating MST
        		 edge[] ans=kruskal_mst(input,curr.size(),N+1);
        		 ArrayList<Integer> final_ans=final_ans(ans);
        		 cost+=final_ans.get(0);
        		 count+=final_ans.get(1);
        	}
        	System.out.println(cost+" "+count);      
        	 
        }
	}

}
