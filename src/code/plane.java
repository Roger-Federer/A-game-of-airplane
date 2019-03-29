/**
 * 
 */
package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**
 * class detail:定义飞机类
 * @author GJXAIOU
 * @since  2019年3月28日
 */
public class plane extends GameObject {
	int speed = 3;
	boolean up,down,left,right;  //定义上下左右方向

	public void drawSelf(Graphics graphics) {
		graphics.drawImage(image, (int)x, (int)y, null);
		
		//根据按键的方向实现飞机的移动
		if (left) {
			x -= speed;			
		} else if (right) {
			x += speed;
		} else if (up) {
			y -= speed;
		}else if (down) {
			y += speed;
		}
		
	}
	public plane (Image image,double x, double y) {
		this.image = image;
		this.x = x;
		this.y = y;
		
	}
	
	//根据监听到的键盘的键位增加方向：即相当于按下之后
	
	public void addDirection(KeyEvent event) { //传入的对象包含按了那个键信息
		switch (event.getKeyCode()) { //因为键盘上的见本质上均对应于一个数字
		//case 38://38对应于up键
		case KeyEvent.VK_UP: //或者使用自带的方法，不需要记忆数字了
			up  = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		default:
			break;
		}
		
	}
	
	//监听到抬起某个方向键，则取消增加某个方向
	public void cancelDirection(KeyEvent event) { //传入的对象包含按了那个键信息
		switch (event.getKeyCode()) { //因为键盘上的见本质上均对应于一个数字
		//case 38://38对应于up键
		case KeyEvent.VK_UP: //或者使用自带的方法，不需要记忆数字了
			up  = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		default:
			break;
		}
		
	}
	
	
}
