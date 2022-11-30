package A10_DijkstraPQShortestPath;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//wie viele Knoten = numVertices und directed gerichtet oder ungerichtet
		//Graphen mit Edge verbinden (Von- und Zielknoten)
		Graph g = new ListGraph(8, false);
		g.addEdge(0, 4,  3);
		g.addEdge(0, 5,  4);
		g.addEdge(1, 3,  1);
		g.addEdge(1, 4,  6);
		g.addEdge(1, 6,  2);
		g.addEdge(2, 3,  3);
		g.addEdge(2, 4,  4);
		g.addEdge(2, 7,  4);
		g.addEdge(3, 6,  2);
		g.addEdge(3, 7,  1);
		g.addEdge(5, 6,  3);
		//von 5 auf 6 mit Gewicht von 3

		HashMap<Integer, String> vertexCountry = new HashMap<>(); //je Knotenpunkt festlegen, wo ist Knoten
		vertexCountry.put(0, "AT");
		vertexCountry.put(1, "AT");
		vertexCountry.put(2, "AT");
		vertexCountry.put(3, "AT");
		vertexCountry.put(4, "AT");
		vertexCountry.put(5, "DE");
		vertexCountry.put(6, "AT");
		vertexCountry.put(7, "AT");

		DijkstraPQShortestPath dfs = new DijkstraPQShortestPath(g, vertexCountry);
		List<Integer> way = dfs.findWay(0, 7); //finden des kürzesten Weg von 0 auf 7
		printWay(way);

	}
	
	public static void printWay(List<Integer> way) { //Weg wie wir von 0 auf 7 kommen
		if (way == null) {
			System.out.println("Kein Weg gefunden.");
			return;
		}
		for (int i=0; i < way.size(); i++) {
			if (i != 0)
				System.out.print(" -> ");
			System.out.print(way.get(i));
		}
	}
}
