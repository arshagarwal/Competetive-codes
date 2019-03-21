package fenwick_tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Main {
	public static long[] seive=new long[(int)Math.pow(10, 7)+1];
	// fenwick_tree should contain the sum of seive elements from L to R
	public static int[] fenwick_tree;
	public static void initilize() {
		int root=(int)Math.sqrt(seive.length-1);
		for(int i=2;i<seive.length;i++) {
			if(seive[i]==0) {
				//seive[i]=i;
				for(int t=1;seive.length>t*i;t++) {
					seive[i*t]+=i;
				}
			}
		}
	}
	// this function calculates the summation from L to r
    public static int summation(int L,int R) {
    	int sum_R1=(R*(R+1))/2;
    	return L+sum_R1;
    	
    }
	public static class query implements Comparable<query>{
		int L;
		int R;
		long K;
		int index=-1;
		
		@Override
		public int compareTo(query o){
			if(this.K!=o.K)
			return (int)(this.K-o.K);
			else {
				return this.L-o.L;
			}
		}
		
	public static void update(int index,int[] input,int in) {
		for(;index<fenwick_tree.length;index+=index&(-index)) {
			fenwick_tree[index]+=seive[input[in-1]]*in;
		}
	}
	public static int query(int index) {
		int value=0;
		for(;index>0;index-=index&(-index)) {
			value+=fenwick_tree[index];
		}
		return value;
	}
public static void main(String[] args) {
	initilize();
	//int[] s=seive;
	Scanner scanner=new Scanner(System.in);
	int N=scanner.nextInt();
	fenwick_tree=new int[N+1];
	int [] fen=fenwick_tree;
	int Q=scanner.nextInt();
	int[] input=new int[N];
	for(int i=0;i<input.length;i++) {
		input[i]=scanner.nextInt();
	}
	query[] query_input=new query[Q+N];
	for(int i=0;i<Q;i++) {
		query_input[i]=new query();
		query_input[i].L=scanner.nextInt();
		query_input[i].R=scanner.nextInt();
		query_input[i].K=scanner.nextInt();
		query_input[i].index=i;
	}
	for(int i=Q;i<query_input.length;i++) {
		query_input[i]=new query();
		query_input[i].K=seive[input[i-Q]];
		query_input[i].L=0;
		query_input[i].R=i-Q;
	}
	int[] ans=new int[Q];
	Arrays.sort(query_input,Collections.reverseOrder());
	for(int i=0;i<query_input.length;i++){
		if(query_input[i].L==0){
			update(query_input[i].R+1, input,query_input[i].R+1);
		}
		else {
			int sub_ans1=query(query_input[i].R);
			int sub_ans2=query(query_input[i].L-1);
			ans[query_input[i].index]=sub_ans1-sub_ans2;
		}
	}
	for(int i=0;i<ans.length;i++) {
		System.out.println(ans[i]);
	}
	
	
}
}
