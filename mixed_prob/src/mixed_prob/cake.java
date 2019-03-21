package mixed_prob;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class cake {
	public static HashMap<Integer, Integer> resposibility=new HashMap<>();
	public static int[] l;
	public static int [] W;
	public static HashMap<Integer, Integer> C=new HashMap<>();
	public static void initialize() {
		for(int i=0;i<cake.l.length;i++) {
			resposibility.put(cake.l[i], 0);
		}
	}
	public static boolean isPossible(int t) {
		Iterator<Integer> iterator=resposibility.keySet().iterator();
		int key=cake.l.length;
		int sum=0;
		while (sum<=0 && key>=1){
			if(resposibility.containsKey(cake.l[--key])) {
			sum+=resposibility.get(cake.l[key])-t;
			}
		}
		if(sum>0) {
			return false;
		}
		return true;
	}
	public static void assign_responsibility(int l,int w) {
		int f;
		if(w<0) {}
		else if(w==0) {
			resposibility.put(cake.l[l], C.get(W[w]));
		}
		else {
			//System.out.println("l= "+l+"w= "+w);
			int sum=0;
			resposibility.put(cake.l[l], 0);
		while(W[w]>cake.l[l-1]) {
			sum+=C.get(W[w]);
			w--;
			if(w<0) {break;}
		}
		resposibility.put(cake.l[l], resposibility.get(cake.l[l])+sum);
		assign_responsibility(--l, w);}
		
	}
	public static int binary_check(int min, int max) {
		//System.out.println("min= "+min+"max= "+max);
		if(min>=max) {
			if (isPossible(min)) {
				return min;
			}
			return min+1;
		}
	//	System.out.println("fuck");
		int n=max-min+1;
		int mid = min+(n-1)/2;
		//System.out.println(mid);
		//System.out.println(isPossible(mid));
		if(isPossible(mid)) {
			return binary_check(min, mid-1);
		}
		return binary_check(mid+1, max);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int test_case=scanner.nextInt();
		for(int r=0;r<test_case;r++) {
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		l=new int[M];
		// l denotes the capacity of the ith friend
		for(int i=0;i<M;i++) {
			l[i]=scanner.nextInt();
		}
		// W denotes the weight of the ith cake
		 W= new int[N]; 
		for(int t=0;t<N;t++) {
			W[t]=scanner.nextInt();
		}
		// C denotes the no of ith ckes
		// C=new int[N];
		int s1=0;
		for(int t=0;t<N;t++) {
			int input=scanner.nextInt();
			s1+=input;
			C.put(W[t], input);
		}
		Arrays.sort(l);
		Arrays.sort(W);
		assign_responsibility(l.length-1,W.length-1);
		//System.out.println(resposibility);
		//assign_responsibility(1,1);
		if(l[l.length-1]<W[W.length-1]) {
			System.out.println(-1);
		}
		else {
		int min = s1/l.length;
		int ans=binary_check(min,s1 );
		System.out.println(ans);
		
	}}}

}
