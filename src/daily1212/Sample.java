package daily1212;
	import java.awt.Container;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {

		public void printSample(ArrayList a, int b) {

			a.add("foo");
			b = 20;

			System.out.println(a);
			System.out.println(b);

			}

			public static void  main(String[] args){

			Sample s = new Sample();
			ArrayList al = new ArrayList();
			String a = "hoge";

			al.add(a);

			int b = 5;

			s.printSample(al, b);

			System.out.println(al);
			System.out.println(b);

		}

	}


