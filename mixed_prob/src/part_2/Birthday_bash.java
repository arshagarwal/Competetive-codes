package part_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Birthday_bash {
	public static class edges extends HashMap<Integer, Integer>{}
	public static int mod=(int)Math.pow(10, 9)+7;
	public static long mod_product(long a,long b) {
		long ans=((a)%mod*(b)%mod)%mod;
		return ans;
	}
public static long ans=0;
// this fuction adds the sum of product of all possible paths in ans variable and returns
// the sum of product of paths from the current idx(index)
public static long solve(int parent,edges[] input,int idx){
	long curr=1;
	Iterator<Integer> iterator=input[idx].keySet().iterator();
	while(iterator.hasNext()) {
		// current element
		int element=iterator.next();
		// weight of edge from idx
		int w=input[idx].get(element);
		if(element!=parent) {
			// current child answer
			long sub_ans=solve(idx, input, element);
			//ans+=((mod_product(sub_ans, w))%mod+(mod_product(curr-1, w))%mod)%mod;
			ans+=mod_product(sub_ans, mod_product(curr, w));
			curr+= mod_product(sub_ans, w);
			ans=ans%mod;
			curr=curr%mod;
			
		}
	}
	return curr;
}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader s=new FastReader();
		int n=s.nextInt();
		// array of hashmap
	edges[] input=new edges[n+1];
	// initializing the input
	for(int i=0;i<input.length;i++) {
		edges put =new edges();
		input[i]=put;
	}
	for(int i=0;i<n-1;i++) {
		int u=s.nextInt();
		int v=s.nextInt();
		int c=s.nextInt();
		input[u].put(v, c);
		input[v].put(u, c);
	}
	solve(-1, input, 1);
	System.out.println(ans);	
	}

}
