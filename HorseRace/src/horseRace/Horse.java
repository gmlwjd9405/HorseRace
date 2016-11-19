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

	private MovingStrategy movingStrategy; // Horse이 달리는 전략
	private HorseImgStrategy horseImgStrategy; // Horse의 종류에 대한 전략

	private String name = null; // Horse의 이름
	private ImageIcon image; // Horse의 종류에 따른 ImageIcon
	private int speed = 1; // Horse의 속도
	private int stamina = MAXSTAMINA;

	/** Horse의 생성자. JLabel의 크기지정 */
	public Horse() {
		setSize(WIDTH, HEIGHT);
	}

	/** Horse가 달리는 전략 설정 */
	public void setMovingStrategy(MovingStrategy directionStrategy) {
		this.movingStrategy = directionStrategy;
	}

	/** Horse의 종류에 대한 전략 설정 */
	public void setHorseImgStrategy(HorseImgStrategy drawStrategy) {
		this.horseImgStrategy = drawStrategy;
	}

	/** Horse의 종류에 따른 ImageIcon 설정 */
	public void setImage(String imgPath) {
		image = new ImageIcon(imgPath);
		this.setIcon(image); // horse의 icon에 해당 image를 설정
	}

	/** Horse의 종류에 따른 changeImage */
	public void changeImage() {
		horseImgStrategy.changeImage(this);
	}

	/** Horse이 달리는 전략에 따른 move */
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

	/** @return Horse Label의 X축 Location */
	@Override
	public int getX() {
		return this.getLocation().x;
	}

	/** @return Horse Label의 Y축 Location */
	@Override
	public int getY() {
		return this.getLocation().y;
	}
}
