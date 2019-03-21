package segment_Tree;

import java.util.Scanner;

public class max_sum_subArray {
	public static class node {
		int max=Integer.MIN_VALUE;
		int prefix_sum=Integer.MIN_VALUE/10000;
		int suffix_sum=Integer.MIN_VALUE/10000;
		int sum=Integer.MIN_VALUE/10000;
	}
	public static node query(node[] tree,int s,int e,int l,int r,int t){
		//System.out.println(l+" "+r+" "+t);
		// completely outside
		if(l>e || r<s) {
			node ans=new node();
			return ans; 
		}
		// completely inside
		else if(l>=s && r<=e) {
			return tree[t];
		}
		else {
			int mid=(l+r)/2;
			node L=query(tree, s, e, l, mid, 2*t);
			node R=query(tree, s, e, mid+1, r, 2*t+1);
			node ans=new node();
			int a=Math.max(L.max,Math.max(R.max, L.suffix_sum+R.sum));
    		int b=Math.max(L.sum+R.sum, Math.max(L.suffix_sum+R.prefix_sum,R.suffix_sum+L.sum ));
    		ans.max=Math.max(a, b);
    		ans.prefix_sum=Math.max(Math.max(L.prefix_sum,L.sum),L.sum+R.prefix_sum);
    		ans.suffix_sum=Math.max(R.sum, Math.max(R.suffix_sum, L.suffix_sum+R.sum));
    		ans.sum=L.sum+R.sum;
    		return ans;
		}
	}
	public static void update(node[] tree,int[] input,int index,int s,int e,int t){
		
		if(s==e) {
			tree[t].max=input[index];
			tree[t].sum=input[index];
		}
		else {
			int mid=(s+e)/2;
			if(index<=mid) {
				update(tree, input, index, s, mid, 2*t);
				node ans=new node();
				node L=tree[2*t];
	    		node R=tree[2*t+1];
	    		int a=Math.max(L.max,Math.max(R.max, L.suffix_sum+R.sum));
	    		int b=Math.max(L.sum+R.sum, Math.max(L.suffix_sum+R.prefix_sum,R.suffix_sum+L.sum ));
	    		ans.max=Math.max(a, b);
	    		ans.prefix_sum=Math.max(Math.max(L.prefix_sum,L.sum),L.sum+R.prefix_sum);
	    		ans.suffix_sum=Math.max(R.sum, Math.max(R.suffix_sum, L.suffix_sum+R.sum));
	    		tree[t]=ans;
			}else {
				update(tree, input, index, mid+1, e, 2*t+1);
				node ans=new node();
				node L=tree[2*t];
	    		node R=tree[2*t+1];
	    		int a=Math.max(L.max,Math.max(R.max, L.suffix_sum+R.sum));
	    		int b=Math.max(L.sum+R.sum, Math.max(L.suffix_sum+R.prefix_sum,R.suffix_sum+L.sum ));
	    		ans.max=Math.max(a, b);
	    		ans.prefix_sum=Math.max(Math.max(L.prefix_sum,L.sum),L.sum+R.prefix_sum);
	    		ans.suffix_sum=Math.max(R.sum, Math.max(R.suffix_sum, L.suffix_sum+R.sum));
	    		tree[t]=ans;
			}
		}
	}
    public static void build(int[]input,node[]tree,int s,int e,int t){
    	//System.out.println(s+" "+e+" "+t);
    	if(s==e) {
    		node ans=new node();
    		ans.max=input[s];
    		ans.prefix_sum=Integer.MIN_VALUE/10000;
    		ans.suffix_sum=Integer.MIN_VALUE/10000;
    		ans.sum=input[s];
    		tree[t]=ans;
    	}
    	else {
    		int mid=(s+e)/2;
    		build(input, tree, s, mid, 2*t);
    		build(input, tree, mid+1, e, 2*t+1);
    		node ans=new node();
    		node L=tree[2*t];
    		node R=tree[2*t+1];
    		int a=Math.max(L.max,Math.max(R.max, L.suffix_sum+R.sum));
    		int b=Math.max(L.sum+R.sum, Math.max(L.suffix_sum+R.prefix_sum,R.prefix_sum+L.sum ));
    		ans.max=Math.max(a, b);
    		ans.prefix_sum=Math.max(Math.max(L.prefix_sum,L.sum),L.sum+R.prefix_sum);
    		ans.suffix_sum=Math.max(R.sum, Math.max(R.suffix_sum, L.suffix_sum+R.sum));
    		ans.sum=L.sum+R.sum;
    		tree[t]=ans;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int[] input=new int[N];
        for(int i=0;i<N;i++) {
        	input[i]=scanner.nextInt();
        }
        node[] tree=new node[4*N];
        build(input, tree, 0, input.length-1, 1);
        //for(int i=0;i<tree.length;i++) {
        	//if(tree[i]!=null) {
        	//System.out.println(tree[i].max+" "+i);}
        //}
        //System.out.println("fuck");
        int M=scanner.nextInt();
        for(int i=0;i<M;i++) {
        	int x=scanner.nextInt();
        	int y=scanner.nextInt();
        	node ans=query(tree, x-1, y-1, 0, input.length-1, 1);
        	System.out.println(ans.max);
        }
        
	}

}
