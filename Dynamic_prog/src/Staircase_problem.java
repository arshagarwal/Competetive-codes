import java.util.HashMap;
import java.util.Scanner;

public class Staircase_problem {
	public static HashMap<Integer, Long> ans_record=new HashMap<>();
	public static long staircase(int n) {
		if(n==1){
			return 1;
		}
		else if(n==2) {
			return 2;
		}
		else if(n==0) {
			return 1;
		}
		else {
			if(ans_record.containsKey(n)) {
				return ans_record.get(n);
			}
			long ans=staircase(n-1)+staircase(n-2)+staircase(n-3);
			ans_record.put(n, ans);
			return ans;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.print(staircase(n));
	}

}
