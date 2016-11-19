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
	private static final JLabel ENDLABEL = new JLabel(); // ����� ����� Label
	private static String winner; // �̱� ���� �̸�

	private ImageIcon background;
	private Horse[] horses;

	/**
	 * Field�� ������
	 * 
	 * @param horses
	 *            Field�� ���� ������ �迭
	 */
	public Field(Horse[] horses) {
		setLayout(null);
		setBounds(0, 0, width, height);

		this.horses = horses;
		this.background = new ImageIcon("image/background.png");

		// horse�� ��ġ
		for (int i = 0; i < horses.length; i++) {
			horses[i].setBounds(60, 70 + (80 * i), 120, 70);
			horses[i].setName(Integer.toString(i + 1));
			horses[i].changeImage();
			this.add(horses[i]);
			repaint();
			invalidate();
		}
		// EndLabel�� ��ġ
		ENDLABEL.setBounds(310, 100, 400, 100);
		ENDLABEL.setFont(new Font("DialogInput", Font.BOLD, 50));
		ENDLABEL.setForeground(new Color(255, 220, 9));
	}

	/**
	 * ���ָ��� field�� �������� �����ߴ����� Ȯ��
	 * 
	 * @return true ���������� �̱� ���� �̸��� ����
	 */
	private boolean isEnd() {
		for (int i = 0; i < horses.length; i++) {
			// horse�� field�� �������� �����ϸ� return true
			if (horses[i].getX() > width - 90) {
				winner = horses[i].getName();
				return true;
			}
		}
		return false;
	}

	/** ���ѷ��� 1. horses �޸��� 2. ��ȭ ���� 3. repaint */
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
		// ���â�� ����Ѵ�.
		try {
			ENDLABEL.setText(winner + "�� ���� �¸�!");
			this.add(ENDLABEL);
			// ���� ���� �� field���� horses�� ����
			for (int i = 0; i < horses.length; i++) {
				this.remove(horses[i]);
			}
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** Field�� ��� ���� */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
	}
}
