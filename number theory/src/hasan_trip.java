import java.util.Scanner;

public class hasan_trip {
	public static int [] x_c;
	public static int [] y_c;
	public static double calc_distance(int i,int j) {
		double x_diff=x_c[i]-x_c[j];
		double y_diff=y_c[i]-y_c[j];
		x_diff=Math.pow(x_diff, 2);
		y_diff=Math.pow(y_diff, 2);
		double ans=x_diff+y_diff;
		ans=Math.sqrt(ans);
		return ans;
	}
	public static double solve(int[] x_c,int[] y_c,int [] F) {
		double[] dp=new double[x_c.length+1];
		dp[0]=0;
		dp[1]=F[0];
		for(int i=2;i<dp.length;i++) {
			double max=dp[i-1]+F[i-1]-calc_distance(i-1, i-2);
			for(int j=i-1;j>=1;j--) {
				double check=dp[j]+F[i-1]-calc_distance(i-1, j-1);
				if(max<check) {
					max=check;
				}
				dp[i]=max;
			}
		}
		return dp[dp.length-1];
			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		 x_c=new int[N];
		 y_c=new int[N];
		int[] F=new int[N];
		for(int i=0;i<N;i++) {
			x_c[i]=scanner.nextInt();
			y_c[i]=scanner.nextInt();
			F[i]=scanner.nextInt();
		}
		System.out.println(solve(x_c, y_c, F));

	}

}
