package A10_DijkstraPQShortestPath;

import java.util.HashMap;
import java.util.List;

public class DijkstraPQShortestPath extends FindWay {
	private int[] dist;
	//legen Distanzen ab
	private HashMap<Integer, String> vertexCountry;

	public DijkstraPQShortestPath(Graph graph, HashMap<Integer, String> vertexCountry) {
		super(graph);
		this.vertexCountry = vertexCountry;
	}

	/**
	 * Startentfernung initialisieren
	 * 
	 * @param from
	 *            Startknoten
	 */
	protected void initPathSearch() {
		//erste Schritt: Distanzarray anlegen
		int numv = graph.numVertices();
		dist = new int[numv];
		for (int i = 0; i < numv; i++) {
			dist[i] = 9999; // Summen im Graph dürfen nie mehr ergeben
		//mit unendlich initieren z.B. Integer.Max_Value
		}
	}

	/**
	 * Berechnet *alle* kürzesten Wege ausgehend vom Startknoten Setzt dist[]-
	 * und pred[]-Arrays, kein Rückgabewert
	 * 
	 * @param from
	 *            Startknoten
	 */
	protected boolean calculatePath(int from, int to) { //könnte sein, dass wir Weg nicht finden --> boolean
		//1. Schritt: Distanz vom from-Knoten ist 0 --> eigene Distanz ist 0
		dist[from] = 0;
		//2. Schritt Heap aufbauen
		VertexHeap vertexHeap = new VertexHeap(graph.numVertices());
		for(int i = 0; i < graph.numVertices(); i++) {
			//Knoten für Knoten in Heap in beliebiger Reihenfolge reinspeichern
			vertexHeap.insert(new Vertex(i, dist[i]));
			//erster Knoten mit 0 ist ganz oben, alle anderen Knotenpunkte mit 9999 darunter
		}
		while ((!vertexHeap.isEmpty())) {
			int currentVertex = vertexHeap.remove().vertex; //liefert mit Ausgangspunkt 0 --> habe obersten Knoten heruntergenommen
			List<WeightedEdge> edgesFromCurrent = graph.getEdges(currentVertex); //gib mir die Kanten von 0 weg --> liefert Knoten 4 und 5
			for (WeightedEdge we : edgesFromCurrent) {//List durchiteriene, schauen uns alle Kanten genau an
				int newCosts = dist[currentVertex] + we.weight; //müssen Kosten berechnen
				int nextVertext = we.to_vertex; //wo geht Reise hin

				if (!vertexCountry.get(currentVertex).equals(vertexCountry.get(nextVertext))) {
					newCosts += 2;
				}
				if (newCosts < dist[nextVertext]) { //gibt es einen besseren Weg dorthin
					dist[nextVertext] = newCosts; //am Beginn ist natürlich besser als unendlich --> neue Wegkosten festlegen
					pred[nextVertext] = currentVertex; //neuen besseren Weg nach Leibnitz gefunden
					vertexHeap.setCost(nextVertext, newCosts); //Reichung nach vorne, überschreiben die 9999 mit neuen Wegkosten
				}
			}
		}
		if (dist[to] == 9999) { //wird Knoten nicht gefunden, steht noch 9999 drinnen
			return false;
		}

			return true;
	}
	//würden nur mit Array arbeiten, wäre fix --> bekommen nächsten Knotenpunkte zum Bearbeiten nicht vorher hin
}
