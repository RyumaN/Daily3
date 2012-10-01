package daily1001;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import daily0917.GameHoneGumi;

public class UtyuuShoot extends GameHoneGumi {
	public static final int GAMEN_W = 640; //画面の幅
	public static final int GAMEN_H = 480; //画面の高さ

	BufferedImage charaimage;
	Jiki jiki;
	boolean upkey = false, downkey = false, leftkey = false, rightkey = false,
			shiftkey = false;
	ArrayList jikitamas = new ArrayList();
	int rensya = 0;


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
		if (key == KeyEvent.VK_SHIFT) shiftkey = true;

	}

	@Override
	public void keyReleasedGameMain(int key) {
		if (key == KeyEvent.VK_UP) upkey = false;
		if (key == KeyEvent.VK_DOWN) downkey = false;
		if (key == KeyEvent.VK_LEFT) leftkey = false;
		if (key == KeyEvent.VK_RIGHT) rightkey = false;
		if (key == KeyEvent.VK_SHIFT) shiftkey = false;

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
		jiki.move(upkey, downkey, leftkey, rightkey); //自機移動

		if (shiftkey == true && rensya == 0){
			jikitamas.add(new JikiTama(jiki.chara_x + 36, jiki.chara_y + 24, charaimage));
			rensya = 10;
		} //自弾発射


		if (rensya > 0) rensya = rensya - 1;

		jiki.draw(g, frame1); //表示
		for (int i = 0; i < jikitamas.size(); i = i +1){
			JikiTama jt = (JikiTama) jikitamas.get(i);
			jt.draw(g, frame1);
		}


	}

	@Override
	public void runGameOver(Graphics g) {


	}


	public static void main(String[] args) {
		UtyuuShoot us = new UtyuuShoot();

	}

}
