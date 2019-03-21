import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class coin_change {
	public static HashMap<Integer[], Integer> ans_record=new HashMap<>();
	public static int x=0;
	public static int countWaysToMakeChange(int d[], int value,int i){
//System.out.println("recursion call no"+(++x)+" "+ans_record);
		if(value==0) {
			Integer[] key= {value,i};
			ans_record.put(key, 1);
			return 1;}
		else if(value<0 || i>=d.length) {
			Integer[] key= {value,i};
			ans_record.put(key,0);
			return 0;}
		else {Integer[] key= {value,i};
		if(ans_record.containsKey(key)) {
			System.out.println("repetetion no "+(++x));
			return ans_record.get(key);
		}
			int sub_ans1;
			int sub_ans2=0;
			Integer[] key1 = {value-d[i],i};
		Integer[] key2 = {value,i+1};
			if(ans_record.containsKey(key1)) {
				System.out.println("repetetion no "+(++x));
				 sub_ans1=ans_record.get(key1);
			}
			else {
			 sub_ans1=countWaysToMakeChange(d, value-d[i],i);
			
		//	Integer[] key1 = {value-d[i],i};
			ans_record.put((Integer[])key1, sub_ans1);}
			if(ans_record.containsKey(key2)){
				System.out.println("repetetion no "+(++x));
				 sub_ans1=ans_record.get(key2);
			}
			else {
			 sub_ans2=countWaysToMakeChange(d, value,i+1);
			//Integer[] key2 = {value,i+1};
			ans_record.put(key2, sub_ans2);
			}
			return sub_ans1+sub_ans2;
		}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int[] input=new int[N];
		for(int i=0;i<N;i++) {
			input[i]=scanner.nextInt();
		}
		int value=scanner.nextInt();
		System.out.print(countWaysToMakeChange(input, value, 0));

	}

}
