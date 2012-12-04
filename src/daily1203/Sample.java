package daily1203;
	import java.awt.Container;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			Date start, end;
			long keika;

			start = new Date();

			//とりあえず空ループ
			//本来はここに計りたい処理を書く

			for (int i = 0; i < 100000000; i++){}

			end = new Date();

			keika = end.getTime() - start.getTime();

			System.out.println(keika + "[msec]");
			}


	}


