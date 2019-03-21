package competetive_prog;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class solutions {
	public static ArrayList<Integer> longestSubsequence(int arr[]){
		int[] m=arr;
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
		int i=0;
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(0, -1);
		ans.add(0, arrayList);
		for(;i<arr.length;i++) {
		if(i<arr.length-1 && arr[i]+1==arr[i+1]) {
			ArrayList<Integer> yArrayList=new ArrayList<Integer>();
			yArrayList.add(arr[i]);
			i++;
			while(arr[i]+1==arr[i+1]) {
				yArrayList.add(arr[i]);
				i++;}
			yArrayList.add(arr[i]);
			int k=ans.size();
			if(yArrayList.size()>ans.get(k-1).size()) {
			ans.add(0,yArrayList);}
			//else if()
		}
		
		}return ans.get(0);
		
		}
		
	
	public static void main(String[] args) {
		Scanner sc =new  Scanner(System.in);
		int n= sc.nextInt();
		int [] t=new int[n];
		for(int i=0;i<n;i++) {
			t[i]=sc.nextInt();}
		//System.out.println(t.length);
			ArrayList<Integer> ans=new ArrayList<>();
			ans=longestSubsequence(t);
			for(int s:ans) {
				System.out.print(s+" ");}	
			for(int s:t) {
				System.out.println(s);
			}
	}


}
