package movingStrategy;

import horseRace.Horse;

/** Horse가 달리는 전략: 걷기 */
public class WalkStrategy extends MovingStrategy {
	@Override
	public void move(Horse horse) {
		if (breakTime > 0) {
			breakTime--;

			/* 휴식이 0이면 체력을 최고치로 변경한다. */
			if (breakTime == 0)
				horse.setStamina(Horse.MAXSTAMINA);
		}
		/* 체력이 0이상면 속도만큼 말을 이동시키고 체력을 1씩 감소한다. */
		else if (horse.getStamina() > 0) {
			horse.setSpeed(7);
			horse.setLocation(horse.getX() + horse.getSpeed(), horse.getY());
			horse.setStamina(horse.getStamina() - 1);
		}
		/* 체력이 0이면 속도를 0으로 초기화하고 3만큼 휴식을 취한다. */
		else if (horse.getStamina() <= 0) {
			horse.setSpeed(0);
			breakTime = 3;
		}
	}
}
