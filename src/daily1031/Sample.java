package daily1031;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;

public class Sample extends Applet {

	Button myBtn;
	Label myLbl;
	Checkbox myCb;

	public void init(){
		add(myBtn = new Button("私はボタン"));
		add(myLbl = new Label("私はラベル"));
		add(myCb = new Checkbox("私はチェックボックス", false));
	}

	public static void main(String[] args) {


	}

}
