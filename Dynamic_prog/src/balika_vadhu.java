import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class balika_vadhu {
	public static int[][][] ans_record;
	public static void initialize() {
		for(int i=0;i<ans_record.length;i++) {
			for(int j=0;j<ans_record[0].length;j++) {
				for(int t=0;t<ans_record[0][0].length;t++) {
					ans_record[i][j][t]=-1;
				}
			}
		}
	}
	//public static int max=0;
	public static int max_blessing(String s1,String s2,int K) {
		if(s1.equals("")|| s2.equals("")) {
			return 0;
		}
		if(K==0) {
			return 0;
		}
		else {
			if(ans_record[s1.length()][s2.length()][K]!=-1) {
				return ans_record[s1.length()][s2.length()][K];
			}
			int temp_max1=0;
			if(s1.charAt(0)==s2.charAt(0)){
				int temp_ans=max_blessing(s1.substring(1), s2.substring(1),K-1);
				if(temp_ans!=0 || K==1) {
				 temp_max1=(int)(s1.charAt(0))+temp_ans;
			}}
			int temp_max2=max_blessing(s1.substring(1), s2, K);
			int temp_max3=max_blessing(s1, s2.substring(1), K);
		    int ans= Math.max(temp_max2, Math.max(temp_max3, temp_max1));
		    ans_record[s1.length()][s2.length()][K]=ans;
		    return ans;
		}
		
		
	}
		
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;i++) {
        		String s1=scanner.next();
        		String s2=scanner.next();
        		int K=scanner.nextInt();
        		ans_record=new int[s1.length()+1][s2.length()+1][K+1];
        	initialize();
        	System.out.println(max_blessing(s1, s2, K));
        	
        }
	}

}
