package daily1030;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Sample extends Applet {

	public void paint(Graphics g){

		Image[] img;
		img = new Image[3];

		img[0] = getImage(getDocumentBase(), "hoge1.jpg");
		img[1] = getImage(getDocumentBase(), "hoge2.jpg");
		img[2] = getImage(getDocumentBase(), "hoge3.jpg");

		g.drawImage(img[0], 20, 90, this);
		g.drawImage(img[1], 80, 90, this);
		g.drawImage(img[2], 140, 90, this);

	}

	public static void main(String[] args) {


	}

}
