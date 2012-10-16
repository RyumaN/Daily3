package daily1017;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Blocks {
	public int [] [] block;
	static final int BLOCK_X = 30;
	static final int BLOCK_Y = 30;
	static final int BLOCK_W = 40;
	static final int BLOCK_H = 20;

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

	public boolean isHit(int bx, int by){
		int x = (bx - BLOCK_X) / BLOCK_W;
		int y = (by - BLOCK_Y) / BLOCK_H;
		if (x < 0 || y < 0 || x > 5 || y > 11) return false;
		if (block [x] [y] > 0){
			block [x] [y] = block [x] [y] - 1;
			return true;
		} else {
			return false;
		}
	}

	public boolean isNoBlock(){
		for (int i = 0; i < 12; i = i + 1){
			for (int j = 0; j < 6; j = j + 1){
				if (block [j] [i] > 0){
					return false;
				}
			}
		}
		return true;
	}

	public void draw(Graphics g){
		for (int i = 0; i < 12; i = i + 1){
			for (int j = 0; j < 6; j = j + 1){
				int b = block [j] [i];
				if (b > 0){
					if (b > 1){
						g.setColor(Color.LIGHT_GRAY);
					} else {
						g.setColor(Color.CYAN);
					}
					g.fill3DRect(BLOCK_X + j * BLOCK_W, BLOCK_Y + i * BLOCK_H,
                            BLOCK_W - 1, BLOCK_H - 1, true);
				}
			}
		}
	}
}
