package daily1016;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import daily0917.GameHoneGumi;

public class BKuzushi extends GameHoneGumi {
	public static final int GAMEN_W = 300;
	public static final int GAMEN_H = 400;
	static final int RACKET_W = 100;
	static final int RACKET_H = 2;
	public static final int RACKET_Y = GAMEN_H - 40;

	BufferedImage startimage;
	int racket_x;
	boolean leftkey, rightkey;
	Ball ball;
	Blocks blocks;
	int stagenum = 1;

	public BKuzushi() {
		super(GAMEN_W, GAMEN_H, "ブロック崩し");
		try {
			startimage = ImageIO.read(getClass().getResource("start.jpg"));
		} catch (IOException e){
			e.printStackTrace();
		}
		frame1.setBackground(Color.BLACK);

		goStartGamen();
	}

	@Override
	public void initStageStart() {
		this.ball = new Ball();
		this.blocks = new Blocks("stage" + stagenum + ".txt");
		this.racket_x = GAMEN_W / 2;
	}

	@Override
	public void initStageClear() {


	}

	@Override
	public void initGameOver() {


	}

	@Override
	public void keyPressedGameMain(int keycode) {
		if (ball.isStart() == false && keycode == KeyEvent.VK_SPACE) ball.start();
		if (keycode == KeyEvent.VK_LEFT) leftkey = true;
		if (keycode == KeyEvent.VK_RIGHT) rightkey = true;

	}

	@Override
	public void keyReleasedGameMain(int keycode) {
		if (keycode == KeyEvent.VK_LEFT) leftkey = false;
		if (keycode == KeyEvent.VK_RIGHT) rightkey = false;

	}

	@Override
	public void runStartGamen(Graphics g) {
		g.drawImage(startimage, 0, 0, frame1);
	}

	@Override
	public void runStageStart(Graphics g) {
		g.clearRect(0, 0, GAMEN_W, GAMEN_H);
		g.setColor(Color.CYAN);
		g.setFont(new Font("Sanserif", Font.BOLD, 30));
		drawStringCenter("" + stagenum, 200, g);

	}

	@Override
	public void runStageClear(Graphics g) {
		g.setColor(Color.CYAN);
		g.setFont(new Font("Sanserif", Font.BOLD, 30));
		drawStringCenter("", 200, g);

	}

	@Override
	public void runGameMain(Graphics g) {
		if (leftkey == true) racket_x = racket_x - 8;
		if (rightkey == true) racket_x = racket_x + 8;
		if (getRacketLeft() < 0) racket_x = RACKET_W / 2;
		if (getRacketRight() > GAMEN_W) racket_x = GAMEN_W - RACKET_W / 2;
		if (ball.isStart() == false) ball.bx = racket_x;

		if (ball.getBottom() >= RACKET_Y && ball.getBottom() <= RACKET_Y + RACKET_H && ball.bx >= getRacketLeft() &&
				ball.bx <= getRacketRight()){
			ball.boundy();
		}
		if (blocks.isHit(ball.bx, ball.getTop()) == true ||
				blocks.isHit(ball.bx, ball.getBottom()) == true){
			ball.boundy();
		}
		if (blocks.isHit(ball.getLeft(), ball.by) == true ||
				blocks.isHit(ball.getRight(), ball.by) == true){
			ball.boundx();
		}

		if (ball.getBottom() > GAMEN_H) goGameOver();
		if (blocks.isNoBlock() == true) goStageClear();

		g.clearRect(0, 0, GAMEN_W, GAMEN_H);
		g.setColor(Color.RED);
		g.fillRect(getRacketLeft(), RACKET_Y, RACKET_W, RACKET_H);
		blocks.draw(g);
		ball.draw(g);
		}
		int getRacketLeft(){
			return racket_x - RACKET_W / 2;
		}
		int getRacketRight(){
			return racket_x + RACKET_W / 2;
		}

	@Override
	public void runGameOver(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Sanserif", Font.BOLD, 40));
		drawStringCenter("GAMEOVER", 220, g);
		g.setFont(new Font("Sanserif", Font.PLAIN, 24));
		drawStringCenter("PUSH R KEY", 300, g);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BKuzushi bk = new BKuzushi();

	}

}
