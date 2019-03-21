import java.util.Scanner;

public class n_factor {
	public static int[] seive;
	public static int[][] table=new int[10+1][(int)Math.pow(10, 6)+1];
	public static boolean checkprime(int n) {
		int c=(int)Math.pow(n, 0.5);
		for(int i=2;i<=c;i++) {
			if(n%i==0) {
			//	System.out.print(i);
				//seive[n]=false;
				return false;
			}
		}
		return true;
	}
	public static void make_seive(int input){
		seive=new int[input+1];
			int n =(int)Math.pow(input, 0.5);
			for(int t=2;t<=n;t++) {
				if(seive[t]==0 && checkprime(t)==true) {
					for(int k=1;k<=input;k++) {
						if(t*k<=input) {
							seive[t*k]++;
						}
						else {break;}
					}
				}
			}}
	public static void make_table() {
		table[0][0]=1;
		table[0][1]=2;
		for(int i=2;i<table[0].length;i++) {
			table[0][i]=2;
		}
		for(int i=1;i<table.length;i++) {
			table[i][0]=0;
			table[i][1]=0;
			int k=2;
			int c=0;
			for(int j=2;j<table[i].length;j++) {
				// for i no of factor
			
				if(i==seive[k++]) {
					table[i][j]=++c;
				}
				else {
					table[i][j]=c;
				}
			}
		}
	}
	
public static void main(String[] args) {
	make_seive((int)Math.pow(10, 6));
	make_table();
	//System.out.print(seive[2]);
	//for(int i=0;i<table[1].length;i++) {
		//System.out.print(table[1][i]+" ");
	//}
	//System.out.println(seive[]);
//	System.out.println(table[1][2]);
	Scanner s=new Scanner(System.in);
	int t=s.nextInt();
	for(int i=0;i<t;i++) {
		int[] a=new int[3];
		for(int k=0;k<3;k++) {
			a[k]=s.nextInt();
		}
		int ans=table[a[2]][a[1]]-table[a[2]][a[0]-1];
		System.out.println(ans);
	}
}
}
