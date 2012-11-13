package daily1114;
	import java.awt.Container;

	import javax.swing.JFrame;
	import javax.swing.JPasswordField;

	public class Sample {


		public static void main(String[] args) {
			JFrame jf = new JFrame("JPasswordField");
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container con = jf.getContentPane();

			JPasswordField jpf = new JPasswordField();

	con.add(jpf);
	jf.setSize(200, 50);
	jf.setVisible(true);

	}

}
