import java.util.Scanner;

public class ad_gcd {
	public static int gcd(int a,int b)
	{
		// Write your code here
      if(b>a){
        return gcd(b,a);
      }
      if(b==0){
        return a;
      }
      else{
        return gcd(b,a%b);
      }
	}		
	public static int tenmod(int x,int a) {
		if(x==1) {
			return 10%a;
		}
		else {
			if(x%2==0) {
				int sub_ans=tenmod(x/2, a);
				return (sub_ans*sub_ans)%a;
			}
			else {
				int sub_ans1=tenmod((int)x/2, a);
				int sub_ans2= tenmod((int)x/2+1,a);
				int ans =(sub_ans1*sub_ans2)%a;
				return ans ;
			}
		}
	}
	public static int getNo(String input,int a) {
		if(input.length()<=8) {
			return Integer.parseInt(input)%a;
		}
		else {int n=input.length()/8;
		long sum=0;
		int i=0;
		int t=8*(n-1);
		for(int k=0;k<n;i+=8,k++) {
			int sub_input=Integer.parseInt(input.substring(i,i+8));
			long temp=(long)(sub_input%a)*(tenmod(input.length()-i-8, a));
			sum=sum+temp;
		}
		//for remaining digits
		if(input.substring(t+8)!="") {
		//	System.out.println("t="+t);
		int rem=Integer.parseInt(input.substring(t+8));
		sum=sum+(rem%a);}
		return (int)(sum%a);
			
		}
	}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	for(int t=0;t<n;t++) {
int a= s.nextInt();
  String b= s.next();
	int input=getNo(b, a);
	//System.out.println(input);
System.out.println(gcd(input, a));}	
	s.close();
}
}
