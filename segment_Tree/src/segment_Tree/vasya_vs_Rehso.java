package segment_Tree;

import java.util.Scanner;

public class vasya_vs_Rehso {
	public static int query(int[] A,int[] B,int[] tree,int s,int e,int L,int R,int t ){
		
		// completely outside
		if(L>e || R<s) {
			return -1;
		}
		// completely inside
		if(L>=s && R<=e) {
			return tree[t];
		}
		//partially
		else {
			int mid=(L+R)/2;
			
			int ans1=query(A, B, tree, s, e, L, mid, 2*t);
			int ans2=query(A, B, tree, s, e, mid+1, R, 2*t+1);
			if(ans1==-1) {
				return ans2;
			}
			else if(ans2==-1) {return ans1;}
			if(A[ans1]!=A[ans2]) {
				if(A[ans1]>A[ans2]) {
					return ans1;
				}
				else {
					return ans2;
				}
			}
			else if(B[ans1]!=B[ans2]){
				if(B[ans1]>B[ans2]) {
					return ans2;
				}
				else {return ans1;}
            				}
			else {
			
				return ans1;
			}
			
		}
	}
	
	public static void build(int[] A,int[] B,int[] tree,int s,int e,int t) {
	//	System.out.println(s+" "+e+" "+t);
    if(s==e) {
    	 tree[t]=s;
    }
    else {
    	int mid=(s+e)/2;
    	build(A, B, tree, s, mid, 2*t);
    	build(A, B, tree, mid+1, e, 2*t+1);
    	if(A[tree[2*t]]!=A[tree[2*t+1]]) {
    		if(A[tree[2*t]]>A[tree[2*t+1]]) {
    			tree[t]=tree[2*t];
    		}
    		else {
    			tree[t]=tree[2*t+1];
    		}
    	}
    	else if(B[tree[2*t]]!=B[tree[2*t+1]]){
    		if(B[tree[2*t]]>B[tree[2*t+1]]) {
    			tree[t]=tree[2*t+1];
    		}
    		else {
    			tree[t]=tree[2*t];
    		}
    	}
    	else {
    		tree[t]=tree[2*t];
    	}
    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		int[] A=new int[N];
		for(int i=0;i<A.length;i++) {
			A[i]=s.nextInt();
		}
		int[] B=new int[N];
		for(int i=0;i<N;i++) {
			B[i]=s.nextInt();
		}
		int [] tree=new int[4*N];
		
		build(A, B, tree, 0, A.length-1, 1);
		//for(int i=0;i<tree.length;i++) {
			//System.out.println(tree[i]+" "+i);
		//}
		int Q=s.nextInt();
		for(int i=0;i<Q;i++) {
			int x=s.nextInt();
			int y=s.nextInt();
			System.out.println((query(A, B, tree, x-1, y-1, 0, A.length-1, 1)+1));
		}
		

	}

}
