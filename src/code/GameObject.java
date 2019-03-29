/**
 * 
 */
package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * class detail:设计一个飞机、子弹、敌机等等的总类
 * 包含：图片、坐标、速度、高度、宽度；
 * @author GJXAIOU
 * @since  2019年3月28日
 */
public class GameObject {
	Image image;
	double x,y;
	int speed;
	int width,height;
	
	//根据这些变量，将自己画出来
	public void drawSelf(Graphics graphics) {
		graphics.drawImage(image, (int)x, (int)y, null); //因为根据提示：参数全部为整数，所以需要强转
	}
	
	//下面重载几个构造器：使用：source/Generater constructor to invoke

	/**
	 * @param image
	 * @param x
	 * @param y
	 * @param speed
	 * @param width
	 * @param height
	 */
	public GameObject(Image image, double x, double y, int speed, int width, int height) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	/**
	 * @param image
	 * @param x
	 * @param y
	 */
	public GameObject(Image image, double x, double y) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 */
	public GameObject() {
		super();
	}
	
	/*
	 * 返回物体所在的矩形，便于后续的碰撞检测，所谓的碰撞检测就是判断矩形是否相交
	 */
	
	public Rectangle getRect() {
		return new Rectangle((int)x, (int)y, width,height);
		
	}
	
	

}
