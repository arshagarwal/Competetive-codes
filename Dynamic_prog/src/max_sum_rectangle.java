import java.util.Scanner;

public class max_sum_rectangle {
	public static int kadanes(int[] arr) {
		int [] dp=new int[arr.length];
		dp[0]=arr[0];
		int max=Integer.MIN_VALUE;
		//max=arr[0];
		for(int i=1;i<arr.length;i++) {
				if(dp[i-1]<0) {
					dp[i]=arr[i];
				}
				else {
					dp[i]=dp[i-1]+arr[i];
				}
		}
		for(int i=0;i<dp.length;i++) {
			if(dp[i]>max) {
				max=dp[i];
			}
		}
		return max;
	}
	public static int max_sum(int[][] input) {
		int ans=Integer.MIN_VALUE;
		int[] dp=new int[input[0].length];
		for(int i=0;i<dp.length;i++) {
			dp[i]=0;
		}
		int n=input.length;
		int m=input[0].length-1;
		for(int t=0;t<m;t++) {
		for(int i=t;i<m;i++) {
			int k=0;
			for(int j=0;j<n;j++) {
				dp[k++]+=input[j][i];
			}
			if(ans<kadanes(dp)) {
			ans=kadanes(dp);}
		}
		for(int g=0;g<dp.length;g++) {
			dp[g]=0;
		}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int n =scanner.nextInt();
        int m= scanner.nextInt();
        int[][] input=new int[n][m];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		input[i][j]=scanner.nextInt();
        	}
        }
        System.out.println(max_sum(input));
	}

}
