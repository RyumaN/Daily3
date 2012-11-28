package daily1123;

import java.awt.Container;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPasswordField;


 class Oya{
	void morning(){
		System.out.println("Buongiorno!");
	}
}
	 class Sample extends Oya{
		 void evening(){
			 System.out.println("Buonasera!");
		 }
	 }

	  class Keishou {
		public static void main(String[] args) {
			Sample s = new Sample();

			s.morning();
			s.evening();

			}


	}


