import java.util.Scanner;

public class roy_coin_boxes {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int N=scanner.nextInt();
	int M=scanner.nextInt();
	int [] start=new int[N+1];
	int [] end=new int[N+1];
	for(int i=0;i<N+1;i++) {
		start[i]=0;
		end[i]=0;
	}
	for(int i=0;i<M;i++) {
		int s=scanner.nextInt();
		int e=scanner.nextInt();
		start[s]+=1;
		end[e]+=1;
	}
	// coins in ith box array
	int [] coins=new int[N+1];
	coins[0]=0;
	for(int i=1;i<coins.length;i++) {
		coins[i]=start[i]+coins[i-1]-end[i-1];
	}
	// no of boxes with i no coins
	int [] ans=new int[M+1];
	for(int i=0;i<ans.length;i++) {
		ans[i]=0;
	}
	for(int i=0;i<coins.length;i++) {
		ans[coins[i]]++;
	}
	// no of boxes with atleast i coins
	int[] res=new int[M+1];
	res[0]=N;
	res[res.length-1]=ans[res.length-1];
	for(int i=res.length-2;i>=0;i--) {
		res[i]=ans[i]+res[i+1];
	}
	int Q = scanner.nextInt();
	for(int i=0;i<Q;i++) {
		int input=scanner.nextInt();
		if(input<res.length) {
		System.out.println(res[input]);}
		else {System.out.println(0);}
	}
	
}
}
