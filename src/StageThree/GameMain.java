package StageThree;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import StageOne.GameOver1;
import StageOne.PlatformScene_One;
import StageTwo.GameOver2;
import StageTwo.PlatformScene_Two;

public class GameMain extends JFrame{
	
	public CardLayout card = new CardLayout();
	public Container contentPane = getContentPane();
	
	PlatformScene_One p1;
	PlatformScene_Two p2;
	PlatformScene_Three p3;
	GameOver3 gameover3;
	GameOver2 gameover2;
	GameOver1 gameover1;
	GameManual menu;
	
	//Thread th1;
	
	public static boolean Isgameover = false;
	public static boolean go_stageThree = false;

	public GameMain() {
		setTitle("Sammaru");
		contentPane.setLayout(card);
		
		menu = new GameManual(1015, 800, this); //메인메뉴
		contentPane.add(menu, "menu");
		
		gameover1 = new GameOver1(this);
		contentPane.add(gameover1, "gameover1");
		
		gameover2 = new GameOver2(this);
		contentPane.add(gameover2, "gameover2");
		
		
		gameover3 = new GameOver3(this); //showInitialPanel 메소드를 사용하기 위해서
		contentPane.add(gameover3, "gameover3");
		
		setSize(1020, 820);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	public void showGameOver3Panel() {
		Isgameover = true;
		
		card.show(contentPane, "gameover3");
		gameover3.requestFocusInWindow();
	}
	
	public void showGameOver2Panel() {
		Isgameover = true;
		
		card.show(contentPane, "gameover2");
		gameover2.requestFocusInWindow();
	}
	
	public void showGameOver1Panel() {
		Isgameover = true;
		card.show(contentPane, "gameover1");
		gameover1.requestFocusInWindow();
		
	}
	
	public void showInitialPanel() { // 메인화면으로
		Isgameover = false;
		menu.musicSound();
		card.show(contentPane, "menu");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameMain();
	}

}
