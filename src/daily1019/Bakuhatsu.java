
package daily1019;

import java.awt.image.BufferedImage;


public class Bakuhatsu extends GameChara {
	int waittime;

	public Bakuhatsu(int x, int y, BufferedImage img) {
		super(x, y, 0, 0, img, 48, 0, 48, 48);
		waittime = 10;
	}
	public boolean isSotoNiDeta(){
		if (waittime < 0){
			return true;
		} else {
			return false;
		}
	}
	public void move() {
		waittime = waittime-1;
	}
}
