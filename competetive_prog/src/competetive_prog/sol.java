package competetive_prog;

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class sol {
	// element - number to be searched
	public static int binarySearch(int input[], int element,int b,int e) {
		// Write your code here
int s=e-b+1;
      int t= b+(s-1)/2;
      if(input[t]==element){return t; }
      else if(b>=e & input[t]!=element) {return -1;}
      else if(input[t]>element){
        return binarySearch(input,element,b+0,t-1);
      }
      else if(input[t]<element){
        return binarySearch(input,element,t+1,input.length-1);
       }
      return 0;
      
 }
	public static int binarySearch(int input[],int element) {
		return binarySearch(input, element,0,input.length-1);
	}
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int m= a.nextInt();
		int [] input=new int[m];
		for(int i=0;i<m;i++) {
			input[i]=a.nextInt();
		}
		int element=a.nextInt();
		//System.out.print(input[5]+"what the "+element);
		int res=binarySearch(input, element);
		System.out.println(res);
		
		
	}
}


