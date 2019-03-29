/**
 * 
 */
package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * class detail:���һ���ɻ����ӵ����л��ȵȵ�����
 * ������ͼƬ�����ꡢ�ٶȡ��߶ȡ���ȣ�
 * @author GJXAIOU
 * @since  2019��3��28��
 */
public class GameObject {
	Image image;
	double x,y;
	int speed;
	int width,height;
	
	//������Щ���������Լ�������
	public void drawSelf(Graphics graphics) {
		graphics.drawImage(image, (int)x, (int)y, null); //��Ϊ������ʾ������ȫ��Ϊ������������Ҫǿת
	}
	
	//�������ؼ�����������ʹ�ã�source/Generater constructor to invoke

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
	 * �����������ڵľ��Σ����ں�������ײ��⣬��ν����ײ�������жϾ����Ƿ��ཻ
	 */
	
	public Rectangle getRect() {
		return new Rectangle((int)x, (int)y, width,height);
		
	}
	
	

}
