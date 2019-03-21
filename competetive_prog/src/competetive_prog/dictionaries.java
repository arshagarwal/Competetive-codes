package competetive_prog;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;
import java.io.*;


public class dictionaries {
	 public static void main(String []arh){
	       Scanner sc= new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<String, Integer> phonebook=new HashMap<>();
	    for(int i=0;i<n;i++) {
	    	String a= sc.next();
	    	int b= (sc.nextInt());
	    	phonebook.put(a, b);
	    }
	    while(sc.hasNext()) {
	    	int x=0;
	    	int v=0;
	    	String k = sc.next();
	    	try {
	    	 v = phonebook.get(k);}
	    	catch (NullPointerException e) {
	    		
				// TODO: handle exception
	    		System.out.println("Not found");
	    		x=3;
			}
	    	
				

	    	finally {if(x==0) {
	    		System.out.println(k+"="+v);
	    	}
				
			}
	    
			
	    	
	    	
	    }
	    
		}
	}