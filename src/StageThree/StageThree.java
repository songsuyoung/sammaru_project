package StageThree;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class StageThree extends GameObject {

	int coordinates=1;
	int arrow_coordinates=1;
	int arrow_coordinates_2p=2;
	
	ImageIcon five;
	Image five_img;
	ImageIcon five_w;
	Image five_wimg;
	ImageIcon four;
	ImageIcon three;
	ImageIcon eight;
	Image four_img;
	Image three_img;
	Image eight_img;
	ImageIcon one;
	Image one_img;
	ImageIcon nine;
	Image nine_img;
	ImageIcon nine_h;
	Image nine_himg;
	ImageIcon height_three;
	Image three_himg;
	ImageIcon two;
	Image two_img;
	ImageIcon six;
	Image six_img;
	ImageIcon red;
	Image red_door;
	ImageIcon blue;
	Image blue_door;
	ImageIcon hurdle;
	Image obs1;
	ImageIcon reddia;
	Image Rdia;
	ImageIcon bluedia;
	Image Bdia;

	static int sum=-1;
	//
	int diaCount=0;
	int diaCount1=0;
	int diaCount2=0;
	//
	int diaCount3=0;
	int diaCount4=0;
	int diaCount5=0;

	static ImageIcon Bbutton=new ImageIcon("images/bluebutton.png");
	static Image Bbut=Bbutton.getImage();
	ImageIcon game_over = new ImageIcon("images/gameover.png");
	Image game=game_over.getImage();
	ArrayList<BlockObject> block;
	ArrayList<BlockObject> appear_block;
	ArrayList<BlockObject> move_block;
	ArrayList<BlockObject> Reddia;
	ArrayList<BlockObject> Bluedia;
	ArrayList<BlockObject> button;
	ArrayList<BlockObject> fire;
	ArrayList<BlockObject> water;
	ArrayList<BlockObject> arrow;
	ArrayList<BlockObject> door;
	ArrayList<BlockObject> one_block;
	ArrayList<BlockObject> Goomba;
	
	


	ImageIcon wall_25_w = new ImageIcon("images/wall_25x20_w.png");
	Image wall_25_w_I = wall_25_w.getImage();

	ImageIcon wall_w8 = new ImageIcon("images/wall_w_8.png");
	Image wall_8_w = wall_w8.getImage();
	ImageIcon arrow_ricon = new ImageIcon("images/arrow_right.png");
	ImageIcon arrow_licon = new ImageIcon("images/arrow_left.png");
	ImageIcon arrow_ricon1 = new ImageIcon("images/arrow_right.png");
	ImageIcon arrow_licon1 = new ImageIcon("images/arrow_left.png");
	Image arrow_img = arrow_ricon1.getImage();
	Image arrow_img1 = arrow_licon.getImage();
	

	ImageIcon wall_20_h = new ImageIcon("images/wall_bk_h.png");
	Image wall_20_h_I = wall_20_h.getImage();

	ImageIcon outButton = new ImageIcon("images/redbutton.png");
	Image reButton = outButton.getImage();
	ImageIcon RoutButton = new ImageIcon("images/redOnbutton.png");
	Image re_on_Button = RoutButton.getImage();
	ImageIcon icon = new ImageIcon("images/07.jpg");
	Image img = icon.getImage();

	static ImageIcon p_outButton = new ImageIcon("images/outbutton.png");
	static Image purpleButton = p_outButton.getImage();

	ImageIcon fire_icon = new ImageIcon("images/fire.png");
	Image fire_img = fire_icon.getImage();

	ImageIcon water_icon = new ImageIcon("images/water.png");
	Image water_img = water_icon.getImage();

	ImageIcon red_one_icon = new ImageIcon("images/red_one.png");
	Image red_one_img = red_one_icon.getImage();
	ImageIcon blue_one_icon = new ImageIcon("images/blue_one.png");
	Image blue_one_img = blue_one_icon.getImage();
	ImageIcon purpleOnBlock = new ImageIcon("images/onbutton.png");
	Image purpleOnButton = purpleOnBlock.getImage();
	ImageIcon pur_one_icon = new ImageIcon("images/pur_one_wall.png");
	Image pur_one_img = pur_one_icon.getImage();

	ImageIcon open_icon = new ImageIcon("images/open_door.png");
	Image open_door = open_icon.getImage();
	ImageIcon wall;
	Image wall_img;
	public StageThree() {

		this.speed = 1;
		water=new ArrayList<BlockObject>();
		fire = new ArrayList<BlockObject>();
		block = new ArrayList<BlockObject>();
		appear_block = new ArrayList<BlockObject>();
		move_block=new ArrayList<BlockObject>();
		Reddia=new ArrayList<BlockObject>();
		button=new ArrayList<BlockObject>();
		Bluedia=new ArrayList<BlockObject>();
		arrow = new ArrayList<BlockObject>();
		door = new ArrayList<BlockObject>();
		one_block=new ArrayList<BlockObject>();
		Goomba=new ArrayList<BlockObject>();

		wall=new ImageIcon("images/wall.png");
		wall_img=wall.getImage();
		hurdle=new ImageIcon("images/hurdle.png");
		obs1=hurdle.getImage();
		five= new ImageIcon("images/wall_5.png");
		five_img = five.getImage();
		five_w= new ImageIcon("images/wall_5_w.png");
		five_wimg = five_w.getImage();
		four= new ImageIcon("images/wall_4.png");
		four_img = four.getImage();
		three= new ImageIcon("images/wall_3.png");
		three_img = three.getImage();
		eight= new ImageIcon("images/wall_8.png");
		eight_img = eight.getImage();
		one= new ImageIcon("images/one_wall.png");
		one_img=one.getImage();
		nine= new ImageIcon("images/wall_9.png");
		nine_img=nine.getImage();
		nine_h= new ImageIcon("images/wall_h_9.png");
		nine_himg=nine_h.getImage();
		height_three= new ImageIcon("images/wall_3h.png");
		three_himg=height_three.getImage();
		two= new ImageIcon("images/wall_2.png");
		two_img=two.getImage();
		six= new ImageIcon("images/wall_6w.png");
		six_img=six.getImage();
		red= new ImageIcon("images/red_d.png");
		red_door=red.getImage();
		blue= new ImageIcon("images/blue.png");
		blue_door=blue.getImage();

		reddia=new ImageIcon("images/star.png");
		Rdia=reddia.getImage();
		bluedia=new ImageIcon("images/bluedia.png");
		Bdia=bluedia.getImage();

		block.add(new BlockObject(0,705,1020,80));
		/*
		block.add(new BlockObject(40,705,40,80));
		block.add(new BlockObject(80,705,40,80));
		block.add(new BlockObject(120,705,40,80));
		block.add(new BlockObject(160,705,40,80));
		block.add(new BlockObject(200,705,40,80));
		block.add(new BlockObject(240,705,40,38));
		block.add(new BlockObject(280,705,40,38));
		block.add(new BlockObject(320,705,40,38));
		block.add(new BlockObject(360,705,40,38));
		block.add(new BlockObject(400,705,40,38));
		block.add(new BlockObject(440,705,40,38));
		block.add(new BlockObject(480,705,40,38));
		block.add(new BlockObject(520,705,40,38));
		block.add(new BlockObject(560,705,40,38));
		block.add(new BlockObject(600,705,40,38));
		block.add(new BlockObject(640,705,40,38));
		block.add(new BlockObject(680,705,40,38));
		block.add(new BlockObject(720,705,40,38));
		block.add(new BlockObject(740,705,40,38));
		block.add(new BlockObject(780,705,40,38));
		block.add(new BlockObject(820,705,40,38));
		block.add(new BlockObject(860,705,40,38));
		block.add(new BlockObject(900,705,40,38));
		block.add(new BlockObject(920,705,40,38));
		block.add(new BlockObject(940,705,40,38));
		block.add(new BlockObject(960,705,40,38));
		block.add(new BlockObject(1000,705,40,38));
		*/
		///////
		
		block.add(new BlockObject(70,625,80,40));
		block.add(new BlockObject(230,585,80,40));
		block.add(new BlockObject(block.get(2).x+160, block.get(2).y-40,40*4,40));
		block.add(new BlockObject(block.get(2).x+360, block.get(2).y,40*4,40));
		block.add(new BlockObject(block.get(2).x+600, block.get(2).y-40,40,40));
		block.add(new BlockObject(block.get(2).x+680, block.get(2).y-120,40,40));
		block.add(new BlockObject(block.get(2).x+560, block.get(2).y-160,40,40));
		block.add(new BlockObject(block.get(2).x+480, block.get(2).y-200,40,40));
		block.add(new BlockObject(block.get(2).x+240, block.get(2).y-240,40*4,40));
		block.add(new BlockObject(block.get(2).x+120, block.get(2).y-240,40,40));
		block.add(new BlockObject(block.get(2).x, block.get(2).y-240,40,40));
		block.add(new BlockObject(block.get(2).x-120, block.get(2).y-200,40,40));
		
		block.add(new BlockObject(block.get(2).x-200, block.get(2).y-280,40,40));
		block.add(new BlockObject(block.get(2).x-40, block.get(2).y-360,40,40));
		block.add(new BlockObject(block.get(2).x+40, block.get(2).y-400,40*2,40));
		block.add(new BlockObject(block.get(2).x+120, block.get(2).y-440,40,40));
		block.add(new BlockObject(block.get(2).x+200, block.get(2).y-440,40,40));
		block.add(new BlockObject(block.get(2).x+280, block.get(2).y-440,40*2,40));
		
		block.add(new BlockObject(block.get(2).x+320, block.get(2).y-440,40,40));
		block.add(new BlockObject(block.get(2).x+320, block.get(2).y-480,40,40));
		Goomba.add(new BlockObject(block.get(2).x+40, block.get(2).y-440,40,40));
		
		
		////
		
		button.add(new BlockObject(230,385,60,30));
		Bluedia.add(new BlockObject(860,640,40,40));

		button.add(new BlockObject(880,225,60,30));
		move_block.add(new BlockObject(200,400,40*3,40));
		appear_block.add(new BlockObject(810,610,40,40));
		appear_block.add(new BlockObject(850,610,40,40));
		Reddia.add(new BlockObject(120,80,40,40));
		Reddia.add(new BlockObject(840,320,40,40));
		Reddia.add(new BlockObject(200,640,40,40));
		one_block.add(new BlockObject(760,300,40,20));
		one_block.add(new BlockObject(720,380,40,20));
		
		Bluedia.add(new BlockObject(720,120,40,40));
		
		Bluedia.add(new BlockObject(500,680,40,40));
		fire.add(new BlockObject(400,680,40,40));
		fire.add(new BlockObject(440,680,40,40));
		fire.add(new BlockObject(480,680,40,40));
		fire.add(new BlockObject(520,680,40,40));
		fire.add(new BlockObject(560,680,40,40));
		fire.add(new BlockObject(600,680,40,40));

		button.add(new BlockObject(550,265,60,30));

		water.add(new BlockObject(145,233,60,60));
		water.add(new BlockObject(190,233,60,60));
		arrow.add(new BlockObject(320,620,40,10));
		arrow.add(new BlockObject(720,660,40,10));
		//180,450,55,100
		door.add(new BlockObject(180,450,55,100)); //중앙으로 가면 다음 맵으로 이동하기 위해 어레이 리스트에 넣어놓음
		door.add(new BlockObject(260,450,55,100));
		
	}


	public void draw(Graphics g) {

		
		
		//System.out.println(block.get(0).x);
		//1번째
		g.drawImage(img,0,0,1010,800,null);

		for(int i=0;i<28;i++) {
			g.drawImage(wall_img, 40*i, 705,null);
			g.drawImage(wall_img, 40*i, 745,null);
		}
		g.drawImage(wall_img, block.get(1).x, block.get(1).y,null);
		g.drawImage(wall_img, block.get(1).x+40, block.get(1).y,null);
	

		g.drawImage(wall_img, block.get(2).x, block.get(2).y,null);
		g.drawImage(wall_img, block.get(2).x+40, block.get(2).y,null);
		
		g.drawImage(wall_img, block.get(2).x+160, block.get(2).y-40,null);
		g.drawImage(wall_img, block.get(2).x+200, block.get(2).y-40,null);
		g.drawImage(wall_img, block.get(2).x+240, block.get(2).y-40,null);
		g.drawImage(wall_img, block.get(2).x+280, block.get(2).y-40,null);
		
		g.drawImage(wall_img, block.get(2).x+360, block.get(2).y,null);
		g.drawImage(wall_img, block.get(2).x+400, block.get(2).y,null);
		g.drawImage(wall_img, block.get(2).x+440, block.get(2).y,null);
		g.drawImage(wall_img, block.get(2).x+480, block.get(2).y,null);
		
		
		g.drawImage(wall_img, block.get(2).x+600, block.get(2).y-40,null);
		
		g.drawImage(wall_img, block.get(2).x+680, block.get(2).y-120,null);
		g.drawImage(wall_img, block.get(2).x+560, block.get(2).y-160,null);
		
		g.drawImage(wall_img, block.get(2).x+480, block.get(2).y-200,null);
		g.drawImage(wall_img, block.get(2).x+240, block.get(2).y-240,null);
		g.drawImage(wall_img, block.get(2).x+280, block.get(2).y-240,null);
		g.drawImage(wall_img, block.get(2).x+320, block.get(2).y-240,null);
		g.drawImage(wall_img, block.get(2).x+360, block.get(2).y-240,null);
		g.drawImage(wall_img, block.get(2).x+120, block.get(2).y-240,null);
		
		g.drawImage(wall_img, block.get(2).x, block.get(2).y-240,null);
		g.drawImage(wall_img, block.get(2).x-120, block.get(2).y-200,null);
		
		g.drawImage(wall_img, block.get(2).x-200, block.get(2).y-280,null);
		g.drawImage(wall_img, block.get(2).x-40, block.get(2).y-360,null);
		g.drawImage(wall_img, block.get(2).x+40, block.get(2).y-400,null);
		g.drawImage(wall_img, block.get(2).x+80, block.get(2).y-400,null);
		g.drawImage(wall_img, block.get(2).x+320, block.get(2).y-440,null);
		g.drawImage(wall_img, block.get(2).x+320, block.get(2).y-480,null);
		g.drawImage(Rdia,block.get(2).x+40, block.get(2).y-440,40,40,null);
		/*g.drawImage(five_img,block.get(0).x,560,null);
		g.drawImage(five_img,block.get(0).x+40,560,null);

		//2번째
		//파란색 벽쪽
		g.drawImage(three_img,block.get(1).x,block.get(1).y,null);
		g.drawImage(three_img,block.get(1).x,block.get(1).size_s(280),null);

		//3번째
		g.drawImage(eight_img,block.get(2).x,block.get(2).y,null); //높이

		//4번째
		g.drawImage(one_img,block.get(30).x,block.get(30).y,null);
		g.drawImage(three_img,block.get(3).x,block.get(3).size_s(600),null);
		g.drawImage(three_img,block.get(3).x,block.get(3).y,null);

		//5번
		g.drawImage(four_img,block.get(4).x,block.get(4).y,null);

		//6번째
		g.drawImage(wall_8_w,block.get(5).x,block.get(5).y,null);//바닥

		//7번째
		g.drawImage(four_img,block.get(6).x,block.get(6).y,null);//공중에 있는 발판
		//8번째

		g.drawImage(three_img,block.get(7).x,block.get(7).y,null); //공중 바닥1
		//9번째
		g.drawImage(five_wimg,block.get(8).x,block.get(8).y,null); //공중 바닥2



		//10번째
		g.drawImage(one_img,block.get(9).x,block.get(9).y,null);
		//11번째
		g.drawImage(one_img,block.get(10).x,block.get(10).y,null);

		//12번째
		if(PlatformScene_Two.open_bluedoor1&&PlatformScene_Two.open_bluedoor2&&PlatformScene_Two.open_bluedoor3) {
			g.drawImage(open_door,260,450,55,100,null);
		}
		else {
			g.drawImage(blue_door,260,450,55,100,null);
		}
		if(PlatformScene_Two.open_reddoor1&&PlatformScene_Two.open_reddoor2&&PlatformScene_Two.open_reddoor3) {
			g.drawImage(open_door,180,450,55,100,null);
		}
		else {
			g.drawImage(red_door,180,450,55,100,null);
		}

		if(PlatformScene_Two.reddia1) {
			g.drawImage(Rdia, Reddia.get(0).x,Reddia.get(0).y,40,40,null); //red dia
		}
		else {
			diaCount++;
		}
		if(diaCount==1) {
			PlatformScene_Two.diaSound();
		}
		if(PlatformScene_Two.reddia2) {
			g.drawImage(Rdia, Reddia.get(1).x,Reddia.get(1).y,40,40,null); //red dia
		}else {
			diaCount1++;
		}
		if(diaCount1==1) {
			PlatformScene_Two.diaSound();
		}
		if(PlatformScene_Two.reddia3) {
			g.drawImage(Rdia,200,640,40,40,null); //red dia
		}else {
			diaCount2++;
		}
		if(diaCount2==1) {
			PlatformScene_Two.diaSound();
		}


		g.drawImage(one_img,block.get(11).x,block.get(11).y,null);
		//13번째
		g.drawImage(nine_himg,block.get(12).x,block.get(12).y,null);

		//14번째

		g.drawImage(four_img,block.get(13).x,block.get(13).y,null);

		//15번째

		g.drawImage(five_img,block.get(14).x,block.get(14).y,null);

		//16번째
		g.drawImage(three_himg,block.get(15).x,block.get(15).y,null);
		//17번째
		g.drawImage(two_img,block.get(16).x,block.get(16).y,null);

		//18번째
		g.drawImage(three_himg,block.get(17).x,block.get(17).y,null);		
		//19

		g.drawImage(four_img,block.get(18).x,block.get(18).y,null);
		g.drawImage(two_img,block.get(19).x,block.get(19).y,null);
		//21

		g.drawImage(three_himg,block.get(20).x,block.get(20).y,null);
		g.drawImage(red_one_img,block.get(21).x,block.get(21).y,60,10,null);
		g.drawImage(three_img,move_block.get(0).x,move_block.get(0).y,null);

		g.drawImage(wall_25_w_I, block.get(22).getX(), block.get(22).getY(), block.get(22).getWidth(),  block.get(22).getHeight(), null);
		g.drawImage(wall_20_h_I, block.get(23).getX(), block.get(23).getY(), block.get(23).getWidth(),  block.get(23).getHeight(), null);
		g.drawImage(wall_25_w_I, block.get(24).getX(), block.get(24).getY(), block.get(24).getWidth(),  block.get(24).getHeight(), null);
		g.drawImage(wall_20_h_I, block.get(25).getX(), block.get(25).getY(), block.get(25).getWidth(),  block.get(25).getHeight(), null);

		if(PlatformScene_Two.red_button) {
			g.drawImage(reButton,button.get(0).x,button.get(0).y,null);
			sum=0;
		}else {
			sum++;
		}

		if(PlatformScene_Two.bluedia2) {
			g.drawImage(Bdia,Bluedia.get(1).x,Bluedia.get(1).y,40,40,null);
		}else
			diaCount4++;

		g.drawImage(Bbut,button.get(1).x,button.get(1).y,null);

		g.drawImage(pur_one_img,block.get(27).x,block.get(27).y,60,10,null);

		if(PlatformScene_Two.on_Block) {
			g.drawImage(one_img,720,380,40,20,null);
			g.drawImage(one_img,760,300,40,20,null);
		}

		if(PlatformScene_Two.obs_On_button) {
			g.drawImage(fire_img,400,680,40,40,null);
			g.drawImage(fire_img,440,680,40,40,null);
			g.drawImage(fire_img,480,680,40,40,null);
			g.drawImage(fire_img,520,680,40,40,null);
			g.drawImage(fire_img,560,680,40,40,null);
			g.drawImage(fire_img,600,680,40,40,null);
		}else {
			if(PlatformScene_Two.bluedia3)
				g.drawImage(Bdia,500,680,40,40,null);
			else
				diaCount5++;
		}
		if(PlatformScene_Two.bluedia1) {
			g.drawImage(Bdia,Bluedia.get(0).x,Bluedia.get(0).y,40,40,null);
		}else {
			diaCount3++;
		}
		if(diaCount3==1||diaCount4==1||diaCount5==1) {
			PlatformScene_Two.diaSound();
		}
		g.drawImage(water_img,145,233,60,60,null);
		g.drawImage(water_img,190,233,60,60,null);

		if(PlatformScene_Two.Purple_Button&&PlatformScene_Two.Purple_Button2) 
			g.drawImage(purpleButton,button.get(2).x,button.get(2).y,null);
		else
			g.drawImage(purpleOnButton,button.get(2).x,button.get(2).y,null);

		if(PlatformScene_Two.arrow_button) {
			g.drawImage(arrow_img,arrow.get(0).x,arrow.get(0).y,40,10,null);
			g.drawImage(arrow_img1,arrow.get(1).x,arrow.get(1).y,40,10,null);
		}

		if(PlatformScene_Two.obs_button) {
			g.drawImage(obs1,appear_block.get(0).x,appear_block.get(0).y,100,100,null);
			g.drawImage(obs1,appear_block.get(1).x,appear_block.get(1).y,100,100,null);
		}*/
	}
	
	public void updateLocation() {
		// TODO Auto-generated method stub

		this.speed=1;
		if(coordinates==1) {
			if(move_block.get(0).y<=480) {
				move_block.get(0).y+=speed;
				button.get(0).y+=speed;
			}
			if(move_block.get(0).y==480)
				coordinates=2;
		}
		if(coordinates==2) {
			if(move_block.get(0).x<=400) {
				move_block.get(0).x+=speed;

				button.get(0).x+=speed;
			}
			if(move_block.get(0).x==400)
				coordinates=3;
		}
		if(coordinates==3) {
			if(move_block.get(0).y<=560) 
				move_block.get(0).y+=speed;

			button.get(0).y+=speed;
			if(move_block.get(0).y==560)
				coordinates=4;
		}
		//
		if(coordinates==4) {
			if(move_block.get(0).y>=480) {
				move_block.get(0).y-=speed;
				button.get(0).y-=speed;

			}
			if(move_block.get(0).y==480) {
				coordinates=5;
			}
		}
		if(coordinates==5) {
			if(move_block.get(0).x>=200) {
				move_block.get(0).x-=speed;
				button.get(0).x-=speed;
			}
			if(move_block.get(0).x==200)
				coordinates=6;

		}
		if(coordinates==6) {

			if(move_block.get(0).y>=400) {

				button.get(0).y-=speed; 
				move_block.get(0).y-=speed;
			}
			if(move_block.get(0).y==400)
				coordinates=1;
		}
		//320,620
		//720,660
		this.speed=2;
		if(arrow_coordinates==1) { 
			if(arrow.get(0).x<=760) {
				arrow.get(0).x+=speed;
				arrow_img = arrow_ricon1.getImage();
			}
			if(arrow.get(0).x==760) {
				arrow_coordinates=2;
				arrow_img = arrow_licon1.getImage();
			}
		}
		if(arrow_coordinates==2) {
			if(arrow.get(0).x>=320) {
				arrow.get(0).x-=speed;
				arrow_img = arrow_licon1.getImage();
			}
			if(arrow.get(0).x==320)
				arrow_coordinates=1;
		    	arrow_img = arrow_ricon1.getImage();
		}
		
		if(arrow_coordinates_2p==1) {
			if(arrow.get(1).x<=720) {
				arrow_img1 = arrow_ricon.getImage();
				arrow.get(1).x+=speed;
			}
			if(arrow.get(1).x==720) {
				arrow_coordinates_2p=2;
				arrow_img1 = arrow_licon.getImage();
			}
		}
		if(arrow_coordinates_2p==2) {
			if(arrow.get(1).x>=320) {
				arrow.get(1).x-=speed;
				arrow_img1 = arrow_licon.getImage();
			}
			if(arrow.get(1).x==320) {
				arrow_coordinates_2p=1;
				arrow_img1 = arrow_ricon.getImage();
			}
		}


	}
	
	public void stepupLocation() {
		if(block.get(21).y>=360)
			block.get(21).y-=speed;

	}
	public void fallLocation() {
		if(block.get(21).y<=520)
			block.get(21).y+=speed;


	}
	public void stepupLocation_2p() {

		if(block.get(27).y>=260)
			block.get(27).y-=speed;


	}
	public void fallLocation_2p() {
		if(block.get(27).y<=700)
			block.get(27).y+=speed;
	}
	public void stepupLocation_1p() {

		if(block.get(27).y>=260)
			block.get(27).y-=speed;


	}
	public void fallLocation_1p() {
		if(block.get(27).y<=700)
			block.get(27).y+=speed;
	}
}

