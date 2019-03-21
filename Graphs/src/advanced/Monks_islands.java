package advanced;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Monks_islands {
	public static class bridges extends ArrayList<Integer>{}
	public static int  BFS_traversal(bridges[] input,int N,int v2){
		v2=N;
       ArrayList<Integer> ans=new ArrayList<>();
       Queue<Integer> queue=new LinkedList<>();
       // visited array
       boolean[] visited=new boolean[N+1];
       // variable to break since dest has been found
       int indicator =0;
    // distance of vertices
	   int[] distance=new int[N+1
	                          ];
	   // initializing the distance array as zero
	   for(int i=0;i<distance.length;i++) {
		   distance[i]=0;
	   }
       queue.add(1);
       while(queue.size()!=0) {
    	   // the current element
    	   
    	   int pop =queue.remove();
    	   if(visited[pop]) {continue;}
    	   visited[pop]=true;
     	  
    	   // vertices of the current element
    	   bridges vertices=input[pop];
    	   // adding all the vertices in the queue and adding a distance
    	   for(int i=0;i<vertices.size();i++) {
    		   if(visited[vertices.get(i)]) {continue;}
    		   if(queue.contains(vertices.get(i))) {continue;}
    		   queue.add(vertices.get(i));
    		   distance[vertices.get(i)]=distance[pop]+1;
    		   if(vertices.get(i)==v2) {
    			   // variable to break since dest has been found
    			   indicator=1;
    			   break;
    		   }}
    		   if(indicator==1) {break;}   	    
       }
       return distance[v2];
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int i=0;i<T;i++) {
			int N=scanner.nextInt();
			int M=scanner.nextInt();
			bridges[] input=new bridges[N+1];
			for(int j=0;j<M;j++) {
				int X=scanner.nextInt();
				int Y=scanner.nextInt();
				bridges put1=new bridges();
				bridges put2=new bridges();
				if(input[X]==null && input[Y]==null) {
					put1.add(Y);
					input[X]=put1;
					put2.add(X);
				    input[Y]=put2;	
				}
				else if(input[X]==null || input[Y]==null) {
					if(input[X]==null) {
						put1.add(Y);
						input[X]=put1;
						input[Y].add(X);
					}
					else {
						put2.add(X);
						input[Y]=put2;
						input[X].add(Y);
					}
				}
				else {
			 input[X].add(Y);
			 input[Y].add(X);
				}
				
			}
			System.out.println(BFS_traversal(input, N, N));
		}
	}

}
