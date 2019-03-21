import java.util.Scanner;

public class magic_grid {
	public static int solve(int[][] min_power) {
		// no of rows
		int r=min_power.length;
		//no of columns
		int c=min_power[0].length;
		int[][] input=new int[r][c];
		if(min_power[r-1][c-1]>=0){
		input[r-1][c-1]=0;
		}
		else {
			input[r-1][c-1]=min_power[r-1][c-1];
		}
		// filling last column
		for(int i=r-2;i>=0;i--) {
			if(input[i+1][c-1]+min_power[i][c-1]>=0) {
				input[i][c-1]=0;
			}
			else {
		input[i][c-1]=input[i+1][c-1]+min_power[i][c-1];
	}}
		// filling last row
		for(int i=c-2;i>=0;i--) {
			if(input[r-1][i+1]+min_power[r-1][i]>=0) {
				input[r-1][i]=0;
			}
			else {
			input[r-1][i]=input[r-1][i+1]+min_power[r-1][i];}
		}
		// filling remaining
		for(int i=r-2;i>=0;i--) {
			for(int j=c-2;j>=0;j--) {
				int max=Math.max(input[i+1][j], input[i][j+1]);
				if(max+min_power[i][j]>=0) {
					input[i][j]=0;
				}
				else {
					input[i][j]=min_power[i][j]+max;
				}
			}
		}
		
		return Math.abs(input[0][0]) +1;
	}

	public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;i++) {
        	int R=scanner.nextInt();
        	int C=scanner.nextInt();
        	int[][] input=new int[R][C];
        	for(int r=0;r<R;r++) {
        		for(int c=0;c<C;c++) {
        			input[r][c]=scanner.nextInt();
        		}
        		
        	}
        	System.out.println(solve(input));
        }
	}

}
