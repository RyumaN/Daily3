package daily1208;
	import java.awt.Container;
import java.util.Calendar;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			String str = new String("Javaパーフェクトマスター");

			char [] ch = str.toCharArray();

			System.out.println("文字　列:"  + str);
			System.out.print("文字配列:");

			for (int i = 0; i < ch.length; i ++){
				System.out.print(ch[i] + " ");
			}

			System.out.println();
			}


	}


