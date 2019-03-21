package competetive_prog;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class duplicates {
	
	public static void main(String[] ar) {
		Scanner in = new Scanner(System.in);
		TreeSet<Integer> x= new TreeSet<>();
		int n = in.nextInt();
		for(int i=0;i<n;i++) {
			x.add(in.nextInt());
		}
		int [] res=new int[x.size()];
		Iterator<Integer> a=x.iterator();
		int t=0;
		while(a.hasNext()) {
			res[t++]=a.next();
		}
		for(int y=0;y<res.length;y++) {
			System.out.print(res[y]+" ");
		}
		
		
	}

}
