/**
 * 
 */
package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.imageio.ImageTypeSpecifier;

/**
 * class detail:����ɻ���
 * @author GJXAIOU
 * @since  2019��3��28��
 */
public class plane extends GameObject {
	int speed = 3;
	boolean up,down,left,right;  //�����������ҷ���

	//�жϷɻ����˻��ǻ���
	boolean live = true;
	
	
	public void drawSelf(Graphics graphics) {
		if(live){
			graphics.drawImage(image, (int)x, (int)y, null);
			
			//���ݰ����ķ���ʵ�ַɻ����ƶ�
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
	}
	
	
	
	public plane (Image image,double x, double y) {
		this.image = image;
		this.x = x;
		this.y = y;
		
		//�趨�ɻ��ĳ��ȺͿ��
		this.speed = 3;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		
	}
	
	//���ݼ������ļ��̵ļ�λ���ӷ��򣺼��൱�ڰ���֮��
	
	public void addDirection(KeyEvent event) { //����Ķ�����������Ǹ�����Ϣ
		switch (event.getKeyCode()) { //��Ϊ�����ϵļ������Ͼ���Ӧ��һ������
		//case 38://38��Ӧ��up��
		case KeyEvent.VK_UP: //����ʹ���Դ��ķ���������Ҫ����������
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
	
	//������̧��ĳ�����������ȡ������ĳ������
	public void cancelDirection(KeyEvent event) { //����Ķ�����������Ǹ�����Ϣ
		switch (event.getKeyCode()) { //��Ϊ�����ϵļ������Ͼ���Ӧ��һ������
		//case 38://38��Ӧ��up��
		case KeyEvent.VK_UP: //����ʹ���Դ��ķ���������Ҫ����������
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
