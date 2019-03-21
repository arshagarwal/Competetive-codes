import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JWindow;

public class connected_components {
	public static HashMap<Integer, ArrayList<Integer>> vertex_record=new HashMap<>();
	public static ArrayList<Integer> DFS(int V,boolean[] visited,int index,ArrayList<Integer>sub_ans){
		ArrayList<Integer> vertices=vertex_record.get(index);
		
		visited[index]=true;
		if(vertices==null) {
			sub_ans.add(index);
			return sub_ans;
		}
		else if(vertices.size()==1 && visited[vertices.get(0)]==true){
			sub_ans.add(index);
			return sub_ans;
		}
		else {ArrayList<Integer> ans=new ArrayList<>();
		ans.add(index);
			for(int i=0;i<vertices.size();i++){
				if(visited[vertices.get(i)]==true){continue;}
				ans.addAll(DFS(V, visited, vertices.get(i), sub_ans));
			}
			return ans;
		}
	}
	public static ArrayList<ArrayList<Integer>> getConnected(int V){
		 ArrayList<ArrayList<Integer>> output=new ArrayList<>();
		boolean[] visited=new boolean[V];
		for(int i=0;i<visited.length;i++){
			if(visited[i]==false) {
				ArrayList<Integer>sub_ans=new ArrayList<>();
			output.add(DFS(V, visited, i, sub_ans));
		}}
		return output;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
        for(int i=0;i<E;i++) {
        	int a=s.nextInt();
        	int b=s.nextInt();
        	if(vertex_record.containsKey(a)){
        		ArrayList<Integer> put=vertex_record.get(a);
        		put.add(b);
        		Collections.sort(put);
        		vertex_record.put(a, put);
        	}
        	else {
        		ArrayList<Integer> value=new ArrayList<>();
        		//Collections.sort(value);
        		value.add(b);
        		vertex_record.put(a, value);
        	}
        	if(vertex_record.containsKey(b)){
        		ArrayList<Integer> put=vertex_record.get(b);
        		
        		put.add(a);
        		Collections.sort(put);
        		vertex_record.put(b, put);
        	}
        	else {
        		ArrayList<Integer> value=new ArrayList<>();
        		value.add(a);
        		vertex_record.put(b, value);
        	}
        }
        ArrayList<ArrayList<Integer>> ans=getConnected(V);
        for(int i=0;i<ans.size();i++){
        	ArrayList<Integer> sub_ans=ans.get(i);
        	//Collections.sort(sub_ans);
        	for(int j=0;j<sub_ans.size();j++) {
        		System.out.print(sub_ans.get(j)+" ");
        	}
        	System.out.println();
        }
        

	}

}
