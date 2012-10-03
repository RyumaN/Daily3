package daily1004;

import java.awt.Point;
import java.util.StringTokenizer;

public class PatternReader {
	String patstr;
	StringTokenizer tokenizer;
	Point movexy = new Point();
	int kaisuu = 0;




	PatternReader(String str){
		patstr = str;
		tokenizer = new StringTokenizer(patstr, ",");
	}

	Point next(){
		if (kaisuu == 0){
			if (tokenizer.hasMoreTokens() == false){
					tokenizer = new StringTokenizer(patstr, ",");
			}
			movexy.x = Integer.parseInt(tokenizer.nextToken());
			movexy.y = Integer.parseInt(tokenizer.nextToken());
			kaisuu = Integer.parseInt(tokenizer.nextToken());
		} else {
			kaisuu = kaisuu - 1;
		}
		return movexy;

	}

}
