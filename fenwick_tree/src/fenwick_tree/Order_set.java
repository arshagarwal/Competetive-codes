package fenwick_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.print.DocFlavor.INPUT_STREAM;

public class Order_set {
	public static class query {
		String type;
		int x;
	}
	public static int query(int index,int[] fenwick_tree){
		int value=0;
		for(;index>0;index-=index&(-index)) {
			value+=fenwick_tree[index];
		}
		return value;
	}
	public static void update(int index,int[] fenwick_tree,int a) {
		for(;index<fenwick_tree.length;index+=index&(-index)) {
			fenwick_tree[index]+=a;
		}
	}
	public static int binary_search(int element ,Object[] fenwick_tree,int s,int e) {
		int mid=(s+e)/2;
		if(s>=e) {
			if((int)fenwick_tree[mid]==element) {
		return s;	}
			else {
				return s-1;
			}
		}
		if((int)fenwick_tree[mid]>element) {
			return binary_search(element, fenwick_tree, s, mid-1);
		}
		else if ((int)fenwick_tree[mid]<element){
			return binary_search(element, fenwick_tree, mid+1, e);
		}
		else{ return mid;}
	}
	public static int binary_search_2(int element ,int[] fenwick_tree,int s,int e) {
		int mid=(s+e)/2;
		if(s>=e) {
			if(query(mid, fenwick_tree)==element) {
		return s;	}
			else {
				return s-1;
			}
		}
		if(query(mid, fenwick_tree)>element) {
			return binary_search_2(element, fenwick_tree, s, mid-1);
		}
		else if (query(mid, fenwick_tree)<element){
			return binary_search_2(element, fenwick_tree, mid+1, e);
		}
		else{ return mid;}
	}
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int q=scanner.nextInt();
	query[] input=new query[q];
	// array that contains all the elements of the set
	ArrayList<Integer> set=new ArrayList<>();
	for(int i=0;i<input.length;i++) {
		input[i]=new query();
		input[i].type=scanner.next();
		input[i].x=scanner.nextInt();
		if(input[i].type.equals("I")) {
			set.add(input[i].x);
		}
	}
   Collections.sort(set);
   HashMap<Integer, Integer> record=new HashMap<>();
   int it=0;
   HashMap<Integer, Integer> inverse_record=new HashMap<>();
   for(int i=0;i<set.size();i++) {
	   if(!record.containsKey(set.get(i))) {
		   record.put(set.get(i),it);
		   inverse_record.put(it++,set.get(i));
	   }
   }
Object[] keys=record.keySet().toArray();
Arrays.sort(keys);
   // fenwick tree that stores no of elements less than corresponding element at set array
   // fenwick[i]=no of elements less than set[i-1] in the set array
   int[] fenwick_tree=new int[record.size()+1];
   int total=0;
   for(int i=0;i<input.length;i++){
	   if(input[i].type.equals("I")){
		   if(query(record.get(input[i].x)+1, fenwick_tree)==query(record.get(input[i].x), fenwick_tree)){
			   update(record.get(input[i].x)+1, fenwick_tree,1);
			   total++;
		   }
	   }
	   else if(input[i].type.equals("D")) {
		   if(record.get(input[i].x)==null) {
			   
		   }
		   else {
	    if(query(record.get(input[i].x)+1, fenwick_tree)!=query(record.get(input[i].x), fenwick_tree)) {
			total--;   
	    	update(record.get(input[i].x)+1, fenwick_tree,-1);
		   }
	   }}
	   else if(input[i].type.equals("C")) {
		   
		   int index=binary_search(input[i].x,keys, 1,keys.length-1);
		   System.out.println(query(record.get((int)keys[index])+1, fenwick_tree));
	   }
	   else if(input[i].type.equals("K")) {
		   if(input[i].x>total) {
			   System.out.println("invalid");
		   }
		   else {
		   int index=binary_search_2(input[i].x, fenwick_tree, 1,fenwick_tree.length-1);
		   while(query(index, fenwick_tree)==query(index-1, fenwick_tree)) {
			   index--;
		   }
		   System.out.println(inverse_record.get(index-1));}
		   
	   }
   }
}
}
