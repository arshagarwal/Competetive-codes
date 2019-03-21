import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class knapsnack {
	public static int[][] ans_record;
	public static void initialize() {
		for(int i=0;i<ans_record.length;i++) {
			for(int j=0;j<ans_record[0].length;j++) {
				ans_record[i][j]=-1;
			}
		}
	}
	public static int knapsack(int[] weight,int value[],int maxWeight,int i) {
		if(maxWeight==0) {
			ans_record[maxWeight][i]=0;
			return 0;
		}
		if(weight.length==i) {
			ans_record[maxWeight][i]=0;
			return 0;
		}
		else {
			if(ans_record[maxWeight][i]!=-1) {
				return ans_record[maxWeight][i];
			}
			int sub_ans1=0;
			if(maxWeight>=weight[i]) {
				 sub_ans1=knapsack(weight, value, maxWeight-weight[i], i+1);
				 
				 sub_ans1+=value[i];
				 
			}
			int sub_ans2=knapsack(weight, value, maxWeight, i+1);
			int ans=Math.max(sub_ans1, sub_ans2);
			ans_record[maxWeight][i]=ans;
			return ans;
		}
	}
	public static int knapsack(int[] weight,int value[],int maxWeight) {
		return knapsack(weight, value, maxWeight,0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] w=new int[n];
        for(int i=0;i<n;i++) {
        	w[i]=s.nextInt();
        }
        int[] v=new int[n];
        for(int i=0;i<n;i++) {
        	v[i]=s.nextInt();
        }
        int max_w=s.nextInt();
        ans_record=new int[max_w+1][v.length+1];
        initialize();
        knapsack(w, v, max_w, 0);
        System.out.println(ans_record[max_w][0]);
	
	
	}

}
