
package StageTwo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import StageThree.PlatformScene_Three;
import StageThree.GameMain;


public class PlatformScene_Two extends JPanel implements Runnable{ //flatform������ ������ �� class

	MoveCharacterKey move = null;
	CharacterObject hero;
	
	StageTwo stage;
	JButton next;
	Thread th;
	//character
	//public static boolean go_stage_three = false;
	Clip background_sound;
	public static boolean jumping = false;
	public static boolean falling = false;
	public static boolean isJumping = false;
	public static boolean leftMove = false;
	public static boolean rightMove = false;
	public static boolean upMove = false;
	public static boolean onTop = false;
	//character 2p
	public int dia_sound_control =-1;
	//

	//��� ��ü�� �����
	public static boolean red_button_block=true;
	public static boolean blue_button_block=true;
	//
	public static int deltaY = 0;
	public static boolean blockrightMoving = true;    // ��� ������
	public static boolean onBottom = false;

	public static int width = 0;
	public static int height = 0;

	public static boolean onBlock = false;
	public static boolean reddia1 = true;
	public static boolean reddia2 = true;
	public static boolean reddia3 = true;
	public static int diacount=0;
	public static boolean bluedia1 = true; //2��° ĳ���Ͱ� ���� �� ����
	public static boolean bluedia2 = true; //2��° ĳ���Ͱ� ���� �� ����
	public static boolean bluedia3 = true; //2��° ĳ���Ͱ� ���� �� ����
	//public static boolean bluedia4 = true;
	public static boolean obs_button=true;
	public static boolean obs_On_button=true;
	public static boolean gameover=false;
	public static boolean on_red_Block=true;

	public static boolean on_Block=false;

	static ImageIcon but=new ImageIcon("images/blueOnbutton.png");
	static ImageIcon Rbut=new ImageIcon("images/RedOnbutton.png");
	public static boolean on_button=false;
	static boolean Purple_Button=true;
	static boolean Purple_Button2=true;
	static boolean red_button=true;
	static boolean checkleft=true;
	static boolean checkright=true;
	static boolean checkleft_2p=true;
	static boolean checkright_2p=true;
	static boolean arrow_button=true;

	//open_door
	ImageIcon img = new ImageIcon("images/next_stage.png");
	static boolean open_reddoor1=false;
	static boolean open_reddoor2=false;
	static boolean open_reddoor3=false;

	static boolean open_bluedoor1=false;
	static boolean open_bluedoor2=false;
	static boolean open_bluedoor3=false;
	boolean bluedia1_button=true;
	boolean stop_sound=true;
	//
	int button_count=0;
	int button_count1=0;
	int button_count2=0;

	GameMain gameMain;
	public PlatformScene_Two(JFrame gameMain) { //������ ����
		this.gameMain = (GameMain)gameMain;
		initboolean();
		initBoard();
		stage = new StageTwo();
		move =new MoveCharacterKey();
		//hero_2p = new Character_2p(160, 680, 40, 40);
		hero = new Character(0, 430, 40, 40);
		
		File file = new File("music/map_start.wav");
		System.out.println(file.exists()); //true

		try {

			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			background_sound = AudioSystem.getClip();
			background_sound.open(stream);
			background_sound.start();
			
		} catch(Exception e) {

			//	e.printStackTrace();
		}       
	}
	//�������� MoveScene()�� �̿��ؼ� ����.
	private void initBoard() {
		move = new MoveCharacterKey();
		addKeyListener(move);
		setFocusable(true); // ������������ ���鶧 ������Ʈ���� ��Ŀ���� ��, ������Ʈ(c)�� ��Ŀ���� ���� �� �ֵ��� ����
		requestFocusInWindow(); // ������Ʈ(c)�� ��Ŀ�� ���� ����
	}

	public void initboolean() {
		//go_stage_three = false;
		
		stop_sound=true;
		jumping = false;
		falling = false;
		isJumping = false;
		leftMove = false;
		rightMove = false;
		upMove = false;
		onTop = false;
		//character 2p =-1;
		//

		//��� ��ü�� �����
		red_button_block=true;
		blue_button_block=true;
		//
		deltaY = 0;
		blockrightMoving = true;    // ��� ������
		onBottom = false;

		width = 0;
		height = 0;

		onBlock = false;
		reddia1 = true;
		reddia2 = true;
		reddia3 = true;
		diacount=0;
		bluedia1 = true; //2��° ĳ���Ͱ� ���� �� ����
		bluedia2 = true; //2��° ĳ���Ͱ� ���� �� ����
		bluedia3 = true; //2��° ĳ���Ͱ� ���� �� ����
		//public static boolean bluedia4 = true;
		obs_button=true;
		obs_On_button=true;
		gameover=false;
		on_red_Block=true;

		on_Block=false;

		but=new ImageIcon("images/blueOnbutton.png");
		Rbut=new ImageIcon("images/RedOnbutton.png");
		on_button=false;
		Purple_Button=true;
		Purple_Button2=true;
		red_button=true;
		checkleft=true;
		checkright=true;
		checkleft_2p=true;
		checkright_2p=true;
		arrow_button=true;

		//open_door

		open_reddoor1=false;
		open_reddoor2=false;
		open_reddoor3=false;

		open_bluedoor1=false;
		open_bluedoor2=false;
		open_bluedoor3=false;

		bluedia1_button=true;
		//
		button_count=0;
		button_count1=0;
		button_count2=0;
	}

	public void start() {
		//System.out.println("asdqwe");
		while (true) {
			//System.out.println("����������������������������");
			updateLocation();
			try {
				Thread.sleep(11); // 10
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();

			checkCollision();
			roadBlocked();

			if(GameMain.Isgameover)
				break;

		}
	}

	@Override // paintComponent �� ��� JComonent�� �ִ�
	public void paintComponent(Graphics g) { // ���α���, ���α��� �޾Ƽ�, ������ ��ü ȣ��
		super.paintComponent(g); // JPanel�� ������ paintComponent() ȣ�� -> �ڱ� �ڽ��� �׸���...
		width = this.getWidth(); // JPanel�� width, height��?
		height = this.getHeight();
		stage.draw(g);
		hero.draw(g); // �׷��ֱ�.
	}

	public void updateLocation() { // ȭ�鿡 �ִ� ��ü����...\
		stage.updateLocation();
		hero.updateLocation(); //

	}

	public boolean checkCollision() { // �浹 üũ
		boolean collision = false;

		checkOnTop();
		checkOnBotton();
		checkOnLeft();
		checkOnRight();
		checkOnAll();
		checkobstacle();
		nextstage();

		return collision;

	}

	public void nextstage() {  // ���� ���������� �Ѿ ����... �̰� �³�?
		stop_sound=true;
		next = new JButton(img);
		next.setLocation(270,560);
		next.setSize(500,200);
		next.setBorderPainted(false);	
		next.setContentAreaFilled(false);
		next.setFocusPainted(false);
		next.requestFocusInWindow();
		next.addActionListener(new MyActionLister(gameMain));

		if(hero.getX()>1020&&!reddia1) {
			try {
				background_sound.stop();
			}catch(Exception a) {}
			GameMain.Isgameover = true;
			add(next);
	}else if(hero.getX()>1020){
		try {
			background_sound.stop();
		}catch(Exception a) {}
		gameMain.showGameOver2Panel();
		gameOverSound();
	}
	}

	class MyActionLister implements ActionListener {  // ���� ���������� ���� ����
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

	public void checkOnTop() {
		//onTop = false;

		/*if(bluedia1_button) {
			for(GameObject r : stage.appear_block) {
				if(hero.getBound().intersects(r.getobstacle())) {
					hero.setX(800);
					hero.setY(200);
					try {
						background_sound.stop();
					}catch(Exception a) {}
					gameMain.showGameOver2Panel();
					gameOverSound();
				}
			} 
*/
			//---------------------------------------------------------------------
/*
		for (GameObject r : stage.one_block) {
			if(on_Block) {
				if(hero.getBottomBound().intersects(r.getTopBound())) {
					falling = false;
					isJumping = false; 
				}
			}
		}
	*/	
		for (GameObject r : stage.block) {
			if (hero.getBottomBound().intersects(r.getTopBound())) {
				if(stage.block.get(14)==r&&!PlatformScene_Two.red_button)
					;
				else {
				falling = false;
				isJumping = false; 
				button_count=0;
				System.out.println("top coll");
				}
				break;
			}

		}
		for (GameObject button : stage.button) {

			if (hero.getBottomBound().intersects(button.getTopBound())){
				// �߰��� �ڵ�
				if(stage.button.get(0)==button) {
					on_Block=true;
					on_red_Block=false;
					red_button=false;
				}
			}
		}
		
	}




	public void checkOnBotton() {

		for (GameObject r : stage.block) {
			if (hero.getTopBound().intersects(r.getBottomBound())) { 
				if(stage.block.get(14)==r&&!PlatformScene_Two.red_button)
					;
				else {
				jumping = false;	
				Character.dy = 0;
				}
				System.out.println("bot coll");
				break;
			}
		}
		
		
	}
	

	public void checkOnLeft() {
		for (GameObject r : stage.block) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				if(stage.block.get(14)==r&&!PlatformScene_Two.red_button)
					;
				else {
				checkright = false;
				}
				System.out.println("left coll");
				break;
			}
			else
				checkright=true;
		}
		

	}

	public void checkOnRight() {
		for (GameObject r : stage.block) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				if(stage.block.get(14)==r&&!PlatformScene_Two.red_button)
					;
				else {	checkleft = false;
				}
				System.out.println("right coll");
				break;
			}
			else
				checkleft=true;
		}	
		
		  
		/*for (GameObject r : stage.Goomba) {
		         if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
		            //��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
		            checkleft = false;
		            try {
		               background_sound.stop();
		            }catch(Exception a) {}
		            gameMain.showGameOver2Panel();
		            gameOverSound();
		         
		            System.out.println(" coll");
		            break;
		         }
		         else
		            checkleft=true;
		      }    */
		



	}
	public void checkOnAll() {

		/*for(GameObject dia : stage.Bluedia) {
			if(hero_2p.getBound().intersects(dia.getBound())) {
				if(stage.Bluedia.get(0)==dia) {
					open_bluedoor1=true;

					bluedia1=false;
					diacount=1;
				}
				if(stage.Bluedia.get(1)==dia) {
					open_bluedoor2=true;
					bluedia2=false;
					diacount=2;
				}
				if(stage.Bluedia.get(2)==dia) {
					open_bluedoor3=true;
					bluedia3=false;
					diacount=3;
				}
			}

		}
		
		
		}*/
		for(GameObject dia : stage.Reddia) {
			if(hero.getBound().intersects(dia.getBound())) {
				if(stage.Reddia.get(0) == dia) {
					reddia1=false;
					obs_On_button=false;
					if(button_count==0) {
						button_count++;
						diaSound();
					}
				}
			}
		}
	}


	public void checkobstacle(){
		
		for(GameObject r : stage.Goomba) { 
			if(hero.getBound().intersects(r.getobstacle())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver2Panel();
				gameOverSound();
			}
		}

	}
	//ĳ���� 2 ����Ű;;; ��ġ��


	public void roadBlocked() { // �浹 üũ -> collision�� true �̸� setX(0)
		if (checkCollision()) {

		}

	}
	public void musicSound() {

		File file = new File("music/map_start.wav");
		System.out.println(file.exists()); //true

		try {

			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			background_sound = AudioSystem.getClip();
			background_sound.open(stream);
			background_sound.start();
			
			if(stop_sound) {
				background_sound.stop();
			}
		} catch(Exception e) {

			//	e.printStackTrace();
		}       
	}
	static public void jumpSound() {
		File file = new File("music/Jump_5.wav");
		System.out.println(file.exists()); //true

		try {

			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch(Exception e) {

			//	e.printStackTrace();
		}
	}
	static public void diaSound() {
		File file = new File("music/dia.wav");
		System.out.println(file.exists()); //true
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch(Exception e) {

			//	e.printStackTrace();
		}
	}
	static public void buttonSound() {
		File file = new File("music/button.wav");
		System.out.println(file.exists()); //true
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch(Exception e) {

			//e.printStackTrace();
		}
	}
	static public void gameOverSound() {
		File file = new File("music/gameover.wav");
		System.out.println(file.exists()); //true
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();


		} catch(Exception e) {

			//e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub		
		start();
	}

}
