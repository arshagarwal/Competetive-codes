package competetive_prog;


import java.util.Scanner;
import java.util.*;

public class practice {
	public static int[][] subsets(int input[]) {
		// Write your code here
      if(input.length==1){
        int[][] ans={{},{input[0]}};
        return ans;
      }
      else{
        int a[][]=subsets(Arrays.copyOfRange(input,1,input.length));
        int[][] ans = new int[2*a.length][];
        for(int i=0;i<a.length;i++){
          int [] s =new int[a[i].length+1];
          if(a[i].length!=0) {
          s[0]=input[0];
          for(int t=0;t<a[i].length;t++){
              s[t+1]=a[i][t];
            }
            ans[i]=s;}
          else {
        	  int[] q=new int[] {input[0]};
        	  ans[i]= q;
          }
         
        }
        for(int i=a.length;i<2*a.length;i++){
          int[] add=a[(2*a.length)-i-1];
          ans[i]=add;
        }
        return ans;
      }

	}
public static void main(String[] args) {
	Scanner  a = new Scanner(System.in);
	int n = a.nextInt();
	int[] input= new int[n];
	for(int i=0;i<n;i++) {
		input[i]=a.nextInt();
	}
	int[][] ans=subsets(input);
	for(int t=0;t<ans.length;t++){
		if(ans[t].length==0) {
			System.out.println("empty as fuck");
		}
		for(int s:ans[t]) {
			System.out.print(s+" ");
		}
		System.out.println();
	}
	
	
}
}
