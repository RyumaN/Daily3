package daily1106;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Calendar;

 class MyCalendar {
	int year;
	int month;

	MyCalendar(int y, int m){
		year = y;
		month = m;
	}

	void createCalendar() throws Exception{
		int i;
		Calendar c = Calendar.getInstance();
		c.clear();

		//月始めの曜日を取る(月は0~11で処理される為1マイナス)
		c.set(year, month - 1, 1);
		int sWeek = c.get(Calendar.DAY_OF_WEEK);

		//月の終わりの日付
		int eDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);

		//カレンダーの表示
		System.out.println("月 火 水 木 金 土 日");
		for (i = 1; i < sWeek; i++) System.out.println("          ");
		for (i = 1; i <= eDay; i++){
			System.out.printf("%3d", 1);
			if ((i + sWeek - 1) % 7 == 0) System.out.println();
		}
	}
 }
	public class sample{
	public static void main(String[] args) {
		try {
			int year = Integer.valueOf(args[0]);
			int month = Integer.valueOf(args[1]);
			MyCalendar mc = new MyCalendar(year, month);
			mc.createCalendar();
		} catch (Exception e) {
			System.out.println("エラーです");
		}

	}
}
