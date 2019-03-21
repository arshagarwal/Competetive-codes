package segment_Tree;

import java.util.Scanner;
// when updating ensure that you only update when even or odd changes
public class even_odd {
	public static int odd_query(int[] odd,int s,int e,int L,int R,int t) {
		if(L>=s && R<=e) {
			return odd[t];
		}
		else if(L>e || R<s) {
			return 0;
		}
		else {
			int mid=(L+R)/2;
			int ans1=even_query(odd, s, e, L, mid, 2*t);
			int ans2=even_query(odd, s, e, mid+1, R, 2*t+1);
			return ans1+ans2;
		}
	}
	public static int even_query(int[] even,int s,int e,int L,int R,int t) {
	//	System.out.println(L+" "+R+" "+t);
		if(L>=s && R<=e) {
			return even[t];
		}
		else if(L>e || R<s) {
			return 0;
		}
		else {
			int mid=(L+R)/2;
			int ans1=even_query(even, s, e, L, mid, 2*t);
			int ans2=even_query(even, s, e, mid+1, R, 2*t+1);
			return ans1+ans2;
		}
	}
	public static void update(int[] even,int[] odd,int[] input,int index,int s,int e,int t) {
		if(s==e) {
			if(input[index]%2==0) {
				even[t]=1;
				odd[t]=0;
			}
			else {
				odd[t]=1;
				even[t]=0;
			}
		}
		else {
			int mid=(s+e)/2;
			if(index>mid) {
				update(even, odd, input, index, mid+1, e, 2*t+1);
	            even[t]=even[2*t+1]+even[2*t];
	            odd[t]=odd[2*t]+odd[2*t+1];
			}
			else {
				update(even, odd, input, index, s, mid, 2*t);
				 even[t]=even[2*t+1]+even[2*t];
		            odd[t]=odd[2*t]+odd[2*t+1];
			}
		}
	}
	public static void build(int[] even,int[] odd,int[] input,int s,int e,int t) {
		if(s==e) {
			if(input[s]%2==0) {
				even[t]=1;
				odd[t]=0;
				
			}
			else {even[t]=0;
			odd[t]=1;}
		}
		else {
			int mid=(s+e)/2;
			build(even,odd, input, s, mid, 2*t);
			build(even, odd,input, mid+1, e, 2*t+1);
			even[t]=even[2*t]+even[2*t+1];
			odd[t]=odd[2*t]+odd[2*t+1];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int[] input=new int[N];
		int [] even =new int[4*N];
		int [] odd =new int[4*N];
		for(int i=0;i<N;i++) {
			input[i]=scanner.nextInt();
		}
		build(even, odd, input, 0, input.length-1, 1);
	
		//System.out.println();
		int Q=scanner.nextInt();
		for(int i=0;i<Q;i++) {
			int q=scanner.nextInt();
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			if(q==0) {
				int prev_no=input[x-1];
				if(prev_no%2==y%2) {
					input[x-1]=y;
				}
				else {
					input[x-1]=y;
					update(even, odd, input, x-1, 0, input.length-1, 1);}
				
			}
			else if(q==1) {
				int ans=even_query(even, x-1, y-1, 0, input.length-1, 1);
				System.out.println(ans);
			}
			else {
				int ans=odd_query(odd, x-1, y-1, 0, input.length-1, 1);
				System.out.println(ans);
			}
			}
		}
		

	}


