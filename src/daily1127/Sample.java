package daily1127;
	import java.awt.Container;

	import javax.swing.JFrame;
	import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			int i, max;
			int val[] = {-30, 46, 92, 31, 87};

			for (i = 1, max = val[0]; i < val.length; i++){
				max = Math.max(max, val[i]);
			}

			System.out.println("最大値は" + max);
			}


	}


