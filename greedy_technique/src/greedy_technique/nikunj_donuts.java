package greedy_technique;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class nikunj_donuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		Integer[] input=new Integer[n];
		for(int i=0;i<input.length;i++) {
			input[i]=scanner.nextInt();
		}
		Arrays.sort(input,Collections.reverseOrder());
		long ans=0;
        for(int i=0;i<input.length;i++) {
        	ans+=(long)Math.pow(2, i)*input[i];
        }
        System.out.println(ans);
	}

}
