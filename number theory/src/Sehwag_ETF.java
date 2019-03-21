import java.util.Scanner;

import org.omg.CORBA.INITIALIZE;

public class Sehwag_ETF {
	
	public static long[] totient;
	public static long[] hidden;
	public static long max_power(long a,long b,long min,long max) {
		if(max==0) {
		double r_a=Math.log(a);
		double r_b=Math.log(b);
		 max= (long)(r_a/r_b);
		 }
		 if(min>=max) {
			 long divisor=(long)Math.pow(b, min);
			 if(a%divisor==0) {
				 return min;
			 }
			 else {
				 return min-1;
			 }
		 }
		 else {
			 long mid=(max+min)/2;
			 long divisor=(long)Math.pow(b, mid);
			 if(a%divisor==0) {
				 return max_power(a, b,mid+1,max);
			 }
			 else {
				 return max_power(a, b, min, mid-1);
			 }
		 }
	}
	public static long max_power(long a,long b) {
		return max_power(a,b,1,0);
	}
	public static void initilize(long L,long R) {
		hidden=new long[totient.length];
		for(int i=0;i<totient.length;i++) {
			totient[i]=L+i;
			hidden[i]=L+i;
		}
	}
	public static boolean checkprime(long n) {
		int c=(int)Math.pow(n, 0.5);
		if(n==1) {
			return false;
		}
		for(int i=2;i<=c;i++) {
			if(n%i==0) {
			//	System.out.print(i);
				//seive[n]=false;
				return false;
			}
		}
		return true;
	}
	public static void create_totient(long L,long R) {
		totient=new long[(int) (R-L+1)];
		initilize(L, R);
		int root=(int)Math.sqrt(R);
		for(int i=2;i<=root;i++) {
			long t=L/i;
			if(checkprime(i)) {
				long p=L/i;
				if(p*i<L) {p++;}
				if(p==1) {p++;}
				for(;p<=R/i;p++) {
					
					totient[(int)p*i-(int)L]=totient[(int)p*i-(int)L]*(i-1);
					totient[(int)p*i-(int)L]=totient[(int)p*i-(int)L]/i;
				
			//	while(hidden[(int)p*i-(int)L]%i==0) {
					long power =max_power(hidden[(int)p*i-(int)L], i);
					long divisor=(long)Math.pow(i,power);
					hidden[(int)p*i-(int)L]=hidden[(int)p*i-(int)L]/divisor;
					//printArray(hidden);
				}
				
			}
		}
	}
	public static double find_probability(long L,long R,long K) {
		create_totient(L, R);
		int count=0;
		for(int i=0;i<totient.length;i++) {
			if(totient[i]==L+i) {totient[i]--;}
			if(checkprime(hidden[i]) && hidden[i]!=L+i) {
				totient[i]=totient[i]*(hidden[i]-1);
				totient[i]=totient[i]/hidden[i];
			}
			if(totient[i]%K==0 && totient[i]!=0) {
				count++;
				//System.out.println(totient[0]);
			}
		}
		//System.out.println("count ="+count);
		double ans=(double)(count)/(R-L+1);
		return Double.parseDouble(String.format("%.6g%n", ans));
	}
public static void printArray(long [] arr) {
	for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]+" ");
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++) {
        	int L=s.nextInt();
        	int R=s.nextInt();
        	int K=s.nextInt();
        	
        	System.out.print(find_probability(L, R, K));
        	String j=Double.toString(find_probability(L, R, K));
        	int le=j.substring(2).length();
        	le=6-le;
        	for(int r=0;r<le;r++) {
        		System.out.print(0);
        	}
        	System.out.println();
        	
        	//totient=new long[8];
        	//initilize(L, R);
        //	printArray(totient);
        }
	}

}
