package daily1019;

import java.awt.Point;
import java.awt.image.BufferedImage;


public class Teki extends GameChara {
	PatternReader preader;
	int hanten;

	public Teki(int x, int y, BufferedImage img, int ptnum, String patstr) {
		super(x, y, 40, 40, img, ptnum * 48, 48, 48, 48);

		preader = new PatternReader(patstr);
		if (chara_y > YokoShootMain.GAMEN_H / 2) {
			hanten = - 1;
		} else {
			hanten = 1;
		}

	}

	public void move() {
		Point movexy = preader.next();
		chara_x = chara_x + movexy.x;
		chara_y = chara_y + movexy.y * hanten;
	}
}
