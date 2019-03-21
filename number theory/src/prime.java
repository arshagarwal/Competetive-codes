import java.util.Scanner;

public class prime {
	public static boolean[] seive;
	public static boolean checkprime(int n) {
		int c=(int)Math.pow(n, 0.5);
		for(int i=2;i<=c;i++) {
			if(n%i==0) {
			//	System.out.print(i);
				seive[n]=false;
				return false;
			}
		}
		return true;
	}
	public static int noOfPrimes(int input){
		
		for(int i=2;i<seive.length;i++) {
			seive[i]=true;
		}
		int n =(int)Math.pow(input, 0.5);
		for(int t=2;t<=n;t++) {
			if(seive[t]==true && checkprime(t)==true) {
				for(int k=t;k<=input;k++) {
					if(t*k<=input) {
						seive[t*k]=false;
					}
					else {break;}
				}
			}
		}
		int ans=0;
		for(int u=0;u<seive.length;u++) {
			if(seive[u]==true) {
				ans++;
			}
		}
		return ans;
	}
public static void main(String[] args) {
	Scanner scanner =new Scanner(System.in);
	int input=scanner.nextInt();
	seive=new boolean[input+1];
	System.out.print(noOfPrimes(input));
}
}
