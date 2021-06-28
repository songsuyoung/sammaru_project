package StageTwo;
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
		if (PlatformScene_Two.checkleft && PlatformScene_Two.leftMove) {

			//img = icon1.getImage();
			
			if (img != icon1.getImage()) {
				img = icon1.getImage();
			}
			
			if (PlatformScene_Two.isJumping == false && img == icon1.getImage() && dx >= 5 ) {
				img = icon1_2.getImage();
				dx = 0;
			}
			

			x -= speed;
			dx += 1;

		}

		if (PlatformScene_Two.checkright && PlatformScene_Two.rightMove) {
			
			//img = icon2.getImage();
			
			if (img != icon2.getImage()) {
				img = icon2.getImage();
			}
			
			if (PlatformScene_Two.isJumping == false && img == icon2.getImage() && dx >= 5) {
				img = icon2_2.getImage();
				dx = 0;
			}

			
			x += speed;
			dx += 1;
			
		}

		if (PlatformScene_Two.onTop) { // ��� �ö� ���� ��
			if (img == leftjump.getImage())
				img = icon1.getImage();
			else if (img == rightjump.getImage())
				img = icon2.getImage();

		}

		{
			if (PlatformScene_Two.jumping) {// ���� ��ġ, ���� ��ġ
				if (img == icon1.getImage() || img == icon1_2.getImage())
					img = leftjump.getImage();
				else if (img == icon2.getImage() || img == icon2_2.getImage())
					img = rightjump.getImage();

				PlatformScene_Two.isJumping = true;

				y -= jumpspeed;
				dy += jumpspeed;

				if (dy >= upperMax) {
					PlatformScene_Two.jumping = false;
					// FlatformScene.falling = true;
					dy = 0;
				}
			}

			else if (PlatformScene_Two.falling) {

				y += jumpspeed;
				PlatformScene_Two.isJumping = true;

				if (img == leftjump.getImage())
					img = icon1.getImage();
				else if (img == rightjump.getImage())
					img = icon2.getImage();
			}
		}

		if (y <= PlatformScene_Two.height) {
			PlatformScene_Two.falling = true;
		}

	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, x, y, width, height, null); // this? null?
		//
		// �ڵ� �߰�
		//
	}
}
