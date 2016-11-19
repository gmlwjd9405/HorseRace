package horseImgStrategy;

import horseRace.Horse;

/** Horse�� ���� ����: ���� horse */
public class DarkBlueHorseStrategy extends HorseImgStrategy {
	private static final String HORSEIMAGE = "image/darkblueHorse_run.gif";

	@Override
	public void changeImage(Horse horse) {
		horse.setImage(HORSEIMAGE);
	}
}