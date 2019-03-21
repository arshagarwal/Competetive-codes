package part_3;

import java.util.BitSet;
import java.util.Scanner;

public class candy {
static long solve(int[][] like,int N){
		int[] dp=new int[(int)Math.pow(2, N)];
		dp[dp.length-1]=1;
		for(int i=dp.length-2;i>=0;i--) {
			int mask=i;
			int bitno=N;
			int k=0;
			// e denotes the student who is getting the candy
			int e=0;
			while(k!=N ) {
				int last_bit=(mask & 1);
				if(last_bit!=0){
					e++;
					//int y=N-bitno;
					// variable to convert to the value that has to be added
					//int t=1<<y;
					//dp[i]+=dp[i | t];
				}
				mask=mask/2;
				bitno--;
				k++;
			}
			for(int m=0;m<like[0].length;m++) {
				if(like[e+1][m]==1 && ((1<<N-m-1)&i)==0){
					dp[i]+=dp[i|(1<<(N-m-1))];
				}
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int[][] like=new int[N+1][N];
		for(int i=1;i<like.length;i++) {
			for(int j=0;j<like[0].length;j++){
				like[i][j]=scanner.nextInt();
			}
		}
		System.out.println(solve(like,N));

	}

}
