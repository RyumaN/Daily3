package daily1004;

import java.awt.image.BufferedImage;

public class JikiTama extends GameChara {

	public JikiTama(int x, int y, BufferedImage img) {
		super(x, y, 12, 12, img, 240, 0, 12, 12);

	}

	@Override
	public void move() {
		chara_x = chara_x + 12;

	}

}
