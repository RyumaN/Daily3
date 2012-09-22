package daily0922;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
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
	int jikikazu = 3;
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
		cy = 200;
		speed = 0;
		spkey = false;
		for(int i = 0; i < tekikazu; i = i+1){
			karasus[i] = new Karasu(eimage, i);
		}
		midiseq.setTickPosition(0);
		midiseq.start();
		stagetimer = System.currentTimeMillis();
	}

	@Override
	public void initStageClear() {
		midiseq.stop();
		tekikazu = tekikazu + 1;
		if(tekikazu > 15)
			tekikazu = 1;
	}

	@Override
	public void initGameOver() {
		jikikazu = jikikazu - 1;
		if(jikikazu < 1)
			tekikazu = 1;
		midiseq.stop();
		clip1.setFramePosition(0);
		clip1.start();

	}

	@Override
	public void keyPressedGameMain(int keycode) {
		if(keycode == KeyEvent.VK_SPACE){
			spkey = true;
		}

	}

	@Override
	public void keyReleasedGameMain(int keycode) {
		if(keycode == KeyEvent.VK_SPACE){
			spkey = false;
		}

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

		if(spkey == true){
			speed = speed - 0.25;
			if(clip2.isRunning() == false){
				clip2.setFramePosition(0);
				clip2.start();
			}
		}else{
			speed = speed + 0.25;
		}

		if(speed < -6) speed = -6;
		if(speed > 6) speed = 6;
		cy = cy + (int)speed;
		if(cy < 0) cy = 0;
		if(cy > 448)
			goGameOver();

		g.drawImage(backimage, 0, 0, frame1);
		g.drawImage(pimage, 270, cy, frame1);

		for(int i = 0; i<tekikazu; i = i + 1){
			karasus[i].draw(g, frame1);
		}

		for(int i = 0; i < tekikazu; i = i +1){
			if(karasus[i].isAtari(270, cy) == true)
				goGameOver();
		}

		if(System.currentTimeMillis() - stagetimer > 40000)
			goStageClear();
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
