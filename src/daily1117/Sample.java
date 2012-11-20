package daily1117;
	import java.awt.Container;

	import javax.swing.JFrame;
	import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			char key = 'N';

			switch (key) {
				case 'Y':
					System.out.println("keyはYです。");
					break;

				case 'y':
					System.out.println("keyはyです。");
					break;

				case 'N':
					System.out.println("keyはNです。");
					break;

				case 'n':
					System.out.println("keyはnです。");
					break;

				default:
					System.out.println("keyはYyNn以外です。");
			}
	}

}
