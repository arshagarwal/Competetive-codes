package game_theory;

import java.util.Arrays;
import java.util.Scanner;import javax.security.auth.x500.X500Principal;

public class tic_tactoe {
	public static int evaluation_func(char[][] board) {
		// first row	
			if(board[0][0]==board[0][1]&& board[0][1]==board[0][2]) {
		          if(board[0][0]=='x') {return 10;}
		          else {return -10;}
			}
			// second row
			if(board[1][0]==board[1][1]&& board[1][1]==board[1][2]) {
		          if(board[1][0]=='x') {return 10;}
		          else if(board[1][0]=='o') {return -10;}
			}
			// third row
			if(board[2][0]==board[2][1]&& board[2][1]==board[2][2]) {
		          if(board[2][0]=='x') {return 10;}
		          else if(board[2][0]=='o')
		          {return -10;}
			}
			// first column
			if(board[0][0]==board[1][0]&& board[1][0]==board[2][0]) {
		          if(board[0][0]=='x') {return 10;}
		          else if(board[0][0]=='o')
		          {return -10;}
			}
			//second column
			if(board[0][1]==board[1][1]&& board[1][1]==board[2][1]) {
		          if(board[0][1]=='x') {return 10;}
		          else if(board[0][1]=='o')
		           {return -10;}
			}
			// third column
			if(board[0][2]==board[1][2]&& board[1][2]==board[2][2]) {
		          if(board[0][2]=='x') {return 10;}
		          else if(board[0][2]=='o') {return -10;}
			}
			// first diagonal
			if(board[0][0]==board[1][1]&& board[1][1]==board[2][2]) {
		          if(board[1][1]=='x') {return 10;}
		          else if(board[1][1]=='o') {return -10;}
			}
			// second diagonal
			if(board[0][2]==board[1][1]&& board[1][1]==board[2][0]) {
		          if(board[0][2]=='x') {return 10;}
		          else if(board[0][2]=='o') {return -10;}
			}
			return 0;
	}
	
	public static int solve(char[][]board,char type,int call_no) {
		char[][]temp_board=new char[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				temp_board[i][j]=board[i][j];
			}
		}
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]=='\0') {
					temp_board[i][j]=type;
					// variable to know if the game is over or not
					int current_winner=evaluation_func(temp_board);
					if(current_winner==10) {
						if(ans<(current_winner-call_no))
						ans= current_winner-call_no;
						// backtracking
						temp_board[i][j]='\0';
					}
					else if(current_winner==-10){
						if(ans<current_winner+call_no)
						ans= current_winner+call_no;
						// backtracking
						temp_board[i][j]='\0';
					}else {
					if(type=='x')
					solve(temp_board,'o',call_no+1);
					else {
						solve(temp_board, 'x',call_no+1);
					}}
				}
			}
		}
		if(ans==Integer.MIN_VALUE)
		return 0;
		else {return ans;}
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int count=0;
		char[][] board=new char[3][3];
		for(int i=0;i<n;i++) {
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			char v=scanner.next().charAt(0);
			board[x][y]=v;
			if(v=='x') {count++;}
		}
		if(count>n/2)
		System.out.println(solve(board,'o', 0));
		else {
			System.out.println(solve(board, 'x', 0));
		}
		
	}

}
