package daily1109;

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

	Button[] myBtn;
	Panel myPnl;
	int imgNo;
	Image[] img;
	MediaTracker myMt;

	public void init(){
		//counter変数
		int count;

		//イメージ番号の初期化
		imgNo = 0;

		//画像の読み込み
		img = new Image[3];
		for (count = 0; count <= 2; count ++){
			img[count] = getImage(getDocumentBase(), "hoge" + (count + 1) + ".gif");
		}

		//メディアトラッカーオブジェクトの作成
		myMt = new MediaTracker(this);

		//メディアトラッカーに画像を追加
		for (count = 0; count <= 2; count ++){
			myMt.addImage(img[count], 0);
		}

		//メディアトラッカー上の画像を全て読み込む
		try {
			myMt.waitForID(0);
		} catch (InterruptedException e){}

		//ボタンの作成
		myBtn = new Button[3];
		myBtn[0] = new Button("hoge1");
		myBtn[1] = new Button("hoge2");
		myBtn[2] = new Button("hoge3");

		//パネルの作成
		myPnl = new Panel();

		//パネルのレイアウト作成設定
		myPnl.setLayout(new GridLayout(1, 3));

		//パネルにボタンを追加
		for (count = 0; count <= 2; count ++){
			myPnl.add(myBtn[count]);
		}

		//アプレット全体のレイアウトをボーダーレイアウトに設定
		setLayout(new BorderLayout());

		//パネルをアプレット上部に配置
		add("North", myPnl);

		//ボタンのクリックイベント処理メソッド定義
		myBtn[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				imgNo = 0;
				repaint();
			}
		});

		myBtn[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				imgNo = 1;
				repaint();
			}
		});

		myBtn[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				imgNo = 2;
				repaint();
			}
		});
	}

	/*メディアトラッカー上の画像が全て読み込まれているかを確認し
	 	読み込まれていたら画像を表示
	 */
	public void paint(Graphics g){
		if (myMt.checkID(0)){
			g.drawImage(img[imgNo], 110, 80, this);
		}
	}

	public static void main(String[] args) {


	}

}
