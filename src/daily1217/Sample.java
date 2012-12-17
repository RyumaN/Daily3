package daily1217;
	import java.awt.Container;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {



			public static void  main(String[] args){
				int [] array = new int[10];

				try {

					array[0] = 99;

				} catch (ArrayIndexOutOfBoundsException e) {

					System.err.println("配列インデックス外をアクセスしました");
					System.err.println("例外" + e);

				} finally {

					System.err.println("finallyブロックを実行");
				}




		}

	}


