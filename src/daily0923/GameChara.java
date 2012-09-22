package daily0923;

import java.awt.image.BufferedImage;

public class GameChara {
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
}
