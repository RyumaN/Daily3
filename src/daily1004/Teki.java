package daily1004;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Teki extends GameChara {

	PatternReader preader;
	int hanten;

	public Teki(int x, int y, BufferedImage img, int ptnum, String patstr) {
		super(x, y, 40, 40, img, 48 + ptnum * 48, 0, 48, 48);

		preader = new PatternReader(patstr);
		if (chara_y > UtyuuShoot.GAMEN_H / 2){
			hanten = - 1;
		} else {
			hanten = 1;
		}

	}

	@Override
	public void move() {

		Point movexy = preader.next();
		chara_x = chara_x + movexy.x;
		chara_y = chara_y + movexy.y * hanten;

	}

}
