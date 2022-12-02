package A06_Tiefensuche;

import java.util.ArrayList;
import java.util.List;

import A05_Breitensuche.BaseTree;
import A05_Breitensuche.Node;

public class Tiefensuche extends BaseTree<Film> {

	ArrayList<String> listOfNodes = new ArrayList<>();

	@Override
	/**
	 * Sortierkriterium im Baum: Länge des Films
	 */
	protected int compare(Film a, Film b) {

		return 0;
	}

	/**
	 * Retourniert die Titelliste der Film-Knoten des Teilbaums in symmetrischer Folge (engl. in-order, d.h. links-Knoten-rechts)
	 * @param node Wurzelknoten des Teilbaums
	 * @return Liste der Titel in symmetrischer Reihenfolge
	 */
	public List<String> getNodesInOrder(Node<Film> node) {
		Film start = new Film(node.getValue().getTitel(), node.getValue().getLänge());


			if (start != null) {
			;}
		listOfNodes.add(node.getValue().getTitel());
		String se = node.getValue().getTitel();

		if (node.getParent() != node) {
			node = node.getParent();
			String n = node.getValue().getTitel();		}

		if (node.getRight() != null) {
			getNodesInOrder(node.getRight());
		}


		return listOfNodes;
	}
	
	/**
	 * Retourniert Titelliste jener Filme, deren Länge zwischen min und max liegt, in Hauptreihenfolge (engl. pre-order, d.h. Knoten-links-rechts)
	 * @param min Minimale Länge des Spielfilms
	 * @param max Maximale Länge des Spielfilms
	 * @return Liste der Filmtitel in Hauptreihenfolge
	 */
	public List<String> getMinMaxPreOrder(double min, double max) {

		return null;
	}

}
