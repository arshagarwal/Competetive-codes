import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class isConnected {
	public static HashMap<Integer, ArrayList<Integer>> vertex_record=new HashMap<>();
	public static boolean checkCoonectedBFS(int V){
		Queue<Integer> queue=new LinkedList<>();
		queue.add(0);
		boolean[] visited=new boolean[V];
		while(queue.isEmpty()==false){
			
			int pop=queue.remove();
			if(visited[pop]==true){
				continue;
			}
			visited[pop]=true;
			ArrayList<Integer> vertices=vertex_record.get(pop);
			for(int i=0;i<vertices.size();i++){
				queue.add(vertices.get(i));
			}
		}
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==false) {
				return false;
			}
		}
		return true;
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
        System.out.print(checkCoonectedBFS(V));

	}

}
