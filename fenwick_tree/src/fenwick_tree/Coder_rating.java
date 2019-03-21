package fenwick_tree;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Coder_rating {
	public static int[] fenwick_tree=new int[100001];
	public static class coder implements Comparable<coder>{
		int x;
		int y;
		int index;
		@Override
		public int compareTo(coder a) {
			if(this.x==a.x) {
				return this.y-a.y;
			}
			else {
				return this.x-a.x;
			}
		}
	}
 public static void update(int y){
	 for(;y<fenwick_tree.length;y+=(y&(-y))) {
		 fenwick_tree[y]++;
	 }
	
 }
 public static int query(int y) {
	 int value=0;
	 for(;y>0;y-=y&(-y)) {
		 value+=fenwick_tree[y];
	 }
	 return value;
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        coder[] input=new coder[N];
        for(int i=0;i<N;i++) {
        	input[i]=new coder();
        	input[i].x=scanner.nextInt();
        	input[i].y=scanner.nextInt();
        	input[i].index=i;
        }
        Arrays.sort(input);
        int[] ans=new int[input.length+1];
        for(int i=0;i<input.length;) {
        	int endindex=i+1;
        	while(endindex<input.length && input[i].x==input[endindex].x && input[i].y==input[endindex].y) {
        		endindex++;
        	}
        	// query 
        	for(int j=i;j<endindex;j++) {
        	ans[input[j].index]=query(input[j].y);}
        	
        	// update
        	for(int j=i;j<endindex;j++) {
        	update(input[j].y);}
        	i=endindex;
        }
        for(int i=0;i<ans.length;i++) {
        	System.out.println(ans[i]);
        }
	}
	

}
