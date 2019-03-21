import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class cubic_square {
	public static long find_power(long a,String b,int m) {
		int i=b.length()-1;
		long ans=1;
		int j=b.length();
		while(i>=0) {
			if(b.substring(i,j).equals("1")) {
				ans=((ans)%m*(a)%m)%m;
			}
			if(b.substring(i,j).equals("2")) {
				ans=((ans)%m*(a)%m*(a)%m)%m;
			}
			i--;
			j--;
			a=((a)%m*(a)%m*(a)%m)%m;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++) {
        	int a= s.nextInt();
        	String b=s.next();
        	int m=s.nextInt();
        	System.out.println(find_power(a, b, m));
        }
	}

}
