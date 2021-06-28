
package StageTwo;

import java.awt.Graphics;

public class BlockObject extends GameObject {
	private int size; //추가되는 넓이
	
	public BlockObject(int x,int y,int block_w,int block_h) {
		
		this.x=x;
		this.y=y;
		this.width=block_w;
		this.height=block_h;
		
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	int size_s(int x) {
		this.size=x;
		return size;
	}

	@Override
	public void updateLocation() {}

	@Override
	public void draw(Graphics g) {}
}
