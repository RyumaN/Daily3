package daily1116;
	import java.awt.Container;

	import javax.swing.JFrame;
	import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			int a = 6;

			if (a < 10){
				System.out.println("aは10より小さい");
			}

			if (a <= 1){
				System.out.println("aは1以下です。");
			} else {
				System.out.println("aは1より大きい");
			}

			if (a == 4){
				System.out.println("aは4です。");
			} else if (a == 5){
				System.out.println("aは5です。");
			} else if (a == 6){
				System.out.println("aは6です。");
			} else {
				System.out.println("aは4,5,6以外です。");
			}
	}

}
