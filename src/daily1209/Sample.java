package daily1209;
	import java.awt.Container;
import java.util.Calendar;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			String str1 = "Javaパーフェクトマスター";
			String str2 = "パーフェクトJavaマスター";

			if (str1.startsWith("パーフェクト", 4)){
				System.out.println("「" + str1 + "」の4番目に「パーフェクト」があります。");
			} else {
				System.out.println("「" + str1 + "」の4番目に「パーフェクト」がありません。");
			}

			if (str2.startsWith("パーフェクト", 4)){
				System.out.println("「" + str2 + "」の4番目に「パーフェクト」があります。");
			} else {
				System.out.println("「" + str2 + "」の4番目に「パーフェクト」がありません。");
			}
			}


	}


