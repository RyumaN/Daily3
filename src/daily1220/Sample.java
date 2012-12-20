package daily1220;
	import java.awt.Container;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
	import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

	public class Sample {



			public static void  main(String[] args){
				JFrame jf = new JFrame("JButton1");
				jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
				Container con = jf.getContentPane();

				JButton jb = new JButton("PUSH ME");

				con.add(jb);
				jf.setSize(200, 100);
				jf.setVisible(true);
		}

	}


