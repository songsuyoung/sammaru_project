package StageOne;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class CharacterObject {

		int x = 0;
		int y = 0;	
		int width = 0;
		int height = 0;
		int speed = 0;
		
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
		
		public CharacterObject(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		
		abstract public void updateLocation(); // ���� ��ü(��ϰ�����)�� ��ǥ�� ������Ʈ �ϴ� �޼ҵ� 
		abstract public void draw(Graphics g); // ȭ�鿡 ���� ��ü �ڽ��� �׸��� �޼ҵ�
		
	    public Rectangle getBound(){    // ���� ��ü�� �ܰ����� ��ȯ, -> �浹�˻�
	        return new Rectangle(x, y, width, height);
	    }
	    
	    
	    public Rectangle getBottomBound(){
	    	return new Rectangle((int)x+width/6, (int)y + height/2, 2*width/3, height/2);           //  300, 630, 40, 40              300 + 40/6 = 306,  630 + 40/2 = 650,  26, 20
	    	//return new Rectangle(x, y+height-5, width, 5);
	    
	    }
	    
	    public Rectangle getTopBound(){
	        return new Rectangle((int)x+width/6, (int)y, 2*width/3, height/2);
	    	//return new Rectangle(x, y, width, 5);
	    }
	    
	    public Rectangle getLeftBound() {
	    	return new Rectangle(x+3, y, 1, height);
	    	//return new Rectangle(x, y, width/3, height);
	    }
	    
	    public Rectangle getRightBound() {
	    	return new Rectangle(x+width-3, y, 1, height);
	    	//return new Rectangle(x+width-width/3, y, width/3, height);
	    }
	    
	    
		
}
