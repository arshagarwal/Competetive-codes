import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

public class divisors {
	public static boolean [] seive;
	public static int mod=(int)Math.pow(10, 9)+7; 
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
	public static int getPower(int N,int t) {
		int x=1;
		int ans=0;
		while(Math.pow(t, x)<=N) {
			int p=(int)Math.pow(t, x);
			ans+=N/p;
			x++;
		}
		return ans;
	}
public static void noOfPrimes(int input){
	seive=new boolean[input+1];
	//	ArrayList<Integer> power=new ArrayList<>();
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
		}}
	public static int  noOfDivisors(int N) {
		int ans=1;
		noOfPrimes(N);
		for(int i=2;i<=N;i++) {
			//System.out.println("i="+i);
			//for(int t=2;t<=i;t++) {
			if(seive[i]==true) {
				int p=getPower(N,i);
				if(p!=0) {
				ans=((ans%(mod))*(p+1)%mod)%mod;}
			}}
			return ans;
		
	}
		
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n= scanner.nextInt();
		for(int i=0;i<n;i++) {
			int t= scanner.nextInt();
			System.out.println(noOfDivisors(t));
		}
		
	}

}
