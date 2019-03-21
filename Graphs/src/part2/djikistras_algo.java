package part2;

import java.util.ArrayList;
import java.util.Scanner;

public class djikistras_algo {
	public static class custom{
		int v;
		int w;
	}
	public static class Custom_ArrayList extends ArrayList<custom>{	
	}
	public static void get_min_distance(Custom_ArrayList[] input,int V){
		boolean[] visited=new boolean[V];
		int[] weight=new int[V];
		int[] parent=new int[V];
		//initializing the weight array
		for(int i=1;i<V;i++) {
			weight[i]=Integer.MAX_VALUE;
		}
		int curr=0;
		// iterating over all the vertices
		for(int i=0;i<V;i++){
			visited[curr]=true;
			// neighbouring vertices variable
			Custom_ArrayList vertices=input[curr];
			// iterating over neighbouring vertices
			for(int t=0;t<vertices.size();t++){
				custom vertex=vertices.get(t);
				int value=vertex.v;
				if(visited[value]==false) {
					if(weight[value]>(vertex.w+weight[curr])) {
						weight[value]=vertex.w+weight[curr];
					}
				}
			}
			int min=Integer.MAX_VALUE;
			// now looking for the next curr
			for(int m=0;m<V;m++) {
				if(visited[m]==false && min>weight[m]) {
					curr=m;
					min=weight[m];
				}
			}
		}
		for(int i=0;i<weight.length;i++) {
			System.out.println(i+" "+weight[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int V=scanner.nextInt();
		int E=scanner.nextInt();
		// input variable is an array of arraylist containing custom class objects
		Custom_ArrayList[] input=new Custom_ArrayList[V];		
		for(int i=0;i<E;i++) {
			Custom_ArrayList put=new Custom_ArrayList();
			Custom_ArrayList put2=new Custom_ArrayList();
			int v1=scanner.nextInt();
			int v2=scanner.nextInt();
			int w=scanner.nextInt();
			custom p1=new custom();
			p1.v=v2;
			p1.w=w;
			custom p2=new custom();
			p2.v=v1;
			p2.w=w;
			if(input[v1]!=null) {
			input[v1].add(p1);
			}
			else {
				put.add(p1);
				input[v1]=put;
			}
			if(input[v2]!=null) {
				input[v2].add(p2);
				}
				else {
					put2.add(p2);
					input[v2]=put2;
				}
		}
		get_min_distance(input, V);
		//System.out.println(input);
	}

}
