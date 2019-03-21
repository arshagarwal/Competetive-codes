import java.util.HashMap;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class alpha_code {
	public static int mod=(int)Math.pow(10, 9)+7;
	public static HashMap<String, Integer> ans_record=new HashMap<>();
public static int noOfCodes(String n,int ans) {
	if(n.equals("@")) {
		return 1;
	}
	else {
		if(ans_record.containsKey(n)) {
			return ans_record.get(n)%mod;
		}
		else {
			if(n.substring(0,1).equals("0")) {
				return 0;
			}
			ans=((ans)%mod+(noOfCodes(n.substring(1), ans))%mod)%mod;
			if(n.length()>2) {
				if(Integer.parseInt(n.substring(0,2))==0) {
					return 0;
				}
			if(Integer.parseInt(n.substring(0,2))<=26) {
				ans=((ans)%mod+(noOfCodes(n.substring(2), ans))%mod)%mod;
			}}
			ans_record.put(n, ans);
			return ans;
		}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        while(s.hasNext()) {
        	String input=s.next();
        	if(!input.equals("0")) {
        		//System.out.println("input = "+input);
        	System.out.println(noOfCodes(input+"@", 0));
        	ans_record.clear();
        }}
	}

}
