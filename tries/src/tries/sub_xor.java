package tries;

import java.util.HashMap;
import java.util.Scanner;

import tries.Max_xor_subArray.tries;

public class sub_xor {
	public static class tries{
		tries left;
		tries right;
		// variable that contains the no of leaf nodes from the current trie object
		int leaf_nodes=0;
	}
	public static int solve2(int[] input,int k) {
		int ans=0;
		// this array contains the total xor uptill now
		int[] xor =new int[input.length];
		// hashmap that contains the visited elements
		HashMap<Integer, Boolean> visited =new HashMap<>();
		xor[0]=input[0];
		// the head trie node
		tries head=new tries();
		// iteration for all elements
		for(int i=0;i<input.length;i++) {
			tries temp_head=head;
			if(xor[i]<k) {ans++;}
			// iterating to count the no of arrays smaller than k
			for(int j=5;j>=0;j--) {
				if(temp_head.right==null && temp_head.left==null) {
					break;
				}
				// bit corresponding to the number
				int bit_1=(xor[i])&(1<<j);
				// bit corresponding to k
				int bit_2=k&(1<<j);
              // case 1
				if(bit_1==0 && bit_2==0) {
					if(temp_head.left==null) {
						break;
					}
					temp_head=temp_head.left;
				}
				// case 2
				if(bit_1==0 && bit_2!=0) {
					if(temp_head.left!=null){
					ans+=temp_head.left.leaf_nodes;}
					if(temp_head.right==null) {break;}
					temp_head=temp_head.right;
				}
				// case 3
				if(bit_1!=0 && bit_2==0) {
					if(temp_head.right==null) {
					break;}
					temp_head=temp_head.right;
				}
				// case 4
				if(bit_1!=0 && bit_2!=0) {
					if(temp_head.right!=null)
					ans+=temp_head.right.leaf_nodes;
					if(temp_head.left==null) {break;}
					temp_head=temp_head.left;
				}
			}
			temp_head=head;
			// now iterating to insert the total xor and to update the leaf nodes no
			for(int j=5;j>=0;j--) {
				int bit=xor[i]&(1<<j);
				if(bit==0) {
					if(temp_head.left!=null) {
						if(!visited.containsKey(xor[i])) {
						temp_head.leaf_nodes++;}
						temp_head=temp_head.left;
					}
					else {
						// new node
						tries node=new tries();
						temp_head.leaf_nodes++;
						temp_head.left=node;
						temp_head=node;
					}
				}
				else {
					if(temp_head.right!=null) {
						if(!visited.containsKey(xor[i])) {
							temp_head.leaf_nodes++;
						}
						temp_head=temp_head.right;
					}
					else {
						tries node=new tries();
						temp_head.leaf_nodes++;
						temp_head.right=node;
						temp_head=node;
					}
				}
				
			}
			// to mark visited
			visited.put(xor[i], true);
			// updating the xor array
			if(i<input.length-1) {
				xor[i+1]=xor[i]^input[i+1];
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int i=0;i<t;i++) {
			int N=scanner.nextInt();
			int K=scanner.nextInt();
			int[] input=new int[N];
			for(int j=0;j<N;j++) {
				input[j]=scanner.nextInt();
			}
			System.out.println(solve2(input, K));
		}

	}

}
