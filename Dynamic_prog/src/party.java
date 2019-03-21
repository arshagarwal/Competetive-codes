import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class party {
	public static int expenditure=0; 
	public static HashMap<String, int[]> ans_record=new HashMap<>();
	public static int[] calculate_expenditure(int[] fee,int[] fun,int B,int i) {
		if(B<=0){
			int[] ans={0,0};
			return ans;
			}
		if(i==fun.length) {
			int[] ans= {0,0};
			return ans;
		}
		else {
		String key1= Integer.toString(B)+"@"+Integer.toString(i);
			if(ans_record.containsKey(key1)) {
			return ans_record.get(key1);
		}
			int[] sub_ans1= {0,0};
			int sub_fun1=0;
			if(B>=fee[i]) {
				 sub_ans1=calculate_expenditure(fee, fun, B-fee[i], i+1);
				 sub_fun1=sub_ans1[1]+fun[i];
			}
			int[] sub_ans2=calculate_expenditure(fee, fun, B, i+1);
			int sub_fun2=sub_ans2[1];
			if(sub_fun1>sub_fun2) {
				int[] ans= {sub_ans1[0]+fee[i],sub_fun1};
				String key= Integer.toString(B)+"@"+Integer.toString(i);
				ans_record.put(key, ans);
				return ans;
			}
			else if(sub_fun2>sub_fun1) {
				int[] ans= sub_ans2;
				//int[] key= {B,i};
				String key= Integer.toString(B)+"@"+Integer.toString(i);
				ans_record.put(key, ans);
				return ans;
			}
			else {
				if(sub_ans1[0]+fee[i]>sub_ans2[0]) {
					int[] ans= sub_ans2;
					//int[] key= {B,i};
					String key= Integer.toString(B)+"@"+Integer.toString(i);
					ans_record.put(key, ans);
					return ans;
				}
				else {
					int[] ans= {sub_ans1[0]+fee[i],sub_fun1};
					//int[] key= {B,i};
					String key= Integer.toString(B)+"@"+Integer.toString(i);
					ans_record.put(key, ans);
					return ans;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        while(true) {
        int B=s.nextInt();
        int N=s.nextInt();
        if(B==0 && N==0) {
           break;  	
        }
        int [] fee=new int[N];
        int [] fun=new int[N];
        for(int i=0;i<N;i++) {
        	fee[i]=s.nextInt();
        	fun[i]=s.nextInt();
        }
        int [] ans=calculate_expenditure(fee, fun, B, 0);
        ans_record.clear();
        System.out.println(ans[0]+" "+ans[1]);
       
	}}

}
