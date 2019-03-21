package competetive_prog;

import java.util.ArrayList;
import java.util.HashMap;

public class code {
	 static HashMap<String, String> record = new HashMap<>();
	 public static ArrayList<ArrayList<String>> possible(String input){
		 ArrayList<ArrayList<String>> ans = new ArrayList<>();
		 if(input.length()==1) {
			 ArrayList<String> a=new ArrayList<>();
			 a.add(Character.toString(input.charAt(0)));
			 ans.add(a);
			 return ans;
		 }
		 else if(input.length()==2) {
			 ArrayList<String> temp= new ArrayList<>();
			 temp.add(Character.toString(input.charAt(0)));
			 temp.add(Character.toString(input.charAt(1)));
			 if(Integer.parseInt(input)<=26) {
				 ArrayList<String> temp1= new ArrayList<>();
				 temp1.add(input);
				 ans.add(temp1);
			 }
		 ans.add(temp);}
		 else {// for 2 digited
			 if(Integer.parseInt(input.substring(0,2))<=26) {
				 ArrayList<ArrayList<String>>sub_ans1=possible(input.substring(2));
				 for(int i=0;i<sub_ans1.size();i++) {
					 ArrayList<String> temp=new ArrayList<>();
					 temp.add(input.substring(0,2));
					 for(int t=0;t<sub_ans1.get(i).size();t++) {
						 ArrayList<String> a=(sub_ans1.get(i));
						 String b= a.get(t);
						 temp.add(b);
					 }
					ans.add(temp); 
				 }
			 }
			 ArrayList<ArrayList<String>>sub_ans1=possible(input.substring(1));
			 for(int i=0;i<sub_ans1.size();i++) {
				 ArrayList<String> temp=new ArrayList<>();
				 temp.add(Character.toString(input.charAt(0)));
				// temp.add(input.substring(0,2));
				 for(int t=0;t<sub_ans1.get(i).size();t++) {
					 ArrayList<String> a=(sub_ans1.get(i));
					 String b= a.get(t);
					 temp.add(b);
				 }
				ans.add(temp); 
			 }
			 return ans;
		 }
		 return ans;
	 }
	public static  String[] getCode(String input){
		// Write your code here
		record.put("1","a");
		record.put("2","b");
		record.put("3","c");
		record.put("4","d");
		record.put("5","e");
		record.put("6","f");
		record.put("7","g");
		record.put("8","h");
		record.put("9","i");
		record.put("10","j");
		record.put("11","k");
		record.put("12","l");
		record.put("13","m");
		record.put("14","n");
		record.put("15","o");
		record.put("16","p");
		record.put("17","q");
		record.put("18","r");
		record.put("19","s");
		record.put("20","t");
		record.put("21","u");
		record.put("22","v");
		record.put("23","w");
		record.put("24","x");
		record.put("25","y");
		record.put("26","z");
		String ans="";
		
		ArrayList<ArrayList<String>> possible=possible(input);
		String[] Ans= new String[possible.size()];
		int j=0;
		for(int i=0;i<possible.size();i++) {
			ArrayList<String> s=new ArrayList<>();
			s=possible.get(i);
			ans="";
			for(int t=0;t<possible.get(i).size();t++) {
				String n=s.get(t);
				ans= ans+record.get(n);
			}
			Ans[j++]=ans;
		}
		return Ans;
		
		
	}
	public static void main(String[] args) {
		String n ="35411";
		String[] ans=getCode(n);
        //ArrayList<ArrayList<String>> d=new ArrayList<>();
        //d=possible(n);
		for(int i =0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
		
	}

}
