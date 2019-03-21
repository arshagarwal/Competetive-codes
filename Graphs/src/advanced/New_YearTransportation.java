package advanced;

import java.util.Scanner;

public class New_YearTransportation{
	
	public static String solve(int[] a,int n,int t) {
	// this array contains the index value the given index has portal to
		int [] portal =new int[n-1];
		for(int i=0;i<portal.length;i++) {
			portal[i]=a[i]+i+1;
		}
		int curr=0;
		// now checking by iterating if there is a path
		while(portal[curr]!=t){
			if(portal[curr]==n && t!=n) {return "NO";}
			if(portal[curr]!=t) {
				curr=portal[curr]-1;
			}
		}
		return "YES";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int t=s.nextInt();
        // array containing ai 
        int [] a=new int[n-1];
        for(int i=0;i<a.length;i++) {
        	a[i]=s.nextInt();
        }
        System.out.println(solve(a, n, t));
        
	}

}
