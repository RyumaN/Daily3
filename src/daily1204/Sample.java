package daily1204;
	import java.awt.Container;
import java.util.Calendar;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			int year;

			Calendar now = Calendar.getInstance();

			year = now.get(now.YEAR);

			System.out.println("今年は" + year + "年です。");
			}


	}


