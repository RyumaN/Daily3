package daily1120;
	import java.awt.Container;

	import javax.swing.JFrame;
	import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			char carray[] = {'あ', 'い', 'う', 'え', 'あ'};

			int i = 0;
			System.out.println("while文");

			while (carray[i] != 'あ'){
				System.out.println(carray[i]);
				i ++;
			}

			i = 0;
			System.out.println("do ~ while文");

			do {
				System.out.println(carray[i]);
				i ++;
			} while (carray[i] != 'あ');

	}

}
