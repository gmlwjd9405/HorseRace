package client;

import horseImgStrategy.*;
import horseRace.Horse;
import horseRace.HorseRaceFrame;
import movingStrategy.*;

public class Main {
	public static void main(String[] args) {
		Horse[] horses = new Horse[3];
		for (int i = 0; i < horses.length; i++) {
			horses[i] = new Horse();
		}
		
		horses[0].setMovingStrategy(new SprintStrategy());
		//horses[0].setMovingStrategy(new RunStrategy());
		horses[0].setHorseImgStrategy(new BrownHorseStrategy());

		horses[1].setMovingStrategy(new WalkStrategy());
		//horses[1].setHorseImgStrategy(new DarkBrownHorseStrategy());
		horses[1].setHorseImgStrategy(new WhiteHorseStrategy());

		horses[2].setMovingStrategy(new RunStrategy());
		//horses[2].setMovingStrategy(new SprintStrategy());
		horses[2].setHorseImgStrategy(new DarkBlueHorseStrategy());

		new HorseRaceFrame(horses);
	}
}

