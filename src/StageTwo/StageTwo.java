package StageTwo;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class StageTwo extends GameObject {

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
	
	ImageIcon pipe;
	Image PPipe;
	ImageIcon goomba;
	Image Gba;

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
	ArrayList<BlockObject> button;
	ArrayList<BlockObject> fire;
	ArrayList<BlockObject> water;
	ArrayList<BlockObject> arrow;
	ArrayList<BlockObject> door;
	ArrayList<BlockObject> one_block;
	
	ArrayList<BlockObject> Pipe;
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
	ImageIcon icon = new ImageIcon("images/wallpaper0.jpg");
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
	public StageTwo() {

		this.speed = 1;
		water=new ArrayList<BlockObject>();
		fire = new ArrayList<BlockObject>();
		block = new ArrayList<BlockObject>();
		appear_block = new ArrayList<BlockObject>();
		move_block=new ArrayList<BlockObject>();
		Reddia=new ArrayList<BlockObject>();
		button=new ArrayList<BlockObject>();
		arrow = new ArrayList<BlockObject>();
		door = new ArrayList<BlockObject>();
		one_block=new ArrayList<BlockObject>();
		
		Pipe=new ArrayList<BlockObject>();
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
		
		pipe=new ImageIcon("images/pipe.png");
		PPipe=pipe.getImage();
		
		goomba=new ImageIcon("images/goomba.png");
		Gba=goomba.getImage();

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
		
		block.add(new BlockObject(85,620,80,40)); //1
		block.add(new BlockObject(230,570,80,40)); //2
		block.add(new BlockObject(110,480,80,40)); //3
		block.add(new BlockObject(250,415,80,40)); //4
		block.add(new BlockObject(140,320,80,40)); //5
		block.add(new BlockObject(40,230,80,40)); //6
		block.add(new BlockObject(170,160,80,40)); //7
		block.add(new BlockObject(320,105,80,40)); //8
		block.add(new BlockObject(400,65,40,640)); //9		
		block.add(new BlockObject(480,105,40,520)); //10
		block.add(new BlockObject(480,65,520,40)); //11
		block.add(new BlockObject(640,665,40,40)); //12
		block.add(new BlockObject(680,625,40,40)); //13
		block.add(new BlockObject(720,585,40,40)); //14
	    block.add(new BlockObject(760,625,40,40)); //15
		block.add(new BlockObject(800,665,40,40)); //16
		block.add(new BlockObject(840,505,160,40)); //17
		block.add(new BlockObject(660,430,120,40)); //18
		block.add(new BlockObject(520,345,80,40)); //19
		block.add(new BlockObject(680,265,320,40)); //20
		
		Reddia.add(new BlockObject(720,655,40,40)); //star
		Pipe.add(new BlockObject(400,665,40,40)); //pipe
		Goomba.add(new BlockObject(400,665,40,40)); //goomba
		////
		
		button.add(new BlockObject(800,30,60,30));
		Pipe.add(new BlockObject(860,640,40,40));

		button.add(new BlockObject(880,225,60,30));
		move_block.add(new BlockObject(200,400,40*3,40));
		appear_block.add(new BlockObject(810,610,40,40));
		appear_block.add(new BlockObject(850,610,40,40));
		Reddia.add(new BlockObject(120,80,40,40));
		Reddia.add(new BlockObject(840,320,40,40));
		Reddia.add(new BlockObject(200,640,40,40));
		one_block.add(new BlockObject(760,300,40,20));
		one_block.add(new BlockObject(720,380,40,20));
		
		//Bluedia.add(new BlockObject(720,120,40,40));
		block.add(new BlockObject(240,240,40*1,40*1));
		//Bluedia.add(new BlockObject(500,680,40,40));
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
		door.add(new BlockObject(180,450,55,100)); //�߾����� ���� ���� ������ �̵��ϱ� ���� ��� ����Ʈ�� �־����
		door.add(new BlockObject(260,450,55,100));
		
	}


	public void draw(Graphics g) {

		
		
		//System.out.println(block.get(0).x);
		//1��°
		g.drawImage(img,0,0,1010,800,null);

		for(int i=0;i<28;i++) {
			g.drawImage(wall_img, 40*i, 705,null);
			g.drawImage(wall_img, 40*i, 745,null);
		}
		g.drawImage(wall_img, block.get(1).x, block.get(1).y,null);
		g.drawImage(wall_img, block.get(1).x+40, block.get(1).y,null);
	

		g.drawImage(wall_img, block.get(2).x, block.get(2).y,null);
		g.drawImage(wall_img, block.get(2).x+40, block.get(2).y,null);
		
		g.drawImage(wall_img, block.get(3).x, block.get(3).y,null);
		g.drawImage(wall_img, block.get(3).x+40, block.get(3).y,null);
		
		g.drawImage(wall_img, block.get(4).x, block.get(4).y,null);
		g.drawImage(wall_img, block.get(4).x+40, block.get(4).y,null);
		
		g.drawImage(wall_img, block.get(5).x, block.get(5).y,null);
		g.drawImage(wall_img, block.get(5).x+40, block.get(5).y,null);
		
		g.drawImage(wall_img, block.get(6).x, block.get(6).y,null);
		g.drawImage(wall_img, block.get(6).x+40, block.get(6).y,null);
		
		g.drawImage(wall_img, block.get(7).x, block.get(7).y,null);
		g.drawImage(wall_img, block.get(7).x+40, block.get(7).y,null);
		
		g.drawImage(wall_img, block.get(8).x, block.get(8).y,null);
		g.drawImage(wall_img, block.get(8).x+40, block.get(8).y,null);
		
		for(int i=0;i<600;i+=40) {
			g.drawImage(wall_img, block.get(9).x, block.get(9).y+i,null);
		}		
		
		for(int i=0;i<=520;i+=40) {
			g.drawImage(wall_img, block.get(10).x, block.get(10).y+i,null);
		}

		for(int i=0;i<=520;i+=40) {
			g.drawImage(wall_img, block.get(11).x+i, block.get(11).y,null);
		}
		
		g.drawImage(wall_img, block.get(12).x, block.get(12).y,null);
		g.drawImage(wall_img, block.get(13).x, block.get(13).y,null);
		if(PlatformScene_Two.red_button)	g.drawImage(wall_img, block.get(14).x, block.get(14).y,null);
		g.drawImage(wall_img, block.get(15).x, block.get(13).y,null);
		g.drawImage(wall_img, block.get(16).x, block.get(16).y,null);
		
		g.drawImage(wall_img, block.get(17).x, block.get(17).y,null);
		g.drawImage(wall_img, block.get(17).x+40, block.get(17).y,null);
		g.drawImage(wall_img, block.get(17).x+80, block.get(17).y,null);
		g.drawImage(wall_img, block.get(17).x+120, block.get(17).y,null);
		
		g.drawImage(wall_img, block.get(18).x, block.get(18).y,null);
		g.drawImage(wall_img, block.get(18).x+40, block.get(18).y,null);
		g.drawImage(wall_img, block.get(18).x+80, block.get(18).y,null);
		
		g.drawImage(wall_img, block.get(19).x, block.get(19).y,null);
		g.drawImage(wall_img, block.get(19).x+40, block.get(19).y,null);
		
		
		for(int i=0;i<=320;i+=40) {
			g.drawImage(wall_img, block.get(20).x+i, block.get(20).y,null);
		}
		if(PlatformScene_Two.reddia1)
			g.drawImage(Rdia, Reddia.get(0).x,Reddia.get(0).y,40,40,null); 
		g.drawImage(PPipe, Pipe.get(0).x,Pipe.get(0).y,40,40,null);
		g.drawImage(Gba, Goomba.get(0).x,Goomba.get(0).y,40,40,null);
		if(PlatformScene_Two.red_button) {
			g.drawImage(Bbut, button.get(0).x,button.get(0).y,60,40,null);
			sum=0;
		}else {
			sum++;
		}//g.drawImage(wall_img, block.get(9).x, block.get(9).y+40,null);
		
		/*g.drawImage(five_img,block.get(0).x,560,null);
		g.drawImage(five_img,block.get(0).x+40,560,null);

		//2��°
		//�Ķ��� ����
		g.drawImage(three_img,block.get(1).x,block.get(1).y,null);
		g.drawImage(three_img,block.get(1).x,block.get(1).size_s(280),null);

		//3��°
		g.drawImage(eight_img,block.get(2).x,block.get(2).y,null); //����

		//4��°
		g.drawImage(one_img,block.get(30).x,block.get(30).y,null);
		g.drawImage(three_img,block.get(3).x,block.get(3).size_s(600),null);
		g.drawImage(three_img,block.get(3).x,block.get(3).y,null);

		//5��
		g.drawImage(four_img,block.get(4).x,block.get(4).y,null);

		//6��°
		g.drawImage(wall_8_w,block.get(5).x,block.get(5).y,null);//�ٴ�

		//7��°
		g.drawImage(four_img,block.get(6).x,block.get(6).y,null);//���߿� �ִ� ����
		//8��°

		g.drawImage(three_img,block.get(7).x,block.get(7).y,null); //���� �ٴ�1
		//9��°
		g.drawImage(five_wimg,block.get(8).x,block.get(8).y,null); //���� �ٴ�2



		//10��°
		g.drawImage(one_img,block.get(9).x,block.get(9).y,null);
		//11��°
		g.drawImage(one_img,block.get(10).x,block.get(10).y,null);

		//12��°
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
		//13��°
		g.drawImage(nine_himg,block.get(12).x,block.get(12).y,null);

		//14��°

		g.drawImage(four_img,block.get(13).x,block.get(13).y,null);

		//15��°

		g.drawImage(five_img,block.get(14).x,block.get(14).y,null);

		//16��°
		g.drawImage(three_himg,block.get(15).x,block.get(15).y,null);
		//17��°
		g.drawImage(two_img,block.get(16).x,block.get(16).y,null);

		//18��°
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
		
		if(Goomba.get(0).x<=500) {
            Goomba.get(0).x-=speed;
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


