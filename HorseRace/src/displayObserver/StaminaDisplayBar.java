package displayObserver;

import java.awt.Color;
import javax.swing.JLabel;

import horseRace.Horse;
import horseRace.StatusTable;

public class StaminaDisplayBar implements StatusObserver {
	private final static int MAXBAR = 100;
	private Horse horse;
	private JLabel staminaLabel;
	
	public StaminaDisplayBar(Horse horse, StatusTable statusTable, int i) {
		this.horse = horse;
		this.staminaLabel = new JLabel();
		
		staminaLabel.setBounds(i*320 + 170, 60, MAXBAR, 15);
		staminaLabel.setBackground(Color.LIGHT_GRAY);
		staminaLabel.setOpaque(true);
		statusTable.add(staminaLabel);
	}
	@Override
	public void update() {
		staminaLabel.setSize(MAXBAR*horse.getStamina()/Horse.MAXSTAMINA, 15);
	}
}