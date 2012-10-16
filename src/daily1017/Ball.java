package daily1017;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	int bx, by;
	int dx, dy;
	public final static int BALL_SIZE = 12;

	Ball(){
		bx = (BKuzushi.GAMEN_W - BALL_SIZE) / 2;
		by = BKuzushi.RACKET_Y - BALL_SIZE;
		dx = 0; dy = 0;
	}

	public void start(){
		dy = -4;
		dx = 4;
	}

	public boolean isStart(){
		if (dx == 0 && dy == 0) return false;
		else return true;
	}

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

	public void draw(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(bx - BALL_SIZE / 2, by - BALL_SIZE / 2, BALL_SIZE, BALL_SIZE);
		bx = bx + dx;
		by = by + dy;

		if (getTop() < 0) boundy();
		if (getLeft() < 0 || getRight() > BKuzushi.GAMEN_W){
			boundx();
		}
	}

}
