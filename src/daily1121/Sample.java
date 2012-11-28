package daily1121;
	import java.awt.Container;

	import javax.swing.JFrame;
	import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			int iarray[] = {0, 1, 2, 3, 4};

			for (int i = 0; i < 5; i ++){
				if (i == 3) {
					continue;
				}
				System.out.println("iarray[" + i + "] → " + iarray[i]);
			}


	}

}
