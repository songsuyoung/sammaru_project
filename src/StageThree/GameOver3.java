package StageThree;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import StageTwo.PlatformScene_Two;

public class GameOver3 extends JPanel{
	
	ImageIcon gameover = new ImageIcon("images/gameover.png");
	Image gameover_I = gameover.getImage();
	ImageIcon img_replay = new ImageIcon("images/replay.png");
	GameMain gameMain;
	Thread th;
	public GameOver3(JFrame frame) {
		this.gameMain = (GameMain)frame;
		
		//FlatformGameBoard.Isgameover = false;
		
		setLayout(null);
		
		JButton replay = new JButton(img_replay);
		replay.setBounds(430,500,200,50);		
		replay.setBorderPainted(false);	
		replay.setContentAreaFilled(false);
		replay.setFocusPainted(false);
		
		replay.addActionListener(new MyActionLister(frame));
		
		add(replay);
		
	}
	
	class MyActionLister implements ActionListener {
		JFrame frame;
		
		public MyActionLister(JFrame frame) {
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent e) {	
			GameMain.Isgameover = false;
			PlatformScene_Three p3 = new PlatformScene_Three(frame);
			th = new Thread(p3);
			gameMain.contentPane.add(p3, "p3");
			gameMain.card.show(gameMain.contentPane, "p3");
			p3.requestFocusInWindow();				
			th.start();				
		}
	}

	
	 public void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
		 
		 g2d.drawImage(gameover_I,0,0,1000,800,null);//배경
		 super.paintComponent(g);
		 g2d.drawImage(gameover_I,0,0,1000,800,null);//배경
	 }
	 
	/* public static void main(String[] args) {
		 new GameOver();
	 }*/
}
