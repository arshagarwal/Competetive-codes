package fenwick_tree;

import java.util.Scanner;

public class incseq {
	public static void update(int[][] fenwick_tree,int value,int i,int j) {
		
		for(;j<fenwick_tree[0].length;j+=j&(-j)) {
			fenwick_tree[i][j]+=value;
		}
	}
	public static int query(int[][] fenwick_tree,int i,int j) {
		int value=0;
		for(;j>0;j-=j&(-j)) {
			value+=fenwick_tree[i][j];
		}
		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		int K=s.nextInt();
		int[] input=new int[N];
		for(int i=0;i<input.length;i++) {
			input[i]=s.nextInt();
		}
		int[][]fenwick_tree=new int[K+1][(int)Math.pow(10, 6)+2];
		int v=input[0];
		int inpu=0
				;
		//update(fenwick_tree, 1, 1, v);
		int ans=0;
			for(int j=0;j<N;j++) {
				for(int i=1;i<=K;i++) {
					// current element corresponding to which value is being calculated
				 inpu=input[j];
				 int value=0;
				 value=query(fenwick_tree,i-1,inpu);
				if(i!=1) {
				update(fenwick_tree, value, i,inpu+1 );
				if(i==K)
				ans+=value;}
				else {
					if(i==K)
					ans++;
					update(fenwick_tree, 1, i, inpu+1);
				}
			}
		}
			
			
		System.out.println(ans);

	}

}
