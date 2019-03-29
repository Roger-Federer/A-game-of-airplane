
package code;
import java.awt.Image;
import code.Constant;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

/**
 * class detail:游戏主窗口
 * @author GJXAIOU
 * @since  2019年3月28日
 */
public class GameFrame extends Frame{  //要继承系统中默认的Frame
	//因为Jframe和Frame均闪烁，所以这里使用Frame和双缓冲解决闪烁问题
	
	
	//双缓冲代码
	private Image offScreenImage = null;
	public void update(Graphics graphics) {
		if (offScreenImage  == null) {
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
			Graphics gOff = offScreenImage.getGraphics();
			paint(gOff);
			graphics.drawImage(offScreenImage, 0, 0, null);
	}
	
	

	
	//窗口中图形和文本的绘制
	
	Image backgroundImg = GameUtil.getImage("images/background.jpg");
	Image planeImg = GameUtil.getImage("images/plane.png");
	
	plane plane  = new plane(planeImg,250,250);
	//Shell shell =  new Shell();
	//建立30个炮弹
	Shell[] shells = new Shell[30];
	
	Explode baozha; //声明爆炸对象
	
	//计时
	Date startTime = new Date();//游戏开始时间
	Date endTime;//游戏结束时间
	int period;
	
	public void paint(Graphics g){
		g.drawImage(backgroundImg, 0, 0, null);
		plane.drawSelf(g); //画飞机
		
		//画出50个炮弹
		for(int i=0; i<shells.length; i++) {
			shells[i].draw(g);
			
			//判断飞机和子弹是否相撞
			boolean peng = shells[i].getRect().intersects(plane.getRect());
			
			if (peng) {
				plane.live = false;
				endTime = new Date();
				
				//显示爆炸效果
				if(baozha == null) {  //只要碰撞只建立一个对象，如果没有这句会一直建立小图片
					baozha = new Explode(plane.x, plane.y);		
				}	
				baozha.draw(g);						
			}
		}
			
			//计时功能与显示
			if(!plane.live) {
			   period = (int)((endTime.getTime() - startTime.getTime())/1000); //因为是毫秒数
			   printInfo(g, "时间："+period+"秒", 50, 120, 260, Color.white);	
			   
			   for(int i = 0; i < shells.length; i++) {
				   shells[i].stop();
			   }
	      }
			
			
			
		
  }	
	
	
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
        Color c = g.getColor();
        g.setColor(color);
        Font f = new Font("宋体",Font.BOLD,size);
        g.setFont(f);
        g.drawString(str,x,y);
        g.setColor(c);
    }  
	
	
	
	//帮助我们反复的重画窗口
	//使用内部类：内部类可以直接使用外部类的所有属性和方法
	class PaintThread extends Thread{
		
		public void run() {
			while (true) {
				repaint(); //窗口重画
				try {
					Thread.sleep(40);//每40ms重画一次
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	
	/*
	 * 使用键盘控制飞机的移动
	 * 
	 */
	class keyMonitor extends KeyAdapter{

		//重写父类KeyAdapter两个方法
		//使用source/override Implement Methods
		//重写：KeyPressed 和KeyReleased 两个方法：表示控制鼠标按下和松开
		
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			plane.addDirection(arg0);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			plane.cancelDirection(arg0);
		}
		
		
	}
	
	
	
	
	

	/**
	 * @param 初始化窗口
	 */
	public void launchFrame() {
		this.setTitle("GJXAIOU"); //设置窗口标题
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);  //设置窗口大小
		this.setLocation(200, 200); //设置窗口位置（左上角离屏幕左上角的坐标）
		this.setVisible(true); //设置窗口可见 ，默认情况下不可见
		
		//下面这段是为了可以让窗口正常关闭，就是点击X号程序就关闭
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);   //参数0表示正常结束，负数表示异常结束
				
			}
		});
		
		
		//重要
		new PaintThread().start();  //启动重画线程
		addKeyListener(new keyMonitor());  //给窗口启动键盘监听
		
		//初始化50个炮弹
		for(int i=0; i<shells.length; i++) {
			shells[i] = new Shell();
		}
	}	
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame frame = new GameFrame();
		frame.launchFrame();

	}

}
