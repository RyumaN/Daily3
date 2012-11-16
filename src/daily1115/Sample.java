package daily1115;
	import java.awt.Container;

	import javax.swing.JFrame;
	import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			// &&(かつ、AND)
			System.out.println("true && true →" + (true && true));
			System.out.println("true && false →" + (true && false));
			System.out.println("false && true →" + (false && true));
			System.out.println("false && false →" + (false && false));

			// ||(または、OR)
			System.out.println("true || true →" + (true || true));
			System.out.println("true || false →" + (true || false));
			System.out.println("false || true →" + (false || true));
			System.out.println("false || false →" + (false || false));

			// !(でない、NOT)
			System.out.println(" !true →" + !true);
			System.out.println(" !false →" + !false);
	}

}
