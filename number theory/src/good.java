import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class good {
	public static int[] seive = new int[(int)Math.pow(10,6)];
	public static void make_seive(int[] a) {
   //  int[] seive = new int[(int)Math.pow(10,6)+1];
     for(int i=0;i<a.length;i++) {
    	 seive[a[i]]=1;
     }
     int root=(int)a[a.length-1]/2;
     int i=0;
     while(a[i]<=root) {
    	// System.out.println("i= "+i);
    	 int k=a[i];
    	 //System.out.println("k= "+k);
    	 for(int t=2;t<=a[a.length-1]/k;t++) {
    		 if(seive[k*t]!=0) { seive[k*t]+=seive[k];}
    	 }
    	 i++;
     }
	}
	public static long find_sum(int[] a) {
		int m= (int)(Math.pow(10, 6))+7;
		long sum=0;
		int i=0;
		while(i<a.length) {
			sum=(long)(sum%m +(seive[a[i++]])%m)%m;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;t++) {
			int n=s.nextInt();
			int[] a =new int[n];
			for(int m=0;m<n;m++) {
				a[m]=s.nextInt();}
				Arrays.sort(a);
				make_seive(a);				
		//	System.out.println(seive[6]);
			int ans=(int)find_sum(a);
			System.out.println(ans);
		}
	}

}
