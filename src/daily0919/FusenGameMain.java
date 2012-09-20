package daily0919;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;

import daily0917.GameHoneGumi;

public class FusenGameMain extends GameHoneGumi {
	int cy = 200;
	boolean spkey = false;
	BufferedImage backimage, pimage, eimage, startimage;
	double speed;
	Karasu[] karasus = new Karasu[15];
	Clip clip1, clip2;
	long stagetimer;
	int tekikazu = 1;

	public FusenGameMain() {
		super(600, 400, "風船ゲーム");

		try{
			pimage = ImageIO.read(getClass().getResource("fusenman.png"));
			eimage = ImageIO.read(getClass().getResource("karasu.png"));
			backimage = ImageIO.read(getClass().getResource("back.jpg"));
			startimage = ImageIO.read(
					getClass().getResource("f_startgamen.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		clip1 = otoYomikomi("fall01.wav");
		clip2 = otoYomikomi("power05.wav");
		midiYomikomi("toccata.mid");

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


	}

	@Override
	public void runGameOver(Graphics g) {


	}


	public static void main(String[] args) {


	}

}
