import java.util.HashMap;
import java.util.Scanner;

public class cube_freee2 {
public static HashMap<Integer, Integer> record = new HashMap<>();

public static boolean[] seive;
public static boolean checkprime(int n) {
	int c=(int)Math.pow(n, 0.5);
	for(int i=2;i<=c;i++) {
		if(n%i==0) {
		//	System.out.print(i);
			seive[n]=false;
			return false;
		}
	}
	return true;
}public static void make_seive(int input){
	seive=new boolean[input+1];
	//	ArrayList<Integer> power=new ArrayList<>();
		for(int i=2;i<seive.length;i++) {
			seive[i]=true;
		}
		int n =(int)Math.pow(input, 0.5);
		for(int t=2;t<=n;t++) {
			if(seive[t]==true && checkprime(t)==true) {
				for(int k=t;k<=input;k++) {
					if(t*k<=input) {
						seive[t*k]=false;
					}
					else {break;}
				}
			}
		}}
public static int getPower(int N,int t,int ans) {
	if(ans==3) {
		return 3;
	}
       if(N%t!=0) {
    	   return ans+0;
       }
       else {
    	   ans++;
    	   return getPower(N/t, t, ans);
       }
}
public static boolean cubic_check(int n) {
	//make_seive(n);
	int cube_root=(int)(Math.pow(n,(double)1/3));
	for(int i=2;i<=cube_root;i++) {
		if(seive[i]==true ) {
			if(getPower(n, i,0)>=3) {
			return true;}
		}
		else if(seive[i]==false) {
			continue;
		}
		else {
			
		}
		
	}
	return false;
}
public static void make_dictionary() {
	int k=0;
	for(int i=1;i<=Math.pow(10, 6);i++) {
		if(cubic_check(i)) {
			record.put(i,0 );
			k++;
		}
		else {
			record.put(i,i-k);
		}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		make_seive((int)Math.pow(10, 6));
		make_dictionary();
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		for(int i=0;i<n;i++) {
			int t=record.get(s.nextInt());
		//	System.out.println(t);
			if(t!=0) {
				System.out.println("Case "+(i+1)+": "+t);
			}
			else {
				System.out.println("Case "+(i+1)+": Not Cube Free");
			}}
	//	System.out.println(record.get(34)+"fuck");
		

	}

}
