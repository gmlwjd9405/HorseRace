package movingStrategy;

import horseRace.Horse;

/** Horse�� �޸��� ����: �ٱ� */
public class RunStrategy extends MovingStrategy {
	@Override
	public void move(Horse horse) {
		if(breakTime>0) {
			breakTime--;
			/* �޽��� 0�̸� ü���� �ְ�ġ�� �����Ѵ�. */
			if(breakTime == 0)
				horse.setStamina(Horse.MAXSTAMINA);	
		}
		else if(horse.getStamina()>0) {
			horse.setSpeed(12);
			horse.setLocation(horse.getX() + horse.getSpeed(), horse.getY());
			horse.setStamina(horse.getStamina()-5);  //ü���� 5�� �����Ѵ�.
		}
		/* ü���� 0�̸� �ӵ��� 0���� �ʱ�ȭ�ϰ� 4��ŭ �޽��� ���Ѵ�. */
		else {
			horse.setSpeed(0);
			breakTime = 4;
		}
	}
}


