package competetive_prog;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.Painter;

public class non_repeating {
public static void main(String[] ar) throws NullPointerException {
	Scanner c= new Scanner(System.in);
	char[] x=c.nextLine().toCharArray();
	Map<Character, String> record=new HashMap<>();
	for(int i=0;i<x.length;i++) {
		String s=record.get(x[i]);		
		if((s)==null) {
			record.put(x[i], "1");
		}
		else {int k=Integer.parseInt(s)+1;
			record.put(x[i], Integer.toString(k));
		}}
		//System.out.print(record.keySet()+"     "+record.values());
		Set<Character> string=record.keySet();
		Iterator<Character>z=string.iterator();
		int u=0;
		 char k =z.next();
		for(int b=0;b<x.length;b++) {
			//System.out.println(k);
			String m=record.get(x[b]);
			if(m=="1") {
				//System.out.println(k);
				u=4;
				break;
			}
			else {k=z.next();}
			}
			if(u==0){
				System.out.println(x);}
			else {System.out.print(k);}
				
			
			
	}
}


