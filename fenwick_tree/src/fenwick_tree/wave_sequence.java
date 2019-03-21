package fenwick_tree;

import java.io.InputStreamReader;
import java.util.Scanner;

public class wave_sequence {
	public static class store{
		// a contains the sum of less type subsequence
		int a=0;
		// b contains the sum of greater than subsequence
		int b=0;
		// c contains no of smaller elements
		int c=0;
		// d contains no of greater elements
		int d=0;
	}
	public static boolean[] contains=new boolean[(int) Math.pow(10, 5)+1];
	public static void update(int index,store[] fenwick_tree,int [] input){
		for(;index<fenwick_tree.length;index+=index&(-index)) {
			fenwick_tree[index].a=query(input[index]-1, fenwick_tree,"b")+query(input[index]-1, fenwick_tree,"c");
			fenwick_tree[index].b=query(input[index]-1, fenwick_tree,"a")+query(input[index]-1, fenwick_tree,"d");
			fenwick_tree[index].c=query(input[index]-1,fenwick_tree,"c");
			if(contains[input[index]-1]) {
				fenwick_tree[index].c++;
			}
			fenwick_tree[index].d=index-fenwick_tree[index].c;
		}
	}
	public static int query(int index,store[] fenwick_tree,String type){
		int value=0;
		if(type.equals("a")) {
			for(;index>0;index-=index&(-index)) {
				value+=fenwick_tree[index].a;
			}}
			else if(type.equals("b")) {
				for(;index>0;index-=index&(-index)) {
					value+=fenwick_tree[index].b;
				}}
				else if(type.equals("c")) {
					for(;index>0;index-=index&(-index)) {
						value+=fenwick_tree[index].c;
					}}
					else if(type.equals("d")) {
						for(;index>0;index-=index&(-index)) {
							value+=fenwick_tree[index].d;
						}
					}
					return value;
		
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int[] input=new int[N];
		for(int i=0;i<N;i++) {
			input[i]=scanner.nextInt();
			contains[input[i]]=true;
		}
		store[] fenwick_tree=new store[(int)Math.pow(10,6)];
		for(int i=0;i<fenwick_tree.length;i++) {
			fenwick_tree[i]=new store();
		}
		for(int i=0;i<input.length;i++) {
			update(i, fenwick_tree, input);
		}
		System.out.println(fenwick_tree[input[input.length-1]]);
		
	}

}
