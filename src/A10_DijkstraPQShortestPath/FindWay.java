package A10_DijkstraPQShortestPath;


import java.util.ArrayList;
import java.util.List;

public abstract class FindWay {
	protected Graph graph;
	protected int[] pred; //VorgängerArray
	
	public FindWay(Graph graph) {
		this.graph = graph;
		this.pred = new int[graph.numVertices()]; //Vorgänger abgelegt
	}

	/**
	 * Liefert den Weg von (from) nach (to) als Liste zurück
	 * @param from Startknoten
	 * @param to Zielknoten
	 * @return Weg von Start nach Ziel oder null
	 */
	public List<Integer> findWay(int from, int to) {
		initPathSearch();
		if (!calculatePath(from, to)) {
			return null; //bei false --> keinen Weg gefunden, return null
		}
		return createWay(from, to);
	}

	/**
	 * Initialisierungsfunktion
	 */
	abstract protected void initPathSearch();

	/**
	 * Berechnungsfunktion für Weg von (from) nach (to)
	 */
	abstract protected boolean calculatePath(int from, int to);
	
	/**
	 * Weg von (to) nach (from) aus Vorgängerknoten rekonstruieren
	 * @param from Startknoten
	 * @param to Zielknoten
	 * @return Weg als Liste
	 */
	protected ArrayList<Integer> createWay(int from, int to) { //Weg von hinten nach vorne durchlaufen
		ArrayList<Integer> way = new ArrayList<Integer>(); //Weg ist im pred gespeichert
			int currentVertex = to; //Knoten wo wir starten, weiß über welchen Vorgänger erreichbar ist
			while (from != currentVertex) {
				way.add(0, currentVertex); //fügen Weg bzw. Current Knoten hinzu
				currentVertex = pred[currentVertex]; //holen uns Vorgänger


			}
			way.add(0, from); //letzter Vertex 0, deshalb manuell hinzufügen

		return way;
	}
}
