package fenwick_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class K_query {
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
public static class event implements Comparable<event>{
	int left;
	int right;
	int value;
	int index=0;
	@Override
	public int compareTo(event a){
		if(a.value!=this.value) {
			return this.value-a.value;
		}
		else {
			return this.left-a.left;
		}
	}
	
}
public static int query(int index,int[] fenwick_tree) {
	int value=0;
	for(;index>0;index-=index&(-index)) {
		value+=fenwick_tree[index];
	}
	return value;
}
public static void update(int index, int[] fenwick_tree) {
	for(;index<fenwick_tree.length;index+=index&(-index)) {
		fenwick_tree[index]++;
	}	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader s=new FastReader();
		int n=s.nextInt();
		int[] input=new int[n];
		for(int i=0;i<input.length;i++) {
			input[i]=s.nextInt();
		}
		int q=s.nextInt();
		event[] query_input=new event[q+n];
		for(int i=0;i<q;i++) {
			query_input[i]=new event();
			query_input[i].left=s.nextInt();
			query_input[i].right=s.nextInt();
			query_input[i].value=s.nextInt();
			query_input[i].index=i;
		}
		for(int i=q;i<query_input.length;i++) {
			query_input[i]=new event();
			query_input[i].left=0;
			query_input[i].right=i-q;
			query_input[i].value=input[i-q];
			
		}
		int[] fenwick_tree=new int[n+1];
		int [] ans=new int[q];
		Arrays.sort(query_input,Collections.reverseOrder());
		for(int i=0;i<query_input.length;i++) {
			if(query_input[i].left==0) {
				update(query_input[i].right+1, fenwick_tree);
			}
			else {
				ans[query_input[i].index]=(query(query_input[i].right, fenwick_tree)-query(query_input[i].left-1, fenwick_tree));
			}
		}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}

	}

}
