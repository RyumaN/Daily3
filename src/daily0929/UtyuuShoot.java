package daily0929;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import daily0917.GameHoneGumi;

public class UtyuuShoot extends GameHoneGumi {
	public static final int GAMEN_W = 640; //画面の幅
	public static final int GAMEN_H = 480; //画面の高さ

	BufferedImage charaimage;
	Jiki jiki;
	boolean upkey = false, downkey = false, leftkey = false, rightkey = false;

	public UtyuuShoot() {
		super(GAMEN_W, GAMEN_H, "宇宙シューティング");

		try {
			charaimage = ImageIO.read(getClass().getResource("shooting.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		jiki = new Jiki(GAMEN_W / 2, GAMEN_H / 2, charaimage);

		goStartGamen();

	}

	@Override
	public void initStageStart() {


	}

	@Override
	public void initStageClear() {


	}

	@Override
	public void initGameOver() {


	}

	@Override
	public void keyPressedGameMain(int key) {
		if (key == KeyEvent.VK_UP) upkey = true;
		if (key == KeyEvent.VK_DOWN) downkey = true;
		if (key == KeyEvent.VK_LEFT) leftkey = true;
		if (key == KeyEvent.VK_RIGHT) rightkey = true;

	}

	@Override
	public void keyReleasedGameMain(int key) {
		if (key == KeyEvent.VK_UP) upkey = false;
		if (key == KeyEvent.VK_DOWN) downkey = false;
		if (key == KeyEvent.VK_LEFT) leftkey = false;
		if (key == KeyEvent.VK_RIGHT) rightkey = false;

	}

	@Override
	public void runStartGamen(Graphics g) {


	}

	@Override
	public void runStageStart(Graphics g) {


	}

	@Override
	public void runStageClear(Graphics g) {


	}

	@Override
	public void runGameMain(Graphics g) {
		g.clearRect(0, 0, GAMEN_W, GAMEN_H); //ゲーム画面消去
		jiki.move(upkey, downkey, leftkey, rightkey);
		jiki.draw(g, frame1);


	}

	@Override
	public void runGameOver(Graphics g) {


	}


	public static void main(String[] args) {
		UtyuuShoot us = new UtyuuShoot();

	}

}
