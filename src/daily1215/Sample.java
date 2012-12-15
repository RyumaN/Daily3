package daily1215;
	import java.awt.Container;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {



			public static void  main(String[] args){
				String str = "Java::パーフェクト::マスター";

				String strAry[] = str.split("::");

				System.out.println(str + "は");

				for (int i = 0; i < strAry.length; i ++){
					System.out.println(strAry[i]);
				}

				System.out.println("に分割されました");

				int array[] = new int[10];
				try {
					array[10] = 1;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.err.println("配列インデックス外をアクセスしました");

					System.err.println("例外" + e);
				}






		}

	}


