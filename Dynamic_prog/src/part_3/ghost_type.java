package part_3;

import java.util.Scanner;

public class ghost_type {
	public static long solve2(long N) {
	long [] dp=new long[(int) Math.pow(2, N)];
	dp[dp.length-1]=1;
	for(int i=dp.length-2;i>=0;i--){
		// dp loop
		for(long m=0;m<N;m++){
			// loop to find 0s in the no
			if((i&(1<<N-1-m))==0){
				// condition check
				long indicator=0;
				long k=m+1;					
				for(k=m+1;k<N;k++){
					// loop to satisfy condn
					if(((m+1)&(k+1))==m+1 && (i&(1<<N-1-k))!=0) {
						indicator=1;
						break;}
					//dp[i]+=dp[(i|(1<<N-1-k))];
				}
				if(indicator==0) {
					dp[i]+=dp[(i|(1<<N-1-m))];
				}
			}
		}
	}
	return dp[0];
	
	}
	public static long solve(long[] pre_compu,long N){
    long [] dp =new long[(long)Math.pow(2, N)];
    dp[dp.length-1]=1;
    for(long i=dp.length-2;i>=0;i--){
    	long mask=i;
    	long counter=0;
    	// no of 1s in the mask
    	long b=0;
    	while(counter!=N){
    		long last_bit=mask&1;
    		if(last_bit==1){
    			b++;
    		}
    		counter++;
    		mask=mask/2;
    	}
    	// to satisfy condition
    	long check=pre_compu[b+1];
    	long no=0;
    	long temp=i;
    	for(long m=0;m<N;m++) {
        if((i&(1<<N-1-m))!=0){
        	no++;
        }
        if(no>=check){
        	if((i&(1<<N-1-m))==0){
        		dp[i]+=dp[i|(1<<N-1-m)];
        
        }}
       // temp=temp/2;
    	}
    }
    for(long i=0;i<dp.length;i++) {
    	System.out.print(dp[i]+" ");
    }
    return dp[0];
    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		long n=scanner.nextInt();
		// this array contains the no of numbers smaller than the index that satisfy the condn
	//	l[] pre_compu=new int[n+1];
		
		System.out.println(solve2(n));
		

	}

}
