package advanced;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mod =(int)Math.pow(10, 9)+7;
		int n=33;
		long ans=1;
         for(int i=1;i<=n;i++) {
        	 ans=ans*i;
         }
         System.out.println(ans%mod);
	}

}
