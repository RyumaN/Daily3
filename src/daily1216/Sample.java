package daily1216;
	import java.awt.Container;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {



			public static void  main(String[] args){
				int [] array = new int[10];
				String str = "Javaパーフェクトマスター";

				try {
					array[100] = 99;

					char ch = str.charAt(-1);

				} catch (ArrayIndexOutOfBoundsException e) {

					System.err.println("配列インデックス外をアクセスしました");
					System.err.println("配列" + e);

				} catch (StringIndexOutOfBoundsException se) {

					System.err.println("文字列外をアクセスしました");
					System.err.println("例外" + se);
				}




		}

	}


