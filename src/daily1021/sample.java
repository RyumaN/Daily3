package daily1021;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class sample {

	public static void main(String[] args){
		try {
			OutputStreamWriter out = new OutputStreamWriter(System.out);
			BufferedWriter o = new BufferedWriter(out);
			o.write("abc");
			o.close();
			out.close();
	} catch (IOException e) {
		System.out.println("出力エラー");
	}

	}

}
