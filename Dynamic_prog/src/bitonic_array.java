import java.util.Scanner;

import javax.swing.InputMap;

public class bitonic_array {
	public static int[] sub_ans_increasing;
	// stores information weather the corresponding sub_ans is increasing or decreasing
	public static int[] sub_ans_decreasing;
	public static int longestBitonicSubarray(int[] arr){
        sub_ans_increasing=new int[arr.length];
        sub_ans_increasing[0]=1;
        for(int i=1;i<sub_ans_increasing.length;i++) {
        	sub_ans_increasing[i]=1;
        	for(int j=i-1;j>=0;j--) {
        		
        		if(arr[j]>=arr[i]) {
        			continue;
        		}
        		else {
        			if(sub_ans_increasing[i]<=sub_ans_increasing[j]) {
        				sub_ans_increasing[i]=1+sub_ans_increasing[j];
        			}
        		}
        	}}
        	sub_ans_decreasing=new int[arr.length];
        	for(int i=arr.length-1;i>=0;i--) {
        		sub_ans_decreasing[i]=0;
        		for(int j=i+1;j<arr.length;j++) {
        		if(arr[j]>=arr[i]) {
        			continue;
        		}	
        		else {
        			if (sub_ans_decreasing[i]<=sub_ans_decreasing[j]) {
						sub_ans_decreasing[i]=sub_ans_decreasing[j]+1;
					}
        		}
        		}
        	}
        	int max=sub_ans_decreasing[0]+sub_ans_increasing[0];
        	for(int i=1;i<arr.length;i++) {
        		if(max<(sub_ans_decreasing[i]+sub_ans_increasing[i])) {
        			max=sub_ans_decreasing[i]+sub_ans_increasing[i];
        		}
        		
        	}
        	return max;
		}
	public static void main(String[]args) {
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		int[] input =new int[N];
		for(int i=0;i<N;i++) {
			input[i]=s.nextInt();
		}
		longestBitonicSubarray(input);
		System.out.println(longestBitonicSubarray(input));
	}

}
