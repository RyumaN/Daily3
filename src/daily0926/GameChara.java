package daily0926;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public abstract class GameChara {
	public int chara_x, chara_y;
	int image_x, image_y, image_w, image_h;
	int atari_w, atari_h;
	BufferedImage image1;

	GameChara(int x, int y, int aw, int ah, BufferedImage img, int ix, int iy, int iw, int ih){
		chara_x = x; chara_y = y;
		atari_w = aw; atari_h = ah;
		image1 = img;

		image_x = ix;
		image_y = iy;
		image_w = iw;
		image_h = ih;
	}

	public void draw(Graphics g, ImageObserver io){
		g.drawImage(image1, chara_x, chara_y, chara_x + image_w, chara_y + image_h,
				image_x, image_y, image_x + image_w, image_y + image_h, io);
		move();
	}

	public abstract void move();


	public int getx1(){
		return chara_x + (image_w - atari_w) / 2;
	}

	public int gety1(){
		return chara_y + (image_h - atari_h) / 2;
	}

	public int getx2(){
		return chara_x + (image_w + atari_w) / 2;
	}

	public int gety2(){
		return chara_y + (image_h + atari_h) / 2;
	}

	public boolean isAtari(GameChara aite){

		if (aite.getx2() > getx1() && getx2() > aite.getx1() &&
				aite.gety2() > gety1() && gety2() > aite.gety1()){
			return true;
		}else{
			return false;
		}
	}
}