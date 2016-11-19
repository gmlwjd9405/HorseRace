package movingStrategy;

import horseRace.Horse;

/** Horse�� �޸��� ����: �ȱ� */
public class WalkStrategy extends MovingStrategy {
	@Override
	public void move(Horse horse) {
		if(breakTime>0) {
			breakTime--;
			/* �޽��� 0�̸� ü���� �ְ�ġ�� �����Ѵ�. */
			if(breakTime == 0)
				horse.setStamina(Horse.MAXSTAMINA);	
		}
		else if(horse.getStamina()>0) {
			horse.setSpeed(7);
			horse.setLocation(horse.getX() + horse.getSpeed(), horse.getY());
			horse.setStamina(horse.getStamina()-1);  //ü���� 1�� �����Ѵ�.
		}
		/* ü���� 0�̸� �ӵ��� 0���� �ʱ�ȭ�ϰ� 5��ŭ �޽��� ���Ѵ�. */
		else {
			horse.setSpeed(0);
			breakTime = 5;
		}
	}
}
