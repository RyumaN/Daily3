package daily1027;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Sample extends Applet {

	//パラメーターを使う
	String name;
	public void init(){
		name = getParameter("imgName");
	}

	public void paint(Graphics g){
		Image img;
		img = getImage(getDocumentBase(), name);
		g.drawImage(img, 90, 90, this);
	}

	public static void main(String[] args) {


	}

}
