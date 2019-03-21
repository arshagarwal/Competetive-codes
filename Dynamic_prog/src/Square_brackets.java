import java.util.HashMap;
import java.util.Scanner;

public class Square_brackets {
	public static HashMap<Integer, String> constraint=new HashMap<>(); 
	public static HashMap<String, Integer> ans_record=new HashMap<>();
public static int solve(int n,int x,int i,int o,int c) {
//System.out.println(n+","+x+","+i+","+o+","+c);
	String key=Integer.toString(n)+","+Integer.toString(x)+","+Integer.toString(i)+","+Integer.toString(o)+","+Integer.toString(c);
	if(ans_record.containsKey(key)) {return ans_record.get(key);}
	if(constraint.containsKey(i) ){
	//	System.out.println("n= "+n);
		if(n==1) {
			ans_record.put(key, 0);
			return 0;
		}
		int ans=solve(n-1, x+1, i+1, o, c);;
				ans_record.put(key, ans);		
		return ans;}
	if(i==0) {
		int ans= solve(n-1, x+1, i+1, o-1, c);
		ans_record.put(key, ans);		
		return ans;
	}
	if(o<0) {return 0;}
		if(n==1 && o==0&& c==1) {
			ans_record.put(key, 1);		
			return 1;
		}
	//	else if(o==0){
		//	int sub_ans2=solve(n-1, x-1, i+1, o, c-1);
			//return sub_ans2;
			
		//}
		else if(x==0) {
			int ans=solve(n-1, x+1, i+1, o-1, c);
			ans_record.put(key, ans);		
			return ans;
		}
		else {
			int sub_ans1=solve(n-1, x+1, i+1, o-1, c);
			int sub_ans2=solve(n-1, x-1, i+1, o, c-1);
			ans_record.put(key, sub_ans1+sub_ans2);		
			return sub_ans1+sub_ans2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int i=0;i<t;i++) {
			int n=scanner.nextInt();
			int k=scanner.nextInt();
			//constraint.put(0, "yes");
			int[] input=new int[k];
			for(int j=0;j<k;j++) {
				//int in=scanner.nextInt();
				constraint.put(scanner.nextInt()-1, "yes");
				//input[i]=scanner.nextInt();
			}
		//	System.out.println(constraint);
			System.out.println(solve(2*n, 0, 0, n-k, n));
		constraint.clear();
		ans_record.clear();
		}

	}

}
