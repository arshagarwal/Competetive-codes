package advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import advanced.Buglife.edges;

public class Fill_mtr {
	public static class edges extends ArrayList<Integer>{}
	// dictionary that contains components with master parents as keys
	public static HashMap<Integer, ArrayList<Integer>> comp=new HashMap<>();
	// function to create the comp dictionary
	public static void make_components(int[][] B,int[] parent){
		for(int i=1;i<parent.length;i++) {
			int index=i;
			while(parent[index]!=index) {index=parent[index];}
			if (comp.containsKey(index)) {
				comp.get(index).add(i);
			}
			else {ArrayList<Integer> put=new ArrayList<>();
			put.add(i);
			comp.put(index, put);
			}
			// assining master parents in the parent array
			parent[i]=index;
		}
	}public static boolean bipartite(edges[] input,int n) {
		// that divides the vertices into two groups
		edges[] group =new edges[2];
		edges a1=new edges();
		edges a2=new edges();
		group[0]=a1;
		group[1]=a2;
		// queue of numbers that have been added to the stack
		Queue<Integer> pending=new LinkedList<>();
		//pending.add(1);
		// visited array
		boolean[] visited=new boolean[n+1];
		for(int m=1;m<visited.length;m++){
			if(visited[m]==false) {
				group[0].add(m);
		pending.add(m);	
		visited[m]=true;
		while(!pending.isEmpty()) {
			// current element
			int curr=pending.remove();
			visited[curr]=true;
			int grp_no;
			if(group[0].contains(curr)) {
				grp_no=0;
			}
			else {grp_no=1;}
			//neighbours
			edges vertices=input[curr];
			// now adding the neighbors to the queue and to the colour group
			if(vertices==null) {continue;
			}
			for(int i=0;i<vertices.size();i++) {
			if(visited[vertices.get(i)]==false){
			pending.add(vertices.get(i));
			// if it is not in any group
			if(group[0].contains(vertices.get(i))==false && group[1].contains(vertices.get(i))==false) {
                group[1-grp_no].add(vertices.get(i));				
			}
			else if(group[grp_no].contains(vertices.get(i))) {return false;}
			}}}}
		}
		return true;
	}

	// function first assigns edges and then checks if bipartite is possible or not
	public static String solve(int[][] B,int N,int[] parent){
		// sanity check #1
		//diagonal elements should be zero
		for(int i=1;i<B.length;i++) {
			if(B[i][i]==1) {return "no";
		}
		}
		// inverse elements should be zero
		for(int i=1;i<B.length;i++) {
			for(int j=1;j<B[0].length;j++) {
				if(B[i][j]!=-1 && B[j][i]!=-1) {
				if(B[i][j]!=B[j][i]) {return "no";}
			}}
		}
		make_components(B, parent);
		HashMap<Integer, ArrayList<Integer>> compp=comp;
		edges[] record =new edges[N+1];
		for(int i=0;i<record.length;i++) {
			record[i]=new edges();
		}
		// iterating to assign edges
	    for(int i=1;i<B.length;i++) {
	    	for(int j=1;j<B.length;j++) {
	    	  if(B[i][j]==1) {
	    		  // connecting master parent of i and j
	    		  record[parent[i]].add(parent[j]);
	    		  record[parent[j]].add(parent[i]);
	    	  }
	    	}
	    }
	    // now applying bipartite
	    if( bipartite(record, N)) {
	    	return "yes";
	    }
	    else {return "no";}
	    
	}
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int t=scanner.nextInt();
	for(int i=0;i<t;i++) {
	int N=scanner.nextInt();
	int Q=scanner.nextInt();
	int[] parent=new int[N+1];
	// the B matrix
	int[][] B=new int[N+1][N+1];
	// initializing the B array as -1
	for(int h=1;h<B.length;h++) {
		for(int g=1;g<B.length;g++) {
			B[h][g]=-1;
		}
	}
	ArrayList<ArrayList<Integer>> indices=new ArrayList<>();
	for(int j=0;j<Q;j++) {
		int I=scanner.nextInt();
		int J=scanner.nextInt();
		int val=scanner.nextInt();
		B[I][J]=val;
		//storing the indices where value is zero
		if(val==0) {
			ArrayList<Integer> put=new ArrayList<>();
			put.add(I);
			put.add(J);
			indices.add(put);
		}
		// making the parent array
		//int[] parent=new int[N+1];
		//initializing the parent array
		for(int k=0;k<parent.length;k++) {
			parent[k]=k;
		}
		if(val==0) {
			int temp_p1=parent[I];
			int temp_p2=parent[J];
			// to get the master parent
			while(parent[temp_p1]!=temp_p1) {
				temp_p1=parent[temp_p1];
			}
			while(parent[temp_p2]!=temp_p2) {
				temp_p2=parent[temp_p2];
			}
			parent[temp_p1]=temp_p2;
		}
		
		
	}
	System.out.println(solve(B, N, parent));}
}
}
