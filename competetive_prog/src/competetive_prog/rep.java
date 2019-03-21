
package competetive_prog;

import java.util.Scanner;

public class rep {
	public static String removeConsecutiveDuplicates(String s) {
		// Write your code here
		int n=s.length();
		if(n==1) {
			String ans= Character.toString(s.charAt(0));
			return ans;
		}
		else {
			String x= removeConsecutiveDuplicates(s.substring(1));
			if(s.charAt(0)==x.charAt(0)) {
				return x;
			}
			else {
				return s.charAt(0)+x;
			}
		}
      

	}

	
	public static void main(String[] args ) {
		Scanner scanner=new Scanner(System.in);
		String ans = removeConsecutiveDuplicates(scanner.next());
		System.out.print(ans);
		
		
	}

}
