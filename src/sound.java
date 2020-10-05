
import java.io.File;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class sound {
	public void player() {
		File song= new File("recorder star wars theme.wav");
		try {
			Clip clip= AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(song);
			clip.open(inputStream);
			clip.start();
			clip.loop(10);
		
		}catch(Exception e)
		{
			System.out.println(e);
			
		}
	}
	public void player1() {
		File shipLz= new File("huh-2.wav");
		try {
			Clip clip= AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(shipLz);
			clip.open(inputStream);
			clip.start();
		
		}catch(Exception e)
		{
			System.out.println(e);
			
		}
	}

	public void player2() {
		File ashipLz= new File("aahhzz.wav");
		try {
			Clip clip= AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(ashipLz);
			clip.open(inputStream);
			clip.start();
		
		}catch(Exception e)
		{
			System.out.println(e);
			
		}
	}
	public void player3() {
		File explode= new File("TIE fighter explode.wav");
		try {
			Clip clip= AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(explode);
			clip.open(inputStream);
			clip.start();
		
		}catch(Exception e)
		{
			System.out.println(e);
			
		}
	}


}
