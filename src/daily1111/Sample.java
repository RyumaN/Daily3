package daily1111;

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

	Button myBtn; //ボタン
	TextField myTxtW; //体重入力用フィールド
	TextField myTxtH; //	身長入力用フィールド
	Label myLblW; //体重ラベル
	Label myLblH; //身長ラベル

	public void init(){
		//GUI部分の作成
		myLblW = new Label("体重");
		myTxtW = new TextField(6);


		myLblH = new Label("身長");
		myTxtH = new TextField(6);
		myBtn = new Button("表示");
		add(myLblH);
		add(myTxtH);
		add(myLblW);
		add(myTxtW);
		add(myBtn);

		//ボタンのイベント処理メソッドを定義
		myBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showStatus("身長は" + myTxtH.getText() + "cm, 体重は" + myTxtW.getText() + "kgです。");
			}
		});
	}

	public static void main(String[] args) {


	}

}
