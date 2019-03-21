package mixed_prob;

import java.util.Scanner;

public class segmented_s {
	public static boolean seive[]=new boolean[(int)Math.pow(10, 6)+1];
	public static void initialize(){
		for(int i=0;i<seive.length;i++) {
			seive[i]=true;
		}
	}
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
	public static void create_seive() {
		int root=((int)Math.pow(10, 6));
		for(int i=2;i<=root;i++) {
		if(seive[i]==true) {
			for(int t=i;t<=seive.length/t;t++) {
				seive[i*t]=false;
			}
		}
		}
	}
	// segmented seive is a seive from l to r
	public static void seg_seive(int l,int r) {
		boolean[] seg_seive=new boolean[r-l+1];
		for(int k=0;k<seg_seive.length;k++) {
			seg_seive[k]=true;
		}
		int root=(int)(Math.sqrt(r));
		for(int i=2;i<=root;i++) {
			if(seive[i]) {
				for(int t=l/i;t<=r/i;t++) {
					if (i*t<l) {t++;}
					if(t==1) {t++;}
					seg_seive[i*t-l]=false;
					//System.out.println(i*t);
				}
			}
		}
		for(int i=0;i<seg_seive.length;i++) {
			if(seg_seive[i]==true) {
				System.out.println(i+l);
			}
		}
		//return seg_seive;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialize();
		create_seive();
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int i=0;i<t;i++) {
			int L=scan.nextInt();
			int R=scan.nextInt();
			seg_seive(L, R);
		}

	}

}
