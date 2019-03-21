package part2;

import java.util.Scanner;

public  class prims_algo {
	public static class edge{
		int v1;
		int v2;
		int w;
	}
   public static void solve(int[][] input,int V) {
	   boolean[] visited=new boolean[V];
	   int[] weight=new int[V];
	   // initializing the weight array
	   for(int i=0;i<weight.length;i++) {
		   weight[i]=Integer.MAX_VALUE;
	   }
	   weight[0]=0;
	   int[] parent=new int [V];
	   // iterating over all the vertices
	   int curr=0;
	   for(int i=0;i<V;i++) {
		   visited[curr]=true;
		   int new_curr=curr;
		   //min to select the neighbouring  vertex with min weight
		   int min=Integer.MAX_VALUE;
		   // iterating over the neighbouring vertices of the selected vertex
		   for(int t=0;t<V;t++) {
			   // if the element is not visited and has connection
			   if(input[curr][t]!=0 && visited[t]==false) {
				   // if better value is available
				   if(weight[t]>input[curr][t]) {
					   weight[t]=input[curr][t];
					   parent[t]=curr;
					   if(weight[t]<min) {
						   min=weight[t];
						    new_curr=t;
					   }
				   }
			   }
		   }
		    min=Integer.MAX_VALUE;
		   for(int m=0;m<V;m++) {
			   if(weight[m]<min && visited[m]==false) {
				   new_curr=m;
				   min=weight[m];
			   }
		   }
		   curr=new_curr;
	   }
	   edge[] ans =new edge[V];
	   // creating the final edge array
	   for(int i=1;i<ans.length;i++) {
		   if(i<parent[i])
	   System.out.println(i+" "+parent[i]+" "+weight[i]);
		   else
			   System.out.println(parent[i]+" "+i+" "+weight[i]);
	   }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int V=s.nextInt();
		int E=s.nextInt();
		int[][] input=new int[V][E];
		for(int i=0;i<E;i++) {
			int v1=s.nextInt();
			int v2=s.nextInt();
			int w=s.nextInt();
			input[v1][v2]=w;
			input[v2][v1]=w;
		}
		solve(input, V);
		

	}

}
