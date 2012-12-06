package daily1205;
	import java.awt.Container;
import java.util.Calendar;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			int day;
			char [] jday = {' ', '日', '月', '火', '水', '木', '金', '土'};

			Calendar now = Calendar.getInstance();

			day = now.get(now.DAY_OF_WEEK);

			System.out.println("今日は" + jday[day] + "曜日です。");
			}


	}


