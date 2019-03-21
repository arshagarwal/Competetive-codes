package competetive_prog;

import java.util.Arrays;
import java.util.Scanner;

public class sort_2 {
	public static void quickSort(int[] input, int s,int e) {
		
		if(s>=e) {
			return;
		}
		else {int a= input[s];
		
		int c=0;
		int[] temp= Arrays.copyOfRange(input, s, e+1);
		int n=e-s+1;
		for(int i=1;i<n;i++) {
			if(a>temp[i]) {
				++c;
			}}
			//for greater elements
			int t=s+(++c);
			//for smaller elements
			int k =s;
			for(int j=1;j<n;j++) {
				if(a>temp[j]) {
					input[k++]=temp[j];
				}
				else {
					input[t++]=temp[j];
				}}
				input[s+(--c)]=a;
			for(int y : input) {
				System.out.print(y+" ");
			}
			System.out.print("   c="+c+"  s="+s+"   e="+e);
			System.out.println();
			quickSort(input,s,s+c-1);
			quickSort(input,s+c+1,e);
			
			
		}
		
	}
	public static void quickSort(int[] input) {
		quickSort(input,0,input.length-1);
	}
	public static void main(String[] args)  {
		Scanner scanner=new Scanner(System.in);
		int n= scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println();
		quickSort(arr);
		//System.out.println(arr[0]);
		//System.out.print(arr[1]);
		for(int s:arr) {
		System.out.print(s+" ");
		}
	}
}
