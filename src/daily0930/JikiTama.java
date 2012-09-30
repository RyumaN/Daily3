package daily0930;

import java.awt.image.BufferedImage;

public class JikiTama extends GameChara {

	public JikiTama(int x, int y, int aw, int ah, BufferedImage img, int ix,
			int iy, int iw, int ih) {
		super(x, y, 12, 12, img, 240, 0, 12, 12);

	}

	@Override
	public void move() {
		chara_x = chara_x + 12;

	}

}
