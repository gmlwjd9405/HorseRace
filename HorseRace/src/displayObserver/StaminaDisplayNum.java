package displayObserver;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import horseRace.Horse;
import horseRace.StatusTable;

public class StaminaDisplayNum implements StatusObserver {
	private Horse horse;
	private JLabel staminaLabel;

	public StaminaDisplayNum(Horse horse, StatusTable statusTable, int i) {
		this.horse = horse;
		this.staminaLabel = new JLabel();

		staminaLabel.setBounds(i * 320 + 140, 55, 30, 20);
		staminaLabel.setForeground(Color.white);
		staminaLabel.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 15));
		statusTable.add(staminaLabel);
	}

	/** 말의 상태에 따라 StaminaNum의 display를 업데이트 */
	@Override
	public void update() {
		staminaLabel.setText(Integer.toString(horse.getStamina()));
	}
}
