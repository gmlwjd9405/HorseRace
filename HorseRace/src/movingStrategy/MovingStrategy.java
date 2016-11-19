package movingStrategy;

import horseRace.Horse;

public abstract class MovingStrategy {
	protected int breakTime = 0; // ü���� 0�� �Ǹ� �޽��� ���Ѵ�.

	public abstract void move(Horse horse);
}
