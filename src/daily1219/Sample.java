package daily1219;
	import java.awt.Container;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

	public class Sample {



			public static void  main(String[] args){
				JFrame jf = new JFrame("タイトル");

				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				Container con = jf.getContentPane();

				JLabel jl = new JLabel("文字列を中央揃え", JLabel.CENTER);

				con.add(jl);
				jf.setSize(200, 100);
				jf.setVisible(true);
		}

	}


