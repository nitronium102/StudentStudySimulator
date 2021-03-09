package sec01;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
 
	// javazoom에 있는 library
	private Player player;
	private boolean isLoop; // 반복 여부
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
		this.interrupt(); // 스레드를 종료함
	}
	
	/* 스레드가 실행될 때 수행할 코드 */
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop); // isLoop가 true인 동안 음악 재생 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
