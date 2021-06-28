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
	
	// 하위 클래스에서 꼭 구현해줘야함,
	abstract public void updateLocation(); // 게임 객체(블록같은것)의 좌표를 업데이트 하는 메소드 
	abstract public void draw(Graphics g); // 화면에 게임 객체 자신을 그리는 메소드
	
    public Rectangle getBound(){    // 게임 객체의 외곽선을 반환, -> 충동검사
        return new Rectangle(x, y, width, height);
    }
    
    //위 3개는 오브젝트가 움직일떄마다 계~속 호출
    
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
