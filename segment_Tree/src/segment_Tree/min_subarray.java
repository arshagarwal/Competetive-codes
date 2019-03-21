package segment_Tree;

import java.util.Scanner;

public class min_subarray {
	public static int query(int[] tree ,int [] input,int s,int e,int L,int R,int t) {
		//System.out.println(s+" "+e+" "+L+" "+R+" "+t );
		if(L>=s && R<=e) {
			return  tree[t];
		} 
		
		if(L>e || R<s) {
			return 0;
		}
		else {
			int mid=(L+R)/2;
			int ans1=query(tree, input, s, e, L, mid, 2*t);
			int ans2=query(tree, input, s, e, mid+1, R, 2*t+1);
			if(ans1!=0 && ans2!=0) {
			return Math.min(ans1, ans2);}
			else {
				if(ans1==0) {return ans2;}
				else {return ans1;}
			}		
		}
		
	}
	public static void update(int[] tree,int input[],int index,int s,int e,int t) {
		//System.out.println(s+" "+e+" "+t);
		if(s==e) {
			tree[t]=input[index];
		}
		else {
			int mid=(s+e)/2;
			if(mid<index) {
				update(tree, input, index, mid +1, e, 2*t+1);
				tree[t]=Math.min(tree[2*t],tree[2*t+1]);
			}
			else {
				update(tree, input, index, s, mid, 2*t);
				tree[t]=Math.min(tree[2*t],tree[2*t+1]);
			}
		}
	}
	public static void build(int[] tree,int[] input,int s,int e,int index) {
		if(s==e) {
			tree[index]=input[s];
		}
		else {
			int mid=(s+e)/2;
			build(tree, input, s, mid, 2*index);
			build(tree, input, mid+1, e, 2*index+1);
			tree[index]=Math.min(tree[2*index],tree[2*index + 1] );
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int Q=scanner.nextInt();
        int[] input=new int[N];
        int[] tree=new int[4*N];
        for(int i=0;i<N;i++) {
        	input[i]=scanner.nextInt();
        }
        build(tree, input, 0, input.length-1, 1);
    //    for(int i=0;i<tree.length;i++) {
      //  	System.out.print(tree[i]+" ");
        //}
        for(int i=0;i<Q;i++) {
        	String qString=scanner.next();
        	int s=scanner.nextInt();
        	int e=scanner.nextInt();
        	if(qString.equals("q")) {
        		//System.out.println("fuck");
        		System.out.println(query(tree, input, s-1, e-1, 0,input.length-1 , 1));
        	}
        	else {input[s-1]=e;
        		update(tree, input, s-1, 0, input.length-1, 1);
        	//	System.out.println(tree[1]+" fuck");
        	}
        	
        }
	}

}
