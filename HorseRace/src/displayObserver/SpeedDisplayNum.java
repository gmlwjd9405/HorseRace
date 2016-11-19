package displayObserver;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import horseRace.Horse;
import horseRace.StatusTable;

public class SpeedDisplayNum implements StatusObserver {
	private Horse horse;
	private JLabel speedLabel;

	public SpeedDisplayNum(Horse horse, StatusTable statusTable, int i) {
		this.horse = horse;
		this.speedLabel = new JLabel();

		speedLabel.setBounds(i * 320 + 140, 100, 30, 20);
		speedLabel.setForeground(Color.white);
		speedLabel.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 15));
		statusTable.add(speedLabel);
	}

	/** 말의 상태에 따라 SpeedNum의 display를 업데이트 */
	@Override
	public void update() {
		speedLabel.setText(Integer.toString(horse.getSpeed()));
	}
}
