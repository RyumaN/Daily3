package daily1002;

import java.util.StringTokenizer;

public class PatternReader {
	String patstr;
	StringTokenizer tokenizer;

	PatternReader(String str){
		patstr = str;
		tokenizer = new StringTokenizer(patstr, ",");
	}

}
