package daily1023;

public class DoWhile {


	public static void main(String[] args) {
		char carray [] = {'あ', 'い', 'う', 'え', 'お'};
		int i = 0;
		System.out.println("while文");
		while (carray[i] != 'あ'){
			System.out.println(carray[i]);
			i++;
		}

		i = 0;
		System.out.println("do~while文");
		do {
			System.out.println(carray[i]);
			i++;
		} while (carray[i] != 'あ');


	}

}
