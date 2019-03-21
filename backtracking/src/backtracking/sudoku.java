package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class sudoku {
	static int[][] board = new int[9][9];
	// function to calculate possible spaces
	public static ArrayList<Integer> possible(int i,int j){
		ArrayList<Integer> oc=new ArrayList<>();
		ArrayList<Integer> av=new ArrayList<>();
		//for row check
		for(int t=0;t<9;t++) {
			if(board[i][t]!=0) {
				oc.add(board[i][t]);
			}
		}
		// for column check
		for(int t=0;t<9;t++) {
			if(board[t][j]!=0) {
				oc.add(board[t][j]);
			}
		}
		//for 1st box
		if(i<3 &&j<3) {
			for(int p=0;p<3;p++) {
				for(int q=0;q<3;q++) {
					if(board[p][q]!=0) {
						oc.add(board[p][q]);
					}
				}}}
			//for 2nd box
			if(i>=3 && i<6 &&j>=0 && j<3) {
				for(int p=3;p<6;p++) {
					for(int q=0;q<3;q++) {
						if(board[p][q]!=0) {
							oc.add(board[p][q]);
						}
					}}}
				//for third box
				if(i>=6 && i<9 &&j>=0 && j<3) {
					for(int p=6;p<9;p++) {
						for(int q=0;q<3;q++) {
							if(board[p][q]!=0) {
								oc.add(board[p][q]);
							}
						}}}
		// for fourth box
					if(i>=0 && i<3 &&j>=3 && j<6) {
						for(int p=0;p<3;p++) {
							for(int q=3;q<6;q++) {
								if(board[p][q]!=0) {
									oc.add(board[p][q]);
								}
							}}}
		//for fifth box				
		if(i>=3 && i<6 &&j>=3 && j<6) {
		for(int p=3;p<6;p++) {
		for(int q=3;q<6;q++) {
		if(board[p][q]!=0) {
		oc.add(board[p][q]);
						}
				}}	}
		// for sixth box
		if(i>=6 && i<9 &&j>=3 && j<6) {
			for(int p=6;p<9;p++) {
			for(int q=3;q<6;q++) {
			if(board[p][q]!=0) {
			oc.add(board[p][q]);
							}
					}}	}
		//for seventh box
			if(i>=0 && i<3 &&j>=6 && j<9) {
				for(int p=0;p<3;p++) {
				for(int q=6;q<9;q++) {
				if(board[p][q]!=0) {
				oc.add(board[p][q]);
								}
						}}}
		// for eighth box
				if(i>=3 && i<6 &&j>=6 && j<9) {
					for(int p=3;p<6;p++) {
					for(int q=6;q<9;q++) {
					if(board[p][q]!=0) {
					oc.add(board[p][q]);
									}
							}}}
		//for 9th box
					if(i>=6 && i<9 &&j>=6 && j<9) {
						for(int p=6;p<9;p++) {
						for(int q=6;q<9;q++) {
						if(board[p][q]!=0) {
						oc.add(board[p][q]);
										}
								}}}			
		// making available spaces			
			for(int c=1;c<=9;c++) {
				if(oc.contains(c)){
					continue;}
				else {
					av.add(c);
					}
				}
			if(av.isEmpty()) {av.add(100);}
			return av;}
	public static void printSudoku() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean solve(int i,int j) {
		if(i==8 && j==8 && possible(i, j).get(0)!=100 || i==8 && j==8 && board[i][j]!=0 ) {
			printSudoku();
			return true;
		}
		else if(i==8 && j==8 && possible(i, j).get(0)==100) {
			//System.out.print(i+"  "+j);
			return false;
		}
		else {
			if (board[i][j]!=0) {
			if(i<8 && j<8) {
				j++;
				return solve(i, j);
			//	board[i][--j]=0;
			}
			else if(j==8 && i!=8 ) {
				int v=j;
				j=0;
				//System.out.print(i+"  "+j);
			//	System.out.print("fuck");
				return solve(++i, j);
		//		board[i][v]=0;
			}
			else {j++;
			return solve(i, j);
			//System.out.print(i+"  "+j);
	//		board[--i][j]=0;
			}
		}
			ArrayList<Integer> poss=possible(i,j);
	//		if (poss.get(0)==100) {
		//		return false;
			//}
			for(int y=0;y<poss.size();y++) {
			 if( board[i][j]==0 && poss.get(0)!=100) {
			//	System.out.println(poss);
				//System.out.println(i+"  "+j);
			
				board[i][j]=poss.get(y);
				//append(i, j);
				if(i<8 && j<8) {
					j++;
					if(solve(i, j)==false) {
						board[i][--j]=0;
						continue;}
					return solve(i, j);
			//		board[i][--j]=0;
				}
				else if(j==8 && i!=8 ) {
					int v=j;
					j=0;
			//	System.out.print(i+"  "+j);
				if( solve(i+1, j)==false) {
					j=8;
					board[i][j]=0;
					continue;}
				return	solve(++i, j);
				//	board[--i][v]=0;
					
				}
				else {j++;
		//		System.out.print(i+"   "+j);
				if(solve(i, j)==false) {
					j--;
					board[i][j]=0;
					continue;}
				return solve(i, j);
				//board[i][--j]=0;
				}
			}
			 }
		
			//System.out.println(i+"   "+j);
			//printSudoku();
				return false;
			
		}
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<9;i++) {
			for(int t=0;t<9;t++) {
				board[i][t]=scanner.nextInt();
						}
		
		}
	System.out.println((solve(0, 0)));
		//System.out.print("fuck");
	}
	

}
