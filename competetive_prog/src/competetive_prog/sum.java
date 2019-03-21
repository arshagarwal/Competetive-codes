package competetive_prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class sum {
	public static int[][] subsetsSumK(int input[], int k) {
		// Write your code here
		//ArrayList<Integer> poss=new ArrayList<>();
if(input.length==1) {
	if(input[0]==k) {
		int[][] ans = {{k}};
		return ans;
	}
	else {int[][] ans=new int[0][0];
	return ans;
	}
}
else {
	int[] new_in=Arrays.copyOfRange(input, 1, input.length);
	// for 1 st number included
	int[][] sub_ans1 =subsetsSumK(new_in, k-input[0]); 
	
	ArrayList<ArrayList> ans=new ArrayList<>();
	if(k==input[0]) {
		ArrayList<Integer> ax=new ArrayList<>();
		ax.add(input[0]);
		ans.add(ax);
	}
	else if(sub_ans1.length!=0) {
	//	System.out.println(sub_ans1.length+"fuck1");
		//System.out.print(sub_ans1[0]);
		for(int i=0;i<sub_ans1.length;i++) {
			ArrayList<Integer> add=new ArrayList<>();
			add.add(input[0]);
			for(int j=0;j<sub_ans1[i].length;j++) {
				add.add(sub_ans1[i][j]);
			}
			ans.add(add);
			}	}
	
	// for first number excluded
	int[][] sub_ans2=new int[0][0];
	if(subsetsSumK(new_in, k).length!=0) {
	 sub_ans2=subsetsSumK(new_in, k);}
	
	if(sub_ans2.length!=0) {
	//	System.out.println(sub_ans2.length+"fuck 2");
	for(int i=0;i<sub_ans2.length;i++) {
		ArrayList<Integer> add=new ArrayList<>();
		//add.add(input[0]);
		for(int j=0;j<sub_ans2[i].length;j++) {
			add.add(sub_ans2[i][j]);
		}
		ans.add(add);
		}	}
	//System.out.print(ans.get(0).size());
// converting Arraylist to array
int[][] out=new int[ans.size()][];
for(int i=0;i<ans.size();i++) {
	ArrayList<Integer> add=new ArrayList<>();
	add=ans.get(i);
	int[] as=new int[add.size()];
	int q=0;
	for(int j=0;j<add.size();j++) {
		as[q++]=add.get(j);
       	
	}
	out[i]=as;
}
return out;
}}
	
	public static int sumArray(int[] a) {
		int sum=0;
		for(int t=0;t<a.length;t++) {
			sum=sum+a[t];
		}
		return sum;
	}
	public static void main(String[] args) {
		/*Scanner scanner= new Scanner(System.in);
		int n= scanner.nextInt();
		int[] input=new int[n];
		for(int i=0;i<n;i++) {
			input[i]=scanner.nextInt();
			
		}*/
		int[] new_in= { 5, 12, 3, 17, 1, 18, 15, 3, 17 };
		//int k= scanner.nextInt();
		int[][] ans = subsetsSumK(new_in, 6);
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[i].length;j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}

}
