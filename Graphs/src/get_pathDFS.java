import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// code for shortest distance bw two vertices of the graph
public class get_pathDFS {
	public static HashMap<Integer, ArrayList<Integer>> vertex_record=new HashMap<>();
public static ArrayList<Integer> get_pathBFS(int V,int v1,int v2){
	
	ArrayList<Integer> ans=new ArrayList<>();
	Queue<Integer> queue=new LinkedList<>();
	queue.add(v1);
	// key-child,value-parent
	HashMap<Integer, Integer> record=new HashMap<>();
	boolean[] visited=new boolean[V];
	while(!queue.isEmpty()){
		int pop=queue.remove();
		
	//	ans.add(pop);
		if(pop==v2){break;}
		if(visited[pop]==true){
			continue;
		}
		visited[pop]=true;
		ArrayList<Integer> vertices =vertex_record.get(pop);
		int indicator=0;
		if(vertices==null) {
			return null;
		}
		for(int i=0;i<vertices.size();i++){
			if(visited[vertices.get(i)]){
				continue;
			}
			record.put(vertices.get(i), pop);
			queue.add(vertices.get(i));
			if(vertices.get(i)==v2){indicator=1;
			break;
			}
		}
		if(indicator==1) {
			break;
		}
		
	}
	if(record.get(v2)==null) {return null;}
	int parent=record.get(v2);
	ans.add(v2);
	while(parent!=-1) {
		ans.add(parent);
		if(record.containsKey(parent)){
		parent=record.get(parent);
		}
		else{
			parent=-1;
		}
	}
	return ans;
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
       ArrayList<Integer>ans=(get_pathBFS(V, v1, v2));
       if(ans!=null) {
    	   System.out.println(ans);
       }

	}

}
