package daily1101;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sample extends Applet {

	Button myBtn;
	Image myImg;
	int flag;

	public void init(){
		add(myBtn = new Button("クリックすると画像が表示されます。") );
		myBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				flag = 1;
				repaint();
			}
		});

		myImg = getImage(getDocumentBase(), "hoge.jpg");
		flag = 0;
	}

	public void paint(Graphics g){
		if (flag == 0);
		else
			g.drawImage(myImg, 80, 80, this);
	}



	public static void main(String[] args) {


	}

}
