package horseRace;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StatusTable extends JPanel {
	public static final int WIDTH = HorseRaceFrame.WIDTH;
	public static final int HEIGHT = 150;

	private ImageIcon background;
	private JLabel laneNumTitles[]; // 레인 번호 Label
	private JLabel staminaTitles[]; // 체력 Label
	private JLabel speedTitles[]; // 속도 Label

	/** StatusTable 생성자 */
	public StatusTable() {
		setLayout(null);
		setBounds(0, Field.height, WIDTH, HEIGHT);

		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.background = new ImageIcon("image/statusBG.png");
		laneNumTitles = new JLabel[3];
		staminaTitles = new JLabel[3];
		speedTitles = new JLabel[3];

		for (int i = 0; i < staminaTitles.length; i++) {
			laneNumTitles[i] = new JLabel();
			laneNumTitles[i].setBounds(i * 320 + 90, 5, 144, 30);
			laneNumTitles[i].setText(" Lane " + (i + 1) + " ");
			laneNumTitles[i].setBackground(new Color(46, 39, 0));
			laneNumTitles[i].setOpaque(true);
			laneNumTitles[i].setForeground(Color.white);
			laneNumTitles[i].setFont(new Font("Consolas", Font.BOLD, 30));
			add(laneNumTitles[i]);

			staminaTitles[i] = new JLabel();
			staminaTitles[i].setBounds(i * 320 + 30, 40, 90, 50);
			staminaTitles[i].setText("Stamina");
			staminaTitles[i].setForeground(new Color(255, 220, 9));
			staminaTitles[i].setFont(new Font("Consolas", Font.BOLD, 20));
			add(staminaTitles[i]);

			speedTitles[i] = new JLabel();
			speedTitles[i].setBounds(i * 320 + 30, 80, 90, 50);
			speedTitles[i].setText("Speed");
			speedTitles[i].setForeground(new Color(255, 220, 9));
			speedTitles[i].setFont(new Font("Consolas", Font.BOLD, 20));
			add(speedTitles[i]);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.gray);

		/* 구분선을 그린다. */
		for (int i = -1; i < 1; i++) {
			g.drawLine(getWidth() / 3 + i, 0, getWidth() / 3 + i, getHeight());
			g.drawLine(getWidth() * 2 / 3 + i, 0, getWidth() * 2 / 3 + i, getHeight());
		}
	}
}
