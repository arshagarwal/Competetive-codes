package greedy_technique;

import java.util.Arrays;
import java.util.Scanner;

public class min_diff {
	public static int minAbsoluteDifference(int input[]) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		Arrays.sort(input);
		int min=Integer.MAX_VALUE;
		for(int i=0;i<input.length-1;i++) {
			int temp_min=input[i+1]-input[i];
			if(min>temp_min) {
				min=temp_min;
			}
		}
		return min;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int[] input=new int[N];
		for(int i=0;i<input.length;i++) {
			input[i]=scanner.nextInt();
		}
		System.out.println(minAbsoluteDifference(input));

	}

}
