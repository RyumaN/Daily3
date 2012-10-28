package daily1025;

import java.applet.Applet;
import java.awt.Graphics;

public class Sample extends Applet {

	public void paint(Graphics g){

		//家
		g.drawLine(15, 150, 25, 130);
		g.drawLine(25, 130, 65, 130);
		g.drawLine(65, 130, 75, 150);
		g.drawLine(15, 150, 75, 150);
		g.drawRect(25, 150, 40, 30);

		//窓
		g.drawRect(30, 155, 16, 10);
		g.drawLine(38, 155, 38, 165);

		//山
		g.drawLine(0, 120, 45, 80);
		g.drawLine(45, 80, 120, 110);
		g.drawLine(120, 110, 180, 75);
		g.drawLine(180, 75, 20, 85);

		//月
		g.drawOval(145, 20, 25, 25);

		//地面
		g.drawLine(0, 175, 25, 175);
		g.drawLine(65, 175, 200, 175);

	}


	public static void main(String[] args) {


	}

}
