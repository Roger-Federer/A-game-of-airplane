
package code;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


import java.awt.Graphics;

/**
 * class detail:游戏主窗口
 * @author GJXAIOU
 * @since  2019年3月28日
 */
public class GameFrame extends JFrame{  //要继承系统中默认的JFrame

	
	//窗口中图形和文本的绘制
	
	Image backgroundImg = GameUtil.getImage("images/background.jpg");
	Image planeImg = GameUtil.getImage("images/plane.png");
	
	plane plane  = new plane(planeImg,250,250);
	Shell shell =  new Shell();
	
	public void paint(Graphics g){
		g.drawImage(backgroundImg, 0, 0, null);
		plane.drawSelf(g); //画飞机
		
		shell.draw(g); //画炮弹
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
		
		/* (non-Javadoc)
		 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			plane.addDirection(arg0);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
		 */
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
	}	
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame frame = new GameFrame();
		frame.launchFrame();

	}

}
