package horseRace;

import java.util.ArrayList;
import javax.swing.JLabel;

import displayObserver.StatusObserver;

public abstract class Subject extends JLabel {
	private ArrayList<StatusObserver> observers = new ArrayList<StatusObserver>();

	/** Observer 추가 */
	public void attach(StatusObserver observer) {
		observers.add(observer);
	}

	/** Observer 제거 */
	public void detach(StatusObserver observer) {
		observers.remove(observer);
	}

	/** Observer의 변화를 확인하여 update */
	public void notifyObservers() {
		for (StatusObserver o : observers)
			o.update();
	}
}
