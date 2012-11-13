package daily1113;

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

import javax.swing.JFrame;

public class Sample extends Applet {
	Button btnPrev;
	Button btnNext;
	Button btnFirst;
	Button btnLast;
	Label lblTitle;
	Panel myPnl;

	Image[] myImg;
	String[] myComment;

	int crntNo;
	int maxNo;

	public void init(){
		int count;

		maxNo = Integer.parseInt(getParameter("NumImage"));
		myImg = new Image[maxNo];
		myComment = new String[maxNo];
		crntNo = 0;

		for (count = 0; count < maxNo; count ++){
			myImg[count] = getImage(getDocumentBase(), "image" + count + ".gif");
			myComment[count] = getParameter("Message" + count);
		}

		btnFirst = new Button("<<");
		btnFirst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				crntNo = 0;
				repaint();
			}
		});

		btnPrev = new Button("<");
		btnPrev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (crntNo > 0)
					crntNo = crntNo - 1;
					repaint();
			}
		});

		btnNext = new Button(">");
		btnNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (crntNo < maxNo - 1)
					crntNo = crntNo + 1;
					repaint();
			}
		});

		btnLast = new Button(">>");
		btnLast.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				crntNo = maxNo - 1;
				repaint();
			}
		});

		lblTitle = new Label("", Label.CENTER);

		myPnl = new Panel();
		myPnl.setLayout(new GridLayout(1, 4));
		myPnl.add(btnFirst);
		myPnl.add(btnPrev);
		myPnl.add(btnNext);
		myPnl.add(btnLast);

		setLayout(new BorderLayout());
		add("North", lblTitle);
		add("South", myPnl);

	}

		public void paint(Graphics g){
			g.drawImage(myImg[crntNo], 0, 25, this);
			lblTitle.setText("No." + (crntNo + 1) + ":" + myComment[crntNo]);
		}



	public static void main(String[] args) {



	}

}