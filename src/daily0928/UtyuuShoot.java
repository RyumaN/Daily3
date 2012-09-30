package daily0928;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import daily0917.GameHoneGumi;

public class UtyuuShoot extends GameHoneGumi {
	public static final int GAMEN_W = 640; //画面の幅
	public static final int GAMEN_H = 480; //画面の高さ

	BufferedImage charaimage;
	Jiki jiki;

	public UtyuuShoot() {
		super(GAMEN_W, GAMEN_H, "宇宙シューティング");

		try {
			charaimage = ImageIO.read(getClass().getResource("shooting.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		jiki = new Jiki(0, 0, charaimage);

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
	public void keyPressedGameMain(int keycode) {


	}

	@Override
	public void keyReleasedGameMain(int keycode) {


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
		jiki.draw(g, frame1);


	}

	@Override
	public void runGameOver(Graphics g) {


	}


	public static void main(String[] args) {
		UtyuuShoot usm = new UtyuuShoot();

	}

}
