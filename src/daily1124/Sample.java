package daily1124;

import java.awt.Container;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPasswordField;


 public class Sample{
	 public static void main(String[] args ){
		 double hankei = 10;
		 double ensyu, menseki;

		 ensyu = hankei * 2 * Math.PI;
		 menseki = hankei * hankei * Math.PI;

		 System.out.println("円の半径が" + hankei + "[cm]のとき");
		 System.out.println("円周は" + ensyu + "[cm]");
		 System.out.println("面積は" + menseki + "[平方cm]");

	 }
 }