package daily0915;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.TimerTask;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;



public class GameHoneGumi {
	public static final Integer GS_STARTGAMEN = 0;
	public static final Integer GS_STAGESTART = 1;
	public static final Integer GS_STAGECLEAR = 2;
	public static final Integer GS_GAMEOVER = 3;
	public static final Integer GS_GAMEMAIN = 4;

	private Integer gamestate;
	public BufferStrategy bstrategy;
	public JFrame frame1;
	public Sequencer midiseq = null;
	private Integer waittimer;

	public GameHoneGumi(int w, int h, String title){
		frame1 = new JFrame("title");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBackground(Color.WHITE);
		frame1.setResizable(false);


		frame1.setVisible(true);
		Insets insets = frame1.getInsets();
		frame1.setSize(600 + insets.left + insets.right, 400 + insets.top + insets.bottom);
		frame1.setLocationRelativeTo(null);

		frame1.createBufferStrategy(2);
		bstrategy = frame1.getBufferStrategy();
		frame1.setIgnoreRepaint(true);

		frame1.addKeyListener(new MyKeyAdapter());


	public void drawStringCenter(String str, Integer y, Graphics g){
		Integer fw = frame1.getWidth() / 2;
		FontMetrics fm = g.getFontMetrics();
		Integer strw = fm.stringWidth(str) / 2;
		g.drawString(str, fw - strw, y);
	}
	void midiYomikomi(String fname){
		if(midiseq == null){
			try {
				midiseq = MidiSystem.getSequencer();
				midiseq.open();
			} catch (MidiUnavailableException e) {
				e.printStackTrace();
			}
		}

		try{
				Sequence seq = MidiSystem.getSequence(getClass().getResource(fname));
				midiseq.setSequence(seq);
		} catch (InvalidMidiDataException e){
				e.printStackTrace();
		} catch(IOException e){
				e.printStackTrace();
		}
	}
	public Clip otoYomikomi(String fname){
		Clip clip = null;

		try{
		AudioInputStream aistream = AudioSystem.
				getAudioInputStream(getClass().getResource(fname));
		DataLine.Info info = new DataLine.Info(Clip.class, aistream.getFormat());
		clip = (Clip)AudioSystem.getLine(info);
		clip.open(aistream);

		} catch (UnsupportedAudioFileException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} catch (LineUnavailableException e){
			e.printStackTrace();
		}
		return clip;
	}
}

	void keyPressedGameMain(int keycode){

	}

	void keyReleasedGamemain(int keycode){

	}

	void runStartGamen(Graphics g){

	}

	void runStageStart(Graphics g){

	}

	void runStageClear(Graphics g){

	}

	void runGameMain(Graphics g){

	}

	void runGameOver(Graphics g){

	}

	private class MyKeyAdapter extends KeyAdapter {

		public void keyPressed(KeyEvent ev){
			if(gamestate == GS_GAMEMAIN){
				keyPressedGameMain(ev.getKeyCode());
			}
		}

		public void keyReleased(KeyEvent ev){
			int keycode = ev.getKeyCode();

			switch(gamestate){
			case GS_GAMEMAIN:
				keyReleasedGameMain(keycode);
				break;
			case GS_STARTGAMEN:
				if(keycode == KeyEvent.VK_P){
					goStageStart();
					break;
				}
			case GS_GAMEOVER:
				if(keycode == KeyEvent.VK_R){
					goStageStart();
				}
			}
		}

		private class MyTimerTask extends TimerTask {

			public void run() {
				Graphics g = bstrategy.getDrawGraphics();
				if (bstrategy.contentsLost() == false){
					Insets insets = frame1.getInsets();
					g.translate(insets.left, insets.top);

					switch(gamestate){
						case GS_STARTGAMEN:
							runStartGamen(g);
							break;
						case GS_STAGESTART:
							runStageStart(g);
							waittimer = waittimer - 1;
							if (waittimer < 0)	goGameMain();
							break;
						case GS_STAGECLEAR:
							runStageClear(g);
							waittimer = waittimer - 1;
							if (waittimer < 0)	goStageStart();
							break;
						case GS_GAMEMAIN:
							runGameMain(g);
							break;
						case GS_GAMEOVER:
							runGameOver(g);
							break;
					}

					bstrategy.show();
					g.dispose();
				}
			}
		}
	}
}
