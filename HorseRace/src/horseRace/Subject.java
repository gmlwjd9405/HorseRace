package horseRace;

import java.util.ArrayList;
import javax.swing.JLabel;

import displayObserver.StatusObserver;

public abstract class Subject extends JLabel{
	private ArrayList<StatusObserver> observers = new ArrayList<StatusObserver>();
	
	public void attach(StatusObserver observer) {
		observers.add(observer);
	}
	
	public void detach(StatusObserver observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(StatusObserver o:observers)
			o.update();
	}
}

