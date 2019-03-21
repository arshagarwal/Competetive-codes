import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class get_path {
	public static HashMap<Integer, ArrayList<Integer>> vertex_record=new HashMap<>();
	public static ArrayList<Integer> get_pathDFS(boolean[] visited,int v1,int v2,ArrayList<Integer> sub_ans){
		ArrayList<Integer> vertices=vertex_record.get(v1);
		visited[v1]=true;
		if(vertices==null){
			ArrayList<Integer>ans=new ArrayList<>();
			return ans;
		}
		if(vertices.size()==1 && visited[vertices.get(0)]==true) {
			return null;
		}
		if(v1==v2 || vertices.contains(v2)){
			visited[v2]=true;
			if(sub_ans!=null) {
			sub_ans.add(v2);
			sub_ans.add(v1);
			return sub_ans;
			}
			else {
			 ArrayList<Integer> temp=new ArrayList<>();
			 temp.add(v2);
			 temp.add(v1);
			 return temp;
			}
			
			
		}
		else {
			for(int i=0;i<vertices.size();i++){
				if(visited[vertices.get(i)]) {
					continue;
				}
				visited[vertices.get(i)]=true;
				ArrayList<Integer> temp=get_pathDFS(visited, vertices.get(i), v2,sub_ans);
				if(temp!=null) {
					sub_ans=temp;
					sub_ans.add(v1);
					return sub_ans;
				}
				
			}
			return null;
			
		}
	}
	public static void main(String[] args) {
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
		boolean[] visited =new boolean[V];
		ArrayList<Integer> sub_ans=null;
		ArrayList<Integer> ans=get_pathDFS(visited, v1, v2, sub_ans);
		if(ans==null){}
		else {
		for(int t=0;t<ans.size();t++){
		System.out.print(ans.get(t)+" ");}
		}}

	}


