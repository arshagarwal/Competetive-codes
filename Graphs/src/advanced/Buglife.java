package advanced;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Buglife {
	public static class edges extends ArrayList<Integer>{}
	public static boolean bipartite(edges[] input,int n) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;i++) {
        	int n=scanner.nextInt();
        	int m=scanner.nextInt();
        	// storing interactions
        	edges[] input=new edges[n+1];
        	for(int j=0;j<m;j++) {
        		int v1=scanner.nextInt();
        		int v2=scanner.nextInt();
        		if(input[v1]!=null) {
        		input[v1].add(v2);
        		}
        		else {
        			edges put=new edges();
        			put.add(v2);
        			input[v1]=put;
        		}
        		if(input[v2]!=null) {
            		input[v2].add(v1);
            		}
            		else {
            			edges put=new edges();
            			put.add(v1);
            			input[v2]=put;
            		}
        	}
        	boolean ans=bipartite(input, n);
        	System.out.println("Scenario #"+(i+1)+":");
        	if(ans==true) {
        		System.out.println("No suspicious bugs found!");
        	}
        	else {
        		System.out.println("Suspicious bugs found!");
        	}
        }
	}

}
