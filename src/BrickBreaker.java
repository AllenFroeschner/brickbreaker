
import javax.swing.*;
import java.awt.*;
public class BrickBreaker extends JFrame {

	
	private static final int WIDTH = 800;
	private static final int HEIGHT= 600;
	
	public BrickBreaker (){
		super("Brick KILLER ");
		setSize(WIDTH, HEIGHT);
		Game play = new Game(WIDTH, HEIGHT);
		
		((Component)play).setFocusable(true);
		setBackground(Color.DARK_GRAY);
		
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		
		BrickBreaker run =new BrickBreaker ();
	}
	
	
}
