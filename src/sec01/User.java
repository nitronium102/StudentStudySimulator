package sec01;

public class User {
	protected String name; // ���� �̸�
	protected int health; // ü��
	protected int mental; // ���ŷ�
	protected int date; // ���� ���� ��¥
	
	
	public User(String name) {
		this.name=name;
		health = 100;
		mental = 100;
		date = 6;
	}
	
	/* ���� �ð��뿡 '��'�� �������� �ʾ��� ��� : ü�� +55, ���ŷ� +60 ȸ��	 */
	public String light_sleep() {
		if (health + 55 <= 100)
			health += 55;
		else 
			health += 100-health;
		
		if (mental + 60 <= 100)
			mental += 60;
		else 
			mental += 100- mental;
		
		date -= 1;
		return "���� ������� ü�°� ���ŷ��� ��Һ��� ���� ȸ���Ǿ����ϴ�.";
	}
	
	/* ���� �ð��뿡 '��'�� �������� ��� : ü�� +80, ���ŷ� +75 ȸ�� */
	public String deep_sleep() {
		if (health + 80 <= 100)
			health += 80;
		else 
			health += 100-health;
		
		if (mental + 75 <= 100)
			mental += 75;
		else 
			mental += 100- mental;
		date -= 1;
		return "����� �������� ���� ü�°� ���ŷ��� ���� ȸ���Ǿ����ϴ�.";
	}

}
