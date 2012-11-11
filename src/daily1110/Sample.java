package daily1110;

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

public class Sample extends Applet implements Runnable{

	Image[] myImg; //イメージオブジェクト
	int myNo; //画像番号
	MediaTracker myMt; //メディアトラッカーオブジェクト
	Thread myTh; //スレッド

	public void init(){
		int count; //ループカウンター

		//各変数の初期化
		myImg = new Image[3];
		myNo = 0;
		myMt = new MediaTracker(this);
		myTh = null;

		//画像を読み込んでメディアトラッカーに追加
		for (count = 0; count < 3; count ++){
			myImg[count] = getImage(getDocumentBase(), "image" + count + ".gif");
			myMt.addImage(myImg[count], 0);
		}
	}

	public void start(){
		//スレッドのインスタンスを作成しスレッドを始動
		if (myTh == null){
			myTh = new Thread(this);
			myTh.start();

		}
	}

	public void run(){
		//画像のロードを開始
		try {
			myMt.waitForID(0);
		} catch (InterruptedException e) {

		}

		//画像番号を1増加し、3(存在しない要素)になったら0に戻す
		while(true){
			myNo = myNo + 1;
			if (myNo == 3){
				myNo = 0;

				//スレッドを1秒停止
				try {
					myTh.sleep(1000);

				} catch (InterruptedException e) {

				}

				//描画メソッドを呼び出す
				repaint();
			}
		}
	}

		public void paint(Graphics g){
			//全ての画像が読み込まれていれば画像の描画を行う
			if (myMt.checkID(0)){
				g.drawImage(myImg[myNo], 80, 80, this);
				g.drawString("Image" + myNo, 75, 50);
		}
	}

	public static void main(String[] args) {


	}

}
