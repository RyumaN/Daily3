package daily1108;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Sample extends Applet {

	Image myImg1;
	Image myImg2;
	Image myImg3;
	MediaTracker myMt;

public void init(){
	myImg1 = getImage(getDocumentBase(), "hoge1.gif");
	myImg2 = getImage(getDocumentBase(), "hoge2.gif");
	myImg3 = getImage(getDocumentBase(), "hoge3.gif");

	myMt = new MediaTracker(this);
	myMt.addImage(myImg1, 0);
	myMt.addImage(myImg2, 0);
	myMt.addImage(myImg3, 0);

	try {
		myMt.waitForID(0);
	} catch(InterruptedException e){

	}
}

	public void paint(Graphics g){
		if (myMt.checkID(0)){
			g.drawImage(myImg1, 50, 50, this);
		}
	}
	public static void main(String[] args) {


	}

}
