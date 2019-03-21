package mixed_prob;

import java.util.Scanner;

public class fib {
	public static void multiply(long[][] A,long[][] C) {
		long value_1=A[0][0]*C[0][0]+A[0][1]*C[1][0];
		long value_2=A[0][0]*C[0][1]+A[0][1]*C[1][1];
		long value_3=A[1][0]*C[0][0]+A[1][1]*C[1][0];
		long value_4=A[1][0]*C[0][1]+A[1][1]*C[1][1];
		//int[][] B= {{value_1,value_2},{value_3,value_4}};
		A[0][0]=value_1;
		A[0][1]=value_2;
		A[1][0]=value_3;
		A[1][1]=value_4;
	}
	public static void power(long [][] A,long n) {
		if(n==1 || n==0) {}
		else {
			power(A, n/2);
			multiply(A,A);
			if(n%2!=0) {
			long[][] c= {{1,1},{1,0}};
				multiply(A,c);
			}
		}
	}
	public static long find_fib(int n) {
		long[][] A= {{1,1},{1,0}};
		if(n==0) {
			return 0;
		}
		power(A,n-1);
		
		return A[0][0];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
System.out.print(find_fib(21)-find_fib(11));
	}

}
