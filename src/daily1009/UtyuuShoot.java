package daily1009;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

import daily0917.GameHoneGumi;

public class UtyuuShoot extends GameHoneGumi {
	public static final int GAMEN_W = 640; //画面の幅
	public static final int GAMEN_H = 480; //画面の高さ
	public static final int TEKI_RATE = 10; //敵の出現率
	public static final String[] TEKIPATTERN = {"-4, 0, 60, 0, 0, 30",
		"-2, -4, 10, -2, -3, 5, -2, -2, 5, -2, 0, 5, -2, 2, 5, -2, 3, 5, -2, 4, 10, -2, 3, 5, -2, 2, 5, -2, 0, 5, -2, -2, 5, -2, -3, 5",
		"-2, 0, 10, -8, 0, 60, -2, 0, 10, 4, 3, 60"};

	BufferedImage charaimage;
	Jiki jiki;
	boolean upkey = false, downkey = false, leftkey = false, rightkey = false,
			shiftkey = false;
	ArrayList jikitamas = new ArrayList();
	ArrayList tekis = new ArrayList();
	ArrayList tekitamas = new ArrayList();
	int rensya = 0;
	int tekikazu = 6;
	int tekitamarate = 150;


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

		//ゲーム画面消去
		g.clearRect(0, 0, GAMEN_W, GAMEN_H);

		//自機移動
		jiki.move(upkey, downkey, leftkey, rightkey);

		//自弾発射
		if (shiftkey == true && rensya == 0){
			jikitamas.add(new JikiTama(jiki.chara_x + 36, jiki.chara_y + 24, charaimage));
			rensya = 10;
		}
		if (rensya > 0) rensya = rensya - 1;

		//敵出現
		if (tekis.size() < tekikazu && Math.random() * TEKI_RATE < 1){
			int ptnum = (int) (Math.random() * 3);
			int ty = (int) (Math.random() * 23) * 20;
			tekis.add(new Teki(GAMEN_W, ty, charaimage, ptnum, TEKIPATTERN[ptnum]));
		}

		//敵弾発射
		Iterator it = tekis.iterator();
		while (it.hasNext() == true){
			Teki tk = (Teki) it.next();
			if (Math.random() * tekitamarate < 1){
				tekitamas.add(new TekiTama(tk.chara_x - 8, tk.chara_y + 24, jiki.chara_x, jiki.chara_y, charaimage));
			}
		}


		//表示,削除
		jiki.draw(g, frame1);
		it = jikitamas.iterator();
		while (it.hasNext() == true){
			JikiTama jt = (JikiTama) it.next();
			jt.draw(g, frame1);
			if (jt.isSotoNiDeta() == true) it.remove();
		}

		it = tekis.iterator();
		while (it.hasNext() == true){
			Teki tk = (Teki) it.next();
			tk.draw(g, frame1);
			if (tk.isSotoNiDeta() == true)
				it.remove();
		}

		it = tekitamas.iterator();
		while (it.hasNext() == true){
			TekiTama tm = (TekiTama) it.next();
			tm.draw(g, frame1);
			if (tm.isSotoNiDeta() == true)
				it.remove();
		}

		//当たり判定(敵と自機弾)
		it = tekis.iterator();
		while (it.hasNext() == true){
			Teki tk = (Teki) it.next();
			Iterator it2 = jikitamas.iterator();
			while (it2.hasNext() == true){
				JikiTama jt = (JikiTama) it2.next();
				if (tk.isAtari(jt) == true){
					it.remove();
					it2.remove();
					break;
				}
			}
		}

		//当たり判定(自機と敵、敵弾)
		it = tekis.iterator();
		while (it.hasNext() == true){
			Teki tk = (Teki) it.next();
			if (tk.isAtari(jiki)){
				goGameOver();
				break;

			}
		}
		it = tekitamas.iterator();
		while (it.hasNext() == true){
			TekiTama tt = (TekiTama) it.next();
			if (tt.isAtari(jiki)){
				goGameOver();
				break;
			}
		}


	}

	@Override
	public void runGameOver(Graphics g) {


	}


	public static void main(String[] args) {
		UtyuuShoot us = new UtyuuShoot();

	}

}
