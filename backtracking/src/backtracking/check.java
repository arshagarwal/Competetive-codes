package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class check {public static long merge(int[] input_1,int[] input_2) {
	int[] ar1= new int[input_1.length];
	ar1=input_1.clone();
	int[] ar2= new int[input_2.length];
	ar2=input_2.clone();
	long ans=0;
	int i=0,j=0;
	while(i<input_1.length && j<input_2.length) {
		if(input_1[i]>input_2[j]) {
			ans++;
			j++;
		}
		else {
			i++;
		}
	}
	return ans;
	
}
public static long solve(int[] A,int n){
	
	//Write your code here.
if(n==1) {
	return 0;
}
else {
	int mid=(n-1)/2;
	int[] input_1 = new int[mid+1];
input_1=Arrays.copyOfRange(A,0,mid+1);
int[] input_2 = new int[n-mid];
input_2=Arrays.copyOfRange(A,mid+1,n-1);
Arrays.sort(input_1);
Arrays.sort(input_2);
long sub_ans2 = solve(input_2,n/2);
long sub_ans1 = solve(input_1,n-1);
long ans=merge(input_1,input_2);
ans+=sub_ans1+sub_ans2;
return ans;
}
	
}
public static void main(String[] args) {
	Scanner scanner= new Scanner(System.in);
	int n=scanner.nextInt();
	int[] input=new int[n];
	for(int i=0;i<n;i++) {
		input[i]=scanner.nextInt();
	}
	long ans=solve(input, n);
	System.out.println(ans+"fuck");
	
}
	
	
	
	
	
	
	
}
