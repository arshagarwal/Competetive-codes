package advanced;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

import advanced.Kingdom_ofMonkeys.edges;

public class Bottom {
	public static void dfs2(edges[] input,boolean[] visited,int index,ArrayList<Integer> comp) {
		visited[index]=true;
		comp.add(index);
		// neighbouring vertices
		edges vertices=input[index];
		if(vertices==null) {
			return;
		}
		for(int i=0;i<vertices.size();i++) {
			if(visited[vertices.get(i)]==false){
				dfs2(input, visited, vertices.get(i), comp);
			}
			
		}
	} 
	public static void dfs(edges[] input,boolean[] visited,int index,Stack<Integer> finished) {
		visited[index]=true;
		// neighbouring vertices
		edges vertices=input[index];
		if(vertices==null) {
			finished.add(index);
			return;
		}
		for(int i=0;i<vertices.size();i++) {
			if(visited[vertices.get(i)]==false) {
				dfs(input, visited, vertices.get(i), finished);
			}
		
		}
		finished.add(index);
	}
	
	public static class edges extends ArrayList<Integer>{}
	public static ArrayList<ArrayList<Integer>> find_bottom(edges[] input,int v,edges[] input_t){
		// answer variable
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>(); 
		// the variable that contains all the scc components
		ArrayList<ArrayList<Integer>> scc=get_scc(input, v,input_t);
		// checking if the vertex of any scc has an edge with any other component
		 for(int i=0;i<scc.size();i++){
			 // curr_comp
			 ArrayList<Integer>curr_comp=scc.get(i);
			 for(int j=0;j<curr_comp.size();j++) {
				 //  current element
				 int curr=curr_comp.get(j);
				 // to indicate break
				 int flag=1;
				 if(input[curr]==null) {
					 ArrayList<Integer> put =new ArrayList<>();
					 put.add(curr);
					 ans.add(put);
					 break;}
				 for(int k=0;k<input[curr].size();k++) {
					 int w1=input[curr].get(k);
					 if(!curr_comp.contains(w1)) {
						 flag=flag^1;
						 break;
					 }
					 else if (k==input[curr].size()-1 && curr==curr_comp.get(curr_comp.size()-1)) {
						ans.add(curr_comp);
						flag=flag^1;
					}
				 }
				 if(flag==0) {break;}
			 }
		 }
		 return ans;
		
	}
	public static ArrayList<ArrayList<Integer>> get_scc(edges[] input,int v,edges[] input_t){
		// arrayList that contains scc
		ArrayList<ArrayList<Integer>> scc=new ArrayList<>();
	Stack<Integer> finished=new Stack<>();
	boolean[] visited=new boolean[v+1];
	// iteration to create stack
	for(int i=1;i<visited.length;i++) {
		if(visited[i]==false) {
			dfs(input, visited, i, finished);
		}}
		visited=new boolean[v+1];
		// iteration to fill components
		while(finished.isEmpty()==false) {
			// current element
			int curr=finished.pop();
			if(visited[curr]==false){
				ArrayList<Integer> comp=new ArrayList<>();
				dfs2(input_t, visited, curr, comp);
				scc.add(comp);
			}
		}
		return  scc;
	
	}
	// function to print list of list
 public static void print(ArrayList<ArrayList<Integer>> a){
	 // array made to sort
	 ArrayList<Integer> sort=new ArrayList<>();
     for(int i=0;i<a.size();i++) {
    	 // to print
    	 ArrayList<Integer> ar=a.get(i);
    	 //Collections.sort(ar);
    	 for(int j=0;j<ar.size();j++) {
    		 sort.add(ar.get(j));
    		 //System.out.print(ar.get(j)+" ");
    	 }
     }
     Collections.sort(sort);
     for(int i=0;i<sort.size();i++) {
    	 System.out.print(sort.get(i)+" ");
     }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		// no of vertices
		int v=s.nextInt();
	    while(v!=0) {
	    	// no of edges
	    	int e=s.nextInt();
	    	edges[] input=new edges[v+1];
	    	edges[] input_t=new edges[v+1];
	    	for(int i=0;i<e;i++) {
	    		int v1=s.nextInt();
	    		int w1=s.nextInt();
	    		if(input[v1]!=null) {
	    			input[v1].add(w1);
	    		}
	    		else {
	    			edges put=new edges();
	    			put.add(w1);
	    			input[v1]=put;
	    		}
	    		if(input_t[w1]!=null) {
	    			input_t[w1].add(v1);
	    		}
	    		else {
	    			edges put=new edges();
	    			put.add(v1);
	    			input_t[w1]=put;
	    		}
	    	
	    	}
	    		ArrayList<ArrayList<Integer>> ans=find_bottom(input, v,input_t);
	    		print(ans);
	    	System.out.println();
	    	v=s.nextInt();
	    }	
	    

	}

}
