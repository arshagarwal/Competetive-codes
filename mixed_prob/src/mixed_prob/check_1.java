package mixed_prob;

public class check_1 {
	public static String copy(String word,int i,int j) {
		String ans="";
		char[] w=word.toCharArray();
			for(int m=i;m<=j;m++) {
				ans+=Character.toString(w[m]);
			}
			return ans;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
String string="iloveicecreamandmango";
string+="@";
String sub=copy(string, 0, 2);
System.out.println(sub=="ilo");
	}

}
