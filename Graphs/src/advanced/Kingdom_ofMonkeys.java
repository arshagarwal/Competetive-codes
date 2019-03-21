package advanced;

import java.util.ArrayList;
import java.util.Scanner;

import advanced.Monks_islands.bridges;

public class Kingdom_ofMonkeys {
	public static class edges extends ArrayList<Integer>{}
	// function for DFS traversal
	public static void DFS(boolean[] visited,edges[] input,int index,ArrayList<Integer>ans){
		visited[index]=true;
		ans.add(index);
		// neighbouring vertices
		edges vertices=input[index];
		if(vertices==null) {
			return ;
		}
		for(int i=0;i<vertices.size();i++) {
			if(visited[vertices.get(i)]==false) {
			DFS(visited, input, vertices.get(i), ans);}
		}
		
	}
	public static ArrayList<ArrayList<Integer>> get_connected(edges[] input,int N){
		boolean[] visited=new boolean[N+1];
		ArrayList<ArrayList<Integer>> output=new ArrayList<>();
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==false) {
				ArrayList<Integer> ans=new ArrayList<>();
				DFS(visited,input,i,ans);
				output.add(ans);
			}
		}
		return output;
	}
	// this function gets the  final answer
	public static int solve(edges[] input,int N,int[] A) {
		int max=0;
		// list that contains all components
		ArrayList<ArrayList<Integer>> components=get_connected(input, N);
		for(int i=0;i<components.size();i++) {
			// current component
			ArrayList<Integer> curr=components.get(i);
			int sum=0;
			for(int j=0;j<curr.size();j++) {
				sum+=A[curr.get(j)];
			}
			if(max<sum) {max=sum;}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int i=0;i<t;i++) {
			int N=scanner.nextInt();
			int M=scanner.nextInt();
			edges[] input=new edges[N+1];
			int[] A=new int[N+1];
			for(int j=0;j<M;j++) {
				int X=scanner.nextInt();
				int Y=scanner.nextInt();
				edges put1=new edges();
				edges put2=new edges();
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
			for(int j=1;j<A.length;j++) {
				A[j]=scanner.nextInt();
			}
			System.out.println(solve(input,N,A));
		}
     
	}

}
