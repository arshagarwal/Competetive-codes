import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import Capcity.edges;

public class dominos {
public static class edges extends ArrayList<Integer>{}
public static void dfs2(edges[] input,int index,boolean[] visited,ArrayList<Integer> comp) {
	visited[index]=true;
	comp.add(index);
	// vertices
	edges vertices=input[index];
	if(vertices==null) {
        return;
	}
	for(int i=0;i<vertices.size();i++) {
		if(visited[vertices.get(i)]==false) {
			dfs2(input, vertices.get(i), visited, comp);
		}
	}
}
public static void dfs(edges[] input_t,int index,boolean[] visited,Stack<Integer> finished) {
	visited[index]=true;
	// vertices
	edges vertices=input_t[index];
	if(vertices==null) {
		finished.add(index);
		return;
	}
	for(int i=0;i<vertices.size();i++) {
		if(visited[vertices.get(i)]==false) {
			dfs(input_t, vertices.get(i), visited,finished);
		}
	}
	finished.add(index);
	
}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int z=0;z<t;z++) {
        int n=s.nextInt();
        int m=s.nextInt();
        // taking input transpose and actual
        edges[] input=new edges[n+1];
        edges[] input_t=new edges[n+1];
        for(int i=0;i<m;i++) {
         int x=s.nextInt();
         int y=s.nextInt();
         if(input[x]!=null) {
        	 
        	 input[x].add(y);
         }
         else {
        	 edges put=new edges();
        	put.add(y);
        	input[x]=put;
         }
         if(input_t[y]!=null) {
        	 input_t[y].add(x);
         }
         else {
        	 edges put=new edges();
        	put.add(x);
        	input_t[y]=put;
         }
         
        }
	
        Stack<Integer> finished=new Stack<>();
        boolean[] visited=new boolean[n+1];
        // iteration to create stack
        for(int i=1;i<visited.length;i++) {
        	if(visited[i]==false) {
        		dfs(input, i, visited, finished);
        	}
        }
        visited=new boolean[n+1];
        int count=0;
        while(finished.empty()==false) {
        	
        // first element in the stack
        int pop = finished.pop();
        if(visited[pop]==false) {
        	count++;
        // component array
        ArrayList<Integer> comp=new ArrayList<>();
        dfs2(input, pop, visited, comp);}}
        System.out.println(count);
        
	}}

}
