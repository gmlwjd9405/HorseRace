package horseImgStrategy;

import horseRace.Horse;

/** Horse의 종류 전략: 남색 horse */
public class DarkBlueHorseStrategy extends HorseImgStrategy {
	private static final String HORSEIMAGE = "image/darkblueHorse_run.gif";

	@Override
	public void changeImage(Horse horse) {
		horse.setImage(HORSEIMAGE);
	}
}