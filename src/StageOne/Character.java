package StageOne;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Character extends CharacterObject {
	
	static ImageIcon icon1 = new ImageIcon("images/mario_leftwalk.png");
	static ImageIcon icon1_2 = new ImageIcon("images/mario_leftwalk2.png");
	static ImageIcon leftjump = new ImageIcon("images/mario_leftjump.png");
	
	static ImageIcon icon2 = new ImageIcon("images/mario_rightwalk.png");
	static ImageIcon icon2_2 = new ImageIcon("images/mario_rightwalk2.png");
	static ImageIcon rightjump = new ImageIcon("images/mario_rightjump.png");

	
	static Image img = icon2.getImage();

	int upperMax = 120;
    static int dy = 0;
	int jumpspeed = 3;
	
	int movecheck = 0;
	
	int dx = 0;
	
	public Character(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 2;
	}

	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}

	@Override
	public void updateLocation() {
		if (PlatformScene_One.checkleft && PlatformScene_One.leftMove) {

			//img = icon1.getImage();
			
			if (img != icon1.getImage()) {
				img = icon1.getImage();
			}
			
			if (PlatformScene_One.isJumping == false && img == icon1.getImage() && dx >= 5 ) {
				img = icon1_2.getImage();
				dx = 0;
			}
			

			x -= speed;
			dx += 1;

		}

		if (PlatformScene_One.checkright && PlatformScene_One.rightMove) {
			
			//img = icon2.getImage();
			
			if (img != icon2.getImage()) {
				img = icon2.getImage();
			}
			
			if (PlatformScene_One.isJumping == false && img == icon2.getImage() && dx >= 5) {
				img = icon2_2.getImage();
				dx = 0;
			}

			
			x += speed;
			dx += 1;
			
		}

		if (PlatformScene_One.onTop) { // 블록 올라 갔을 때
			if (img == leftjump.getImage())
				img = icon1.getImage();
			else if (img == rightjump.getImage())
				img = icon2.getImage();

		}

		{
			if (PlatformScene_One.jumping) {// 점프 위치, 착지 위치
				if (img == icon1.getImage() || img == icon1_2.getImage())
					img = leftjump.getImage();
				else if (img == icon2.getImage() || img == icon2_2.getImage())
					img = rightjump.getImage();

				PlatformScene_One.isJumping = true;

				y -= jumpspeed;
				dy += jumpspeed;

				if (dy >= upperMax) {
					PlatformScene_One.jumping = false;
					// FlatformScene.falling = true;
					dy = 0;
				}
			}

			else if (PlatformScene_One.falling) {

				y += jumpspeed;
				PlatformScene_One.isJumping = true;

				if (img == leftjump.getImage())
					img = icon1.getImage();
				else if (img == rightjump.getImage())
					img = icon2.getImage();
			}
		}

		if (y <= PlatformScene_One.height) {
			PlatformScene_One.falling = true;
		}

	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, x, y, width, height, null); // this? null?
		//
		// 코드 추가
		//
	}
}
