/**
 * 
 */
package code;

import java.awt.Graphics;
import java.awt.Image;

/**
 * class detail:实现飞机爆炸效果
 * @author GJXAIOU
 * @since  2019年3月29日
 */
public class Explode {
	double x,y; //爆炸的位置
	static Image[] images = new Image[16];
	static {
		for(int i = 0; i < 16;i++) {
			images[i] = GameUtil.getImage("images/explode/e" + (i + 1)+ "gif");
			images[i].getWidth(null);
		}
	}
	
	int count;
	public void draw(Graphics graphics) {
		if(count <= 15) {
			graphics.drawImage(images[count], (int)x,(int)y,null);
			count++;
		}
	}
	public Explode (double x, double y) {
		this.x = x;
		this.y = y;
	}

}
