package mixed_prob;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class check {
	public static HashMap<Integer, Integer> resposibility=new HashMap<>();
	public static int[] l;
	public static int [] W;
	public static HashMap<Integer, Integer> C=new HashMap<>();
	public static void assign_responsibility(int l,int w) {
		int f;
		if(w<0) {
		
		}
		else if(w==0) {
			resposibility.put(check.l[l], C.get(W[w]));
		}
		else {
			System.out.println("l= "+l+"w= "+w);
			int sum=0;
			resposibility.put(check.l[l], 0);
		while(W[w]>check.l[l-1]) {
			sum+=C.get(W[w]);
			w--;
			if(w<0) {break;}
		}
		resposibility.put(check.l[l], resposibility.get(check.l[l])+sum);
		System.out.println(resposibility);
		assign_responsibility(--l, w);}
		
	}
	public static boolean isPossible(int t) {
		//Iterator<Integer> iterator=resposibility.keySet().iterator();
		int key=check.l.length;
		int sum=0;
		while (sum<=0 && key>=1) {
			System.out.println(sum);
			if(resposibility.containsKey(check.l[--key])) {
			sum+=resposibility.get(check.l[key])-t;}
			
		}
		System.out.println(sum);
		if(sum>0) {
			return false;
		}
		return true;
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
		System.out.println(resposibility);
		//assign_responsibility(1,1);
		//System.out.println(isPossible(77));
		int min = s1/l.length;
		//int ans=binary_check(min,s1 );
	//	System.out.println(ans);
		
	}}


}
