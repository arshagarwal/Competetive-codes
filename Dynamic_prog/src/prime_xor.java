import java.util.HashMap;
import java.util.Scanner;

public class prime_xor {
	public static int flag=1;
	public static boolean[] seive=new boolean[9000];
	public static HashMap<Integer, Integer> frequency=new HashMap<>();
	public static boolean checkprime(int n) {
		int c=(int)Math.pow(n, 0.5);
		for(int i=2;i<=c;i++) {
			if(n%i==0) {
			//	System.out.print(i);
			//	seive[n]=false;
				return false;
			}
		}
		return true;
	}
	public static void make_seive(){
		for(int i=0;i<seive.length;i++) {
			seive[i]=true;
		}
		int root=(int)Math.sqrt(seive.length);
		for(int i=2;i<=root;i++) {
			if(checkprime(i)) {
				for(int t=i;t<=root/i;t++) {
					seive[i*t]=false;
				}
			}
		}
	}
	public static int find_prime_multisets(int [] input) {
		int count=0;
		int[][] dp=new int[2][8192];
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=0;
		}
		dp[0][input[0]^input[1]]=1;
		dp[0][0]=1;
		dp[1][1]=1;
		for(int i=2;i<input.length+1;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//if(checkprime(j)) {
					int n=frequency.get(input[i-1]);
				dp[flag][j]=dp[flag^1][j]*(1+(n/2));// multiply with exclude frequency here
				System.out.println("j ="+j+"input = "+input[i-1]+" xor"+(j^input[i-1]));
				dp[flag][j]+=dp[flag^1][j^input[i-1]]*(n/2);//multiply with include frequency here
		       // System.out.println(dp[flag][j]);
				//count+=dp[flag][j];
				
			
				flag=flag^1;
				}
		}
		for(int i=0;i<dp[0].length;i++) {
			count+=dp[flag^1][i];
		}
return count;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
	
		int n=scanner.nextInt();
		for(int i=0;i<n;i++){
			int t=scanner.nextInt();
			int [] input=new int[t];
			for(int j=0;j<t;j++) {
				int a=scanner.nextInt();
				input[j]=a;
				if(frequency.containsKey(a)) {
					frequency.put(a, frequency.get(a)+1);
				}
				else {
					frequency.put(a, 1);
				}
				
			}
			System.out.println(find_prime_multisets(input)+"fuck");
		}
	
	}

}
