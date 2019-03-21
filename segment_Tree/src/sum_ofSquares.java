import java.util.Scanner;

public class sum_ofSquares {
	public static class tree{
		int sum=0;
		int square_sum=0;
	}
	public static class lazy{
		String type;
		int inc;
	}
	public static int query(tree[] seg_tree,lazy[] lazy_tree,int s,int e,int L,int R,int t) {
		if(lazy_tree[t]!=null) {
			if(lazy_tree[t].type.equals("set")) {
				seg_tree[t].sum=(R-L+1)*lazy_tree[t].inc;
	    		 seg_tree[t].square_sum=(R-L+1)*lazy_tree[t].inc*lazy_tree[t].inc;
	    		 lazy child=new lazy();
	    		 child.inc=lazy_tree[t].inc;
	    		 child.type="set";
	    		 lazy_tree[2*t]=child;
	    		 lazy_tree[2*t+1]=child;
	    		 lazy_tree[t]=null;
			}
			else {
	              seg_tree[t].sum+=(R-L+1)*lazy_tree[t].inc;
	              seg_tree[t].square_sum+=(R-L+1)*lazy_tree[t].inc*lazy_tree[t].inc+2*lazy_tree[t].inc*seg_tree[t].sum;
	              lazy child=new lazy();
	     		 child.inc=lazy_tree[t].inc;
	     		 child.type="add";
	              lazy_tree[2*t]=child;
	              lazy_tree[2*t+1]=child;
	              lazy_tree[t]=null;
			}
		}
		// completely outside
		if(L>e || R<s) {
			return 0;
		}
		// completely inside
		else if(L>=s && R<=e) {
			return seg_tree[t].square_sum;
		}
		else {
			int mid=(L+R)/2;
			int ans1=query(seg_tree, lazy_tree, s, e, L, mid, 2*t);
			int ans2=query(seg_tree, lazy_tree, ans1, e, mid+1, R, 2*t+1);
		return ans1+ans2;
		}
	}
public static void update(int[] input,tree[] seg_tree,lazy[] lazy_tree,int s,int e,int L,int R,int t,String type,int inc){
     if(lazy_tree[t]!=null){
    	 if(lazy_tree[t].type.equals("set")) {
    		 //input[s]=lazy_tree[t].inc;
    		 seg_tree[t].sum=(R-L+1)*lazy_tree[t].inc;
    		 seg_tree[t].square_sum=(R-L+1)*lazy_tree[t].inc*lazy_tree[t].inc;
    		 lazy child=new lazy();
    		 child.inc=lazy_tree[t].inc;
    		 child.type="set";
    		 lazy_tree[2*t]=child;
    		 //lazy_tree[2*t].type="set";
    		 //lazy_tree[2*t+1].type="set";
             lazy_tree[2*t+1]=child;
    		 lazy_tree[t]=null;
    		// return;
    	 }
    	 else {
              seg_tree[t].sum+=(R-L+1)*lazy_tree[t].inc;
              seg_tree[t].square_sum+=(R-L+1)*lazy_tree[t].inc*lazy_tree[t].inc+2*lazy_tree[t].inc*seg_tree[t].sum;
              lazy child=new lazy();
     		 child.inc=lazy_tree[t].inc;
     		 child.type="add";
              lazy_tree[2*t]=child;
              lazy_tree[2*t+1]=child;
              lazy_tree[t]=null;
    	 }
     }
     // totally outisde
     if(L>e || R<s) {
    	 return;
     }
     // completely inside
     if(L>=s && R<=e) {
    	 if(type.equals("set")){
    		 seg_tree[t].sum=(R-L+1)*inc;
    		 seg_tree[t].square_sum=(R-L+1)*inc*inc;
    		 lazy child=new lazy();
    		 child.inc=inc;
    		 child.type="set";
    		 lazy_tree[2*t]=child;
    		 lazy_tree[2*t+1]=child;
    	 }
    	 else{
    		 
    		 seg_tree[t].square_sum+=(R-L+1)*inc*inc+2*inc*(seg_tree[t].sum);
    		 seg_tree[t].sum+=(R-L+1)*inc;
    		 lazy child=new lazy();
    		 child.inc=inc;
    		 child.type="add";
    		 lazy_tree[2*t]=child;
    		 lazy_tree[2*t+1]=child;
    	 }
     }
     else {
    	 int mid=(L+R)/2;
    	 update(input, seg_tree, lazy_tree, s, e, L, mid, 2*t, type, inc);
    	 update(input, seg_tree, lazy_tree, s, e, mid+1, R, 2*t+1, type, inc);
    	 seg_tree[t].sum=seg_tree[2*t].sum+seg_tree[2*t+1].sum;
    	 seg_tree[t].square_sum=seg_tree[2*t].square_sum+seg_tree[2*t+1].square_sum;
     }
}
public static void build(int[] input,tree[] seg_tree,lazy[] lazy_tree,int s,int e,int t){
		if(s==e) {
			tree put=new tree();
			put.square_sum=input[s]*input[s];
			put.sum=input[s];
			seg_tree[t]=put;
		}
		else{
			int mid=(s+e)/2;
			build(input, seg_tree, lazy_tree, s, mid, 2*t);
			build(input, seg_tree, lazy_tree, mid+1, e, 2*t+1);
			tree put=new tree();
			put.sum=seg_tree[2*t].sum+seg_tree[2*t+1].sum;
			put.square_sum=seg_tree[2*t].square_sum+seg_tree[2*t+1].square_sum;
			seg_tree[t]=put;
		}
	}
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        for(int g=0;g<T;g++){
        	System.out.println("Case "+(g+1)+":");
        int N=s.nextInt();
        int Q=s.nextInt();
        int[] input=new int[N];
        for(int i=0;i<N;i++) {
        	input[i]=s.nextInt();
        }
        tree[] seg_tree=new tree[4*N];
        lazy[] lazy_tree=new lazy[4*N];
        build(input, seg_tree, lazy_tree, 0, N-1, 1);
        for(int i=0;i<Q;i++){
        	int a=s.nextInt();
        	// for setting numbers to x
        	if(a==0) {
        		int st=s.nextInt();
        		int nd=s.nextInt();
        		int x=s.nextInt();
        		update(input, seg_tree, lazy_tree, st-1, nd-1, 0, N-1, 1, "set", x);
        	}
        	// for sum o squares
        	else if(a==2) {
        		int st=s.nextInt();
        		int nd=s.nextInt();
        		System.out.println(query(seg_tree, lazy_tree, st-1, nd-1, 0, N-1, 1));
			}
        	// for adding x to all numbers
        	else {
        		int st=s.nextInt();
        		int nd=s.nextInt();
        		int x=s.nextInt();
        		update(input, seg_tree, lazy_tree, st-1, nd-1, 0, N-1, 1, "add", x);
        	}
        }
	}}

}
