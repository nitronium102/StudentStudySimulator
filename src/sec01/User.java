package sec01;

public class User {
	protected String name; // 유저 이름
	protected int health; // 체력
	protected int mental; // 정신력
	protected int date; // 게임 진행 날짜
	
	
	public User(String name) {
		this.name=name;
		health = 100;
		mental = 100;
		date = 6;
	}
	
	/* 새벽 시간대에 '잠'을 선택하지 않았을 경우 : 체력 +55, 정신력 +60 회복	 */
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
		return "새벽 밤샘으로 체력과 정신력이 평소보다 적게 회복되었습니다.";
	}
	
	/* 새벽 시간대에 '잠'을 선택했을 경우 : 체력 +80, 정신력 +75 회복 */
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
		return "충분한 수면으로 인해 체력과 정신력이 많이 회복되었습니다.";
	}

}
