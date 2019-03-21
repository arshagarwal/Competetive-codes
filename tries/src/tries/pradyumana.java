package tries;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class pradyumana {
	public static class tries {
		tries[] children=new tries[26];
		// contains arraylist
		ArrayList<Integer> contains=new ArrayList<>();
		boolean terminates=false;
	}
	public static void insert(String word,tries head){
		if(word.equals("")) {
			head.terminates=true;
			return;
		}
		// current charachter\
		char charachter=word.charAt(0);
		int index=(int)charachter-(int)'a';
		head.contains.add(index);
		if(head.children[index]!=null) {
			head=head.children[index];
		}
		else {
			// new node
			tries node=new tries();
			head.children[index]=node;
			head.contains.add(index);
			head=node;
		}
		insert(word.substring(1), head);
	}
	public static void DFS(tries head,String word){
     if(head.terminates) {
    	 System.out.println(word);
     }
     ArrayList<Integer> contain=head.contains;
     Collections.sort(contain);
     if(contain.size()==0) {return;}
     ArrayList<Integer> contains=new ArrayList<>();
     contains.add(contain.get(0));
     // converting into an array of unrepeated elements
     for(int i=1;i<contain.size();i++) {
    	 if(contains.get(contains.size()-1)!=contain.get(i)) {
    		 contains.add(contain.get(i));
    	 }
     }
     for(int i=0;i<contains.size();i++) {
    	 if(head.children[contains.get(i)]!=null){
    		 DFS(head.children[contains.get(i)],word+Character.toString((char)(contains.get(i)+(int)'a')));
    	 }
     }
	}
	
	public static void print(tries head ,String word){
		int flag=0;
		for(int i=0;i<word.length();i++) {
			int index=(int)word.charAt(i)-(int)'a';
			if(head.children[index]==null) {
				System.out.println("No suggestions");
				flag=1;
				break;
			}
			else {
				head=head.children[index];
			}
		}
		if(flag!=1) {
		DFS(head,word);}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		
		tries head=new tries();
		for(int i=0;i<n;i++) {
			String word=scanner.next();
		insert(word, head);	
		}
		int q=scanner.nextInt();
		for(int i=0;i<q;i++) {
			String word=scanner.next();
			print(head, word);
		}

	}

}
