package part_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Oliver_Bob {
	public static int timer;
	public static int[] intime;
	public static int[] outtime;
	public static class edges extends ArrayList<Integer>{}
	 static class FastReader 
	    { 
	        BufferedReader br; 
	        StringTokenizer st; 
	  
	        public FastReader() 
	        { 
	            br = new BufferedReader(new
	                     InputStreamReader(System.in)); 
	        } 
	  
	        String next() 
	        { 
	            while (st == null || !st.hasMoreElements()) 
	            { 
	                try
	                { 
	                    st = new StringTokenizer(br.readLine()); 
	                } 
	                catch (IOException  e) 
	                { 
	                    e.printStackTrace(); 
	                } 
	            } 
	            return st.nextToken(); 
	        } 
	  
	        int nextInt() 
	        { 
	            return Integer.parseInt(next()); 
	        } 
	  
	        long nextLong() 
	        { 
	            return Long.parseLong(next()); 
	        } 
	  
	        double nextDouble() 
	        { 
	            return Double.parseDouble(next()); 
	        } 
	  
	        String nextLine() 
	        { 
	            String str = ""; 
	            try
	            { 
	                str = br.readLine(); 
	            } 
	            catch (IOException e) 
	            { 
	                e.printStackTrace(); 
	            } 
	            return str; 
	        } 
	    }
	 // dfs to set the intime and the outtime
	 public static void dfs(edges[] input,boolean[] visited,int idx) {
		 visited[idx]=true;
		 timer++;
		 intime[idx]=timer;
		 edges vertices=input[idx];
		 if(vertices==null) {
			 timer++;
			 outtime[idx]=timer;
		 }
		 for(int i=0;i<vertices.size();i++) {
			 if(visited[vertices.get(i)]==false) {
				 dfs(input, visited, vertices.get(i));
			 }
		 }
		 timer++;
		 outtime[idx]=timer;
	 }
	 public static boolean query(int u,int v) {
		 return((intime[u]<intime[v] && outtime[u]>outtime[v])|| (intime[v]<intime[u] && outtime[v]>outtime[u]));
	 }
	 // dfs using the stack data structure
	 public static void dfs_2(edges[] input) {
		 Stack<Integer> stack=new Stack<>();
		 stack.push(1);
		 boolean[] visited=new boolean[input.length];
		 while(stack.isEmpty()==false) {
			 int pop=stack.pop();
			 timer++;
			 intime[pop]=timer;
			 visited[pop]=true;
			 // vertices
			 edges vertices=input[pop];
			 for(int i=0;i<vertices.size();i++) {
				 if(visited[vertices.get(i)]==false)
				  stack.push(vertices.get(i));
			 }
			 timer++;
			 outtime[pop]=timer;
		 }
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 FastReader sFastReader=new FastReader();
	 int n=sFastReader.nextInt();
	 edges[] input=new edges[n+1];
	 // initializing the input array
	 for(int i=0;i<input.length;i++) {
		 edges put=new edges();
		 input[i]=put;
	 }
	 for(int i=0;i<n-1;i++) {
		 int A=sFastReader.nextInt();
		 int B=sFastReader.nextInt();
		 input[A].add(B);
		 input[B].add(A);
	 }
	 int q=sFastReader.nextInt();
	 for(int i=0;i<q;i++) {
		 int type=sFastReader.nextInt();
		 int X=sFastReader.nextInt();
		 int Y=sFastReader.nextInt();
		 intime=new int[n+1];
		 outtime=new int[n+1];
		 boolean[] visited=new boolean[n+1];
		// dfs(input, visited, 1);
		 dfs_2(input)
		 ;
		 int[] in=intime;
		 int[] out=outtime;
		 // case 1 towards the mansion
		 if(type==0) {
			 if(query(X, Y)) {
				 // case when X is the parent
				 if(intime[X]<intime[Y]) {
					 System.out.println("YES");
				 }
				 else {
					System.out.println("NO");
				}
			 }
			 else {
				 System.out.println("NO");
			 }
		 }
		 // case when going away from the mansion
		 else {
			 if(query(X, Y)) {
				 // if Y is the parent
			 if(intime[X]>intime[Y]) {
				 System.out.println("YES");
			 }
			 else {
				 System.out.println("NO");
			 }
		 }
			 else {
				 System.out.println("NO");
			 }	 
		 }
	 }
	 
	 
	 
        
	}

}
