package daily1103;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sample extends Applet {

	Button myBtn;
	Label myLbl;

	public void init(){
		setBackground(Color.pink);
		setLayout(new BorderLayout());
		myBtn = new Button("クリックしてね");
		myLbl = new Label("", Label.CENTER);
		add("North", myBtn);
		add("Center", myLbl);

		myBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				repaint();
			}
		});

	}

	public void paint(Graphics g){
		myLbl.setText("クリックしましたね");
	}



	public static void main(String[] args) {


	}

}
