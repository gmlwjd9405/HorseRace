package horseImgStrategy;

import horseRace.Horse;

/** Horse의 종류 전략: 밝은 갈색 horse */
public class BrownHorseStrategy extends HorseImgStrategy {
	private static final String HORSEIMAGE = "image/brownHorse_run.gif";

	@Override
	public void changeImage(Horse horse) {
		horse.setImage(HORSEIMAGE);
	}
}
