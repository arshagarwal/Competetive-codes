package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class journey_toMoon {
	public static boolean [] visited;
	public static class edges extends ArrayList<Integer>{
	}
	public static ArrayList<Integer> DFS(edges[] edge,int s,ArrayList<Integer>all_vertices) {
		visited[s]=true;
		//ArrayList<Integer> all_vertices=new ArrayList<>();
		all_vertices.add(s);
		edges adjacent=edge[s];
		for(int i=0;i<adjacent.size();i++){
			if(visited[adjacent.get(i)]==false)
			DFS(edge,adjacent.get(i),all_vertices);
		}
		return all_vertices;
	}
	public static ArrayList<ArrayList<Integer>>get_connected_components(edges[]edge){
		ArrayList<ArrayList<Integer>> connected_components=new ArrayList<>();
		for(int i=0;i<edge.length;i++) {
			if(visited[i]==false) {
				ArrayList<Integer> vertices_curr=new ArrayList<>();
						vertices_curr=DFS(edge,i,vertices_curr);
				connected_components.add(vertices_curr);
			}
		}
		return connected_components;
	}
	public static int factorial(int a) {
		if(a==0) {
			return 1;
		}
		int ans=1;
		for(int i=1;i<=a;i++) {
			ans=ans*i;
		}
		return ans;	
	}
	// this function returns aCb
	public static long get_C(int a){
		long ans=(long)a*(a-1);
		ans=ans/2;
		return ans;
	}
	public static long get_total_combinations(edges[] adj_edge) {
		long ans=0;
		ArrayList<ArrayList<Integer>> connected_components=get_connected_components(adj_edge);
		// dictionary that contains the equal lengthed pairs
		// with keys as the size of the pairs
		HashMap<Integer,Integer> record=new HashMap<>();
		for(int i=0;i<connected_components.size();i++) {
			int key=connected_components.get(i).size();
			if(record.containsKey(key)){
				// check
				record.put(key,record.get(key)+1);
			}
			else {
				ArrayList<ArrayList<Integer>> put =new ArrayList<>();
				record.put(key, 1);
			}
		}
		// adding all the pairs among equal lengthed pairs
		Iterator<Integer> iterator=record.keySet().iterator();
		int[] keys=new int[record.keySet().size()];
		//record.keySet().toArray(keys);
		int m=0;
		while(iterator.hasNext()) {
			int key=iterator.next();
			keys[m++]=key;
			ans+=get_C(record.get(key))*key*key;
		}
		iterator=record.keySet().iterator();
		// adding combinations bw different lengthed pairs
		for(int i=0;i<keys.length;i++) {
			for(int j=i+1;j<keys.length;j++) {
				int key1=keys[i];
				int key2=keys[j];
				// no of elements
				int no_1=record.get(keys[i]);
				int no_2=record.get(keys[j]);
				// the answer bw the ith and jth pair
				int temp=no_1*key1*no_2*key2;
				ans+=temp;
			}
		}
		return ans;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		visited=new boolean[n];
		int p=scanner.nextInt();
		edges[] edge=new edges[n];
		for(int i=0;i<edge.length;i++) {
			edge[i]=new edges();
		}
		for(int i=0;i<p;i++){
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			if(edge[a]==null) {
				edge[a]=new edges();
				edge[a].add(b);
			}
			else {edge[a].add(b);}
			if(edge[b]==null) {
				edge[b]=new edges();
				edge[b].add(a);
			}
			else {edge[b].add(a);}
			
		}
		System.out.println(get_total_combinations(edge));

	}

}
