package daily1020;

import daily1019.Teki;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TikeiMap {
	static final int CHIP_W = 24;
	static final int CHIP_H = 24;
	static final int VIEW_W = YokoShootMain.GAMEN_W  /CHIP_W;
	static final int VIEW_H = YokoShootMain.GAMEN_H / CHIP_H;


	BufferedImage tikeiimage;
	int mapnagasa, worldx;
	String[] tekipattern = new String[10];
	String[] mapdata = new String[VIEW_H];

	TikeiMap(BufferedImage img, String mapname, String tekipatname){
		tikeiimage = img;
		worldx = 0;

		InputStream is = getClass().getResourceAsStream(mapname);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		try{
			for (int i = 0; i < VIEW_H; i = i + 1){
				mapdata[i] = br.readLine();
				if (mapdata[i] == null) {
				    System.err.println("invalid mapdata");
				    System.exit(0);
				}
			}
			br.close();
			is.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		mapnagasa=mapdata[0].length();


		is = getClass().getResourceAsStream(tekipatname);
		br = new BufferedReader(new InputStreamReader(is));
		try{
			for(int i = 0; i < tekipattern.length; i = i + 1){
				tekipattern[i] = br.readLine();
				if (tekipattern[i] == null) break;
			}
			br.close();
			is.close();
		} catch(Exception e){
			e.printStackTrace();
		}

	}

	int getMapData(int x, int y){
		return Character.getNumericValue(mapdata[y].charAt(x));
	}

	public boolean isMapEnd(){
		if (worldx >=(mapnagasa - VIEW_W) * CHIP_W) return true;
		else return false;
	}

	public boolean isAtari(int jx, int jy){
		int cx = (worldx + jx) / CHIP_W;
		int cy = jy / CHIP_H;

		if (getMapData(cx, cy) > 0 && getMapData(cx, cy) < 10)
			return true;
		else return false;
	}

	public ArrayList getNewTeki(BufferedImage img){
		ArrayList newtekis = new ArrayList();
		int cx = worldx / CHIP_W;
		if (worldx % CHIP_W > 0) return newtekis;

		for (int i = 0; i < VIEW_H; i = i + 1){
			int csnum = getMapData(cx + VIEW_W - 1, i);
			if (csnum > 9) {
				newtekis.add((Object)new Teki(YokoShootMain.GAMEN_W,
						i * CHIP_H, img, csnum - 10, tekipattern[csnum-10]));
			}
		}
		return newtekis;
	}

	public void draw(Graphics g, ImageObserver io){
		int cx = worldx / CHIP_W;
		int shx = worldx % CHIP_W;

		for (int i = 0; i < VIEW_H; i = i + 1){
			for (int j = 0; j < VIEW_W + 2; j = j + 1){
				if (cx + j > mapnagasa - 1) break;

				int csnum = getMapData(cx + j, i);
				if (csnum > 0 && csnum < 10){
					g.drawImage(tikeiimage, j * CHIP_W - shx, i * CHIP_H,
							j * CHIP_W - shx + CHIP_W, i * CHIP_H + CHIP_H,
							csnum * CHIP_W, 0,
							(csnum + 1) * CHIP_W, CHIP_H, io);
				}
			}
		}

		if (worldx < (mapnagasa - VIEW_W) * CHIP_W) worldx = worldx + 2;
	}

}
