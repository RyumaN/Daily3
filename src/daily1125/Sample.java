package daily1125;
	import java.awt.Container;

	import javax.swing.JFrame;
	import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			int i1, i2 = -1;
			long l1, l2 = 999L;
			float f1, f2 = 3.1415F;
			double d1, d2 = -6800.9821D;

			i1 = Math.abs(i2);
			l1 = Math.abs(l2);
			f1 = Math.abs(f2);
			d1 = Math.abs(d2);

			System.out.println(i2 + "の絶対値は" + i1);
			System.out.println(l2 + "の絶対値は" + l1);
			System.out.println(f2 + "の絶対値は" + f1);
			System.out.println(d2 + "の絶対値は" + d1);
			}


	}


