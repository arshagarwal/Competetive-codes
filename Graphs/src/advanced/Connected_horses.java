package advanced;

import java.awt.geom.AffineTransform;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

import advanced.Monks_islands.bridges;
import part2.prims_algo;

public class Connected_horses {
	public static int mod=(int)Math.pow(10,9)+7;
	// this function returns the size of connected components starting with the given source vertex
public static int get_connected(boolean[][] board, boolean[][] visited, int X, int Y) {
		// TODO Auto-generated method stub
	visited[X][Y]=true;
	int sub_ans1=0;
	int sub_ans2=0;
	int sub_ans3=0;
	int sub_ans4=0;
	int sub_ans5=0;
	int sub_ans6=0;
	int sub_ans7=0;
	int sub_ans8=0;
	
	// bottom two and half
	if(board[X+2][Y+1]==true) {
		if(visited[X+2][Y+1]==false) {
		sub_ans1=get_connected(board, visited, X+2, Y+1);
	}}
	if(board[X+2][Y-1]==true ) {
		if(visited[X+2][Y-1]==false) {
		sub_ans2=get_connected(board, visited, X+2, Y-1);
	}}
	// left two and half
	if(X>=2) {
	if(board[X-2][Y+1]==true) {
		if(visited[X-2][Y+1]==false ) {
		sub_ans3=get_connected(board, visited, X-2, Y+1);
	}}}
	if(X>=2) {
	if(board[X-2][Y-1]==true) {
		if(visited[X-2][Y-1]==false) {
		sub_ans4=get_connected(board, visited, X-2, Y-1);
	}}}
	// for top two and half
	if(board[X+1][Y+2]==true) {
		if(visited[X+1][Y+2]==false) {
		sub_ans5=get_connected(board, visited, X+1, Y+2);
	}}
	
	if(board[X-1][Y+2]==true) {
		if(visited[X-1][Y+2]==false) {
		sub_ans6=get_connected(board, visited, X-1, Y+2);
	}}
	// for bottom two and half
	if(Y>=2) {
	if(board[X+1][Y-2]==true){
		if(visited[X+1][Y-2]==false) {
		sub_ans7=get_connected(board, visited, X+1, Y-2);
	}}}
	if(Y>=2) {
	if (board[X-1][Y-2]==true){
		if(visited[X-1][Y-2]==false){
		sub_ans8=get_connected(board, visited, X+1, Y-2);
	}}}
	return 1+sub_ans1+sub_ans2+sub_ans3+sub_ans4+sub_ans5+sub_ans6+sub_ans7+sub_ans8;
	}
// function to get all connected components according to the question
public static ArrayList<Integer> get_all_comp(boolean[][] board){
	ArrayList<Integer> ans=new ArrayList<>();
	boolean[][] visited=new boolean[board.length][board[0].length];
	for(int i=1;i<board.length-3;i++) {
		for(int j=1;j<board[0].length-3;j++) {
			if(visited[i][j]==false && board[i][j]==true) {
			int put=get_connected(board, visited, i,j);
			if(put!=1) {
			ans.add(put);}}
		}
	}
	return ans;
}
public static long factorial(int n) {
	long ans=1;
for(int i=1;i<=n;i++){
	ans=((ans)%mod*i%mod)%mod;
}
return ans;
}
 public static long  get_ans(boolean[][] board){
	 ArrayList<Integer> a=get_all_comp(board);
	 long ans=1;
	 for(int i=0;i<a.size();i++) {
		 ans=((factorial(a.get(i)))%mod*(ans)%mod)%mod;
	 }
	 return ans;
 }
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int T=scanner.nextInt();
	for(int i=0;i<T;i++) {
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		int Q=scanner.nextInt();
		// initialized higher to avoid index out of bounds exception 
		boolean[][] board=new boolean[M+4][N+4];
		for(int j=0;j<Q;j++){
			int X=scanner.nextInt();
			int Y=scanner.nextInt();
			board[Y][X]=true;
		}
		System.out.println(get_ans(board));
		
	}
}

}