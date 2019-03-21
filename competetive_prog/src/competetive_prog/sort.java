package competetive_prog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class sort {
	public static void mergeSort(int[] input)  {
		
		int n= input.length;
		if(n==1) {
			return ;
		}
		else{int c=0;
		int[] ans = new int[n];
		int mid = (n-1)/2;
		int [] a1=Arrays.copyOfRange(input, 0, mid+1);
		int[] a2=Arrays.copyOfRange(input, mid+1, input.length);
		mergeSort(a1);
		mergeSort(a2);
		int n1 = a1.length;
		int n2= a2.length;
		int i=0,t=0;
		while(i<n1 & t<n2) {
			if(a1[i]>a2[t]) {
				input[c++]=a2[t];
				t++;
			}
			else {
				input[c++]=a1[i];
				i++;
			}
			}
		while(i<n1) {
			input[c++]=a1[i++];
		}
		while(t<n2) {
			input[c++]=a2[t++];
		}
			//add remaining elements from the greater array
			//input=ans;
			}
		}
	public static void main(String[] args)  {
		Scanner scanner=new Scanner(System.in);
		int n= scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println();
		mergeSort(arr);
		//System.out.println(arr[0]);
		//System.out.print(arr[1]);
		for(int s:arr) {
		System.out.print(s+" ");
		}
	}

}
