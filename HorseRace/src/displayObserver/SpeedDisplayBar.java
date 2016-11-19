package displayObserver;

import java.awt.Color;

import javax.swing.JLabel;

import horseRace.Horse;
import horseRace.StatusTable;

public class SpeedDisplayBar implements StatusObserver {
	private final static int MAXBAR = 100;
	private Horse horse;
	private JLabel speedLabel;

	public SpeedDisplayBar(Horse horse, StatusTable statusTable, int i) {
		this.horse = horse;
		this.speedLabel = new JLabel();

		speedLabel.setBounds(i * 320 + 170, 100, MAXBAR, 15);
		speedLabel.setBackground(new Color(153, 1, 146));
		speedLabel.setOpaque(true);
		statusTable.add(speedLabel);
	}

	@Override
	public void update() {
		speedLabel.setSize(MAXBAR * horse.getSpeed() / Horse.MAXSPEED, 15);
	}
}