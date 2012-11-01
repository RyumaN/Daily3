package daily1102;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sample extends Applet {

	Button btn1;
	Button btn2;
	Button btn3;
	Image[] myImg;
	Panel myPanel1;
	int flag;

	public void init(){
		//背景色の設定
		//setBackground(Color.white);

		//画像のロード
		myImg = new Image[3];
		myImg[0] = getImage(getDocumentBase(), "hoge1.jpg");
		myImg[1] = getImage(getDocumentBase(), "hoge2.jpg");
		myImg[2] = getImage(getDocumentBase(), "hoge3.jpg");

		//レイアウト用パネルの作成
		myPanel1 = new Panel();

		//パネルのレイアウト方式を設定
		myPanel1.setLayout(new GridLayout(1, 3));

		//パネルの上にボタンを載せる
		myPanel1.add(btn1 = new Button("緑色のボタン"));
		myPanel1.add(btn2 = new Button("赤色のボタン"));
		myPanel1.add(btn3 = new Button("黄色のボタン"));

		//ボーダーレイアウトを設定
		setLayout(new BorderLayout());

		//画像消去ボタンを作成
		//add(btnClear = new Button("画像を消す"));

		//パネルをNorth(上部)に配置
		add("North", myPanel1);

		//ボタンのイベント処理メソッドを定義
			btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				flag = 1;
				repaint();
			}
		});

			btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					flag = 2;
					repaint();
				}
			});

			btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					flag = 3;
					repaint();
				}
			});

			flag = 0;
	}

	public void paint(Graphics g){
		switch (flag) {

		case 0:
			break;

		case 1:
			g.drawImage(myImg[0], 140, 80, this);
			break;

		case 2:
			g.drawImage(myImg[1], 140, 80, this);
			break;

		case 3:
			g.drawImage(myImg[2], 140, 80, this);
			break;
		}

	}



	public static void main(String[] args) {


	}

}
