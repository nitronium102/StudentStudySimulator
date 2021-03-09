package sec01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

// Simulator
public class Simulator extends JFrame {

	String[] doList = { "놀기", "놀기", "놀기", "놀기" };
	int cnt = 0;

	private Image screenImage;
	private Graphics screenGraphic;
	/* 시작 화면의 배경 설정 */
	private Image background = new ImageIcon(Main.class.getResource("/images/introBackground.jpg")).getImage();
	
	/* 메뉴바 관련 컴포넌트 */
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("/images/menubar.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("/images/exitbutton.png")));

	/* 시작 화면에서 사용되는 컴포넌트 */
	private JButton startBtn = new JButton(new ImageIcon(Main.class.getResource("/images/startbutton.jpg")));
	private JLabel nameLabel = new JLabel(new ImageIcon(Main.class.getResource("/images/namelabel.jpg")));
	private JTextField txtname = new JTextField(10);

	/* 메인 화면에서 사용되는 컴포넌트 */
	private JLabel date = new JLabel(); // 시험까지의 D-day를 나타내는 컴포넌트
	private JLabel health = new JLabel(); // 남은 체력을 나타내는 컴포넌트
	private JLabel mental = new JLabel(); // 남은 정신력을 나타내는 컴포넌트
	private JButton btn1 = new JButton(new ImageIcon(Main.class.getResource("/images/subject1Button.png"))); // 과목1 공부하기
	private JButton btn2 = new JButton(new ImageIcon(Main.class.getResource("/images/subject2Button.png"))); // 과목2 공부하기
	private JButton btn3 = new JButton(new ImageIcon(Main.class.getResource("/images/subject3Button.png"))); // 과목3 공부하기
	private JButton btn4 = new JButton(new ImageIcon(Main.class.getResource("/images/subject4Button.png"))); // 과목4 공부하기
	private JButton btn5 = new JButton(new ImageIcon(Main.class.getResource("/images/subject5Button.png"))); // 과목5 공부하기
	private JLabel morning = new JLabel();	// 아침에 무슨 공부를 할지 나타내는 컴포넌트
	private JLabel afternoon = new JLabel();// 점심에 무슨 공부를 할지 나타내는 컴포넌트
	private JLabel evening = new JLabel(); 	// 저녁에 무슨 공부를 할지 나타내는 컴포넌트
	private JComboBox<String> nightSelect;	// 새벽에 무슨 공부를 할지 나타내는 컴포넌트
	private JButton check = new JButton(new ImageIcon(Main.class.getResource("/images/checkButton.png")));; // 공부 계획을 수행하는 컴포넌트
	private JButton init = new JButton(new ImageIcon(Main.class.getResource("/images/resetButton.png")));	// 공부 계획을 초기화하는 컴포넌트
	private JLabel subject1 = new JLabel(); // 과목별 이해도를 나타내는 컴포넌트
	private JLabel subject2 = new JLabel();
	private JLabel subject3 = new JLabel();
	private JLabel subject4 = new JLabel();
	private JLabel subject5 = new JLabel();

	/* 메인 화면에서 일정 선택에 사용되는 이미지들 */
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

	/* 결과 화면에서 사용되는 컴포넌트 */
	private JButton finbutton = new JButton(new ImageIcon(Main.class.getResource("/images/finButton.png")));
	private JLabel grade1 = new JLabel();
	private JLabel grade2 = new JLabel();
	private JLabel grade3 = new JLabel();
	private JLabel grade4 = new JLabel();
	private JLabel grade5 = new JLabel();
	private JLabel finGrade = new JLabel();

	// 기본 폰트 설정
	Font f = new Font("나눔고딕", Font.BOLD, 15);

	// 생성자
	public Simulator() {
		setUndecorated(true); // 기존 메뉴바 없애기
		setTitle("대학생 육성 시뮬레이터");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 사용자 크기 조정 불가능

		setLocationRelativeTo(null); // 실행 시 화면 중앙에 창이 뜨게 함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 시 메모리에서 없앰
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		/* 시작 화면 폰트 적용 */
		txtname.setFont(f);
		startBtn.setFont(f);

		/* 메인 화면 폰트 적용 */
		date.setFont(f);
		health.setFont(f);
		mental.setFont(f);
		subject1.setFont(f);
		subject2.setFont(f);
		subject3.setFont(f);
		subject4.setFont(f);
		subject5.setFont(f);

		/* 결과 화면 폰트 적용 */
		grade1.setFont(f);
		grade2.setFont(f);
		grade3.setFont(f);
		grade4.setFont(f);
		grade5.setFont(f);
		finGrade.setFont(f);

		/* 시작 화면에 컴포넌트 추가 */
		add(exitButton);
		add(menubar);
		add(startBtn);
		add(txtname);
		add(nameLabel);
		
		// exitButton 이벤트처리
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

		// 메뉴바 위치 설정
		menubar.setBounds(0, 0, 800, 30);
		
		// 이름 입력 컴포넌트
		nameLabel.setBounds(258, 250, 60, 30);
		String name = txtname.getText();
		
		// 유저와 과목 생성
		User user = new User(name);
		Subject BSP = new Subject("의용신호처리");
		Subject DS = new Subject("자료구조");
		Subject CA = new Subject("컴퓨터구조");
		Subject SLT = new Subject("통계적학습이론");
		Subject JPL = new Subject("자바프로그래밍");
		String nightList[] = {" ", "잠", "의용신호처리", "자료구조", "컴퓨터구조", "통계적학습이론", "자바프로그래밍" };
		
		// 시작 화면 컴포넌트 위치 설정
		txtname.setBounds(318, 250, 150, 30);
		startBtn.setBounds(468, 250, 60, 30);
		
		// startButton 이벤트 처리
		startBtn.setBorderPainted(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setFocusPainted(false);
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String name = txtname.getText();
				// 이름을 입력하지 않았을 때
				if (name.length() < 1) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요", "message", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// 게임 시작 이벤트
					user.name = name;
					JOptionPane.showMessageDialog(null, name + "님 반갑습니다.", "message", JOptionPane.PLAIN_MESSAGE);
					startBtn.setVisible(false);
					txtname.setVisible(false);
					nameLabel.setVisible(false);
					
					// 배경화면 변경
					background = new ImageIcon(Main.class.getResource("/images/mainbackground.jpg")).getImage();
					
					// 메인 화면 컴포넌트 가시화
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

		/* 메인화면 컴포넌트 기본 설정*/
		date.setIcon(day);
		health.setText("체력 : " + user.health);
		mental.setText("정신력 : " + user.mental);
		morning.setIcon(basic_morning);
		afternoon.setIcon(basic_afternoon);
		evening.setIcon(basic_evening);
		nightSelect = new JComboBox<String>(nightList);

		/* 메인 화면 컴포넌트 위치 설정 */
		date.setBounds(20, 40, 200, 40);
		health.setBounds(690, 45, 100, 30);
		mental.setBounds(690, 75, 100, 30);
		morning.setBounds(100, 300, 50, 50);
		afternoon.setBounds(200, 300, 50, 50);
		evening.setBounds(300, 300, 50, 50);
		nightSelect.setBounds(400, 300, 100, 50);

		/* 콤보박스 이벤트 처리 */
		nightSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nightSelect.getSelectedItem().toString() != " ")
					doList[3] = nightSelect.getSelectedItem().toString();
			}
		});

		/* 일정 수행버튼 이벤트 처리 */
		check.setBounds(550, 300, 100, 50);
		check.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StringBuilder message = new StringBuilder();
				int comprehension = 0;
				int nullcount = 0;
				int sleepcount = 0;
				// 비어있는 시간대가 없는지 확인
				for (int i = 0; i < doList.length; i++) {
					System.out.println(doList[i]);
					if (doList[i] == "놀기") {
						nullcount += 1;
					}
				}
				// 비어있는 시간대가 있을 경우
				if (nullcount != 0) {
					JOptionPane.showMessageDialog(null, "비어있는 시간대가 있습니다", "message", JOptionPane.INFORMATION_MESSAGE);
				}

				else { // 비어있는 시간대가 없을 경우
					for (int i = 0; i < doList.length; i++) {
						// 선택된 과목의 이해도 증가 및 화면에 보이는 문구 설정
						switch (doList[i]) {
						case "의용신호처리":
							comprehension = BSP.study();
							message.append(BSP.display());
							subject1.setText(BSP.screen_display());
							break;
						case "자료구조":
							comprehension = DS.study();
							message.append(DS.display());
							subject2.setText(DS.screen_display());
							break;
						case "컴퓨터구조":
							comprehension = CA.study();
							message.append(CA.display());
							subject3.setText(CA.screen_display());
							break;
						case "통계적학습이론":
							comprehension = SLT.study();
							message.append(SLT.display());
							subject4.setText(SLT.screen_display());
							break;
						case "자바프로그래밍":
							comprehension = JPL.study();
							message.append(JPL.display());
							subject5.setText(JPL.screen_display());
							break;
						case "잠":
							comprehension = -1;
							sleepcount += 1;
							break;
						default:
							break;
						}
						// 새벽에 '잠'을 선택하지 않은 경우(모든 시간대에 공부한 경우)
						if (comprehension != -1) {
							// 과목의 이해도가 50보다 낮은 경우
							if (comprehension < 50) {
								user.health -= 20;
								user.mental -= 20;
							} 
							// 과목의 이해도가 50보다 높은 경우
							else {
								user.health -= 20;
								user.mental -= 10; // 이해도가 높으면 정신력이 덜 감소된다
							}
						}
						
					}
					// 새벽 밤샘 여부에 따라 체력, 정신력 회복량 결정
					if (sleepcount == 0) 
						message.append(user.light_sleep());
					 else 
						message.append(user.deep_sleep());
					
					// 유저의 체력, 정신력이 0 이하로 내려갈 경우 0으로 처리한다
					if (user.health <= 0)
						user.health = 0;
					else if (user.mental <= 0)
						user.mental = 0;
					
					// 콤보박스 값 초기화
					nightSelect.setSelectedIndex(0);
					// 종강날이 아니고 유저의 체력과 정신력이 0 이상인 경우
					if (user.date > 0 && user.health > 0 && user.mental > 0) {
						// D-day 이미지 바꾸기
						ImageIcon day = new ImageIcon(Main.class.getResource("/images/date" + user.date + ".png"));
						date.setIcon(day);
						health.setText("체력 : " + user.health);
						mental.setText("정신력 : " + user.mental);
						// 이해도 증가량을 유저에게 보여주는 창
						JOptionPane.showMessageDialog(null, message, "message", JOptionPane.PLAIN_MESSAGE);

						// 일정 초기화
						for (int i = 0; i < doList.length; i++) {
							doList[i] = "놀기";

						}
						// 이미지 및 기타 초기화
						cnt = 0;
						morning.setIcon(basic_morning);
						afternoon.setIcon(basic_afternoon);
						evening.setIcon(basic_evening);
					} 
	
					else if (user.date == 0 || user.health == 0 || user.mental == 0) {
						// 유저의 체력이나 정신력이 0인 경우 >> 배드 엔딩 : 유저에게 알림창을 보여준다)
						if (user.health == 0 || user.mental == 0)
							JOptionPane.showMessageDialog(null, "잦은 밤샘으로 인해 갑자기 쓰려졌습니다.\n병원에 입원해 더 이상 공부를 할 수 없습니다.\n",
									"message", JOptionPane.PLAIN_MESSAGE);
						// 종강날인 경우
						// 결과 화면으로 전환
						background = new ImageIcon(Main.class.getResource("/images/ResultBackground.jpg")).getImage();

						/* 메인 화면의 버튼 숨기기 */
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

						/* 결과 화면의 컴포넌트 나타내기 */
						grade1.setVisible(true);
						grade2.setVisible(true);
						grade3.setVisible(true);
						grade4.setVisible(true);
						grade5.setVisible(true);
						finGrade.setVisible(true);
						finbutton.setVisible(true);
						
						/* 학점 계산하기 */
						String grade;
						double totalGPA = 0;
						/* 각 과목별 학점 계산하기 */
						BSP.calcGrade();
						DS.calcGrade();
						CA.calcGrade();
						SLT.calcGrade();
						JPL.calcGrade();
						
						/* 과목별 학점 변환하여 더하기 */
						grade = BSP.grade;
						totalGPA += BSP.GPA;
						grade1.setText("의용신호처리 : " + grade);
						grade = DS.grade;
						totalGPA += DS.GPA;
						grade2.setText("자료구조 : " + grade);
						grade = CA.grade;
						totalGPA += CA.GPA;
						grade3.setText("컴퓨터구조 : " + grade);
						SLT.calcGrade();
						grade = SLT.grade;
						totalGPA += SLT.GPA;
						grade4.setText("통계적학습이론 : " + grade);
						grade = JPL.grade;
						totalGPA += JPL.GPA;
						grade5.setText("자바프로그래밍 : " + grade);
						
						double finalGPA = Math.round((totalGPA / 5) * 100) / 100.0;
						finGrade.setText(user.name + "의 총 학점 : " + finalGPA);

					}
				}
			}
		});
		
		// 일정 초기화 이벤트 처리
		init.setBounds(650, 300, 100, 50);
		init.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 일정 초기화
				cnt = 0;
				for (int i = 0; i < doList.length; i++) {
					doList[i] = "놀기";
				}
				morning.setIcon(basic_morning);
				afternoon.setIcon(basic_afternoon);
				evening.setIcon(basic_evening);
			}
		});
		
		// 과목1 공부했을 때 이벤트 처리
		btn1.setBounds(70, 400, 130, 50);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cnt < 3) {
					doList[cnt] = "의용신호처리";
					System.out.println(doList[cnt]);
					System.out.println(cnt);
					// 공부 시간대에 따라 이미지 변경하기
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
					JOptionPane.showMessageDialog(null, "일정이 꽉 찼습니다.", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		// 과목2 공부했을 때 이벤트 처리
		btn2.setBounds(210, 400, 130, 50);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cnt < 3) {
					doList[cnt] = "자료구조";
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
					JOptionPane.showMessageDialog(null, "일정이 꽉 찼습니다.", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// 과목3 공부했을 때 이벤트 처리
		btn3.setBounds(350, 400, 130, 50);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cnt < 3) {
					doList[cnt] = "컴퓨터구조";
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
					JOptionPane.showMessageDialog(null, "일정이 꽉 찼습니다.", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// 과목4 공부했을 때 이벤트 처리
		btn4.setBounds(490, 400, 130, 50);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cnt < 3) {
					doList[cnt] = "통계적학습이론";
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
					JOptionPane.showMessageDialog(null, "일정이 꽉 찼습니다.", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		// 과목5 공부했을 때 이벤트 처리
		btn5.setBounds(630, 400, 130, 50);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cnt < 3) {
					doList[cnt] = "자바프로그래밍";
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
					JOptionPane.showMessageDialog(null, "일정이 꽉 찼습니다.", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		/* 각 과목 별 이해도를 화면에 나타내기 */
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

		/* 컴포넌트 노출 조절 */
		/* 시작 화면에서 메인 화면 컴포넌트 안 보이게 함 */
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
		
		/* 메인 화면 컴포넌트 JFrame에 부착 */
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

		/* 시작 화면에서 결과 화면 버튼 안 보이게 함 */
		grade1.setVisible(false);
		grade2.setVisible(false);
		grade3.setVisible(false);
		grade4.setVisible(false);
		grade5.setVisible(false);
		finGrade.setVisible(false);
		finbutton.setVisible(false);
		
		/* 결과 화면 컴포넌트 배치 */
		Font f = new Font("배달의 민족 도현", Font.BOLD, 15);
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
		
		/* 결과 화면의 컴포넌트를 JFrame에 부착 */
		add(grade1);
		add(grade2);
		add(grade3);
		add(grade4);
		add(grade5);
		add(finGrade);
		add(finbutton);

		/* 배경 음악 시작 */
		Music backgroundMusic = new Music("backgroundMusic.mp3", true);
		backgroundMusic.start();

	}

	/* 더블 버퍼링 사용 */
	public void paint(Graphics g) {
		// 800*500만큼의 이미지 생성 후 screenImage 변수에 저장
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 그래픽 변수에 이미지 변수를 넣어 그래픽을 만듦
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		// 해당 x,y에 screenImage를 그림
		g.drawImage(screenImage, 0, 0, null); // g객체가 그림을 그린다
	}

	public void screenDraw(Graphics g) {
		// 해당 x,y에 background를 그림
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint(); // 프로그램 끝날 때까지 계속해서 사진을 띄움
	}
}
