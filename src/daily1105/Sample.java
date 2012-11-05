package daily1105;

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

	int posX; //マウスのX座標
	int posY; //マウスのY座標
	Image myImg; //イメージオブジェクト

	//initメソッド
	public void init(){
		//画像ファイルを取得
		myImg = getImage(getDocumentBase(), "hoge1.jpg");

		//マウスがアプレット上を動く時の処理
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e){
				//X座標を取得
				posX = e.getX();
				//Y座標を取得
				posY = e.getY();
				//paintメソッドを呼び出す
				repaint();
			}
		});
	}

	public void paint(Graphics g){
		//画像を描画する(カーソルから少しずらすために+5する)
		g.drawImage(myImg, posX + 5, posY + 5, this);
	}

	public static void main(String[] args) {


	}

}
