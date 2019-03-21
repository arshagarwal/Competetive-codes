import java.util.HashMap;
import java.util.Scanner;

public class charlie_pilots {
	public static int[] ass;
	public static int[] cap;
	public static HashMap<String, Integer>ans_record=new HashMap<>();
	public static int solve(int N,int x,int i) {
		System.out.println(ans_record.size());
	//	System.out.println("N= "+N+"x = "+x+"i = "+i);
		String key=Integer.toString(N)+","+Integer.toString(x)+","+Integer.toString(i);
		if(ans_record.containsKey(key)) { return ans_record.get(key);}
		if(i==N-1) {
			
			return cap[i];
		}
		if(x==0 ) {
			 key=Integer.toString(N)+","+Integer.toString(x)+","+Integer.toString(i);
			int ans=0;
			String key1=Integer.toString(N)+","+Integer.toString(x+1)+","+Integer.toString(i+1);
			if(ans_record.containsKey(key1)) {
				ans=ans_record.get(key1);
			}
			else {
			 ans=ass[i]+solve(N,x+1,i+1);}
			ans_record.put(key, ans);
			return ans;
		}
		else if(x==(N-i)) {
			 key=Integer.toString(N)+","+Integer.toString(x)+","+Integer.toString(i);
			 int ans=0;
			 String key1=Integer.toString(N)+","+Integer.toString(x-1)+","+Integer.toString(i+1);
			 if(ans_record.containsKey(key1)) {
				 ans=ans_record.get(key1);
			 }
			 else {
			 ans=cap[i]+solve(N,x-1,i+1);}
			ans_record.put(key, ans);
			return ans;
		}
		else {int sub_ans1=0;
		int sub_ans2=0;
			String key1=Integer.toString(N)+","+Integer.toString(x+1)+","+Integer.toString(i+1);
			if(ans_record.containsKey(key1)) {
				sub_ans1=ans_record.get(key1);
			}
			else {
			 sub_ans1= ass[i]+solve(N,x+1,i+1);}
			String key2=Integer.toString(N)+","+Integer.toString(x-1)+","+Integer.toString(i+1);
			if(ans_record.containsKey(key2)) {
				sub_ans2=ans_record.get(key2);
			}
			else {
			 sub_ans2=cap[i]+solve(N, x-1, i+1);}
			 key=Integer.toString(N)+","+Integer.toString(x)+","+Integer.toString(i);
			int ans=Math.min(sub_ans1, sub_ans2);
			ans_record.put(key, ans);
			return ans;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		 ass=new int[N];
		 cap=new int[N];
		for(int i=0;i<N;i++) {
			cap[i]=scanner.nextInt();
			ass[i]=scanner.nextInt();
		}
		System.out.print(solve(N, 0, 0));

	}

}
