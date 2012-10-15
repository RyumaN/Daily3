package daily1015;

public class Ball {
	int bx, by;
	int dx, dy;


	public final static int BALL_SIZE = 12;

	//ボール4隅の座標をゲット
	public int getTop(){
		return by - BALL_SIZE / 2;
	}

	public int getLeft(){
		return bx - BALL_SIZE / 2;
	}

	public int getRight(){
		return bx + BALL_SIZE / 2;
	}

	public int getBottom(){
		return by + BALL_SIZE / 2;
	}

	//反射(移動量を反転)
	public void boundx(){
		dx = - dx;
	}

	public void boundy(){
		dy = - dy;
	}

}
