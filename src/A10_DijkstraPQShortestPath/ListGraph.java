package A10_DijkstraPQShortestPath;
import java.util.ArrayList;
import java.util.List;

public class ListGraph implements Graph {

	private ArrayList<WeightedEdge>[] graph; //haben Array von ArrayList
	//Anzahl der Städte fix aber nicht die Anzahl der Wege
	private int numVertices;
	private boolean directed;
	
	@SuppressWarnings("unchecked")
	public ListGraph(int numVertices, boolean directed) {
		graph = new ArrayList[numVertices];
		for (int i=0; i < numVertices; i++)
			graph[i] = new ArrayList<WeightedEdge>();
		//graph mit Städte --> ArrayList Liste mit jeweiligen Destinationen
		//von jedem Knoten gibt es eine List von Wege
		//hier List weil ich noch nicht weiß wieviel Wege es von einem Punkt es gibt
		this.numVertices = numVertices;
		this.directed = directed;
	}

	
	public int numVertices() {
		return numVertices;
	}
	
	public boolean isDirected() {
		return directed;
	}

	public boolean hasEdge(int u, int v) {
		WeightedEdge pv = findEdge(u, v);
		return pv != null;
	}

	public int getEdgeWeight(int u, int v) {
		WeightedEdge pv = findEdge(u, v);
		return pv.weight;
	}

	public void addEdge(int u, int v) {
		addEdge(u, v, 1);
	}
	
	public void addEdge(int u, int v, int weight) {
		graph[u].add(new WeightedEdge(u, v, weight));
		//z.B. u = Graz --> von Graz nach Leoben mit 45 km
		if (!directed) {
			graph[v].add(new WeightedEdge(v, u, weight));
			//nicht gerichtet, Weg auch retour --> von Leoben nach Graz
		}
	}
	
	private WeightedEdge findEdge(int u, int v) {
		for (WeightedEdge we: graph[u]) {
			if (we.to_vertex == v) {
				return we;
			}
		}
		return null;
		//schaut ob u nach v Beziehung vorhanden ist
		//alle Wege von u, iterieren durch, schauen, ob wir irgendwann nach v kommen
		//gibt es von Graz nach Leoben einen Weg
	}

	public void removeEdge(int u, int v) {
		// TODO
	}

	public List<WeightedEdge> getEdges(int v) {
		return graph[v];
	}
}
