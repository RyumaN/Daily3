package daily1024;

import java.applet.Applet;
import java.awt.Graphics;

public class Sample extends Applet {

	public void paint(Graphics g){
		g.drawLine(0, 0, 200, 200);//直線を描画する
		g.drawRect(10, 10, 180, 180);//四角形を描画する
		g.drawOval(50, 50, 100, 100);//円を描画する
	}


	public static void main(String[] args) {


	}

}
