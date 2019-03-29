/**
 * 
 */
package code;

import java.awt.Color;
import java.awt.Graphics;



/**
 * class detail:�ӵ��ࣺ����Ĭ����һ����ɫ��ʵ��С�����
 * @author GJXAIOU
 * @since  2019��3��29��
 */
public class Shell extends GameObject{
	double degree; //�����degree�ǻ��ȣ���ΧΪ0-2PI

	public Shell() {
		// TODO Auto-generated constructor stub
		//�ӵ��ĳ�ʼλ��
		x = 200;
		y = 200;
		
		width = 10;
		height = 10;
		speed = 5;
		degree = Math.random()*Math.PI*2;
		
	} 
	
	//���ڵ�������
	public void draw(Graphics graphics) {
		Color color = graphics.getColor(); //������ɫ������֮��ģ�ʹ��֮ǰ�Ƚ�Ĭ��ֵ���棬����Ĭ����ɫ�ͻ����
		graphics.setColor(Color.YELLOW);
		
		//����ڵ���ɫ
		graphics.fillOval((int)x, (int)y, width, height);
		
		//�ڵ���������Ƕȷ���
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		
		//�ӵ������߽緵��
		if (x < 0 || x > Constant.GAME_WIDTH - width) {
			degree = Math.PI - degree;
		} 
		if (y < 30 || y > Constant.GAME_HEIGHT - height) {
			degree = -degree;
		}
		
		
		graphics.setColor(color); //��֮ǰ�������ɫ������ָ�
	}

}
