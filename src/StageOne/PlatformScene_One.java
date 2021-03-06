
package StageOne;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import StageTwo.GameObject;
import StageTwo.PlatformScene_Two;
import StageThree.GameMain;


public class PlatformScene_One extends JPanel implements Runnable{ //flatform惟績税 郊伝戚 吃 class

	MoveCharacterKey move = null;
	CharacterObject hero;
	
	StageOne stage;
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
	boolean tread=false;
	//character 2p
	public int dia_sound_control =-1;
	//

	//鷺系 切端研 紫虞像
	public static boolean red_button_block=true;
	public static boolean blue_button_block=true;
	//
	public static int deltaY = 0;
	public static boolean blockrightMoving = true;    // 鷺系 崇送績
	public static boolean onBottom = false;

	public static int width = 0;
	public static int height = 0;

	public static boolean onBlock = false;
	public static boolean reddia1 = true;
	public static boolean reddia2 = true;
	public static boolean reddia3 = true;
	public static int diacount=0;
	public static boolean bluedia1 = true; //2腰属 蝶遣斗亜 股聖 呪 赤製
	public static boolean bluedia2 = true; //2腰属 蝶遣斗亜 股聖 呪 赤製
	public static boolean bluedia3 = true; //2腰属 蝶遣斗亜 股聖 呪 赤製
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
	public PlatformScene_One(JFrame gameMain) { //持失切 持失
		this.gameMain = (GameMain)gameMain;
		initboolean();
		initBoard();
		stage = new StageOne();
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
	//嘘呪還税 MoveScene()聖 戚遂背辞 幻給.
	private void initBoard() {
		move = new MoveCharacterKey();
		addKeyListener(move);
		setFocusable(true); // 什成覗傾績聖 幻級凶 陳匂獲闘拭惟 匂朕什研 捜, 陳匂獲闘(c)亜 匂朕什研 閤聖 呪 赤亀系 竺舛
		requestFocusInWindow(); // 陳匂獲闘(c)拭 匂朕什 悪薦 走舛
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
		tread=false;
		//鷺系 切端研 紫虞像
		red_button_block=true;
		blue_button_block=true;
		//
		deltaY = 0;
		blockrightMoving = true;    // 鷺系 崇送績
		onBottom = false;

		width = 0;
		height = 0;

		onBlock = false;
		reddia1 = true;
		reddia2 = true;
		reddia3 = true;
		diacount=0;
		bluedia1 = true; //2腰属 蝶遣斗亜 股聖 呪 赤製
		bluedia2 = true; //2腰属 蝶遣斗亜 股聖 呪 赤製
		bluedia3 = true; //2腰属 蝶遣斗亜 股聖 呪 赤製
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
			//System.out.println("けけけけけけけけけけけけけけ");
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

	@Override // paintComponent 澗 乞窮 JComonent拭 赤陥
	public void paintComponent(Graphics g) { // 亜稽掩戚, 室稽掩戚 閤焼辞, 唖唖税 梓端 硲窒
		super.paintComponent(g); // JPanel拭 姥薄吉 paintComponent() 硲窒 -> 切奄 切重聖 益鍵陥...
		width = this.getWidth(); // JPanel税 width, height葵?
		height = this.getHeight();
		stage.draw(g);
		hero.draw(g); // 益形爽奄.
	}

	public void updateLocation() { // 鉢檎拭 赤澗 梓端級税...\
		stage.updateLocation();
		hero.updateLocation(); //

	}

	public boolean checkCollision() { // 中宜 端滴
		boolean collision = false;

		checkOnTop();
		checkOnBottom();
		checkOnLeft();
		checkOnRight();
		checkOnAll();
		checkobstacle();
		nextstage();

		return collision;

	}

	public void nextstage() {  // 陥製 什砺戚走稽 角嬢哀 繕闇... 戚惟 限蟹?
		stop_sound=true;
		next = new JButton(img);
		next.setLocation(270,560);
		next.setSize(500,200);
		next.setBorderPainted(false);	
		next.setContentAreaFilled(false);
		next.setFocusPainted(false);
		next.requestFocusInWindow();
		next.addActionListener(new MyActionLister(gameMain));
		
		System.out.println(hero.getX());
		if(hero.getX()>1020&&!bluedia1&&!bluedia3&&!bluedia2) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				GameMain.Isgameover = true;
				add(next);
		}else if(hero.getX()>1020){
			try {
				background_sound.stop();
			}catch(Exception a) {}
			gameMain.showGameOver1Panel();
			gameOverSound();
		}
	}

	class MyActionLister implements ActionListener {  // 陥製 什砺戚走稽 亜奄 是敗
		JFrame frame;

		public MyActionLister(JFrame frame) {
			this.frame = frame;
		}

		public void actionPerformed(ActionEvent e) {	
			GameMain.Isgameover = false;
			PlatformScene_Two p2 = new PlatformScene_Two(frame);
			th = new Thread(p2);
			gameMain.contentPane.add(p2, "p2");
			gameMain.card.show(gameMain.contentPane, "p2");
			p2.requestFocusInWindow();				
			th.start();				
		}
	}

	public void checkOnTop() {
	
		for (BlockObject r : stage.block) {
			if (hero.getBottomBound().intersects(r.getTopBound())) {
				if(stage.block.get(7)==r && stage.stop) {
					;
				}else {
					falling = false;
					isJumping = false; 
					button_count=0;
					System.out.println("top coll");
				}
				break;
			}
		}
		for (BlockObject r : stage.box_block) {
			if (hero.getBottomBound().intersects(r.getTopBound())) {
				falling = false;
				isJumping = false; 
				button_count=0;
				
				System.out.println("top coll");
				break;
			}
		}

		if(stage.tread1&&stage.tread2)
			for (BlockObject r : stage.obstacle) {
				if (hero.getBottomBound().intersects(r.getTopBound())) {
					if(r==stage.obstacle.get(0))
						stage.tread1=true;
					if(r==stage.obstacle.get(1))
						stage.tread2=true;
					falling = false;
					isJumping = false; 
					button_count=0;
					break;
				}
			}

	}

	public void checkOnBottom() {

		for (BlockObject r : stage.block) {
			if (hero.getTopBound().intersects(r.getBottomBound())) { 
				if(stage.block.get(7)==r && stage.stop) {
					;
				}else {
				jumping = false;	
				Character.dy = 0;
				}
				System.out.println("bot coll");
				break;
			}
		}
		for(BlockObject r: stage.box_block) {
			if(hero.getTopBound().intersects(r.getBottomBound())) {
				jumping = false;	
				Character.dy = 0;
				stage.stop_block=true;
				stage.appear=true;
				break;
			}
		}
		
		for(BlockObject r: stage.obstacle) {
			if(hero.getTopBound().intersects(r.getBottomBound())) {
				jumping = false;	
				Character.dy = 0;
				stage.stop_block=true;
				stage.appear=true;
				break;
			}
		}
		
	}

	public void checkOnLeft() {
		
		for (BlockObject r : stage.block) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//疎, 酔 端滴 骨是研 滴惟 背鎌奄 凶庚拭 onTop, onBottom析��研 繕闇庚拭 蓄亜
				if(stage.block.get(7)==r && stage.stop) {
					;
				}else {
				checkright = false;
				}
				System.out.println("left coll");
				break;
			}
			else
				checkright=true;
		}
		for (BlockObject r : stage.box_block) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//疎, 酔 端滴 骨是研 滴惟 背鎌奄 凶庚拭 onTop, onBottom析��研 繕闇庚拭 蓄亜
				checkright = false;

				System.out.println("left coll");
				break;
			}
			else
				checkright=true;
		}
		for (BlockObject r : stage.obstacle) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//疎, 酔 端滴 骨是研 滴惟 背鎌奄 凶庚拭 onTop, onBottom析��研 繕闇庚拭 蓄亜
				checkright = false;
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver1Panel();
				gameOverSound();
				System.out.println("left coll");
				break;
			}
			else
				checkright=true;
		}

	}

	public void checkOnRight() {
		for (BlockObject r : stage.block) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//疎, 酔 端滴 骨是研 滴惟 背鎌奄 凶庚拭 onTop, onBottom析��研 繕闇庚拭 蓄亜
				if(stage.block.get(7)==r && stage.stop) {
					;
				}else {
				checkleft = false;
				}
				System.out.println(" coll");
				break;
			}
			else
				checkleft=true;
		}
		for (BlockObject r : stage.box_block) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//疎, 酔 端滴 骨是研 滴惟 背鎌奄 凶庚拭 onTop, onBottom析��研 繕闇庚拭 蓄亜
				checkleft = false;

				System.out.println(" coll");
				break;
			}
			else
				checkleft=true;
		}	
		for (BlockObject r : stage.obstacle) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//疎, 酔 端滴 骨是研 滴惟 背鎌奄 凶庚拭 onTop, onBottom析��研 繕闇庚拭 蓄亜
				checkleft = false;
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver1Panel();
				gameOverSound();
			
				System.out.println(" coll");
				break;
			}
			else
				checkleft=true;
		}	
	
	}
	public void checkOnAll() {
		for(BlockObject star : stage.star) {
			if(hero.getBound().intersects(star.getBound())) {
				if(stage.star.get(0)==star) {
					bluedia1=false;
					if(button_count==0) {
						button_count++;
						diaSound();
					}
				}
				if(stage.star.get(1)==star) {
					bluedia2=false;
					if(button_count1==0) {
						System.out.println(button_count1);
						diaSound();
						button_count1++;
					}
				}
				if(stage.star.get(2)==star) {
					bluedia3=false;
					if(button_count2==0) {
						button_count2++;
						diaSound();
					}
				}
			}
		}
	
	}


	public void checkobstacle(){
		

	}


	public void roadBlocked() { // 中宜 端滴 -> collision戚 true 戚檎 setX(0)
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