package part_2;

import java.util.ArrayList;
import java.util.Scanner;

public class BigP_road {
	public static class edges extends ArrayList<Integer>{}
	public static int[]dp;
	// this fuction return the total paths from idx to node n
	public static int noOFPaths(int parent,int idx,edges[] input,int n,boolean[] visited) {
		visited[idx]=true;
		if(idx==n) {
			dp[idx]=1;
			return 1;
		}
		edges vertices =input[idx];
		int ans=0;
		for(int i=0;i<vertices.size();i++){
			if(dp[vertices.get(i)]!=-1) {
				ans+=dp[vertices.get(i)];
			}
			else {
			if(vertices.get(i)!=parent && visited[vertices.get(i)]==false) {
			ans+=noOFPaths(idx, vertices.get(i), input, n,visited);}
		}}
		dp[idx]=ans;
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		dp=new int[n+1];
		// intializing dp with-1
		for(int i=0;i<dp.length;i++) {
			dp[i]=-1;
		}
		edges[] input=new edges[n+1];
		boolean[] visited=new boolean[n+1];
		for(int i=0;i<=n;i++) {
			edges put=new edges();
			input[i]=put;
		}
		int x=scanner.nextInt();
		int y=scanner.nextInt();
		while(x!=0) {
			input[x].add(y);
			x=scanner.nextInt();
			y=scanner.nextInt();
		}
		
		System.out.println(noOFPaths(-1, 1, input, n,visited));
		

	}

}
