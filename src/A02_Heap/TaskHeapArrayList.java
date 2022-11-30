package A02_Heap;

import java.util.ArrayList;public class TaskHeapArrayList {

	/**
	 * Internes Task-Array für den Heap
	 * Ansonsten keine anderen Variablen verwenden!
	 */
	private ArrayList<Task> tasks;

	/**
	 * Konstruktor
	 */
	public TaskHeapArrayList() {
		this.tasks = new ArrayList<>();
		this.tasks.add(null); //Damit Index bei 1 anfängt
	}

	/**
	 * Neuen Task in den Heap einfügen
	 *
	 * @param t Einzufügender Task
	 */
	public void insert(Task t) {
		// TODO: Your implementation
		tasks.add(t);
		swim(tasks.size()-1);


	}

	/**
	 * Das oberste Element (mit kleinster Priorität entfernen)
	 *
	 * @return Task mit kleinster Priorität
	 */
	public Task remove() {
		// TODO: Your implementation
		if (tasks.size() <= 1)
		return null;
		Task result = tasks.get(1); //hole mir oberstes Element
		tasks.set(1, tasks.get(tasks.size() -1)); //Überschreiben oberste Element mit dem letzten
		tasks.remove(tasks.size() -1); //Löschen letztes Element raus

		sink(1); //lassen oberste hinuntersinken
		return result;
	}

	private void swim(int pos) {
		// let the first swim if > test if it hasChildren;
		while (pos > 1) { //solange irgendwo drinnen sind
			if (prio(parent(pos)) < prio(pos))   //     2     5 //Parent kleiner als aktiver
				break;
			exchange(parent(pos), pos); // change to positions   //  1    2
			pos = parent(pos); // set new pos;
		}
	}

	private void sink(int pos) { //Prüfung min zu max Heap umbauen
		// double the position _> 2
		int left = left(pos);
		int right = right(pos);
		int res = pos; // 1 //wo befinde ich mich im Array? wird index berechnet

		if(hasChildren(pos)) { // if has two children
			if (exists(right)) { // if exist one right
				if (prio(left) < prio(right)) {
					// check
					if (left < tasks.size() && prio(left) < prio(res))
						res = left; // res is the new left, pos= 2
				}  else if (right < tasks.size() && prio(right) < prio(res))
					res = right; // if right < smaller then res = right

			}	else { // if no right element exist? then check if left < res;
				if (prio(left) < prio(res))
					res = left; // pos 2
			}
			if (res != pos) { // if nothing res didnt change if( 2 != 1)
				exchange(pos, res);
				sink(res); // recursion, go again until nothing changes anymore;
			} // pos = 2
		}
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int left(int pos) {
		return pos * 2;
	}

	private int right(int pos) {
		return (pos * 2) + 1;
	}

	private boolean exists(int pos) {
		return (pos < tasks.size() && pos > 0);
	}

	private int prio(int pos) {
		return tasks.get(pos).getPriority();
	}


	private void exchange(int pos1, int pos2) {
		Task temp; // zwischenspeicher
		temp = tasks.get(pos1);
		tasks.set(pos1, tasks.get(pos2));
		tasks.set(pos2, temp);

	}

	private boolean hasChildren(int pos) {
		return exists(left(pos));
	}

	private int minChild(int pos) {
		int min, l, r;
		l = left(pos);
		r = right(pos);
		min = l;
		if (exists(r) && prio(r) < prio(l)) {
			min = r;
		}
		return min;
	}

}

