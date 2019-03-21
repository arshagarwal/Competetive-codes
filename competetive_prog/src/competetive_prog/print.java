package competetive_prog;

import java.util.ArrayList;
import java.util.HashMap;

public class print {
	public static HashMap<String, String> key_pad=new HashMap<>();

	public static void printKeypad(int input,String output) {
		int n=input/10;
		String t=Integer.toString(input);
		String s=Integer.toString(input);
		if(n==0){
			for(int i=0;i<key_pad.get(s).length();i++) {
				
				 String out = output+ Character.toString(key_pad.get(s).charAt(i)) ;
				System.out.println(out);
			}
			}
		else {String f=(t.substring(1));
		if(output==" ") {output="";}
		char b=t.charAt(0);
		String m=key_pad.get(Character.toString(b));
		for(int y=0;y<key_pad.get(Character.toString(b)).length();y++) {
			
			printKeypad(Integer.parseInt(t.substring(1)),output+m.charAt(y));}
		}
		}
	public static void printKeypad(int input) {
		 printKeypad( input," ");
	}
	
	
	
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		//String n=scanner.next();
		key_pad.put("2", "abc");
		key_pad.put("4", "ghi");
		key_pad.put("3", "def");
		key_pad.put("5", "jkl");
		key_pad.put("6", "mno");
		key_pad.put("7", "pqrs");
		key_pad.put("8", "tuv");
		key_pad.put("9", "wxyz");
		printKeypad(234688);

}}
