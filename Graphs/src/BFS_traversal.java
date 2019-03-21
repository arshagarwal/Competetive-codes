import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BFS_traversal {
	public static HashMap<Integer, ArrayList<Integer>> vertex_record=new HashMap<>();
	public static void print_BFS(int V,HashMap<Integer, Boolean> visited,Queue<Integer> queue,int t){
		ArrayList<Integer>vertices=vertex_record.get(t);
		
		if(vertices.isEmpty()){
			System.out.print(queue.remove()+" ");
			return;}
		else {
			//queue.add(t);
			System.out.print(queue.remove()+" ");
			//ArrayList<Integer>vertices=vertex_record.get(t);
			for(int i=0;i<vertices.size();i++){
				queue.add(vertices.get(i));
			}
			for(int i=0;i<=vertices.size();i++) {
			print_BFS(V, visited, queue,vertices.get(i));
			}
		}
		
	}
	public static void print_BFS2(HashMap<Integer, Boolean> visited,Queue<Integer> queue,int t) {
		queue.add(t);
		while(!queue.isEmpty()) {
			int pop =queue.remove();
			System.out.print(pop+" ");
			visited.put(pop, true);
			ArrayList<Integer> vertices=vertex_record.get(pop);
			Collections.sort(vertices);
			if(vertices==null) {}
			else {
			for(int i=0;i<vertices.size();i++) {
				if(visited.containsKey(vertices.get(i))) {
					continue;
				}
				else {
					visited.put(vertices.get(i),true);
					queue.add(vertices.get(i));
				}
				
			}}
		}
		//ArrayList<Integer> vertices=vertex_record.get(t);
		
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
        Queue<Integer> queue=new LinkedList<>();
		HashMap< Integer, Boolean> visited=new HashMap<>();
		//queue.add(0);
		print_BFS2(visited, queue, 0);
	}

}
