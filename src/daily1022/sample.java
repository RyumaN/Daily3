package daily1022;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Test extends Thread {
	public void run(){
		try {
			System.out.println("Testクラスのメソッド");
			} catch (Exception e) {
				System.out.println("エラー");
			}
	}
}

public class sample {
	public static void main(String[] args){
		Test test - new Test();
		Test.start();
		System.out.println("mainメソッド");
	}

}
