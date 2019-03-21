package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Frog_in_a_maze {
	public static boolean[][] create_copy(boolean[][] array){
		boolean[][] ans=new boolean[array.length][array[0].length];
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				ans[i][j]=array[i][j];
			}
		}
		return ans;
		
	}
	public static ArrayList<coordinate> find_possible_moves(coordinate curr_pos,String[][] maze,boolean [][] visited){
		ArrayList<coordinate> possible_moves=new ArrayList<>();
		int x=curr_pos.x;
		int y=curr_pos.y;
		//int x_prev=previous.x;
		//int y_prev=previous.y;
		// adding cell to the top
		if(x!=0) {
			if(visited[x-1][y]==false || maze[x-1][y]=="#") {
			coordinate add=new coordinate(x-1, y);
			possible_moves.add(add);}
		}
		// adding cell to the bottom
		if(x!=(maze.length-1)){
			if(visited[x+1][y]==false || maze[x+1][y]=="#") {
			coordinate add=new coordinate(x+1, y);
			possible_moves.add(add);}
		}
		// adding cell to the left
		if(y!=0) {
			if(visited[x][y-1]==false || maze[x][y-1]=="#") {
			coordinate add=new coordinate(x, y-1);
			possible_moves.add(add);}
		}
		// adding cell to the right
		if(y!=maze[0].length-1) {
			if(visited[x][y+1]==false || maze[x][y+1]=="#") {
			coordinate add=new coordinate(x, y+1);
			possible_moves.add(add);}
		}
		return possible_moves;
	}
	
	public static int[][] dp;
	public static boolean[][] visited;
	public static class coordinate {
		int x;
		int y;
		public coordinate(int i,int j) {
			x=i;
			y=j;
		}
	}
	// this function returns the probabilty of finishing the maze given that the frog stands at curr_position
	public static double solve(coordinate curr_pos,String[][]maze,HashMap<coordinate, coordinate> tunnel,boolean[][] visited){
		visited[curr_pos.x][curr_pos.y]=true;
		// base case #0(if the cell is coonected to another via tunnel)
		if(tunnel.containsKey(curr_pos)) {
			curr_pos=tunnel.get(curr_pos);
		}
		// base case #1(Obstacle)
		if(maze[curr_pos.x][curr_pos.y].equals("#")) {
			return 0;
		}
		// base case #2 (mine)
		else if(maze[curr_pos.x][curr_pos.y].equals("*")) {
			return 0;
		}
		//base case #3(exit)
		else if(maze[curr_pos.x][curr_pos.y].equals("%")) {
			return 1;
		}
		double probability=0;
		// variable that contains the possible moves
		ArrayList<coordinate> possible_moves=find_possible_moves(curr_pos, maze,visited);
		int adj_cells=possible_moves.size();
		for(int i=0;i<possible_moves.size();i++) {
			// adjacent cell
			coordinate cell=possible_moves.get(i);
			boolean[][] visited2=create_copy(visited);
				probability+=solve(cell, maze,tunnel,visited2)*(1.0/adj_cells);
				visited2=null;
				
			
		}
		return probability;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		int k=scanner.nextInt();
		coordinate curr_pos=new coordinate(0,0);
	    String [][] maze=new String[n][m];

	    dp=new int[n][m];
	    visited=new boolean[n][m];
	    for(int i=0;i<n;i++) {
	    	String row=scanner.next();
	    	for(int j=0;j<m;j++) {
	    		maze[i][j]=Character.toString(row.charAt(j));
	    		if(maze[i][j].equals("A")){
	    			visited[i][j]=true;
	    			curr_pos=new coordinate(i, j);
	    		}
	    		
	    	}
	    }
	    HashMap<coordinate, coordinate> tunnel=new HashMap<>();
	    for(int i=0;i<k;i++) {
	    	int i1=scanner.nextInt();
	    	int j1=scanner.nextInt();
	    	int i2=scanner.nextInt();
	    	int j2=scanner.nextInt();
	    	coordinate c1=new coordinate(i1, j1);
	    	coordinate c2=new coordinate(i2, j2);
	    	tunnel.put(c1, c2);
	    	tunnel.put(c2, c1);
	    }
	   // coordinate initial=new coordinate(-1, -1);
        System.out.print(solve(curr_pos, maze, tunnel,visited));
	}

}
;