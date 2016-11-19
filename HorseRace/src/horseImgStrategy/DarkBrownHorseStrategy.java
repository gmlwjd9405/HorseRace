package horseImgStrategy;

import horseRace.Horse;

/** Horse의 종류 전략: 어두운 갈색 horse */
public class DarkBrownHorseStrategy extends HorseImgStrategy {
	private static final String HORSEIMAGE = "image/darkbrownHorse_run.gif";

	@Override
	public void changeImage(Horse horse) {
		horse.setImage(HORSEIMAGE);
	}
}
