/**
 * 
 */
package code;

import java.awt.Graphics;
import java.awt.Image;

/**
 * class detail:ʵ�ַɻ���ըЧ��
 * @author GJXAIOU
 * @since  2019��3��29��
 */
public class Explode {
	double x,y; //��ը��λ��
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
