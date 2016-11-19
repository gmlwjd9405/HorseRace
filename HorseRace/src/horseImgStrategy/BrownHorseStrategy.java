package horseImgStrategy;

import horseRace.Horse;

/** Horse�� ���� ����: ���� ���� horse */
public class BrownHorseStrategy extends HorseImgStrategy {
	private static final String HORSEIMAGE = "image/brownHorse_run.gif";

	@Override
	public void changeImage(Horse horse) {
		horse.setImage(HORSEIMAGE);
	}
}
