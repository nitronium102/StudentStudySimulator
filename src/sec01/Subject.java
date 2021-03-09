package sec01;

import java.util.*;

public class Subject {
	
	protected String subject_name; // �����
	protected int comprehension; // ���ص�
	protected int increased_comprehension; // ���ص� ������
	protected String grade; // ����(���ĺ�)
	protected double GPA;	// ����(����)
	protected int value = 0;
	
	// ������
	public Subject(String subject_name) {
		this.subject_name = subject_name;
		comprehension = 10;
	}
	
	/* ���ص� ������Ʈ
	10% ���� Ȯ�� : 40%
	15% ���� Ȯ�� : 40%
	20% ���� Ȯ�� : 20%
	���ص��� 50% �̻��� ���� �Ź� ���ص� 25% ����
	*/
	public int study() {
		// ���ص��� 100�� �ƴ� ���
		if (comprehension < 100) {
			// ���ص��� 50% �̸��� ���
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
			// ���ص��� 50% �̻��� ���
			else {
				increased_comprehension = 25;
				// ���� ���, ���ص��� 100%�� �Ѿ�� ���
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
			return 0; // ���ص� 100�� ��� �������� 0�̴�.
	
		}
	}
	
	// �˸�â�� ��Ÿ���� �޽���
	public String display() {
		if (increased_comprehension == 0)
			return subject_name+" >> 100% �����߱� ������ �� �̻� ���ص��� �������� �ʽ��ϴ�.\n";
		else if (increased_comprehension == 1)
			return subject_name+" >> 100% �����߽��ϴ�!\n";
		return subject_name+"�� ���ص��� "+increased_comprehension+"��ŭ �����߽��ϴ�.\n";
	}
	
	// ȭ�鿡 ��Ÿ���� ���ص� 
	public String screen_display() {
		return subject_name+"�� ���ص� : "+comprehension;
	}
	
	/* ���� ���
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
