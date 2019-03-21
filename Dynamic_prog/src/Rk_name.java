import java.net.Inet4Address;
import java.util.Scanner;

import javax.xml.bind.SchemaOutputResolver;

public class Rk_name {
	public static int solve(String a) {
		if(a.equals("R")) {
			return 0;
		}
		int max=0;
		int current_max=0;
		int count=0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)=='R') {
				current_max+=-1;
				count++;
			}
			else {
				if(current_max<0) {
					current_max=1;
				}
				else {
					current_max+=1;
				}
			}
			if(max<current_max) {
				max=current_max;
			}
		}
		if(count==a.length()) {
			return count-1;
		}
		return count + max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++) {
        	String input=s.next();
        	System.out.println(solve(input));
        }
	}

}
