package competetive_prog;

import java.util.ArrayList;

public class che {
	public static long merge(int[] input1,int[] input2) {
		int i=0,j=0;
		long ans=0;
		while(i<input1.length && j<input2.length) {
			if(input1[i]<input2[j]) {
				long sub_ans=input1[i]*(input2.length-j);
				System.out.println(sub_ans+"fuck");
				ans=ans+sub_ans;
				i++;
			}
			else {
				j++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] a= {1};
int[] b= {5};
ArrayList<Integer> arrayList=new ArrayList<>();
arrayList.add(0);
String string="abc";
System.out.println(string.substring(1));
System.out.println(string);
	}

}
