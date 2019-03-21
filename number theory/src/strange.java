import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class strange {
	public static int[] seive=new int[(int)Math.pow(10, 6)+1];
	public static void initialize() {
		for(int i=0;i<seive.length;i++) {
			seive[i]=1;
		}
	}
	public static boolean checkprime(int n) {
		int c=(int)Math.pow(n, 0.5);
		for(int i=2;i<=c;i++) {
			if(n%i==0) {
			//	System.out.print(i);
				//seive[n]=false;
				return false;
			}
		}
		return true;
	}
	public static ArrayList<Integer>find_factors(int n) {
		ArrayList<Integer> ans=new ArrayList<>();
		int root=(int)Math.sqrt(n);
		if(checkprime(n)) {
			ans.add(n);
			return ans;
		}
		for(int i=2;i<=root;i++) {
			if(n%i==0) {
				if(checkprime(i)) {ans.add(i);}
				if(checkprime(n/i) && n/i!=i) {ans.add(n/i);}
				
			}
			}
		return ans;
	}
	public static void find_array(int n,ArrayList<Integer> out) {
		if(n==1) {
			out.add(1);
			System.out.print(1);
		}
		else {
			ArrayList<Integer> p_factors=find_factors(n);
			ArrayList<Integer> arr=new ArrayList<>();
			for(int i=0;i<p_factors.size();i++) {
				int q=p_factors.get(i);
				for(int t=(n/q)-1;t>=1;t--) {
					if(seive[t*q]==1) {
					seive[t*q]=0;
					arr.add(t*q);}
				}
				//arr.add(n);
				//Collections.sort(arr,Collections.reverseOrder());
			}
			seive[n]=0;
			arr.add(n);
			Collections.sort(arr,Collections.reverseOrder());
			//System.out.println(n);
			System.out.print(arr);
			//System.out.print(Arrays.toString(arr.toArray())+" ");
		/*	for(int t:arr) {
				System.out.print(t+" ");
			}*/
			//for(int t=0;t<arr.size();t++) {
				//out.add(arr.get(t));
			//}
			int h=n-1;
			while(seive[h]==0) {
				h--;
			}
			//System.out.println(h);
		//	System.out.println(h);
			 find_array(h, out);
			
			}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       // Scanner scanner =new Scanner(System.in);
        initialize();
        ArrayList<Integer> out = new ArrayList<>();
        find_array(9999, out);
       // System.out.println("seive at 1 "+seive[1]);
    //  System.out.print(prIntegers);
      //  for(int s=0;s<prIntegers.size();s++) {
        //	System.out.print(prIntegers.get(s)+" ");
        //}
	}

}
