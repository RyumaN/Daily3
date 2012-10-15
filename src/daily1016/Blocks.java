package daily1016;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Blocks {


	public int [] [] block;

	Blocks(String fn){
		this.block = new int [6] [12];
		InputStream is = getClass().getResourceAsStream(fn);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		try {
			for (int i = 0; i < 12; i = i+ 1){
				String str =br.readLine();
				if (str == null)
					break;
				for (int j = 0; j < str.length(); j = j + 1){
					block [j] [i] = Character.getNumericValue(str.charAt(j));
				}
			}
			br.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
