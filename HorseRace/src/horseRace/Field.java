package horseRace;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Field extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int width = HorseRaceFrame.WIDTH;
	public static final int height = 400;
	private static final JLabel ENDLABEL = new JLabel(); // 결과를 출력할 Label
	private static String winner; // 이긴 말의 이름

	private ImageIcon background;
	private Horse[] horses;

	/**
	 * Field의 생성자
	 * 
	 * @param horses
	 *            Field에 넣을 말들의 배열
	 */
	public Field(Horse[] horses) {
		setLayout(null);
		setBounds(0, 0, width, height);

		this.horses = horses;
		this.background = new ImageIcon("image/background.png");

		// horse를 배치
		for (int i = 0; i < horses.length; i++) {
			horses[i].setBounds(60, 70 + (80 * i), 120, 70);
			horses[i].setName(Integer.toString(i + 1));
			horses[i].changeImage();
			this.add(horses[i]);
			repaint();
			invalidate();
		}
		// EndLabel을 배치
		ENDLABEL.setBounds(310, 100, 400, 100);
		ENDLABEL.setFont(new Font("DialogInput", Font.BOLD, 50));
		ENDLABEL.setForeground(new Color(255, 220, 9));
	}

	/**
	 * 경주마가 field의 마지막에 도달했는지를 확인
	 * 
	 * @return true 도달했으면 이긴 말의 이름을 설정
	 */
	private boolean isEnd() {
		for (int i = 0; i < horses.length; i++) {
			// horse가 field의 마지막에 도달하면 return true
			if (horses[i].getX() > width - 90) {
				winner = horses[i].getName();
				return true;
			}
		}
		return false;
	}

	/** 무한루프 1. horses 달리기 2. 변화 감지 3. repaint */
	public void run() {
		while (true) {
			for (int i = 0; i < horses.length; i++) {
				horses[i].move();
				horses[i].notifyObservers();
			}
			repaint();
			invalidate();

			if (isEnd() == true) {
				break;
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 결과창을 출력한다.
		try {
			ENDLABEL.setText(winner + "번 말이 승리!");
			this.add(ENDLABEL);
			// 게임 종료 후 field에서 horses를 제거
			for (int i = 0; i < horses.length; i++) {
				this.remove(horses[i]);
			}
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** Field의 배경 설정 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
	}
}
