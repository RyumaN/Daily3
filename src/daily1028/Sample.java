package daily1028;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Sample extends Applet {

	public void paint(Graphics g){
		int count;
		Image img;

		img = getImage(getDocumentBase(), "hoge.jpg");
		for (count = 0; count < 150; count += 30){
			g.drawImage(img, 90, 15 + count, this);
		}
	}

	public static void main(String[] args) {


	}

}
