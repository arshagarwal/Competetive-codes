package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class permutations {
	public static String[] permutationOfString(String input){
		// Write your code here
		ArrayList<String> ans= new ArrayList<>();
		if(input.length()==1) {
			ans.add(input);
			String[] Ans=ans.toArray(new String[ans.size()]);
			return Ans;
		}
		else{
			String[] sub_ans=permutationOfString(input.substring(1));
			for(int i=0;i<sub_ans.length;i++) {
				for(int j=0;j<sub_ans[i].length()+1;j++) {
				String add= sub_ans[i].substring(0, j)+input.charAt(0)+sub_ans[i].substring(j);
				ans.add(add);
			}}
			String[] Ans=ans.toArray(new String[ans.size()]);
			return Ans;
		}
	}
	public static void main(String[] args) {
	//	Sca s= new Scanner(System.in);
		String[] ans= permutationOfString("abcd");
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
