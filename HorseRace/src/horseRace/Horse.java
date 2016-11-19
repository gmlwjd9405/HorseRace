package horseRace;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import horseImgStrategy.HorseImgStrategy;
import movingStrategy.MovingStrategy;

public class Horse extends Subject {
	public final static int MAXSTAMINA = 100;
	public final static int MAXSPEED = 20;

	public static final int WIDTH = 110;
	public static final int HEIGHT = 90;

	private MovingStrategy movingStrategy; // Horse�� �޸��� ����
	private HorseImgStrategy horseImgStrategy; // Horse�� ������ ���� ����

	private String name = null; // Horse�� �̸�
	private ImageIcon image; // Horse�� ������ ���� ImageIcon
	private int speed = 1; // Horse�� �ӵ�
	private int stamina = MAXSTAMINA;

	/** Horse�� ������. JLabel�� ũ������ */
	public Horse() {
		setSize(WIDTH, HEIGHT);
	}

	/** Horse�� �޸��� ���� ���� */
	public void setMovingStrategy(MovingStrategy directionStrategy) {
		this.movingStrategy = directionStrategy;
	}

	/** Horse�� ������ ���� ���� ���� */
	public void setHorseImgStrategy(HorseImgStrategy drawStrategy) {
		this.horseImgStrategy = drawStrategy;
	}

	/** Horse�� ������ ���� ImageIcon ���� */
	public void setImage(String imgPath) {
		image = new ImageIcon(imgPath);
		this.setIcon(image); // horse�� icon�� �ش� image�� ����
	}

	/** Horse�� ������ ���� changeImage */
	public void changeImage() {
		horseImgStrategy.changeImage(this);
	}

	/** Horse�� �޸��� ������ ���� move */
	public void move() {
		movingStrategy.move(this);
	}

	// /* setter */
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setName(String name) {
		this.name = name;
	}

	// /* getter */
	public String getName() {
		return this.name;
	}

	public int getStamina() {
		return this.stamina;
	}

	public int getSpeed() {
		return this.speed;
	}

	/** @return Horse Label�� X�� Location */
	@Override
	public int getX() {
		return this.getLocation().x;
	}

	/** @return Horse Label�� Y�� Location */
	@Override
	public int getY() {
		return this.getLocation().y;
	}
}
