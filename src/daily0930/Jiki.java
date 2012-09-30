package daily0930;

import java.awt.image.BufferedImage;

public class Jiki extends GameChara {

	public Jiki(int x, int y, BufferedImage img) {
		super(x, y, 12, 12, img, 0, 0, 48, 48);

	}

	@Override
	public void move() {

	}

	public void move(boolean up, boolean down, boolean left, boolean right){
		if (up == true) chara_y = chara_y - 8;
		if (down == true) chara_y = chara_y + 8;
		if (left == true) chara_x = chara_x - 8;
		if (right == true) chara_x = chara_x + 8;

		if (chara_y < 0) chara_y = 0;
		if (chara_x < 0) chara_x = 0;
		if (chara_y >UtyuuShoot.GAMEN_H - 48)
				chara_y = UtyuuShoot.GAMEN_H - 48;
		if (chara_x > UtyuuShoot.GAMEN_W - 48)
				chara_x = UtyuuShoot.GAMEN_W - 48;
	}


}
