package movingStrategy;

import horseRace.Horse;

/** Horse가 달리는 전략: 뛰기 */
public class RunStrategy extends MovingStrategy {
	@Override
	public void move(Horse horse) {
		if(breakTime>0) {
			breakTime--;
			/* 휴식이 0이면 체력을 최고치로 변경한다. */
			if(breakTime == 0)
				horse.setStamina(Horse.MAXSTAMINA);	
		}
		else if(horse.getStamina()>0) {
			horse.setSpeed(12);
			horse.setLocation(horse.getX() + horse.getSpeed(), horse.getY());
			horse.setStamina(horse.getStamina()-5);  //체력을 5씩 감소한다.
		}
		/* 체력이 0이면 속도를 0으로 초기화하고 4만큼 휴식을 취한다. */
		else {
			horse.setSpeed(0);
			breakTime = 4;
		}
	}
}


