package part_3;

import java.util.HashMap;
import java.util.Scanner;

public class dilemma {
	//public static int[][] dp;
	public static HashMap<String,Integer> dp=new HashMap<>();
	public static int minimumTouchRequired(int n,String[] input,int mask,int idx){
		// to count no of 1s in mask
				int c=0;
				// length of mask
				int length=Integer.toString(mask).length();
		for(int i=0;i<length;i++){
			if(Integer.toString(mask).substring(i,i+1).equals("1")){
				c++;}}
		if(c==1) {return 0;}
		if(idx>=input[0].length()) {return Integer.MAX_VALUE/10;}
		String key=Integer.toString(mask)+","+Integer.toString(idx);
		String m1="";
		String m2="";
		
		for(int i=0;i<length;i++){
			if(Integer.toString(mask).substring(i,i+1).equals("1")){
				//c++;
			int temp=Integer.parseInt(input[i].substring(idx,idx+
					1));
	    	if((temp&(1))!=0){
	    	//	count++;
	    	   m2+="0";
	    	   m1+="1";
	    		}
	    	else {
	    		 m2+="1";
		    	   m1+="0";
	    		
	    	}}
			else {m1+="0";
			m2+="0";
			}	
		}
		//int t=(int)Math.pow(2, n+1);
		int mask1=Integer.parseInt(m1);
		int mask2=Integer.parseInt(m2);
		//if(c==1) {return 0;}
		if(mask==0) {
			return Integer.MAX_VALUE/10;
		}
	    	/*if(count==1 || count==n-1){
	    		if(count==1) {
	    		int ans=c+minimumTouchRequired(n, input, mask2, idx+1);
	    		dp.put(key, ans);
	    		return ans;}
	    		else {
	    			int ans=c+minimumTouchRequired(n, input, mask2, idx+1);
	    			dp.put(key, ans);
		    		return ans;
	    		}
	    	}*/
			else if(dp.containsKey(key)){
				return dp.get(key);
			}
			else if (mask1==mask || mask2==mask) {
				return minimumTouchRequired(n, input, mask, idx+1);
			}
	    	else {
	    		int sub_ans1=c+minimumTouchRequired(n,input,mask1,idx+1)
	    		+minimumTouchRequired(n, input, mask2, idx+1);
	    		int sub_ans2=minimumTouchRequired(n, input, mask, idx+2);
	    		int ans=Math.min(sub_ans1,sub_ans2);
	    		dp.put(key,ans);
	    		return ans;
	    	}
	     
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		String[] input=new String[n];
		for(int i=0;i<n;i++){
			input[i]=scanner.next();
		}
		int l=input[0].length();
		//dp=new int[(int)Math.min(2, l)][l];
		//for(int i=0;i<dp.length;i++) {
			//for(int j=0;j<dp[0].length;j++) {
				//dp[i][j]=Integer.MAX_VALUE;
			//}
		//}
		String m="";
		for(int i=0;i<n;i++){
			m+="1";
		}
		int mask=Integer.parseInt(m);
		System.out.println(minimumTouchRequired(n, input, mask, 0));

	}

}
