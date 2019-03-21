import java.util.Scanner;

public class princess_farida {
	public static long max_coins(int[] input) {
		long[] prospectus=new long[input.length];
		int n=prospectus.length;
		if(n>=1) {
		prospectus[n-1]=input[n-1];}
		if(n>=2) {
		prospectus[n-2]=input[n-2];}
		if(n>=3) {
		prospectus[n-3]=prospectus[n-1]+input[n-3];}
		if(n>=4) {
			for(int i=n-4;i>=0;i--) {
				if(prospectus[i+2]>prospectus[i+3]) {
					prospectus[i]=prospectus[i+2]+input[i];
				}
				else {
					prospectus[i]=prospectus[i+3]+input[i];
				}
			}
		}
		if(prospectus.length==1) {
			return prospectus[0];
		}
		if(prospectus[0]>prospectus[1]) {
			return prospectus[0];
		}
		else {
			return prospectus[1];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++) {
        	int n=s.nextInt();
        	int[] input =new int[n];
        	for(int j=0;j<n;j++) {
        		input[j]=s.nextInt();
        	}
        	System.out.println(max_coins(input));
        }
	}

}
