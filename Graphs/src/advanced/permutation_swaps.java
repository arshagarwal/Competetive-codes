package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class permutation_swaps {
	public static class edges extends ArrayList<Integer>{
		
	}
	public static ArrayList<Integer> DfS(int[] array,edges[] edges,ArrayList<Integer> ans,int idx,boolean[] visited){
		if(visited[idx]) {
			return ans;
		}
        ans.add(idx);
		visited[idx]=true;
		//case when no neighbour
      if(edges[idx]==null){  	  
    	  return ans;}
      // case when no unvisited neighbour
      else if(edges[idx].size()==1 && visited[edges[idx].get(0)]==true) {
    	  return ans;
      }
      else {
    	 //ans.add(idx);
    	  for(int i=0;i<edges[idx].size();i++) {
    		  DfS(array, edges, ans,edges[idx].get(i), visited);
    	  }
    	  return ans;
      } 
     
	}
	public static String solve(edges[] edges,int[] P,int[] Q){
		boolean[] visited =new boolean[P.length];
		// loop to iterate on visited array and get comp of unvisited ones
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==false) {
				boolean[] visited2=Arrays.copyOfRange(visited, 0, visited.length);
				ArrayList<Integer> ans_p=new ArrayList<>();
				// getting all the connected components(indexes) for P and Q starting with index i
				ArrayList<Integer> comp_P=DfS(P, edges, ans_p, i, visited);
				ArrayList<Integer> ans_q=new ArrayList<>();
				ArrayList<Integer> comp_Q=DfS(Q, edges, ans_q, i, visited2);
				ArrayList<Integer> Ans_q=new ArrayList<>();
				// converting the connected index list to connected values Lists
				for(int k=0;k<ans_q.size();k++) {
					Ans_q.add(Q[ans_q.get(k)]);
				}
				ArrayList<Integer> Ans_p=new ArrayList<>();
				for(int k=0;k<ans_p.size();k++){
					Ans_p.add(P[ans_p.get(k)]);
					}
				// sorting the Arrays
				Collections.sort(Ans_p);
				Collections.sort(Ans_q);
				if(!Ans_p.equals(Ans_q)){
					return "No";
				}
			}
		}
		return "Yes";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int i=0;i<T;i++) {
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		int[] P=new int[N];
		for(int j=0;j<N;j++){
			P[j]=scanner.nextInt();
		}
		int [] Q=new int[N];
		for(int m=0;m<N;m++) {
			Q[m]=scanner.nextInt();
		}
		// creating an array of list of neighboring vertices
		edges[] edges =new edges[N];
		for(int j=0;j<M;j++){
			edges put =new edges();
			edges putt=new edges();
			int v1=scanner.nextInt()-1;
			int v2=scanner.nextInt()-1;
			if(edges[v1]==null && edges[v2]==null){
				put.add(v2);
				putt.add(v1);
				edges[v1]=put;
				edges[v2]=putt;
			}
			else if(edges[v1]==null || edges[v2]==null){
				if(edges[v1]==null) {
					put.add(v2);
					edges[v1]=put;
					edges[v2].add(v1);
				}
				else {putt.add(v1);
				edges[v2]=putt;
				edges[v1].add(v2);
				}
			}
			else {
			edges[v1].add(v2);
			edges[v2].add(v1);
		}}
		
		System.out.println(solve(edges, P, Q));
		}
		

	}

}
