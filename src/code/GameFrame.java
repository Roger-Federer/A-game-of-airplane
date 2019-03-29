
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
 * class detail:��Ϸ������
 * @author GJXAIOU
 * @since  2019��3��28��
 */
public class GameFrame extends Frame{  //Ҫ�̳�ϵͳ��Ĭ�ϵ�Frame
	//��ΪJframe��Frame����˸����������ʹ��Frame��˫��������˸����
	
	
	//˫�������
	private Image offScreenImage = null;
	public void update(Graphics graphics) {
		if (offScreenImage  == null) {
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
			Graphics gOff = offScreenImage.getGraphics();
			paint(gOff);
			graphics.drawImage(offScreenImage, 0, 0, null);
	}
	
	

	
	//������ͼ�κ��ı��Ļ���
	
	Image backgroundImg = GameUtil.getImage("images/background.jpg");
	Image planeImg = GameUtil.getImage("images/plane.png");
	
	plane plane  = new plane(planeImg,250,250);
	//Shell shell =  new Shell();
	//����30���ڵ�
	Shell[] shells = new Shell[30];
	
	Explode baozha; //������ը����
	
	//��ʱ
	Date startTime = new Date();//��Ϸ��ʼʱ��
	Date endTime;//��Ϸ����ʱ��
	int period;
	
	public void paint(Graphics g){
		g.drawImage(backgroundImg, 0, 0, null);
		plane.drawSelf(g); //���ɻ�
		
		//����50���ڵ�
		for(int i=0; i<shells.length; i++) {
			shells[i].draw(g);
			
			//�жϷɻ����ӵ��Ƿ���ײ
			boolean peng = shells[i].getRect().intersects(plane.getRect());
			
			if (peng) {
				plane.live = false;
				endTime = new Date();
				
				//��ʾ��ըЧ��
				if(baozha == null) {  //ֻҪ��ײֻ����һ���������û������һֱ����СͼƬ
					baozha = new Explode(plane.x, plane.y);		
				}	
				baozha.draw(g);						
			}
		}
			
			//��ʱ��������ʾ
			if(!plane.live) {
			   period = (int)((endTime.getTime() - startTime.getTime())/1000); //��Ϊ�Ǻ�����
			   printInfo(g, "ʱ�䣺"+period+"��", 50, 120, 260, Color.white);	
			   
			   for(int i = 0; i < shells.length; i++) {
				   shells[i].stop();
			   }
	      }
			
			
			
		
  }	
	
	
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
        Color c = g.getColor();
        g.setColor(color);
        Font f = new Font("����",Font.BOLD,size);
        g.setFont(f);
        g.drawString(str,x,y);
        g.setColor(c);
    }  
	
	
	
	//�������Ƿ������ػ�����
	//ʹ���ڲ��ࣺ�ڲ������ֱ��ʹ���ⲿ����������Ժͷ���
	class PaintThread extends Thread{
		
		public void run() {
			while (true) {
				repaint(); //�����ػ�
				try {
					Thread.sleep(40);//ÿ40ms�ػ�һ��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	
	/*
	 * ʹ�ü��̿��Ʒɻ����ƶ�
	 * 
	 */
	class keyMonitor extends KeyAdapter{

		//��д����KeyAdapter��������
		//ʹ��source/override Implement Methods
		//��д��KeyPressed ��KeyReleased ������������ʾ������갴�º��ɿ�
		
		
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
	 * @param ��ʼ������
	 */
	public void launchFrame() {
		this.setTitle("GJXAIOU"); //���ô��ڱ���
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);  //���ô��ڴ�С
		this.setLocation(200, 200); //���ô���λ�ã����Ͻ�����Ļ���Ͻǵ����꣩
		this.setVisible(true); //���ô��ڿɼ� ��Ĭ������²��ɼ�
		
		//���������Ϊ�˿����ô��������رգ����ǵ��X�ų���͹ر�
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);   //����0��ʾ����������������ʾ�쳣����
				
			}
		});
		
		
		//��Ҫ
		new PaintThread().start();  //�����ػ��߳�
		addKeyListener(new keyMonitor());  //�������������̼���
		
		//��ʼ��50���ڵ�
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
