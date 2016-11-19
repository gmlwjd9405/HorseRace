package horseRace;

import javax.swing.JFrame;

import displayObserver.SpeedDisplayBar;
import displayObserver.SpeedDisplayNum;
import displayObserver.StaminaDisplayBar;
import displayObserver.StaminaDisplayNum;

public class HorseRaceFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 950;
	public static final int HEIGHT = 580;

	private Field field; // horses�� �����ϴ� JPanel
	private StatusTable statusTable; // ���� table�� �����ϴ� JPanel
	private Thread thread; // field�� ���۽�ų thread

	/** HorseRaceFrame ������ */
	public HorseRaceFrame(Horse[] horses) {
		super("Horse Race");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(WIDTH, HEIGHT);
		setLayout(null);

		field = new Field(horses);
		statusTable = new StatusTable();
		add(field);
		add(statusTable);

		StaminaDisplayNum[] staminaDisplayNum = new StaminaDisplayNum[3];
		StaminaDisplayBar[] staminaDisplayBar = new StaminaDisplayBar[3];
		SpeedDisplayNum[] speedDisplayNum = new SpeedDisplayNum[3];
		SpeedDisplayBar[] speedDisplayBar = new SpeedDisplayBar[3];

		for (int i = 0; i < horses.length; i++) {
			staminaDisplayNum[i] = new StaminaDisplayNum(horses[i], statusTable, i);
			staminaDisplayBar[i] = new StaminaDisplayBar(horses[i], statusTable, i);
			speedDisplayNum[i] = new SpeedDisplayNum(horses[i], statusTable, i);
			speedDisplayBar[i] = new SpeedDisplayBar(horses[i], statusTable, i);
			/* ��ȭ�� ������ observer �߰� */
			horses[i].attach(staminaDisplayNum[i]);
			horses[i].attach(staminaDisplayBar[i]);
			horses[i].attach(speedDisplayNum[i]);
			horses[i].attach(speedDisplayBar[i]);
		}

		thread = new Thread(field);
		thread.start(); // field thread ����

		setVisible(true);
	}
}
