package backtracking;

import java.awt.geom.AffineTransform;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class rat {
	public static int[][] maze_g;
	public static ArrayList<ArrayList> moves(int i,int j){
		ArrayList<ArrayList> ans = new ArrayList<>();
			//for up
		if(i-1>=0) {
			ArrayList<Integer> s=new ArrayList<>();
			s.add(i-1);
			s.add(j);
			ans.add(s);}
		
		
		if(i+1<maze_g.length) {
			ArrayList<Integer> s=new ArrayList<>();
			s.add(i+1);
			s.add(j);
			ans.add(s);}
		if(j-1>=0) {
			ArrayList<Integer> s=new ArrayList<>();
			s.add(i);
			s.add(j-1);
			ans.add(s);}
		if(j+1<maze_g.length) {
			ArrayList<Integer> s=new ArrayList<>();
			s.add(i);
			s.add(j+1);
			ans.add(s);}
		
			return ans;
			
			
		
	}
	public static void solve(int i,int j) {
		int n= maze_g.length;
		if(i==n-1&&j==n-1) {
			//System.out.println("fuck");
			for(int q=0;q<maze_g.length;q++) {
				for(int p=0;p<maze_g.length;p++) {
					if(q==0 && p==0) {
						System.out.print(1+" ");
					}
				else if(maze_g[q][p]==9){
					System.out.print(1+" ");}
					else {
						System.out.print(0+ " ");
					}
				}
				//System.out.println();
			}
			System.out.println();
		}
		else {
			ArrayList<ArrayList>possible=moves(i, j);
			Iterator<ArrayList>it=possible.iterator();
			
			for(int c=0;c<possible.size();c++) {
				ArrayList<Integer>index = it.next();
				//System.out.println("fuck"+index.get(0)+"   "+index.get(1));
				if((maze_g[index.get(0)][index.get(1)]==1) && (index.get(0)!= 0|| index.get(1)!=0)) {
					//System.out.println("fuck"+index.get(0)+"   "+index.get(1));
					maze_g[index.get(0)][index.get(1)]=9;
					solve(index.get(0), index.get(1));
					maze_g[index.get(0)][index.get(1)]=1;
				}
			}
		}
	}
	public static void ratInAMaze(int maze[][]) {
		maze_g=maze;
		solve(0,0);
	}
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int[][] maze= new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				maze[i][j]=s.nextInt();
			}
		}
	ratInAMaze(maze);
	
	
	//System.out.println(poss.size());
	}
	

}
