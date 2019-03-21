package backtracking;

import java.util.Arrays;

public class queen {
	public static int [][] board= new int [11][11];
	public static int x=0;
	public static boolean isPossible(int i,int j) {
		//for row check
		for(int o=0;o<board.length;o++) {
			if (board[i][o]==1) {return false;				
			}
		}
		//for column check
		for(int o=0;o<=i;o++) {
			if (board[o][j]==1) {return false;}
	}
		// for right diagonal
	for(int c=i,d=j;c>=0 && d<board.length;c-- ,d++) {
		if(board[c][d]==1) {return false;}
	}
	// for left diagonal
	for(int c=i,d=j;c>=0 && d>=0;c--,d--) {
		if(board[c][d]==1) {return false;}
	}
	return true;
	}
	public static void solve(int row,int column) {
		if(row==board.length) {
			for(int i=0;i<board.length;i++) {
				for(int t=0;t<board.length;t++) {
					System.out.print(board[i][t]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		else {int i=row;
			//for(int i=row;i<board.length;i++) {
				for(int j=0;j<board.length;j++) {
					if(isPossible(i,j)) {
						board[i][j]=1;
						solve(row+1, 0);
						board[i][j]=0;
					}
			//		else{return;}
				}
			//}
		}	
	}
	public static void placeNQueens(int n) {
board =Arrays.copyOfRange(board, 0, n);
		solve(0,0);
	}
	public static void main(String[] args) {
	placeNQueens(5);
	}

}
