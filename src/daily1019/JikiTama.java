package daily1019;

import java.awt.image.BufferedImage;


public class JikiTama extends GameChara {

	public JikiTama(int x, int y, BufferedImage img) {
		super(x, y, 12, 12, img, 0, 96, 12, 12);
	}

	public void move() {
		chara_x = chara_x + 12;
	}

}
