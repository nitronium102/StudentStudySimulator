package sec01;

import java.util.*;

public class Subject {
	
	protected String subject_name; // 과목명
	protected int comprehension; // 이해도
	protected int increased_comprehension; // 이해도 증가량
	protected String grade; // 학점(알파벳)
	protected double GPA;	// 학점(숫자)
	protected int value = 0;
	
	// 생성자
	public Subject(String subject_name) {
		this.subject_name = subject_name;
		comprehension = 10;
	}
	
	/* 이해도 업데이트
	10% 증가 확률 : 40%
	15% 증가 확률 : 40%
	20% 증가 확률 : 20%
	이해도가 50% 이상일 때는 매번 이해도 25% 증가
	*/
	public int study() {
		// 이해도가 100이 아닌 경우
		if (comprehension < 100) {
			// 이해도가 50% 미만인 경우
			if (comprehension < 50) {
				Random r = new Random();
				int temp = (int)r.nextInt(10);
				if (temp >= 4)
					increased_comprehension = 10;
				else if (temp >= 8)
					increased_comprehension = 15;
				else
					increased_comprehension = 20;
			}
			// 이해도가 50% 이상인 경우
			else {
				increased_comprehension = 25;
				// 공부 결과, 이해도가 100%가 넘어가는 경우
				if (comprehension + increased_comprehension >= 100) {
					value = comprehension-increased_comprehension;
					increased_comprehension = 1;
					comprehension = 100;
					return 100-value;
				}
			}
			comprehension += increased_comprehension;
			return comprehension-increased_comprehension;
		}
		else {
			increased_comprehension = 0;
			return 0; // 이해도 100인 경우 증가량은 0이다.
	
		}
	}
	
	// 알림창에 나타나는 메시지
	public String display() {
		if (increased_comprehension == 0)
			return subject_name+" >> 100% 이해했기 때문에 더 이상 이해도가 증가하지 않습니다.\n";
		else if (increased_comprehension == 1)
			return subject_name+" >> 100% 이해했습니다!\n";
		return subject_name+"의 이해도가 "+increased_comprehension+"만큼 증가했습니다.\n";
	}
	
	// 화면에 나타나는 이해도 
	public String screen_display() {
		return subject_name+"의 이해도 : "+comprehension;
	}
	
	/* 학점 계산
	~40 : C+(2.3)
	~55 : B0(3.0)
	~65 : B+(3.3)
	~80 : A-(3.7)
	~90 : A0(4.0)
	~100 : A+(4.3)
	 */
	public void calcGrade() {
		if (comprehension < 40) {
			grade = "C+";
			GPA = 2.3;
		}
		else if (comprehension < 55) {
			grade = "B0"; GPA = 3.0;
		}
		else if (comprehension < 65) {
			grade = "B+"; GPA = 3.3;
		}
		else if (comprehension < 80) {
			grade = "A-"; GPA = 3.7;
		}
		else if (comprehension < 90) {
			grade = "A0"; GPA = 4.0;
		}
		else {
			grade = "A+"; GPA = 4.3;
		}
	}
}
