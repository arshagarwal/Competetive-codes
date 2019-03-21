import java.util.HashMap;

public class check {
	public static int gcd(int a,int b) {
		if(b>a) {
			return gcd(b, a);
		}
		if(b==0) { return a;}
		else if(b==1) { return 1;}
		else {  
			return gcd(b, a%b);
		}
	}
	
	public static void main(String[] args) {
	HashMap<int[], int[]> aHashMap=new HashMap<>();
	int [] key1= {1,3};
	int[] out1= {2,5};
	int[] key2= {1,3};
	aHashMap.put(key1, out1);
	prime_xor.make_seive();
	boolean[] seive=prime_xor.seive;
	System.out.println(31^8);
	}

}
