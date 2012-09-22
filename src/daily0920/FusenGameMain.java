package daily0920;

import java.awt.Color;
import java.awt.Font;
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
		g.drawImage(startimage, 0, 0, frame1);

	}

	@Override
	public void runStageStart(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 600, 400);
		g.setColor(Color.GREEN);
		g.setFont(new  Font("SansSerif", Font.BOLD, 60));
		drawStringCenter("ステージ開始", 220, g);

	}

	@Override
	public void runStageClear(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(new Font("SansSerif", Font.BOLD, 60));
		drawStringCenter("ステージクリア", 220, g);

	}

	@Override
	public void runGameMain(Graphics g) {


	}

	@Override
	public void runGameOver(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("SansSerif", Font.BOLD, 80));
		drawStringCenter("GAMEOVER", 220, g);
		g.setFont(new Font("SansSerif", Font.BOLD, 30));
		drawStringCenter("Push R Key", 280, g);
	}


	public static void main(String[] args) {


	}

}
