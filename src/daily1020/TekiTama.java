package daily1020;

import java.awt.image.BufferedImage;


public class TekiTama extends GameChara {
	int dx,dy;

	public TekiTama(int x, int y, int jx, int jy, BufferedImage img) {
		super(x, y, 12, 12, img, 12, 96, 12, 12);
		double d = Math.sqrt((jx-x) * (jx-x) + (jy-y) * (jy-y));
		if (d != 0){
			dx = (int)Math.round((jx-x) / d * 6.0);
			dy = (int)Math.round((jy-y) / d * 6.0);
		}
	}

	public void move() {
		chara_x = chara_x + dx;
		chara_y = chara_y + dy;
	}
}
