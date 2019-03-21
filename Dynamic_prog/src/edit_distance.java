import java.util.Scanner;
import java.util.function.IntPredicate;

public class edit_distance {
	public static int[][] ans_record;
	public static void initialize() {
		int n=ans_record.length;
		int m=ans_record[0].length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				ans_record[i][j]=-1;
			}
		}
	}

	public static int editDistance(String s1, String s2){
		
	if(s1.equals("")) {
		return s2.length();
	}
	else if(s2.equals("")) {
		return s1.length();
	}
	else if(s1.equals(s2)) {
		return 0;
	}
	else {
		if(ans_record[s2.length()][s1.length()]!=-1) {
			return ans_record[s2.length()][s1.length()];
		}
		System.out.println(s1+"  "+s2);
		if(s1.charAt(0)==s2.charAt(0)) {
			int ans =editDistance(s1.substring(1), s2.substring(1));
			ans_record[s2.length()][s1.length()]=ans;
			return ans;
			}
			else {
				int sub_ans1=1+editDistance(s1.substring(1), s2.substring(1));
				int sub_ans2=1+editDistance(s1.substring(1), s2);
				int sub_ans3=1+editDistance(s1, s2.substring(1));
				
			int ans= Math.min(sub_ans1, Math.min(sub_ans2, sub_ans3));
			ans_record[s2.length()][s1.length()]=ans;
			return ans;
			}	
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String s1=scanner.next();
		String s2=scanner.next();
		ans_record=new int[s2.length()+1][s1.length()+1];
		initialize();
		//int ans=lcs(s1, s2);
		System.out.println(editDistance(s1, s2));

	}

}
