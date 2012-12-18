package daily1218;
	import java.awt.Container;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

	import javax.swing.JFrame;
import javax.swing.JPasswordField;

	public class Sample {



			public static void  main(String[] args){
				InputStreamReader isr = new InputStreamReader(System.in);
				System.out.println(" y/n ? : ");

				try {
					int kb = isr.read();

					if ((char)kb == 'y'){

						System.out.println("yが押されました");

					} else if ((char)kb == 'n') {

						System.out.println("nが押されました");

					} else {

						System.out.println("y/n以外が押されました");

					}

				} catch (IOException e) {}


		}

	}


