package daily1211;
	import java.awt.Container;
import java.util.Calendar;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			String str = "JavaパーフェクトマスターJava";

			int idx = str.indexOf("Java");

			System.out.println("「" + str + "」の中で「Java」は");
			System.out.println("「左」から探すと「" + idx + "」番目にあります");

			int idx2 = str.lastIndexOf("Java");

			System.out.println("「" + str + "」の中で最後の「Java」は");
			System.out.println("「" + idx2 + "」番目にあります");
		}

	}


