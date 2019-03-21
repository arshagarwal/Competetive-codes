package part_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Just_shortestDistance {
	
	public static HashMap<Integer, ArrayList<Integer>> vertex_record=new HashMap<>();
	
	// this function updates the shortest distance array whenever an edge is added
	public static void update_shortestDistance(int V,int[] distance){
		boolean[] visited=new boolean[V+1];
		Queue<Integer> queue=new LinkedList<>();
		queue.add(1);
		
		//initializing distance as -1
		for(int i=0;i<distance.length;i++) {
			distance[i]=-1;
		}
		distance[1]=0;
		// BFS traversal
		while(queue.isEmpty()==false) {
			// current element
			int curr=queue.remove();
			visited[curr]=true;
			// vertices
			ArrayList<Integer> vertices=vertex_record.get(curr);
			if(vertices==null) {continue;}
			for(int i=0;i<vertices.size();i++) {
				if(visited[vertices.get(i)]==false) {
					queue.add(vertices.get(i));
					if(distance[vertices.get(i)]==-1) {
					distance[vertices.get(i)]=distance[curr]+1;}
				}
			}
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		// segment tree containing the shortest distances 
		// initialized as -1
		int[] tree=new int[4*N];
		for(int i=0;i<tree.length;i++) {
			tree[i]=-1;
		}
		// the array that contains the shortest distance
		int[] distance=new int[N+1];
		// initializing the distance array to be -1
		for(int m=0;m<distance.length;m++) {
			distance[m]=-1;
		}
		distance[1]=0;
		for(int i=0;i<M;i++) {
			int type=scanner.nextInt();
			
			// get shortest distance from 1 to X
			if(type==1) {
				int X=scanner.nextInt();
				System.out.println(distance[X]);
			}
			// add an edge from X to Y
			else if(type==2) {
				int X=scanner.nextInt();
				int Y=scanner.nextInt();
				if(vertex_record.containsKey(X)){
	        		ArrayList<Integer> put=vertex_record.get(X);
	        		put.add(Y);
	        		vertex_record.put(X, put);
	        		
	        	}
	        	else {
	        		ArrayList<Integer> value=new ArrayList<>();
	        		value.add(Y);
	        		vertex_record.put(X, value);
	        		
	        	}
	        	if(vertex_record.containsKey(Y)){
	        		ArrayList<Integer> put=vertex_record.get(Y);
	        		put.add(X);
	        		vertex_record.put(Y, put);
	        		
	        	}
	        	else {
	        		ArrayList<Integer> value=new ArrayList<>();
	        		value.add(X);
	        		vertex_record.put(Y, value);
	        		
	        	}
			update_shortestDistance(N, distance);
			}
		}

	scanner.close();}
}
