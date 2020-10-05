
public class shipLzr extends missile {

	private static int dx;
	private static int dy;
	public shipLzr(){
		super();
		dx=0;
		dy=0;
	}
	public shipLzr(int posx,int posy){
		super(posx, posy, 50,50, "square_gold_front.jpg");
			dx=2;
			dy=2;
			}
			public void changeDx(){
			dx=-dx;
			}
			
			public void moveX(int x){
				setX(x);
				}
			public void moveY(int y){
				setY(y);
				}
			public void setX(){
				setX(dx);
			}
			public void changeDy(){
				dy=-dy;
			}
			public void changeDyy(){
				dy=-dy-dy;
			}
			public void setY(){
				setY(dy);
			}

		}
