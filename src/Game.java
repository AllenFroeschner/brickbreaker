
import javax.swing.*;



import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.event.*;

public class Game extends JPanel implements Runnable, KeyListener {
	
	/**
	 * 
	 */
	private int key;
	private int dx;
	private int lives;
	private BufferedImage back;
	private ImageIcon background;
	private spaceship zoom;
	private shipLzr ball;
	private sound song;
	private int x;
	private int yy;
	private int width;
	private int height;
	Delay2 d = new Delay2();
	
	private ArrayList<alien> aliens;
	boolean move_rt;
	boolean move_lt;


	
	public Game(int w, int h){
		new Thread(this).start();
		width=w;
		height=h;
		background= new ImageIcon("Monster-Mash-Popcorn-Mix3wm.jpg");
		zoom= new spaceship(width/3);
		ball= new shipLzr(zoom.getX(), height/3);
		aliens= new ArrayList<alien>();
		create_aliens();
		sound pl = new sound();
		pl.player();
		new Thread(this).start();
		key=-1;
		this.addKeyListener((KeyListener) this);
		move_rt= false;
		move_lt= false;
		dx=0;
		lives=5;
		x=200;
		yy=0;
		
		
	}
	public void time(){
	}
	public void move_rect(){
		
		if(move_rt){
			zoom.setX(+2);
		}
		if(zoom.getX()+ zoom.getW() +dx>550) {
			zoom.limitX(550-zoom.getW());
		}
		if(move_lt){
			zoom.setX(-2);
	    }
		if(zoom.getX()+dx<0) {
			zoom.limitX(0);
		}
	}

	public void create_aliens(){
		for (int j=0; j<8; j++){
		for (int i=0; i<8; i++){
		aliens.add(new alien(70*i,31*j));
	}}}
	public void display_aliens(Graphics g2d){
		for (alien a: aliens)
		g2d.drawImage(new ImageIcon(a.getPic()).getImage(),a.getX(), a.getY(), a.getW(),a.getH(),this);
		}
	
	
	public boolean collidee(){ 
			if ( zoom!=null &&(ball.getX()+ball.getW()>=zoom.getX() && ball.getX()<=zoom.getX()+zoom.getW() && ball.getY()+ ball.getH()>=zoom.getY() && ball.getY()<=zoom.getY()+zoom.getH())){
			ball.moveY(-5);
			ball.changeDy();
			
			sound pl = new sound();
			pl.player2();
			new Thread(this).start();
			return true;
			}
		return false;
		}
	public void collide(){ 
		
			for (int a =aliens.size()-1; a>=0;a--) {
			
				if (aliens.size()>0 &&(aliens.get(a).getX()+aliens.get(a).getW()>=ball.getX() && aliens.get(a).getX()<=ball.getX()+ball.getW() && aliens.get(a).getY()+ aliens.get(a).getH()>=ball.getY() && aliens.get(a).getY()<=ball.getY()+ball.getH())){
				removal(a);
				ball.changeDy();
				System.out.println("hit");
				sound pl = new sound();
				pl.player1();
				new Thread(this).start();
				}
			}
	}
	public void removal(int a) {
	
		aliens.remove(a);
	}
	public void move_spaceship(){
		
			
	}
	public void keyPressed(KeyEvent ke){
		key = ke.getKeyCode();
		
		
		if(key==39 && zoom.getX()+ zoom.getW() +dx<550){
			move_rt=true;
		}
		
		if(key==37 && zoom.getX()>0){
			move_lt=true;
		}
		if(key==32){
			ball=null;
			d.wait(1000);
			ball= new shipLzr(zoom.getX(), height/3);
			d.wait(1000);
		}
		//cheat code
		if(key==89){
			lives+=1;
			
			}
	}
	public void keyReleased(KeyEvent ke){
		key = ke.getKeyCode();
		
		if(key==39 || zoom.getX()+ zoom.getW() +dx>550){
			move_rt= false;
		}
		if(key==37) {
			move_lt= false;
			
		}
	}
	public void keyTyped(KeyEvent ke){
		key = ke.getKeyCode();
		
	
	}
public void move_ball(){
		
		ball.setX();
		ball.setY();
		if (ball.getX()+ ball.getW()>550|| ball.getX()<0 ) {
			ball.changeDx();
			//ball.moveX(2);
		}
		if(ball.getY()+ ball.getH()>800|| ball.getY()<0 ) {
			ball.changeDy();
			//ball.moveY(2);
		
		}	}
	public alien getMaxX(){
		if(aliens.size()>0){
		alien max =aliens.get(0);
		for(alien a: aliens){
			if (a.getX()>max.getX())
				max=a;
		}
		return max;
	}
		return null;
	}
	public alien getMinX(){
		if(aliens.size()>0){
		alien min =aliens.get(0);
		for(alien a: aliens){
			if (a.getX()<min.getX())
				min=a;
		}
		return min;
	}
	return null;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				Thread.currentThread();
				Thread.sleep(5);
				repaint();
			}
		}catch(Exception e)
		{
			
		}
	}
	public void shot(){
		if (ball.getY()>zoom.getY()) {
		zoom=null;
		ball=null;
		lives-=1;
		d.wait(1000);
		yy=0;
		ball= new shipLzr(width/3, height/3);
		zoom= new spaceship(width/3);
		d.wait(1000);
		}
		
	}
	public boolean win(Graphics g2d){
	
			if(aliens.isEmpty()&& zoom!=null){
				
				background= new ImageIcon("ed28d8f8-3fa0-4276-9877-f34f991ebbff.gif");
				g2d.setColor(Color.WHITE);
				Font MyFont = new Font("Rockwell Extra Bold", Font.BOLD, 50); // 
				g2d.setFont(MyFont);
				g2d.drawString(" YOU WIN? ", 230, 300);
				return true;
			}
			return false;
		}
	public boolean bad(Graphics g2d){
		
		if(lives==0){ 
			
			background= new ImageIcon("1509296587_giphy (17).gif");
			g2d.setColor(Color.WHITE);
			Font MyFont = new Font("Rockwell Extra Bold", Font.BOLD, 50); // 
			g2d.setFont(MyFont);
			g2d.drawString("YOU ARE BAD", 200, 300);
			return true;
		}
		return false;
	}
	public void reset() {

	}
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph= (Graphics2D) g;
		//take a snap shot of the current screen and name it image
		//that is the exact same width and height as the current screen
		if(back==null)
			back = (BufferedImage) (createImage(getWidth(),getHeight()));
		Graphics g2d = back.createGraphics();
		
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.drawImage(background.getImage(), 0, 0,getWidth(),getHeight(),this);
		if(!(bad(g2d)||win(g2d)))
		{
			if(zoom!=null)
		g2d.drawImage(new ImageIcon(zoom.getPic()).getImage(),zoom.getX(), zoom.getY(), zoom.getW(),zoom.getH(),this);
		display_aliens(g2d);
			
		g2d.fillRect(550, 0, 300, 600);
		g2d.setColor(Color.WHITE);
		g2d.drawString("ball stuck? space ", 620,20);
		Font MyFont = new Font("Rockwell Extra Bold", Font.BOLD, 30); // 
		g2d.setFont(MyFont);
		g2d.drawString("Lives: "+ lives, 604,560);
		
		shot();
		collidee();
		collide();
		move_ball();
		
		move_rect();
		
		
		g2d.drawImage(new ImageIcon(ball.getPic()).getImage(),ball.getX(), ball.getY(), ball.getW(),ball.getH(),this);
		
		}
		twoDgraph.drawImage(back, null, 0, 0);
		
	}
}
