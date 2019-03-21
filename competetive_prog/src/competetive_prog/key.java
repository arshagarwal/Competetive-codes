package competetive_prog;

import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Scanner;

public class key {
	public static HashMap<String, String> key_pad=new HashMap<>();
	

	public static String[] keypad(int n){
		int t=0;
		int size=Integer.toString(n).length();
		String in= Integer.toString(n);
         if(size==1) { 
        	 String alpha=key_pad.get(in);
        	//System.out.println(in);
        	 if(alpha.length()==4){
        		// System.out.print(in);
        		 String[] ans =new String[4];
        		 for(int i=0;i<4;i++) {
        			 ans[i]=Character.toString(alpha.charAt(i));
        		//	 System.out.println("fuck");
        		 }
        	 return ans;}
        	 else {
        		 String[] ans =new String[3];
        		 for(int i=0;i<3;i++) {
        			 ans[i]=Character.toString(alpha.charAt(i));}
        			 return ans;
        		  }
        	 }
         else {
        	 t=0;
        	 
             for(int i=0;i<Integer.toString(n).length();i++) {
            	 if(Integer.toString(n).charAt(i)=='9' | Integer.toString(n).charAt(i)=='7') {
            		 t++;
            	 }}
            	String[] ans= new String[(int) (Math.pow(3, size-t)*Math.pow(4, t))];
            	//System.out.println(ans.length);
            	String new_in=in.substring(1);
            	String[] sub_ans=keypad(Integer.parseInt(new_in));
            	
            	//System.out.print(in);
            	if(in.charAt(0)=='7'|in.charAt(0)=='9') {
            		//System.out.print(in);
            		int k=0;
            		for(int j=0;j<sub_ans.length;j++) {
            			for(int r=0;r<4;r++) {
            				String u=key_pad.get(Character.toString(in.charAt(0))).charAt(r)+sub_ans[j];
            				ans[k++]=u;
            			}
            			}}
            		else {int k=0;
            		String u="0";
            			for(int j=0;j<sub_ans.length;j++) {
            			for(int r=0;r<3;r++) {
            			//	System.out.print(key_pad.get(Character.toString(in.charAt(0))));
            				if(key_pad.get(Character.toString(in.charAt(0))).charAt(r)!='0'){
            				 u=key_pad.get(Character.toString(in.charAt(0))).charAt(r)+sub_ans[j];}
            				else {
            					u=sub_ans[j];}
            				}
            				ans[k++]=u;
            			}
            			
            		}	
            		
            	
            	return ans;}
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
		key_pad.put("1", "0");
		String [] ans= keypad(278);
		//System.out.print(ans.length);
		for(String i:ans) {
			System.out.println(i+"  ");
		}
	}

}
