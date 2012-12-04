package daily1129;
	import java.awt.Container;

	import javax.swing.JFrame;
	import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			int i, min;
			int val[] = {-10, 5, -50, -5, 10};

			for (i = 1, min = val[0]; i < val.length; i++){
				min = Math.min(min, val[i]);
			}

			System.out.println("最小値は" + min);
			}


	}


