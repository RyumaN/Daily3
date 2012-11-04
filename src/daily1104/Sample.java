package daily1104;

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

public class Sample extends Applet {

	Button myBtn;
	Label myLbl;
	TextField myTxt;
	Panel myPnl;

	public void init(){

		//パネルを作成
		myPnl = new Panel();

		//パネルにレイアウトを設定
		myPnl.setLayout(new GridLayout(2, 1));

		//ボタンを作成
		myBtn = new Button("名前を入力してクリック");

		//テキストフィールドを作成
		myTxt = new TextField();
		myTxt.setText("ここに名前を入力");

		//パネルに部品を追加
		myPnl.add(myTxt);
		myPnl.add(myBtn);

		//全体をボーダーレイアウトに設定
		setLayout(new BorderLayout());

		//ラベルを作成
		myLbl = new Label("", Label.CENTER);

		//ボタンを配置
		add("North", myPnl);
		add("Center", myLbl);

		//ボタンのイベント処理メソッドを定義
		myBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				repaint();
			}
		});

	}

	public void paint(Graphics g){
		myLbl.setText(myTxt.getText() + "さん、こんにちわ");
	}



	public static void main(String[] args) {


	}

}
