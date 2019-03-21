import java.util.Scanner;

public class subset_sum {
	public static int x=0;
	public static String subset_sum(int [] input,int k) {
		String[][] dp=new String[k+1][input.length+1];
		dp[k][input.length]="no";
		// for 1 st row
		for(int i=0;i<input.length+1;i++) {
			dp[0][i]="yes";
		}
		// for 1 st column
		for(int i=1;i<dp.length;i++) {
			dp[i][0]="no";
		}
		//System.out.println(dp[0].length+"yes");
		for(int i=1;i<dp.length;i++) {
			//System.out.println("fk"+(++x));
			for(int j=1;j<dp[0].length;j++) {
			//	System.out.println("fuck"+(++x));
				String sub_ans1="no";
				if(i>=input[input.length-j]) {
					sub_ans1=dp[i-input[input.length-j]][j-1];
				}
				String sub_ans2=dp[i][j-1];
				if(sub_ans1=="yes" || sub_ans2=="yes") {
					dp[i][j]="yes";
				}
				else {dp[i][j]="no";}
			}
		}
		//System.out.println(dp[0][0]);
		return dp[k][input.length];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int [] input=new int[n];
        for(int i=0;i<n;i++) {
        	input[i]=s.nextInt();
        }
        int k=s.nextInt();
        System.out.println(subset_sum(input, k));
	}

}
