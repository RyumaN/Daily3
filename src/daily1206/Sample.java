package daily1206;
	import java.awt.Container;
import java.util.Calendar;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			int month, date, hour;

			Calendar when1 = Calendar.getInstance();

			//読み出し
			month = when1.get(when1.MONTH);
			date = when1.get(when1.DATE);
			System.out.println("現在は、" + (month + 1) + "月" + date + "日");

			when1.add(when1.DATE, 150);

			//読み出し
			month = when1.get(when1.MONTH);
			date = when1.get(when1.DATE);
			System.out.println("150日後は、" + (month + 1) + "月" + date + "日");

			Calendar when2 = Calendar.getInstance();

			//読み出し
			date = when2.get(when2.DATE);
			hour = when2.get(when2.HOUR_OF_DAY);
			System.out.println("現在は、" + date + "日" + hour + "時");

			when2.add(when2.HOUR_OF_DAY, - 200);

			//読み出し
			date = when2.get(when2.DATE);
			hour = when2.get(when2.HOUR_OF_DAY);
			System.out.println("200時間前は、" + date + "日" + hour + "時");


			}


	}


