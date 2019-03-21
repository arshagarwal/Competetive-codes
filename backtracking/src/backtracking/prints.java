package backtracking;

import java.util.HashMap;

public class prints {
	public static HashMap<String, String> record= new HashMap<>();
	public static void printAllPossibleCodes(String input,String temp) {
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
		if(input.length()==1) {
			System.out.print(temp+input);
		}
		else if(input.length()==2) {
			if(Integer.parseInt(input.substring(0, 2))<=26) {
			//	temp=input.substring(0,2);
			//	printAllPossibleCodes(input.substring(2), temp);
				System.out.println(temp+record.get(input));
			}
		//temp=record.get(input.substring(0,1))+record.get(input.substring(1,2));
		System.out.println(temp+record.get(input.substring(0,1))+record.get(input.substring(1,2)));
			//printAllPossibleCodes(input.substring(2), temp);
		}
		
		
		else {
			if(Integer.parseInt(input.substring(0, 2))<=26) {
				temp=record.get(input.substring(0,2));
				printAllPossibleCodes(input.substring(2), temp);
		//		System.out.println(input+"   1  ");
			}
		//	printAllPossibleCodes(input.substring(2,input.length()), temp);
		
		temp=record.get(input.substring(0,1))+record.get(input.substring(1,2));
	//	System.out.println(input+"     2");
		printAllPossibleCodes(input.substring(2,input.length()), temp);}
		
	}
	public static void main(String[] args) {
		String s="1123";
		printAllPossibleCodes(s, "");
	}
}
