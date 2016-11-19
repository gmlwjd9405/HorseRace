package movingStrategy;

import horseRace.Horse;

/** Horse�� �޸��� ����: ���������ϱ� */
public class SprintStrategy extends MovingStrategy {
	@Override
	public void move(Horse horse) {
		if(breakTime>0) {
			breakTime--;
			/* �޽��� 0�̸� ü���� �ְ�ġ�� �����Ѵ�. */
			if(breakTime == 0)
				horse.setStamina(Horse.MAXSTAMINA);	
		}
		else if(horse.getStamina()>0) {
			horse.setSpeed(20);
			horse.setLocation(horse.getX() + horse.getSpeed(), horse.getY());
			horse.setStamina(horse.getStamina()-10);  //ü���� 10�� �����Ѵ�.
		}
		/* ü���� 0�̸� �ӵ��� 0���� �ʱ�ȭ�ϰ� 6��ŭ �޽��� ���Ѵ�. */
		else if(horse.getStamina() <= 0) {
			horse.setSpeed(0);
			breakTime = 6;
		}
	}
}