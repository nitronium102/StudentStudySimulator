package sec01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

// Simulator
public class Simulator extends JFrame {

	String[] doList = { "���", "���", "���", "���" };
	int cnt = 0;

	private Image screenImage;
	private Graphics screenGraphic;
	/* ���� ȭ���� ��� ���� */
	private Image background = new ImageIcon(Main.class.getResource("/images/introBackground.jpg")).getImage();
	
	/* �޴��� ���� ������Ʈ */
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("/images/menubar.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("/images/exitbutton.png")));

	/* ���� ȭ�鿡�� ���Ǵ� ������Ʈ */
	private JButton startBtn = new JButton(new ImageIcon(Main.class.getResource("/images/startbutton.jpg")));
	private JLabel nameLabel = new JLabel(new ImageIcon(Main.class.getResource("/images/namelabel.jpg")));
	private JTextField txtname = new JTextField(10);

	/* ���� ȭ�鿡�� ���Ǵ� ������Ʈ */
	private JLabel date = new JLabel(); // ��������� D-day�� ��Ÿ���� ������Ʈ
	private JLabel health = new JLabel(); // ���� ü���� ��Ÿ���� ������Ʈ
	private JLabel mental = new JLabel(); // ���� ���ŷ��� ��Ÿ���� ������Ʈ
	private JButton btn1 = new JButton(new ImageIcon(Main.class.getResource("/images/subject1Button.png"))); // ����1 �����ϱ�
	private JButton btn2 = new JButton(new ImageIcon(Main.class.getResource("/images/subject2Button.png"))); // ����2 �����ϱ�
	private JButton btn3 = new JButton(new ImageIcon(Main.class.getResource("/images/subject3Button.png"))); // ����3 �����ϱ�
	private JButton btn4 = new JButton(new ImageIcon(Main.class.getResource("/images/subject4Button.png"))); // ����4 �����ϱ�
	private JButton btn5 = new JButton(new ImageIcon(Main.class.getResource("/images/subject5Button.png"))); // ����5 �����ϱ�
	private JLabel morning = new JLabel();	// ��ħ�� ���� ���θ� ���� ��Ÿ���� ������Ʈ
	private JLabel afternoon = new JLabel();// ���ɿ� ���� ���θ� ���� ��Ÿ���� ������Ʈ
	private JLabel evening = new JLabel(); 	// ���ῡ ���� ���θ� ���� ��Ÿ���� ������Ʈ
	private JComboBox<String> nightSelect;	// ������ ���� ���θ� ���� ��Ÿ���� ������Ʈ
	private JButton check = new JButton(new ImageIcon(Main.class.getResource("/images/checkButton.png")));; // ���� ��ȹ�� �����ϴ� ������Ʈ
	private JButton init = new JButton(new ImageIcon(Main.class.getResource("/images/resetButton.png")));	// ���� ��ȹ�� �ʱ�ȭ�ϴ� ������Ʈ
	private JLabel subject1 = new JLabel(); // ���� ���ص��� ��Ÿ���� ������Ʈ
	private JLabel subject2 = new JLabel();
	private JLabel subject3 = new JLabel();
	private JLabel subject4 = new JLabel();
	private JLabel subject5 = new JLabel();

	/* ���� ȭ�鿡�� ���� ���ÿ� ���Ǵ� �̹����� */
	ImageIcon basic_morning = new ImageIcon(Main.class.getResource("/images/basic_morning.png"));
	ImageIcon basic_afternoon = new ImageIcon(Main.class.getResource("/images/basic_afternoon.png"));
	ImageIcon basic_evening = new ImageIcon(Main.class.getResource("/images/basic_evening.png"));
	ImageIcon subject_bsp = new ImageIcon(Main.class.getResource("/images/subject_bsp.jpg"));
	ImageIcon subject_ds = new ImageIcon(Main.class.getResource("/images/subject_ds.jpg"));
	ImageIcon subject_ca = new ImageIcon(Main.class.getResource("/images/subject_ca.jpg"));
	ImageIcon subject_slt = new ImageIcon(Main.class.getResource("/images/subject_slt.jpg"));
	ImageIcon subject_jpl = new ImageIcon(Main.class.getResource("/images/subject_jpl.jpg"));
	ImageIcon subject_sleep = new ImageIcon(Main.class.getResource("/images/subject_sleep.jpg"));
	ImageIcon day = new ImageIcon(Main.class.getResource("/images/date6.png"));
	private int mouseX, mouseY;

	/* ��� ȭ�鿡�� ���Ǵ� ������Ʈ */
	private JButton finbutton = new JButton(new ImageIcon(Main.class.getResource("/images/finButton.png")));
	private JLabel grade1 = new JLabel();
	private JLabel grade2 = new JLabel();
	private JLabel grade3 = new JLabel();
	private JLabel grade4 = new JLabel();
	private JLabel grade5 = new JLabel();
	private JLabel finGrade = new JLabel();

	// �⺻ ��Ʈ ����
	Font f = new Font("�������", Font.BOLD, 15);

	// ������
	public Simulator() {
		setUndecorated(true); // ���� �޴��� ���ֱ�
		setTitle("���л� ���� �ùķ�����");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // ����� ũ�� ���� �Ұ���

		setLocationRelativeTo(null); // ���� �� ȭ�� �߾ӿ� â�� �߰� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �� �޸𸮿��� ����
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		/* ���� ȭ�� ��Ʈ ���� */
		txtname.setFont(f);
		startBtn.setFont(f);

		/* ���� ȭ�� ��Ʈ ���� */
		date.setFont(f);
		health.setFont(f);
		mental.setFont(f);
		subject1.setFont(f);
		subject2.setFont(f);
		subject3.setFont(f);
		subject4.setFont(f);
		subject5.setFont(f);

		/* ��� ȭ�� ��Ʈ ���� */
		grade1.setFont(f);
		grade2.setFont(f);
		grade3.setFont(f);
		grade4.setFont(f);
		grade5.setFont(f);
		finGrade.setFont(f);

		/* ���� ȭ�鿡 ������Ʈ �߰� */
		add(exitButton);
		add(menubar);
		add(startBtn);
		add(txtname);
		add(nameLabel);
		
		// exitButton �̺�Ʈó��
		exitButton.setBounds(770, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		// �޴��� ��ġ ����
		menubar.setBounds(0, 0, 800, 30);
		
		// �̸� �Է� ������Ʈ
		nameLabel.setBounds(258, 250, 60, 30);
		String name = txtname.getText();
		
		// ������ ���� ����
		User user = new User(name);
		Subject BSP = new Subject("�ǿ��ȣó��");
		Subject DS = new Subject("�ڷᱸ��");
		Subject CA = new Subject("��ǻ�ͱ���");
		Subject SLT = new Subject("������н��̷�");
		Subject JPL = new Subject("�ڹ����α׷���");
		String nightList[] = {" ", "��", "�ǿ��ȣó��", "�ڷᱸ��", "��ǻ�ͱ���", "������н��̷�", "�ڹ����α׷���" };
		
		// ���� ȭ�� ������Ʈ ��ġ ����
		txtname.setBounds(318, 250, 150, 30);
		startBtn.setBounds(468, 250, 60, 30);
		
		// startButton �̺�Ʈ ó��
		startBtn.setBorderPainted(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setFocusPainted(false);
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String name = txtname.getText();
				// �̸��� �Է����� �ʾ��� ��
				if (name.length() < 1) {
					JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���", "message", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// ���� ���� �̺�Ʈ
					user.name = name;
					JOptionPane.showMessageDialog(null, name + "�� �ݰ����ϴ�.", "message", JOptionPane.PLAIN_MESSAGE);
					startBtn.setVisible(false);
					txtname.setVisible(false);
					nameLabel.setVisible(false);
					
					// ���ȭ�� ����
					background = new ImageIcon(Main.class.getResource("/images/mainbackground.jpg")).getImage();
					
					// ���� ȭ�� ������Ʈ ����ȭ
					date.setVisible(true);
					health.setVisible(true);
					mental.setVisible(true);
					morning.setVisible(true);
					afternoon.setVisible(true);
					evening.setVisible(true);
					nightSelect.setVisible(true);
					check.setVisible(true);
					init.setVisible(true);
					btn1.setVisible(true);
					btn2.setVisible(true);
					btn3.setVisible(true);
					btn4.setVisible(true);
					btn5.setVisible(true);
					subject1.setVisible(true);
					subject2.setVisible(true);
					subject3.setVisible(true);
					subject4.setVisible(true);
					subject5.setVisible(true);

				}
			}
		});

		/* ����ȭ�� ������Ʈ �⺻ ����*/
		date.setIcon(day);
		health.setText("ü�� : " + user.health);
		mental.setText("���ŷ� : " + user.mental);
		morning.setIcon(basic_morning);
		afternoon.setIcon(basic_afternoon);
		evening.setIcon(basic_evening);
		nightSelect = new JComboBox<String>(nightList);

		/* ���� ȭ�� ������Ʈ ��ġ ���� */
		date.setBounds(20, 40, 200, 40);
		health.setBounds(690, 45, 100, 30);
		mental.setBounds(690, 75, 100, 30);
		morning.setBounds(100, 300, 50, 50);
		afternoon.setBounds(200, 300, 50, 50);
		evening.setBounds(300, 300, 50, 50);
		nightSelect.setBounds(400, 300, 100, 50);

		/* �޺��ڽ� �̺�Ʈ ó�� */
		nightSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nightSelect.getSelectedItem().toString() != " ")
					doList[3] = nightSelect.getSelectedItem().toString();
			}
		});

		/* ���� �����ư �̺�Ʈ ó�� */
		check.setBounds(550, 300, 100, 50);
		check.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StringBuilder message = new StringBuilder();
				int comprehension = 0;
				int nullcount = 0;
				int sleepcount = 0;
				// ����ִ� �ð��밡 ������ Ȯ��
				for (int i = 0; i < doList.length; i++) {
					System.out.println(doList[i]);
					if (doList[i] == "���") {
						nullcount += 1;
					}
				}
				// ����ִ� �ð��밡 ���� ���
				if (nullcount != 0) {
					JOptionPane.showMessageDialog(null, "����ִ� �ð��밡 �ֽ��ϴ�", "message", JOptionPane.INFORMATION_MESSAGE);
				}

				else { // ����ִ� �ð��밡 ���� ���
					for (int i = 0; i < doList.length; i++) {
						// ���õ� ������ ���ص� ���� �� ȭ�鿡 ���̴� ���� ����
						switch (doList[i]) {
						case "�ǿ��ȣó��":
							comprehension = BSP.study();
							message.append(BSP.display());
							subject1.setText(BSP.screen_display());
							break;
						case "�ڷᱸ��":
							comprehension = DS.study();
							message.append(DS.display());
							subject2.setText(DS.screen_display());
							break;
						case "��ǻ�ͱ���":
							comprehension = CA.study();
							message.append(CA.display());
							subject3.setText(CA.screen_display());
							break;
						case "������н��̷�":
							comprehension = SLT.study();
							message.append(SLT.display());
							subject4.setText(SLT.screen_display());
							break;
						case "�ڹ����α׷���":
							comprehension = JPL.study();
							message.append(JPL.display());
							subject5.setText(JPL.screen_display());
							break;
						case "��":
							comprehension = -1;
							sleepcount += 1;
							break;
						default:
							break;
						}
						// ������ '��'�� �������� ���� ���(��� �ð��뿡 ������ ���)
						if (comprehension != -1) {
							// ������ ���ص��� 50���� ���� ���
							if (comprehension < 50) {
								user.health -= 20;
								user.mental -= 20;
							} 
							// ������ ���ص��� 50���� ���� ���
							else {
								user.health -= 20;
								user.mental -= 10; // ���ص��� ������ ���ŷ��� �� ���ҵȴ�
							}
						}
						
					}
					// ���� ��� ���ο� ���� ü��, ���ŷ� ȸ���� ����
					if (sleepcount == 0) 
						message.append(user.light_sleep());
					 else 
						message.append(user.deep_sleep());
					
					// ������ ü��, ���ŷ��� 0 ���Ϸ� ������ ��� 0���� ó���Ѵ�
					if (user.health <= 0)
						user.health = 0;
					else if (user.mental <= 0)
						user.mental = 0;
					
					// �޺��ڽ� �� �ʱ�ȭ
					nightSelect.setSelectedIndex(0);
					// �������� �ƴϰ� ������ ü�°� ���ŷ��� 0 �̻��� ���
					if (user.date > 0 && user.health > 0 && user.mental > 0) {
						// D-day �̹��� �ٲٱ�
						ImageIcon day = new ImageIcon(Main.class.getResource("/images/date" + user.date + ".png"));
						date.setIcon(day);
						health.setText("ü�� : " + user.health);
						mental.setText("���ŷ� : " + user.mental);
						// ���ص� �������� �������� �����ִ� â
						JOptionPane.showMessageDialog(null, message, "message", JOptionPane.PLAIN_MESSAGE);

						// ���� �ʱ�ȭ
						for (int i = 0; i < doList.length; i++) {
							doList[i] = "���";

						}
						// �̹��� �� ��Ÿ �ʱ�ȭ
						cnt = 0;
						morning.setIcon(basic_morning);
						afternoon.setIcon(basic_afternoon);
						evening.setIcon(basic_evening);
					} 
	
					else if (user.date == 0 || user.health == 0 || user.mental == 0) {
						// ������ ü���̳� ���ŷ��� 0�� ��� >> ��� ���� : �������� �˸�â�� �����ش�)
						if (user.health == 0 || user.mental == 0)
							JOptionPane.showMessageDialog(null, "���� ������� ���� ���ڱ� ���������ϴ�.\n������ �Կ��� �� �̻� ���θ� �� �� �����ϴ�.\n",
									"message", JOptionPane.PLAIN_MESSAGE);
						// �������� ���
						// ��� ȭ������ ��ȯ
						background = new ImageIcon(Main.class.getResource("/images/ResultBackground.jpg")).getImage();

						/* ���� ȭ���� ��ư ����� */
						date.setVisible(false);
						health.setVisible(false);
						mental.setVisible(false);
						morning.setVisible(false);
						afternoon.setVisible(false);
						evening.setVisible(false);
						nightSelect.setVisible(false);
						check.setVisible(false);
						init.setVisible(false);
						btn1.setVisible(false);
						btn2.setVisible(false);
						btn3.setVisible(false);
						btn4.setVisible(false);
						btn5.setVisible(false);
						subject1.setVisible(false);
						subject2.setVisible(false);
						subject3.setVisible(false);
						subject4.setVisible(false);
						subject5.setVisible(false);

						/* ��� ȭ���� ������Ʈ ��Ÿ���� */
						grade1.setVisible(true);
						grade2.setVisible(true);
						grade3.setVisible(true);
						grade4.setVisible(true);
						grade5.setVisible(true);
						finGrade.setVisible(true);
						finbutton.setVisible(true);
						
						/* ���� ����ϱ� */
						String grade;
						double totalGPA = 0;
						/* �� ���� ���� ����ϱ� */
						BSP.calcGrade();
						DS.calcGrade();
						CA.calcGrade();
						SLT.calcGrade();
						JPL.calcGrade();
						
						/* ���� ���� ��ȯ�Ͽ� ���ϱ� */
						grade = BSP.grade;
						totalGPA += BSP.GPA;
						grade1.setText("�ǿ��ȣó�� : " + grade);
						grade = DS.grade;
						totalGPA += DS.GPA;
						grade2.setText("�ڷᱸ�� : " + grade);
						grade = CA.grade;
						totalGPA += CA.GPA;
						grade3.setText("��ǻ�ͱ��� : " + grade);
						SLT.calcGrade();
						grade = SLT.grade;
						totalGPA += SLT.GPA;
						grade4.setText("������н��̷� : " + grade);
						grade = JPL.grade;
						totalGPA += JPL.GPA;
						grade5.setText("�ڹ����α׷��� : " + grade);
						
						double finalGPA = Math.round((totalGPA / 5) * 100) / 100.0;
						finGrade.setText(user.name + "�� �� ���� : " + finalGPA);

					}
				}
			}
		});
		
		// ���� �ʱ�ȭ �̺�Ʈ ó��
		init.setBounds(650, 300, 100, 50);
		init.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// ���� �ʱ�ȭ
				cnt = 0;
				for (int i = 0; i < doList.length; i++) {
					doList[i] = "���";
				}
				morning.setIcon(basic_morning);
				afternoon.setIcon(basic_afternoon);
				evening.setIcon(basic_evening);
			}
		});
		
		// ����1 �������� �� �̺�Ʈ ó��
		btn1.setBounds(70, 400, 130, 50);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cnt < 3) {
					doList[cnt] = "�ǿ��ȣó��";
					System.out.println(doList[cnt]);
					System.out.println(cnt);
					// ���� �ð��뿡 ���� �̹��� �����ϱ�
					switch (cnt) {
					case 0:
						morning.setIcon(subject_bsp);
						break;
					case 1:
						afternoon.setIcon(subject_bsp);
						break;
					case 2:
						evening.setIcon(subject_bsp);
						break;
					default:
						break;
					}
					cnt += 1;
				} else
					JOptionPane.showMessageDialog(null, "������ �� á���ϴ�.", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		// ����2 �������� �� �̺�Ʈ ó��
		btn2.setBounds(210, 400, 130, 50);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cnt < 3) {
					doList[cnt] = "�ڷᱸ��";
					switch (cnt) {
					case 0:
						morning.setIcon(subject_ds);
						break;
					case 1:
						afternoon.setIcon(subject_ds);
						break;
					case 2:
						evening.setIcon(subject_ds);
						break;
					default:
						break;
					}
					cnt += 1;
				} else if (cnt == 3)
					JOptionPane.showMessageDialog(null, "������ �� á���ϴ�.", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// ����3 �������� �� �̺�Ʈ ó��
		btn3.setBounds(350, 400, 130, 50);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cnt < 3) {
					doList[cnt] = "��ǻ�ͱ���";
					switch (cnt) {
					case 0:
						morning.setIcon(subject_ca);
						break;
					case 1:
						afternoon.setIcon(subject_ca);
						break;
					case 2:
						evening.setIcon(subject_ca);
						break;
					default:
						break;
					}
					cnt += 1;
				} else if (cnt == 3)
					JOptionPane.showMessageDialog(null, "������ �� á���ϴ�.", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// ����4 �������� �� �̺�Ʈ ó��
		btn4.setBounds(490, 400, 130, 50);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cnt < 3) {
					doList[cnt] = "������н��̷�";
					switch (cnt) {
					case 0:
						morning.setIcon(subject_slt);
						break;
					case 1:
						afternoon.setIcon(subject_slt);
						break;
					case 2:
						evening.setIcon(subject_slt);
						break;
					default:
						break;
					}
					cnt += 1;
				} else if (cnt == 3)
					JOptionPane.showMessageDialog(null, "������ �� á���ϴ�.", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		// ����5 �������� �� �̺�Ʈ ó��
		btn5.setBounds(630, 400, 130, 50);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cnt < 3) {
					doList[cnt] = "�ڹ����α׷���";
					switch (cnt) {
					case 0:
						morning.setIcon(subject_jpl);
						break;
					case 1:
						afternoon.setIcon(subject_jpl);
						break;
					case 2:
						evening.setIcon(subject_jpl);
						break;
					default:
						break;
					}
					cnt += 1;
				} else if (cnt == 3)
					JOptionPane.showMessageDialog(null, "������ �� á���ϴ�.", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		/* �� ���� �� ���ص��� ȭ�鿡 ��Ÿ���� */
		subject1.setBounds(20, 100, 230, 20);
		subject1.setText(BSP.screen_display());
		subject2.setBounds(20, 130, 230, 20);
		subject2.setText(DS.screen_display());
		subject3.setBounds(20, 160, 230, 20);
		subject3.setText(CA.screen_display());
		subject4.setBounds(20, 190, 230, 20);
		subject4.setText(SLT.screen_display());
		subject5.setBounds(20, 220, 230, 20);
		subject5.setText(JPL.screen_display());

		/* ������Ʈ ���� ���� */
		/* ���� ȭ�鿡�� ���� ȭ�� ������Ʈ �� ���̰� �� */
		date.setVisible(false);
		health.setVisible(false);
		mental.setVisible(false);
		morning.setVisible(false);
		afternoon.setVisible(false);
		evening.setVisible(false);
		nightSelect.setVisible(false);
		btn1.setVisible(false);
		btn2.setVisible(false);
		btn3.setVisible(false);
		btn4.setVisible(false);
		btn5.setVisible(false);
		check.setVisible(false);
		init.setVisible(false);
		subject1.setVisible(false);
		subject2.setVisible(false);
		subject3.setVisible(false);
		subject4.setVisible(false);
		subject5.setVisible(false);
		
		/* ���� ȭ�� ������Ʈ JFrame�� ���� */
		add(date);
		add(health);
		add(mental);
		add(morning);
		add(afternoon);
		add(evening);
		add(nightSelect);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(subject1);
		add(subject2);
		add(subject3);
		add(subject4);
		add(subject5);
		add(check);
		add(init);

		/* ���� ȭ�鿡�� ��� ȭ�� ��ư �� ���̰� �� */
		grade1.setVisible(false);
		grade2.setVisible(false);
		grade3.setVisible(false);
		grade4.setVisible(false);
		grade5.setVisible(false);
		finGrade.setVisible(false);
		finbutton.setVisible(false);
		
		/* ��� ȭ�� ������Ʈ ��ġ */
		Font f = new Font("����� ���� ����", Font.BOLD, 15);
		grade1.setBounds(300, 150, 200, 30);
		grade2.setBounds(300, 190, 200, 30);
		grade3.setBounds(300, 230, 200, 30);
		grade4.setBounds(300, 270, 200, 30);
		grade5.setBounds(300, 310, 200, 30);
		finGrade.setBounds(300, 360, 200, 30);
		finbutton.setBounds(300, 420, 200, 50);
		finbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		
		/* ��� ȭ���� ������Ʈ�� JFrame�� ���� */
		add(grade1);
		add(grade2);
		add(grade3);
		add(grade4);
		add(grade5);
		add(finGrade);
		add(finbutton);

		/* ��� ���� ���� */
		Music backgroundMusic = new Music("backgroundMusic.mp3", true);
		backgroundMusic.start();

	}

	/* ���� ���۸� ��� */
	public void paint(Graphics g) {
		// 800*500��ŭ�� �̹��� ���� �� screenImage ������ ����
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// �׷��� ������ �̹��� ������ �־� �׷����� ����
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		// �ش� x,y�� screenImage�� �׸�
		g.drawImage(screenImage, 0, 0, null); // g��ü�� �׸��� �׸���
	}

	public void screenDraw(Graphics g) {
		// �ش� x,y�� background�� �׸�
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint(); // ���α׷� ���� ������ ����ؼ� ������ ���
	}
}
