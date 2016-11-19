package horseImgStrategy;

import horseRace.Horse;

/** Horse�� ���� ����: ��� horse */
public class WhiteHorseStrategy extends HorseImgStrategy {
	private static final String HORSEIMAGE = "image/whiteHorse_walk.gif";

	@Override
	public void changeImage(Horse horse) {
		horse.setImage(HORSEIMAGE);
	}
}

