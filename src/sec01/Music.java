package sec01;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
 
	// javazoom�� �ִ� library
	private Player player;
	private boolean isLoop; // �ݺ� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("/music/"+name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); // �����带 ������
	}
	
	/* �����尡 ����� �� ������ �ڵ� */
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop); // isLoop�� true�� ���� ���� ��� 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
