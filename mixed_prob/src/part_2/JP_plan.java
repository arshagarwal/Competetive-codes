package part_2;

import java.util.ArrayList;
import java.util.Scanner;

public class JP_plan {
	public static class coordinate{
		int x;
		int y;
	}
	// Dx and Dy denotes the current position
	public static ArrayList<coordinate> get_path(int[][] matrix,int Dx,int Dy,int Jp,ArrayList<coordinate>ans,boolean[][] visited){
		visited[Dx][Dy]=true;
		int N=matrix.length;
	    int M=matrix[0].length;
	    // when boundry condition is met
		if(Dx==0 || Dy==0){
			coordinate add=new coordinate();
			add.x=Dx;
			add.y=Dy;
			ans.add(add);
			return ans;}
		else if(Dx==(N-1) || Dy==(M-1)){
			coordinate add=new coordinate();
		add.x=Dx;
		add.y=Dy;
		ans.add(add);
		return ans;}
		// now iterating up,right,down,left if possible
		// for up
		if(Dx>=1) {
		if(matrix[Dx][Dy]-matrix[Dx-1][Dy]<=Jp && visited[Dx-1][Dy]==false) {
			coordinate add=new coordinate();
			add.x=Dx-1;
			add.y=Dy;
			ans.add(add);
			ArrayList<coordinate> check=get_path(matrix, Dx-1, Dy, Jp, ans,visited);
			if(check.size()!=0)
			return check;
		}}
		// for down
				if(Dx<N-1) {
				if(matrix[Dx][Dy]-matrix[Dx+1][Dy]<=Jp && visited[Dx+1][Dy]==false) {
					coordinate add=new coordinate();
					add.x=Dx+1;
					add.y=Dy;
					ans.add(add);
					ArrayList<coordinate> check=get_path(matrix, Dx+1, Dy, Jp, ans,visited);
					if(check.size()!=0)
					return check;
				}}
		// for right
				if(Dy<M-1) {
					if(matrix[Dx][Dy]-matrix[Dx][Dy+1]<=Jp && visited[Dx][Dy+1]==false) {
						coordinate add=new coordinate();
						add.x=Dx;
						add.y=Dy+1;
						ans.add(add);
						ArrayList<coordinate> check=get_path(matrix, Dx, Dy+1, Jp, ans,visited);
						if(check.size()!=0)
						return check;
					}}
				// for left
				if(Dy>0) {
					if(matrix[Dx][Dy]-matrix[Dx][Dy-1]<=Jp && visited[Dx][Dy-1]==false) {
						coordinate add=new coordinate();
						add.x=Dx;
						add.y=Dy-1;
						ans.add(add);
						ArrayList<coordinate> check=get_path(matrix, Dx, Dy-1, Jp, ans,visited);
						if(check.size()!=0)
						return check;
						
					}}	
				// empty list 
				ArrayList<coordinate> output=new ArrayList<>();
				//ans=new ArrayList<>();
				visited[Dx][Dy]=false;
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		int[][] matrix=new int[N][M];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				matrix[i][j]=scanner.nextInt();
			}
		}
		int Dx=scanner.nextInt();
		int Dy=scanner.nextInt();
		int Jp=scanner.nextInt();
		// visited matrix
		boolean[][] visited =new boolean[N][M];
		ArrayList<coordinate> ans=new ArrayList<>();
		ans=get_path(matrix, Dx-1, Dy-1, Jp, ans,visited);
         if(ans!=null) {
        	 System.out.println("Yes");
        	 System.out.println(ans.size());
        	 System.out.println(Dx+" "+ Dy);
        	 for(int i=0;i<ans.size()-1;i++) {
        		 coordinate c=ans.get(i);
        		 System.out.println((c.x+1)+" "+(c.y+1));
        	 }}
        	 else {
				System.out.println("no");
			}
         
	}

}
