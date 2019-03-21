package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class possible {
	static int[][] board = new int[9][9];
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
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<9;i++) {
			for(int t=0;t<9;t++) {
				board[i][t]=scanner.nextInt();
						}}
	System.out.print(possible(8, 1));	
	
	}
	}


