import org.omg.CORBA.PUBLIC_MEMBER;

public class binary_tree {
	public static int balancedTreesOfHeightH(int height) {
		if(height==1) {
			return 1%((int)Math.pow(10,9) + 7);
		}
		if(height==2) {
			return (3)%((int)Math.pow(10,9) + 7);
		}
		else {int m=((int)Math.pow(10,9) + 7);
			int h1=balancedTreesOfHeightH(height-1);
			int h2=balancedTreesOfHeightH(height-2);
			long a1= (long)h1*h2;
			long a2=(long)h1*h2;
			long a3=(long)h1*h1;
			int ans1=(int)(a1%m);
			int ans2=(int)(a2%m);
			int ans3=(int)(a3%m);
			int ans = (int)(ans1 +ans2 +ans3);
			//System.out.println("a1="+a1);
			//System.out.println("a2="+a2);
			System.out.println("a3="+ a3);
			return (ans)%((int)Math.pow(10,9) + 7);
		}
	}
public static void main(String[] args) {
	//System.out.println(balancedTreesOfHeightH(4));
	//System.out.println(balancedTreesOfHeightH(5));
	System.out.println(balancedTreesOfHeightH(6));
}
}
