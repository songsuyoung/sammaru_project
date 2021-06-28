package StageOne;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class StageOne extends GameObject {

	int coordinates=1;
	int arrow_coordinates=1;
	int arrow_coordinates_2p=2;
	boolean stop_block=false;
	boolean appear=false;
	boolean control=true;
	boolean control_2=true;
	boolean star_appear=false;
	boolean tread1=false;
	boolean tread2=false;
	boolean stop=false;
	
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
	ArrayList<BlockObject> star;
	ArrayList<BlockObject> obstacle;
	ArrayList<BlockObject> box_block;
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
	ImageIcon star_icon;
	Image star_img;
	ImageIcon mushroom;
	Image mushroom_img;
	ImageIcon bomb_right;
	Image bomb_img;
	ImageIcon bomb_left;
	ImageIcon box;
	Image box_img;
	ImageIcon stop_box;
	Image stop_box_img;
	public StageOne() {

		this.speed = 1;
		

		star=new ArrayList<BlockObject>();
		block = new ArrayList<BlockObject>();
		obstacle=new ArrayList<BlockObject>();
		box_block=new ArrayList<BlockObject>();
		
		
		water=new ArrayList<BlockObject>();
		fire = new ArrayList<BlockObject>();
		appear_block = new ArrayList<BlockObject>();
		move_block=new ArrayList<BlockObject>();
		button=new ArrayList<BlockObject>();
		Bluedia=new ArrayList<BlockObject>();
		arrow = new ArrayList<BlockObject>();
		door = new ArrayList<BlockObject>();
		one_block=new ArrayList<BlockObject>();
		Reddia=new ArrayList<BlockObject>();
		

		stop_box=new ImageIcon("images/stop_box.png");
		
		star_icon=new ImageIcon("images/star.png");
		star_img=star_icon.getImage();
		mushroom=new ImageIcon("images/mush.png");
		mushroom_img=mushroom.getImage();
		wall=new ImageIcon("images/wall.png");
		wall_img=wall.getImage();
		bomb_right=new ImageIcon("images/boom.png");
		bomb_left=new ImageIcon("images/boom_left.png");
		bomb_img=bomb_left.getImage();
		box=new ImageIcon("images/box.png");
		box_img=box.getImage();
		
		block.add(new BlockObject(0,705,1020,80));
		block.add(new BlockObject(70,625,80,40));
		block.add(new BlockObject(230,585,80,40));
		

		block.add(new BlockObject(340,470,40*5,40));
		block.add(new BlockObject(600,665,40,40));
		
		block.add(new BlockObject(800,585,40,120));
		block.add(new BlockObject(920,585,40,120));
		block.add(new BlockObject(840,585,80,40));
		
		block.add(new BlockObject(600,370,40*4,40));
		
		star.add(new BlockObject(850,635,40,40));
		
		obstacle.add(new BlockObject(920,545,50,50));
		obstacle.add(new BlockObject(670,320,50,50));
	
		star.add(new BlockObject(20,80,40,40));
		block.add(new BlockObject(0,150,40*4,40));
		
		block.add(new BlockObject(480,300,40,40));
		block.add(new BlockObject(340,250,40,40));
		block.add(new BlockObject(200,180,40,40));
		box_block.add(new BlockObject(890,150,40,40));
		star.add(new BlockObject(900,100,40,40));
		
	}


	public void draw(Graphics g) {

		
		
		//System.out.println(block.get(0).x);
		//1¹øÂ°
		g.drawImage(img,0,0,1010,800,null);

		for(int i=0;i<28;i++) {
			g.drawImage(wall_img, 40*i, 705,null);
			g.drawImage(wall_img, 40*i, 745,null);
		}
		g.drawImage(wall_img, block.get(1).x, block.get(1).y,null);
		g.drawImage(wall_img, block.get(1).x+40, block.get(1).y,null);
	

		g.drawImage(wall_img, block.get(2).x, block.get(2).y,null);
		g.drawImage(wall_img, block.get(2).x+40, block.get(2).y,null);
		
		for(int i=0;i<5;i++)
			g.drawImage(wall_img, block.get(3).x+40*i, block.get(3).y,null);

		g.drawImage(wall_img, block.get(4).x, block.get(4).y,null);
		for(int i=0;i<3;i++) {
			g.drawImage(wall_img, block.get(5).x, block.get(5).y+i*40,null);
			g.drawImage(wall_img, block.get(6).x,block.get(6).y+i*40,null);
		}

		if(!stop) {
			g.drawImage(wall_img, block.get(7).x,block.get(7).y,null);
			g.drawImage(wall_img, block.get(7).x+40,block.get(7).y,null);
		}
		for(int i=0;i<4;i++)
			g.drawImage(wall_img, block.get(8).x+i*40,block.get(8).y,null);
		
		if(PlatformScene_One.bluedia1)
			g.drawImage(star_img,star.get(0).x,star.get(0).y,null);
		if(PlatformScene_One.bluedia2)
			g.drawImage(star_img,star.get(1).x,star.get(1).y,null);
		if(!tread1) {
			g.drawImage(mushroom_img,obstacle.get(0).x,obstacle.get(0).y,null);
		}
		if(!tread2) {
			g.drawImage(bomb_img,obstacle.get(1).x,obstacle.get(1).y,null);
		}
		for(int i=0;i<4;i++)
			g.drawImage(wall_img, block.get(9).x+i*40,block.get(9).y,null);
		if(appear) {
			for(int i=10;i<13;i++)
				g.drawImage(wall_img, block.get(i).x,block.get(i).y,null);
		}
		g.drawImage(box_img,box_block.get(0).x,box_block.get(0).y,null);
		
		if(PlatformScene_One.bluedia3)
			g.drawImage(star_img,star.get(2).x,star.get(2).y,null);
	}
	
	public void updateLocation() {
		// TODO Auto-generated method stub

		this.speed=1;

		
		if(coordinates==1&&stop_block==false) {

			if(box_block.get(0).x>850||box_block.get(0).y<250) {
				box_block.get(0).x-=speed;
				box_block.get(0).y+=speed;
				star.get(2).x-=speed;
				star.get(2).y+=speed;
			}
			else	coordinates=2;
		}
		if(coordinates==2&&stop_block==false) {
			if(box_block.get(0).x>750||box_block.get(0).y>150) {
				box_block.get(0).x-=speed;
				box_block.get(0).y-=speed;
				star.get(2).x-=speed;
				star.get(2).y-=speed;
			}
			else
				coordinates=3;
		}
		if(coordinates==3&&stop_block==false) {
			if(box_block.get(0).x>650||box_block.get(0).y<250) {
				box_block.get(0).x-=speed;
				box_block.get(0).y+=speed;
				star.get(2).x-=speed;
				star.get(2).y+=speed;
			}
			else
				coordinates=4;
		}
		if(coordinates==4&&stop_block==false) {
			if(box_block.get(0).x>550||box_block.get(0).y>150) {
				box_block.get(0).x-=speed;
				box_block.get(0).y-=speed;
				star.get(2).x-=speed;
				star.get(2).y-=speed;
			}else
				coordinates=5;
		}
		if(coordinates==5&&stop_block==false) {
			if(box_block.get(0).x<650&&box_block.get(0).y<250) {
				box_block.get(0).x+=speed;
				box_block.get(0).y+=speed;
				star.get(2).x+=speed;
				star.get(2).y+=speed;
			}else	coordinates=6;
		}
		if(coordinates==6&&stop_block==false) {
			if(box_block.get(0).x<750&&box_block.get(0).y>150) {
				box_block.get(0).x+=speed; 
				box_block.get(0).y-=speed;
				star.get(2).x+=speed;
				star.get(2).y-=speed;
			}else coordinates=7;
		}
		if(coordinates==7&&stop_block==false) {
			if(box_block.get(0).x<850&&box_block.get(0).y<250) {
				box_block.get(0).x+=speed;
				box_block.get(0).y+=speed;
				star.get(2).x+=speed;
				star.get(2).y+=speed;
			}else coordinates=8;
		}
		if(coordinates==8&&stop_block==false) {
			if(box_block.get(0).x<890&&box_block.get(0).y>150) {
				box_block.get(0).x+=speed;
				box_block.get(0).y-=speed;
				star.get(2).x+=speed;
				star.get(2).y-=speed;
			}else coordinates=1;
		}
	
		if(stop_block==true) {
			box_img=stop_box.getImage();
			stop=true;
		}
		else
			box_img=box.getImage();
		
		if(control)
			if(obstacle.get(1).x>580) {
				obstacle.get(1).x-=speed;
				bomb_img=bomb_left.getImage();
			}
			else control=false;
		else {
			if(obstacle.get(1).x<=720) {
				obstacle.get(1).x+=speed;
				bomb_img=bomb_right.getImage();
			}
			else
				control=true;
		}
		
		if(obstacle.get(0).x>block.get(5).x-50)
			obstacle.get(0).x-=1;
		else {
				if(obstacle.get(0).y<block.get(4).y) {
					obstacle.get(0).y+=3;
				}
				else {		
					if(control_2)
						if(obstacle.get(0).x>block.get(4).x+40)
							obstacle.get(0).x-=1;
						else
							control_2=false;
					else {
						if(obstacle.get(0).x<block.get(5).x-50)
							obstacle.get(0).x+=1;
						else
							control_2=true;
					}
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

