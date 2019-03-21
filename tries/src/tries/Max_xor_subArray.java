package tries;

import java.util.Scanner;

public class Max_xor_subArray {
	public static  class tries{
		tries left;
		tries right;
	}
	
public static int solve(int[] input){
	int max=Integer.MIN_VALUE;
	// array that contains xor uptill the ith index
	int[] xor=new int[input.length];
	xor[0]=input[0];
	// the head node
	tries head=new tries();
	for(int i=0;i<input.length;i++) {
		// total xor uptill now
		int tot_xor=xor[i];
		tries temp_head=head;
		int element=0;
		int curr_xor=0;
		// iterating on the length of the number
		for(int j=4;j>=0;j--) {
			if(temp_head.left==null && temp_head.right==null) {
				break;
			}
			//current bit
			int bit=tot_xor&(1<<j);
			// current xor
			 //curr_xor=0;
			if(bit==0) {
				if(temp_head.right==null) {
				temp_head=temp_head.left;
				}
				else{
					curr_xor+=Math.pow(2,j);
					temp_head=temp_head.right;
				}}
				else {
					if(temp_head.left==null) {
						temp_head=temp_head.right;
						curr_xor+=Math.pow(2, j);
					}
					else {
						
						temp_head=temp_head.left;
					}
				}
		    }
		element=xor[i]^curr_xor;
		if (input[i]>element || curr_xor==0) {
         element=input[i];			
		}
		if(xor[i]>element) {
			element=xor[i];
		}
		if(element>max) {max=element;}
		element=xor[i];
		// inserting total xor  uptill ith index
		// this is the element that is to be inserted
		//int element=xor[i];
		tries temp_head1=head;
		for(int j=4;j>=0;j--) {
			// current bit
			int bit=(element>>j)&(1);
			if(bit==1) {
				if(temp_head1.right==null) {
					temp_head1.right=new tries();
					temp_head1=temp_head1.right;
				}
				else {
					temp_head1=temp_head1.right;
				}
			}
			else {
				if(temp_head1.left==null) {
					temp_head1.left=new tries();
					temp_head1=temp_head1.left;
				}
				else {
					temp_head1=temp_head1.left;
				}
			}
		}
	
	if(i!=xor.length-1) {
	xor[i+1]=xor[i]^input[i+1];}
	}
		return max;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int [] input=new int[n];
		for(int i=0;i<input.length;i++) {
			input[i]=scanner.nextInt();
		}
		System.out.println(solve(input));
		

	}

}
