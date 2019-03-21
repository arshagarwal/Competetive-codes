import java.util.ArrayList;
import java.util.Scanner;

public class jon_snow {
	public static int[] cal_max(int[] input,int x,int k) {
		int[][] dp=new int [2][input.length];
		// this array will contain the elements present
		//int [] iterator =new int[n];
	//	int m=0;
		for(int i=0;i<input.length;i++) {
			dp[0][i]=input[i];
			System.out.print(dp[0][i]+" ");
		}
		System.out.println();
		int flag=1;
		
		for(int j=0;j<k;j++){
			// intialize the flag array as zero
			for(int i=0;i<dp[0].length;i++) {
				dp[flag][i]=0;
			}
			int count =0;
			// alt-alternate ensures we always take the alternate element
			int alt=1;
		for(int i=0;i<input.length;i++){
			if(dp[flag^1][i]==0 ) {
				continue;}
			else if(alt%2==0) {
				if(dp[flag^1][i]%2!=0) {
				alt++;}
				else {
					alt+=2;
				}
				dp[flag][i]+=dp[flag^1][i];
				count+=dp[flag^1][i];
				continue;
			}
			else {//System.out.println(dp[flag^1][i]+" "+i+"count ="+count);
                if(dp[flag^1][i]%2==0) {
                	dp[flag][i]+=dp[flag^1][i]/2;
                dp[flag][i^x]+=dp[flag^1][i]/2;
                count+=(dp[flag^1][i]/2)+dp[flag^1][i]/2;
                alt+=2;
               }
                else {alt++;
                	if(count%2==0) {
                		dp[flag][i^x]+=1+(dp[flag^1][i]/2);
                		dp[flag][i]+=dp[flag^1][i]/2;
                		count+=1+(dp[flag^1][i]/2)+dp[flag^1][i]/2;
                	}
                	else {
                		dp[flag][i^x]+=dp[flag^1][i]/2;
                		dp[flag][i]+=1+(dp[flag^1][i]/2);
                		count+=(dp[flag^1][i]/2)+1+(dp[flag^1][i]/2);
                	}
                }
			}
			}
		for(int i=0;i<32;i++) {
	      	System.out.print(dp[flag][i]+"  ");
		}
		System.out.println();
		flag=flag^1;
		}
		flag=flag^1;
		int max=0;
		int min=100000;
		for(int i=0;i<dp[0].length;i++) {
			
			if(dp[flag][i]!=0) {
				System.out.print(i+" ");
				if(max<i) {
				max=i;}
				if(min>i) {min=i;}
			}
		}
		int [] ans = {max,min};
		return ans;
	}
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int x=scanner.nextInt();
		int [] input=new int[(int)Math.pow(10, 3)];
		for(int i=0;i<input.length;i++) {
			input[i]=0;
		}
		//int count=0;
		for(int i=0;i<n;i++) {
			int a=scanner.nextInt();
			input[a]++;
		}
		for(int i=0;i<10;i++) {
			System.out.print(i +"  ");}
		for(int i=10;i<32;i++) {
			System.out.print(i +" ");}
		int [] ans=cal_max(input, x, k);
		System.out.println();
		System.out.println(ans[0]+" " +ans[1]);
		
	}

}
