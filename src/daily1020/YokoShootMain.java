package daily1020;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;

import daily0917.GameHoneGumi;


public class YokoShootMain extends GameHoneGumi {
	public static final int GAMEN_W = 624;
	public static final int GAMEN_H = 480;

	BufferedImage charaimage, tikeiimage, startimage;
	Jiki jiki;
	boolean upkey, downkey, rightkey, leftkey, shiftkey;
	ArrayList jikitamas, tekis, tekitamas, bakuhatsus;
	int rensya = 0;
	int tekitamarate = 100;
	int score, highscore, stagenum = 1;
	Clip seClip1, seClip2, seClip3;
	TikeiMap tikeimap;

	public YokoShootMain() {
		super(GAMEN_W, GAMEN_H, "横シューティング");
		frame1.setBackground(Color.BLACK);

		try {
			charaimage = ImageIO.read(getClass().getResource("chara01.PNG"));
			tikeiimage = ImageIO.read(getClass().getResource("tikeidata01.PNG"));
			startimage = ImageIO.read(getClass().getResource("start.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		seClip1 = otoYomikomi("burst01.wav");
		seClip2 = otoYomikomi("fm005.wav");
		seClip3 = otoYomikomi("smoke03.wav");
		midiYomikomi("AW.MID");

		goStartGamen();
	}

	public void initStageStart() {
		jiki = new Jiki(GAMEN_W  /2,GAMEN_H / 2,charaimage);
		jikitamas = new ArrayList();
		tekis = new ArrayList();
		tekitamas = new ArrayList();
		bakuhatsus = new ArrayList();
		upkey = false; downkey = false; rightkey = false;
		leftkey = false;
		tikeimap = new TikeiMap(tikeiimage, "001.map", "001.pat");

		midiseq.setTickPosition(0);
		midiseq.start();
	}

	public void initStageClear() {

		score = score + stagenum * 100;
		midiseq.stop();
	}

	public void initGameOver() {
		if (score > highscore) highscore = score;
		score = 0;
		midiseq.stop();
		seClip3.setFramePosition(0);
		seClip3.start();
	}

	public void keyPressedGameMain(int key) {
		if (key==KeyEvent.VK_UP) 	upkey = true;
		if (key==KeyEvent.VK_DOWN) 	downkey = true;
		if (key==KeyEvent.VK_LEFT) 	leftkey = true;
		if (key==KeyEvent.VK_RIGHT) rightkey=true;
		if (key==KeyEvent.VK_SHIFT) shiftkey = true;
	}
	public void keyReleasedGameMain(int key) {
		if (key==KeyEvent.VK_UP) 	upkey = false;
		if (key==KeyEvent.VK_DOWN) 	downkey = false;
		if (key==KeyEvent.VK_LEFT) 	leftkey = false;
		if (key==KeyEvent.VK_RIGHT) rightkey = false;
		if (key==KeyEvent.VK_SHIFT) shiftkey = false;
	}

	public void runStartGamen(Graphics g) {
		g.drawImage(startimage, 0, 0, frame1);
	}

	public void runStageStart(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GAMEN_W, GAMEN_H);
		g.setColor(Color.CYAN);
		g.setFont(new Font("SansSerif", Font.BOLD, 60));
		drawStringCenter("ステージ開始"+ stagenum, 200, g);
		drawStringCenter("", 280, g);
	}

	public void runStageClear(Graphics g) {
		g.setColor(Color.CYAN);
		g.setFont(new Font("SansSerif", Font.BOLD, 60));
		drawStringCenter("ステージクリア", 200, g);
	}

	public void runGameMain(Graphics g) {
		g.clearRect(0, 0, GAMEN_W, GAMEN_H);


		jiki.move(upkey, downkey, leftkey, rightkey);


		if (shiftkey == true && rensya == 0){
			jikitamas.add(new JikiTama(jiki.chara_x + 36,
					jiki.chara_y + 24, charaimage));
			rensya = 10;
		}
		if (rensya > 0) rensya = rensya - 1;


		ArrayList al = tikeimap.getNewTeki(charaimage);
		if (al.size() > 0) tekis.addAll(al);


		Iterator it = tekis.iterator();
		while(it.hasNext() == true){
			Teki tk = (Teki)it.next();
			if (Math.random() * tekitamarate < 1){
				tekitamas.add(new TekiTama(tk.chara_x - 8, tk.chara_y + 24,
						jiki.chara_x, jiki.chara_y, charaimage));
				seClip2.stop();
				seClip2.setFramePosition(0);
				seClip2.start();
			}
		}


		tikeimap.draw(g, frame1);
		jiki.draw(g, frame1);
		it = jikitamas.iterator();
		while (it.hasNext() == true){
			JikiTama jt = (JikiTama)it.next();
			jt.draw(g, frame1);
			if (jt.isSotoNiDeta() == true) it.remove();
		}
		it = tekis.iterator();
		while (it.hasNext() == true){
			Teki tk = (Teki)it.next();
			tk.draw(g, frame1);
			if(tk.isSotoNiDeta() == true) it.remove();
		}
		it = tekitamas.iterator();
		while (it.hasNext() == true){
			TekiTama tm = (TekiTama)it.next();
			tm.draw(g, frame1);
			if (tm.isSotoNiDeta() == true) it.remove();
		}
		it = bakuhatsus.iterator();
		while (it.hasNext() == true){
			Bakuhatsu bh = (Bakuhatsu)it.next();
			bh.draw(g, frame1);
			if (bh.isSotoNiDeta() == true) it.remove();
		}


		it = tekis.iterator();
		while (it.hasNext() == true){
			Teki tk = (Teki)it.next();
			Iterator it2 = jikitamas.iterator();
			while (it2.hasNext() == true){
				JikiTama jt = (JikiTama)it2.next();
				if (tk.isAtari(jt) == true) {
					bakuhatsus.add(new Bakuhatsu(tk.chara_x, tk.chara_y, charaimage));
					it.remove();
					it2.remove();
					score = score + 10;
					seClip1.stop();
					seClip1.setFramePosition(0);
					seClip1.start();
					break;
				}
			}
		}

		it = tekis.iterator();
		while (it.hasNext() == true){
			Teki tk = (Teki)it.next();
			if (tk.isAtari(jiki)){
				goGameOver();
				break;
			}
		}
		it = tekitamas.iterator();
		while (it.hasNext() == true){
			TekiTama tt = (TekiTama)it.next();
			if(tt.isAtari(jiki)){
				goGameOver();
				break;
			}
		}

		if (tikeimap.isAtari(jiki.getx1(), jiki.gety1()) == true ||
				tikeimap.isAtari(jiki.getx2(), jiki.gety2()) == true) {
		    goGameOver();
		}


		if (tikeimap.isMapEnd() == true) goStageClear();


		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif", Font.PLAIN, 10));
		g.drawString("SC:"+score + " HI:"+ highscore , 2, 10);

	}

	public void runGameOver(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("SansSerif", Font.BOLD, 80));
		drawStringCenter("GAMEOVER", 220, g);
		g.setFont(new Font("SansSerif", Font.PLAIN, 24));
		drawStringCenter("PUSH  R  KEY", 300, g);
	}

	public static void main(String[] args) {
		YokoShootMain usm = new YokoShootMain();
	}
}
