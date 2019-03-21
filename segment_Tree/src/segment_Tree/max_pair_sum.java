package segment_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.FastReader;
import java.util.StringTokenizer;
public class max_pair_sum {
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
	public static class node{
		int max;
		int min;
	}
	public static node query(node[] tree,int s,int e,int L,int R,int t) {
		// completely inside
		if(L>=s && R<=e ) {
			return tree[t];
		}
		// completely outside
		else if(L>e || R<s){
			node ans=new node();
		    ans.max=Integer.MIN_VALUE+1;
			ans.min=Integer.MIN_VALUE;
			return ans;
		}
		// partially
		else {int mid=(L+R)/2;
			node ans1=query(tree, s, e, L, mid, 2*t);
			node ans2=query(tree, s, e, mid+1, R, 2*t+1);
			node ans=new node();
			ans.max=Math.max(ans1.max, ans2.max);
			ans.min=Math.min(Math.max(ans1.max, ans2.min), Math.max(ans1.min, ans2.max));
			return ans;
		}
	}
	public static void update(int[] input,node[] tree,int index,int s,int e,int t) {
	//System.out.println(s+" "+e+" "+" "+t);
		if(s==e) {
		tree[t].max=input[index];
	}		
		else {
			int mid=(s+e)/2;
			if(index<=mid){
			update(input, tree, index, s, mid, 2*t);
			tree[t].max=Math.max(tree[2*t].max, tree[2*t+1].max);
			tree[t].min=Math.min(Math.max(tree[2*t].max, tree[2*t+1].min), Math.max(tree[2*t].min, tree[2*t+1].max));
            }
			else {
			update(input, tree, index, mid+1, e, 2*t+1);
			tree[t].max=Math.max(tree[2*t].max, tree[2*t+1].max);
			tree[t].min=Math.min(Math.max(tree[2*t].max, tree[2*t+1].min), Math.max(tree[2*t].min, tree[2*t+1].max));
			}
			
		}
	}
	public static void build(int[] input,node[] tree,int s,int e,int t) {
	//	System.out.println(s+" "+e+" "+ t);
		if(s==e){
			node ans=new node();
			ans.max=input[s];
			ans.min=Integer.MIN_VALUE;
			tree[t]=ans;
		}
		else {
			int mid=(s+e)/2;
			build(input, tree, s, mid, 2*t);
			build(input, tree, mid+1, e, 2*t+1);
			node ans=new node();
			ans.max=Math.max(tree[2*t].max, tree[2*t+1].max);
			ans.min=Math.min(Math.max(tree[2*t].max, tree[2*t+1].min), Math.max(tree[2*t].min, tree[2*t+1].max));
			tree[t]=ans;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FastReader FastReader=new FastReader();
        int N=FastReader.nextInt();
        int[] input=new int[N];
        for(int i=0;i<N;i++) {
        	input[i]=FastReader.nextInt();
        }
        node[] tree=new node[4*N];
      //  tree[0].max=0;
        build(input, tree, 0, input.length-1, 1);
       /* for(int i=0;i<tree.length;i++) {
        	if (tree[i] != null) {
        		node a=tree[i];
				System.out.println(a.max+" "+a.min);
			}
        	else {
        		System.out.println("0"+" "+"0");
        	}
        }*/
        int Q=FastReader.nextInt();
        for(int i=0;i<Q;i++) {
        	String string=FastReader.next();
        	int x=FastReader.nextInt();
        	int y=FastReader.nextInt();
        	if(string.equals("U")) {
        		input[x-1]=y;
        		update(input, tree, x-1, 0, input.length-1, 1);
        	}
        	else {
        		node ans=query(tree, x-1, y-1, 0, input.length-1, 1);
        		System.out.println(ans.max+ans.min);
        	}
        }
	}

}
