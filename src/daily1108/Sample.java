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
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Sample extends Applet {

	int x;
	int y;
	int myAnswer;
	String myStr;

	public void init(){
		try{
			x = 1;
			y = 0;
			myAnswer = x / y;
		} catch (ArithmeticException ae){
			myStr = ae.getMessage();
		}
	}

	public void paint(Graphics g){
		g.drawString(myStr, 50, 50);
	}

	public static void main(String[] args) {


	}

}
