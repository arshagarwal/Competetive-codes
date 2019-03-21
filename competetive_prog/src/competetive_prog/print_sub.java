package competetive_prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.print.attribute.standard.PrinterLocation;

public class print_sub {
	public static void printSubsets(int input[],String output) {
		if(input.length==1) {
			
			/*ArrayList<String> ans=new ArrayList<>();
					ans.add(output);
			ans.add(Integer.toString(input[0]));
			Iterator it= ans.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}*/
			System.out.println(output);
			if(output=="") {
				System.out.println(Integer.toString(input[0]));
			}
			else {
			System.out.println(output+" "+Integer.toString(input[0]));
		}}
		else {
			int[] x=Arrays.copyOfRange(input, 1, input.length);
			printSubsets(x,output);
			if(output!="") {
			printSubsets(x,output+" "+Integer.toString(input[0]));}
			else {
				printSubsets(x,Integer.toString(input[0]));
			}
		}
	}
	public static void printSubsets(int input[]) {
		printSubsets(input,"");
	}
	public static void main(String[] args) {
		int[] input= {3,4,5,6,8};
		printSubsets(input);
	}

}
