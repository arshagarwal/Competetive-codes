package segment_Tree;

public class check {
	public static int  conv_binary(String s){
		int i=0;
		int ans=0;
		while(i!=s.length()){
			if(s.charAt(i)=='1'){
				ans+=(int)Math.pow(2,s.length()-i-1);
				
			}
			i++;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[10];
		a[0]+=10;
		System.out.print(a[0]);
      // System.out.println(Integer.MIN_VALUE);
	}

}
