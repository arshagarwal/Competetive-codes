package greedy_technique;

import java.util.Arrays;
import java.util.Scanner;

public class activity_selection {
	public static class activity implements Comparable<activity>{
		int start;
		int end;
		@Override
		public int compareTo(activity o) {
			return this.end-o.end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		activity[] input=new activity[N];
		for(int i=0;i<input.length;i++){
			input[i]=new activity();
			input[i].start=s.nextInt();
			input[i].end=s.nextInt();
		}
		Arrays.sort(input);
		int ans=0;
		int start=-1;
		for(int i=0;i<input.length;i++){
			if(start<=input[i].start) {
				start=input[i].end;
				ans++;
			}
			
		}
		System.out.println(ans);
		
		

	}

}
