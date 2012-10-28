package daily1029;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Sample extends Applet {

	public void paint(Graphics g){
		int count;
		int flag;
		Image img1;
		Image img2;

		img1 = getImage(getDocumentBase(), "hoge1.jpg");
		img2 = getImage(getDocumentBase(), "hoge2.jpg");
		flag = 0;

		for (count = 0; count < 150; count += 30){
			if (flag % 2 == 0)
			g.drawImage(img1, 90, 15 + count, this);
			else
				g.drawImage(img2, 90, 15 + count, this);
			flag++;
		}
	}

	public static void main(String[] args) {


	}

}
