package horseImgStrategy;

import horseRace.Horse;

/** Horse�� ���� ����: ��ο� ���� horse */
public class DarkBrownHorseStrategy extends HorseImgStrategy {
	private static final String HORSEIMAGE = "image/darkbrownHorse_run.gif";

	@Override
	public void changeImage(Horse horse) {
		horse.setImage(HORSEIMAGE);
	}
}
