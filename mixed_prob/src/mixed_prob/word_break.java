package mixed_prob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class word_break {
	public static String copy(String word,int i,int j) {
	String ans="";
		for(int m=i;m<=j;m++) {
			ans+=Character.toString(word.charAt(0));
		}
		return ans;
	}
	
	public static HashMap<String, ArrayList<String>> dictionary=new HashMap<>();
	static int k=0;
	public static void print_meaningful(String sentence, String ans) {
		//System.out.println("recursion call no="+ (++k));
		if(sentence.substring(0,1).equals("@")) {
			System.out.print(ans);
			System.out.println();}
		else {
			String first_char=sentence.substring(0, 1);
			ArrayList<String> possible=new ArrayList<>();//=dictionary.get(first_char);
		    if (dictionary.containsKey(first_char)) {
				possible=dictionary.get(first_char);
			String fin=ans;
			for(int t=0;t<possible.size();t++) {
				String word=possible.get(t);
				if(word.length()<=sentence.length()) {
				if(sentence.substring(0,word.length()).equals(word)) {
				//System.out.println("fuck");
					ans+=word+" ";
					print_meaningful(sentence.substring(word.length()),ans);
					ans=fin;
				}
			}}}
		    
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=0;i<n;i++) {
			String input=s.next();
			if(dictionary.containsKey(input.substring(0, 1))){
				 dictionary.get(input.substring(0,1)).add(input);
			}
			else {
				ArrayList<String> add=new ArrayList<>();
				add.add(input);
				dictionary.put(input.substring(0,1),add );
			}
		}
		//System.out.println(dictionary);
		s.nextLine();
		String sentence=s.nextLine();
		sentence=sentence+"@";
		print_meaningful(sentence,"");
	}

}
