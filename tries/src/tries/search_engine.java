package tries;

import java.util.Scanner;

public class search_engine {
	public static class tries{
		tries[] children=new tries[26];
		int weight=0;
	} 
 public static void insert(String word,int weight,tries head){
	 if(word.equals("")) {
		 
		 return;
	 }
	 // current charachter
	 char charachter=word.charAt(0);
	 // index of the chrachter
	 int index=(int)charachter-(int)'a';
	 if(head.children[index]!=null){
		 if(weight>head.children[index].weight){
			 head.children[index].weight=weight;
		 }
		 head=head.children[index];
	 }
	 else {
		 // new node
		 tries node=new tries();
		 node.weight=weight;
		 head.children[index]=node;
		 head=node;
	 }
	 insert(word.substring(1), weight, head);
 }
 // function to get the best possible weight
 public static int weight_search(tries head,String word) {
	 // length of word 
	 int length=word.length();
	 for(int i=0;i<length-1;i++) {
		 int index=(int)word.charAt(i)-(int)'a';
		 if(head.children[index]==null) {
			 return -1;
		 }
		 else {
			 head=head.children[index];
		 }
	 }
	 return head.weight;
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int q=s.nextInt();
		tries head =new tries();
		// iteration to take in strings and weight
		for(int i=0;i<n;i++) {
			String word=s.next();
			int weight =s.nextInt();
			insert(word, weight, head);
		}
		// iteration to query
		for(int i=0;i<q;i++) {
			String t=s.next();
			int ans=weight_search(head, t);
			System.out.println(ans);
		}
		

	}

}
