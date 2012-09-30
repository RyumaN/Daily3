package daily0925;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public abstract class GameChara {
	public int chara_x, chara_y;
	int image_x, image_y, image_w, image_h;
	BufferedImage image1;

	GameChara(int x, int y, BufferedImage img, int ix, int iy, int iw, int ih){
		chara_x = x;
		chara_y = y;

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
}
