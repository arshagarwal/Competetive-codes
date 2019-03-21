import java.net.Inet4Address;
import java.util.Scanner;

public class horrible_query {
	public static long query(long[] tree,long[] lazy_tree ,long s,long e,long L,long R,int t) {
		//System.out.prlongln(L+" "+R+" "+t);
		long inc=lazy_tree[t];
		if(lazy_tree[t]!=0){
			tree[t]+=(R-L+1)*lazy_tree[t];
			if(L!=R){
				lazy_tree[2*t]+=tree[t];
				lazy_tree[2*t+1]+=tree[t];
			}
			lazy_tree[t]=0;
		}
	if(L>e || R<s) {
		return 0;
	}
	else if(L>=s && R<=e) {
		//if(L!=R) {
			//lazy_tree[2*t]+=inc;
			//lazy_tree[2*t+1]+=inc;
		//}
		return tree[t];
	}
	else {
		long mid=(L+R)/2;
		long ans1=query(tree,lazy_tree, s, e, L, mid, 2*t);
		long ans2=query(tree,lazy_tree, s, e, mid+1, R, 2*t+1);
		return ans1+ans2;
	}
	}
	public static void update(long[] tree,long[] lazy_tree,long s,long e,long L,long R,int t,long inc){
		//System.out.prlongln(s+" "+e+" "+L+" "+R+" "+t+" "+inc);
		if(lazy_tree[t]!=0){
			
			tree[t]+=(R-L+1)*lazy_tree[t];
			if(L!=R) {
				lazy_tree[2*t]+=lazy_tree[t];
				lazy_tree[2*t+1]+=lazy_tree[t];
			}
			lazy_tree[t]=0;
		}
    		// completely outside
		if(L>e || R<s){
			return;
		}
		// completely inside
		else if(L>=s && R<=e){
			//System.out.prlongln(t+"="+" "+26);
		tree[t]+=(R-L+1)*inc;
		if(L!=R) {
			lazy_tree[2*t]+=inc;
			lazy_tree[2*t+1]+=inc;
		}
		}
		// partially
		else {
			long mid=(L+R)/2;
			update(tree, lazy_tree, s, e, L, mid, 2*t, inc);
			update(tree, lazy_tree, s, e, mid+1, R, 2*t+1, inc);
			tree[t]=tree[2*t]+tree[2*t+1];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(long i=0;i<T;i++) {
			int N=scanner.nextInt();
			long[] lazy_tree=new long[4*N];
			long[] tree=new long[4*N];
			int C=scanner.nextInt();
			
			for(long j=0;j<C;j++) {
				int a=scanner.nextInt();
				if(a==0){
					int p=scanner.nextInt();
					int q=scanner.nextInt();
					int v=scanner.nextInt();
	            update(tree, lazy_tree, p-1, q-1, 0, N-1, 1, v);
	            for(int y=0;y<tree.length;y++) {
					if(tree[y]!=0) {
	            	//System.out.prlongln(tree[y]+" "+y);
				}}
				
				}
				else {
					for(int y=0;y<tree.length;y++){
					if(tree[y]!=0){
							if(tree[y]!=0) {
						//System.out.prlongln(tree[y]+" "+y);}
					}}}
					//System.out.prlongln("fuck");
					for(int y=0;y<lazy_tree.length;y++) {
						if(lazy_tree[y]!=0){
						//System.out.prlongln(lazy_tree[y]+" "+y);
					}}
					int s=scanner.nextInt();
					int e=scanner.nextInt();
					System.out.println(query(tree,lazy_tree, s-1, e-1, 0, N-1, 1));
				}
				
			}
			
		}

	}

}
