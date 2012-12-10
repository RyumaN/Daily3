package daily1207;
	import java.awt.Container;
import java.util.Calendar;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			Calendar now = Calendar.getInstance();
			Calendar target = Calendar.getInstance();

			//過去に設定
			target.add(target.DATE, 100);

			//読み出し
			Date date_now = now.getTime();
			System.out.println("現在は" + date_now.toString() + "です。");

			Date date_target = target.getTime();
			System.out.println("対象は" + date_target.toString() + "です。");

			//判定
			if (now.before(target)){
				System.out.println("現在は対象より過去です。");
			}

			if (now.equals(target)){
				System.out.println("現在は対象と同じです。");
			}

			if (now.after(target)){
				System.out.println("現在は対象より未来です。");
			}
			}


	}


