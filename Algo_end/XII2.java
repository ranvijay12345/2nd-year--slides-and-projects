import java.util.*;
import java.io.*;
public class XII2 {
	public static void main(String... args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("graph.txt"));
		int n_V = s.nextInt(); // number of vertices
		int n_E = s.nextInt(); // number of edges
		int s_i = s.nextInt(); // source index (staring index 0)
		//construct the graph
		Vertex[] graph = new Vertex[n_V];
		for (int i = 0; i < n_V; i++) { // adding vertices
			graph[i] = new Vertex(s.next());
		}
		for (int i = 0; i < n_E; i++) { // adding edges
			int u = s.nextInt();
			int v = s.nextInt();
			double w = s.nextDouble();
			graph[u].adjacents.add(graph[v]);
			graph[u].weights.add(w);
		} 
		// graph construction complete 
		ArrayList<Vertex> sortedGraph = new ArrayList<>();
		for (Vertex u: graph) {
			if (!u.visited)
				topologicalSort(u, sortedGraph); // topologically sort the graph
		}
		graph[s_i].d = 0.0; // initialize single source
		for (Vertex u: sortedGraph) { // for each vertex u taken in topologically sorted order 
			for (int i = 0; i < u.adjacents.size(); i++) { //for each vertex v adjacent to u
				Vertex v = (Vertex) u.adjacents.get(i);
				if (v.d > u.d + (Double) u.weights.get(i)) { // relax (u, v)
					v.d = u.d + (Double) u.weights.get(i);
					v.π = u;
				}
			}
		}
		for (Vertex u: sortedGraph) {
			System.out.print(graph[s_i].nodeId + " => " + u.nodeId + " :: " );
			System.out.print(u.d + ": " + ((Double.isInfinite(u.d)) ? "" : graph[s_i].nodeId));
			printPath(graph[s_i], u);
			System.out.println();
		}
	}
	
	public static void printPath(Vertex start, Vertex end){
		if (start == end) {
			return;
		} else if (end.π == null) {
			System.out.print("There is no path from " + start.nodeId + " to " + end.nodeId + ".");
		} else {
			printPath(start, end.π);
			System.out.print(" -> " + end.nodeId);
		}
	}
	
	public static void topologicalSort(Vertex u, ArrayList<Vertex> sortedGraph) {  
		u.visited = true;  // mark u as visited 
		for (Vertex v: u.adjacents) {  // for each vertex v that are adjacent to u
			if (!v.visited) {  // if v is not visited
				topologicalSort(v, sortedGraph);  // recursively call itself making v that starting vertex
			}
		}
		sortedGraph.add(0, u); // add u in the sortedGraph
	}
}

class Vertex {
	String nodeId = null;
	ArrayList<Vertex> adjacents = new ArrayList<>();
	ArrayList<Double> weights = new ArrayList<>();
	boolean visited = false;
	double d = Double.POSITIVE_INFINITY; 
	Vertex π = null;
	Vertex(String nodeId) {
		this.nodeId = nodeId;
	}
}