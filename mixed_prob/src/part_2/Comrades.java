package part_2;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import part_2.Tree_divisors.edges;

public class Comrades {
	public static class edges extends ArrayList<Integer>{}
	public static int[] intime;
	public static int[] outtime;
	public static int timer=0;
 // fuction that returns an array with values as rank of soldiers
public static int[] create_list(int[] senior){
	edges[] trans_edges=new edges[senior.length];
	// rank array
	int[] rank=new int[senior.length];
	// this creates the transposed graph with 0 as the junior most soldier
	for(int i=1;i<senior.length;i++) {
		if(trans_edges[senior[i]]==null) {
			edges put=new edges();
			put.add(i);
			trans_edges[senior[i]]=put;
		}
		else {
			trans_edges[senior[i]].add(i);
		}
	}
	intime=new int[senior.length];
	outtime=new int[senior.length];
	boolean[] visited=new boolean[senior.length];
	DFS(trans_edges, visited, 0);
	// assigning ranks
	for(int i=0;i<trans_edges.length;i++) {
		edges vertices=trans_edges[i];
		if(vertices==null) {continue;}
		for(int j=0;j<vertices.size();j++) {
			rank[vertices.get(j)]=rank[i]+1;
		}
	}
	return rank;
}
// this functions does DFS traversal
public static void DFS(edges[] edges,boolean[] visited,int idx){
	visited[idx]=true;
	timer++;
	intime[idx]=timer;
	// vertices
	edges vertices=edges[idx];
	if(vertices==null) {
		timer++;
		outtime[idx]=timer;
		return ;}
	for(int i=0;i<vertices.size();i++) {
		if(visited[vertices.get(i)]==false) {
			DFS(edges,visited,vertices.get(i));
		}
	}
	timer++;
	outtime[idx]=timer;
	
	//return comp;
}
public static boolean query(int u,int v) {
	return ((intime[u]<intime[v] && outtime[u]>outtime[v]) || (intime[v]<intime[u] && outtime[v]>outtime[u]) );
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;i++) {
        	int n=scanner.nextInt();
        	// immidiate senior array 
        	int[] senior=new int[n+1];
        	edges[] edges=new edges[n+1];
        	for(int j=1;j<senior.length;j++) {
        		senior[j]=scanner.nextInt();
        		if(edges[j]==null) {
        			edges put=new edges();
        			put.add(senior[j]);
        			edges[j]=put;
        		}
        		else {
        			edges[j].add(senior[j]);
        		}
        		if(edges[senior[j]]==null) {
        			edges put=new edges();
        			put.add(j);
        			edges[senior[j]]=put;
        		}
        		else {
        			edges[senior[j]].add(j);
        		}
        	}
        	// rank array
        	int[] rank=create_list(senior);
        	int[] in=intime;
        	int[] out=outtime;
        	int q=scanner.nextInt();
        	for(int j=0;j<q;j++) {
        		int x=scanner.nextInt();
        		int y=scanner.nextInt();
        		if(query(x, y)) {
        		if(rank[x]>rank[y]) {
        			System.out.println(rank[x]-rank[y]-1);
        			//System.out.println(intime[x]-intime[y]-1);
        		}
        		else {
					System.out.println(-1);
				}
        	}
        		else {System.out.println(-1);} 
        		
        	}
        	intime= null;
        	outtime= null;
        }
	}

}
