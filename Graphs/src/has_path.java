import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class has_path {
	public static HashMap<Integer, ArrayList<Integer>> vertex_record=new HashMap<>();
	// here i denotes the current element 
	public static boolean check_path_DFS(boolean[] visited,int v1,int v2,int i){
		ArrayList<Integer> vertices=vertex_record.get(i);
		visited[i]=true;
		if(vertices==null) {return false;}
		if(vertices.size()==1 && visited[vertices.get(0)]==true){
		return false;
		}
		else if(vertices.contains(v2) || v1==v2){
			return true;
		}
		else{
			
			for(int j=0;j<vertices.size();j++){
				if(visited[vertices.get(j)]==true) {
					continue;
				}
				boolean sub_ans=check_path_DFS(visited, vertices.get(j), v2,vertices.get(j));
				if(sub_ans==true) {
					return true;
				}
			}
			return false;
		}
		//return 
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
	        		vertex_record.put(a, put);
	        	}
	        	else {
	        		ArrayList<Integer> value=new ArrayList<>();
	        		value.add(b);
	        		vertex_record.put(a, value);
	        	}
	        	if(vertex_record.containsKey(b)){
	        		ArrayList<Integer> put=vertex_record.get(b);
	        		put.add(a);
	        		vertex_record.put(b, put);
	        	}
	        	else {
	        		ArrayList<Integer> value=new ArrayList<>();
	        		value.add(a);
	        		vertex_record.put(b, value);
	        	}
	        }
		int v1=s.nextInt();
		int v2=s.nextInt();
		boolean[] visited=new boolean[V];
		System.out.println(check_path_DFS(visited, v1, v2, v1));
		

	}

}
