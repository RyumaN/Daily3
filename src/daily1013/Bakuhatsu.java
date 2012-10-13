package daily1013;

import java.awt.image.BufferedImage;

public class Bakuhatsu extends GameChara {
	int waittime;

	public Bakuhatsu(int x, int y, BufferedImage img) {
		super(x, y, 0, 0, img, 192, 0, 48, 48);
		waittime = 10;

	}



	@Override
	public boolean isSotoNiDeta() {
		if (waittime < 0){
			return true;
		} else {
			return false;
		}

	}



	@Override
	public void move() {
		waittime = waittime - 1;


	}

}
