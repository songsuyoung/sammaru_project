package StageThree;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import StageOne.PlatformScene_One;
import StageTwo.PlatformScene_Two;

public class GameManual extends JPanel {
	int w;
	int h;
	ImageIcon start_background = new ImageIcon("images/background.jpg");
	Image start = start_background.getImage();
	
	ImageIcon go_background = new ImageIcon("images/background.jpg");
	Image go_img = go_background.getImage();
	
	static ImageIcon go = new ImageIcon("images/game_start.png");
	static ImageIcon go_rollover = new ImageIcon("images/go.png");
	static ImageIcon JLabel_explain = new ImageIcon("images/explain.jpg");
	static ImageIcon JButton_explain = new ImageIcon("images/explanation.png");

	//static Image game_start = go.getImage();
	
	static JButton b1 = new JButton(go);
	static JButton b2 = new JButton(JButton_explain);
	boolean stop_sound =false;
	JButton label = new JButton(JLabel_explain);
	Thread th;
	
	Clip open_music;
	
	GameMain gameMain;
	public GameManual(int w,int h,JFrame gameMain) {
			this.w=w;
			this.h=h;
			this.setLayout(null);
			this.gameMain = (GameMain)gameMain;
			
			musicSound();
			
			JPanel j = new JPanel();
			j.add(label);
			j.setVisible(false);
			j.setLocation(100,50);
			j.setSize(800,600);
			label.setBorderPainted(false);	
			label.setContentAreaFilled(false);
			label.setFocusPainted(false);
			
			label.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					j.setVisible(false);
				}
				
			});
			
			add(j);
			b1.setLocation(350,530);
			b1.setSize(300,50);
			b1.setBorderPainted(false);	
			b1.setContentAreaFilled(false);
			b1.setFocusPainted(false);
			b1.setRolloverIcon(go_rollover);
			b1.addActionListener(new MyActionLister(gameMain));
			add(b1);
			
			b2.setLocation(350,590);
			b2.setSize(300,50);
			b2.setBorderPainted(false);	
			b2.setContentAreaFilled(false);
			b2.setFocusPainted(false);
			b2.setOpaque(false);
			//b2.setRolloverIcon(b2_rollober);
			b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
						j.setVisible(true);
				}
				
			});
			add(b2);
	}
	
	class MyActionLister implements ActionListener {
		JFrame frame;
		
		public MyActionLister(JFrame frame) {
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent e) {	
			try {
				open_music.stop();
			}catch(Exception a) {}
			
			PlatformScene_One p1 = new PlatformScene_One(frame);
			//PlatformScene_Two p1 = new PlatformScene_Two(frame);
			//PlatformScene_Three p1 = new PlatformScene_Three(frame);
			th = new Thread(p1);
			gameMain.contentPane.add(p1, "p1");
			gameMain.card.show(gameMain.contentPane, "p1");
			p1.requestFocusInWindow();				
			th.start();				
		}
	}

	public void paintComponent(Graphics g) { 
		super.paintComponent(g); 
		g.drawImage(start,0,0,w,h,this);

	}
	
	public void musicSound() {

		File file = new File("music/opening.wav");
		System.out.println(file.exists()); //true

		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			open_music = AudioSystem.getClip();
			open_music.open(stream);
			open_music.start();
			
		} catch(Exception e) {

			//	e.printStackTrace();
		}       
	}
}
