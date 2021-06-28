package StageThree;

import java.awt.Graphics;   
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.*;

public abstract class GameObject {

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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public GameObject() {}
	
	// ���� Ŭ�������� �� �����������,
	abstract public void updateLocation(); // ���� ��ü(��ϰ�����)�� ��ǥ�� ������Ʈ �ϴ� �޼ҵ� 
	abstract public void draw(Graphics g); // ȭ�鿡 ���� ��ü �ڽ��� �׸��� �޼ҵ�
	
    public Rectangle getBound(){    // ���� ��ü�� �ܰ����� ��ȯ, -> �浿�˻�
        return new Rectangle(x, y, width, height);
    }
    
    //�� 3���� ������Ʈ�� �����ϋ����� ��~�� ȣ��
    
    public Rectangle getBottomBound(){
        //return new Rectangle((int)x+width/6, (int)y + height/2, 2*width/3, height/2);
    	return new Rectangle(x, (int)y+height/2, width, height/2);
    	//return new Rectangle(x, y+height-1, width, 1);
    }
    
    public Rectangle getTopBound(){
     	//return new Rectangle(x, y, width, height);
    	return new Rectangle(x, y+1, width, height/2);
    }
    
    public Rectangle getLeftBound() {
    	return new Rectangle(x, y+4, width/3, height-4);
    }
    
    public Rectangle getRightBound() {
    	return new Rectangle(x+width-width/3, y+4, width/3, height-4);
    }
    
    public Rectangle getobstacle() {
    	return new Rectangle(x+width/2 , y+height/2, 1, 1); 
    }
    
    
 
	
}
