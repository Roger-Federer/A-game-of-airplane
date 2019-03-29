/**
 * 
 */
package code;

import java.awt.Color;
import java.awt.Graphics;



/**
 * class detail:子弹类：这里默认以一个黄色的实心小球替代
 * @author GJXAIOU
 * @since  2019年3月29日
 */
public class Shell extends GameObject{
	double degree; //这里的degree是弧度，范围为0-2PI

	public Shell() {
		// TODO Auto-generated constructor stub
		//子弹的初始位置
		x = 200;
		y = 200;
		
		width = 10;
		height = 10;
		speed = 5;
		degree = Math.random()*Math.PI*2;
		
	} 
	
	//将炮弹画出来
	public void draw(Graphics graphics) {
		Color color = graphics.getColor(); //更改颜色和字体之类的，使用之前先将默认值保存，否则默认颜色就会更改
		graphics.setColor(Color.YELLOW);
		
		//填充炮弹颜色
		graphics.fillOval((int)x, (int)y, width, height);
		
		//炮弹沿着任意角度飞行
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		
		//子弹碰到边界返回
		if (x < 0 || x > Constant.GAME_WIDTH - width) {
			degree = Math.PI - degree;
		} 
		if (y < 30 || y > Constant.GAME_HEIGHT - height) {
			degree = -degree;
		}
		
		
		graphics.setColor(color); //将之前保存的颜色和字体恢复
	}

}
