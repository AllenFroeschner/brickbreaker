
public class alien extends ship {

	private static int dx;
	public alien(){
		super();
		dx=0;
	}
	public alien(int posx, int posy){
		super(posx, posy, 57,25, "131402851-612x612.jpg");
		dx=1;
	}
	public void changeDx(){
		dx=-dx;
	}
	public void setX(){
		setX(dx);
	}
}