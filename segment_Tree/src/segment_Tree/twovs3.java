package segment_Tree;

import java.util.Scanner;

public class twovs3 {
	static int[] power=new int[(int)Math.pow(10, 5)+1];
	public static void create_power(int[] power){
		power[0]=1;
		for(int i=1;i<power.length;i++) {
			power[i]=((power[i-1]*2))%3;
		}
	}
	public static int  conv_binary(String s){
		int i=0;
		int ans=0;
		while(i!=s.length()){
			if(s.charAt(i)=='1'){
				ans+=(int)Math.pow(2,s.length()-i-1);
			}
		}
		i++;
		return ans;
	}
	public static int query(String input,int[] tree,int s,int e,int L,int R,int t) {
		
		// completely outside
		if(L>e || R<s) {
			return 0;
		}
		// completely inside
		else if(L>=s && R<=e) {
			return tree[t];
		}
		else {
			int mid=(L+R)/2;
			int ans1=query(input, tree, s, e, L, mid, 2*t);
			int ans2=query(input, tree,s, e, mid+1, R, 2*t+1);
			int ans=(ans2+(ans1*power[R-mid])%3)%3;
			return ans;
		}
	}
	public static void update(String input,int[] tree,int index,int s,int e,int t){
		if(s==e){
			if(tree[t]==0) {
			tree[t]=1;}
		}
		else {
			int mid=(s+e)/2;
			if(index<=mid) {
			update(input, tree, index, s, mid, 2*t);}
			else {
				update(input, tree, index, mid+1, e, 2*t+1);
			}
			tree[t]=((tree[2*t+1])+(tree[2*t]*(power[e-mid-1]))%3)%3;
		}
	}
	public static void build(String input,int [] tree,int s,int e,int t){
	//System.out.println(s+" "+e+" "+t);
		if(s==e) {
		tree[t]=Integer.parseInt(input.substring(s,s+1));
	}
	else {
		int mid=(s+e)/2;
		build(input, tree, s, mid, 2*t);
		build(input, tree, mid+1, e, 2*t+1);
		tree[t]=((tree[2*t+1])+(tree[2*t]*(power[e-mid]))%3)%3;
}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		create_power(power);
		//System.out.print(conv_binary("11"));
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        String input=s.next();
        int [] tree=new int[input.length()*4];
        build(input, tree, 0, input.length()-1, 1);
       // for(int i=0;i<tree.length;i++) {
        	//if(tree[i]!=0) {
      		//System.out.println(tree[i] +" "+i);
        //	}
        //}
        System.out.println("fuck");
        int Q=s.nextInt();
        for(int i=0;i<Q;i++) {
        	int t=s.nextInt();
        	int x=s.nextInt();
        	int y=s.nextInt();
        	if(t==1) {
        	update(input, tree, x-1, 0, input.length()-1, 1);
        	}
        	else {
        		System.out.println(query(input, tree, x-1, y-1, 0, input.length()-1, 1));
        	}
        }
	}

}
