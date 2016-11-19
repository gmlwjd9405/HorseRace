package movingStrategy;

import horseRace.Horse;

public abstract class MovingStrategy {
	protected int breakTime = 0; // 체력이 0이 되면 휴식을 취한다.

	public abstract void move(Horse horse);
}
