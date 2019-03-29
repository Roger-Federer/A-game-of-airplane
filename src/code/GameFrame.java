
package code;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


import java.awt.Graphics;

/**
 * class detail:��Ϸ������
 * @author GJXAIOU
 * @since  2019��3��28��
 */
public class GameFrame extends JFrame{  //Ҫ�̳�ϵͳ��Ĭ�ϵ�JFrame

	
	//������ͼ�κ��ı��Ļ���
	
	Image backgroundImg = GameUtil.getImage("images/background.jpg");
	Image planeImg = GameUtil.getImage("images/plane.png");
	
	plane plane  = new plane(planeImg,250,250);
	Shell shell =  new Shell();
	
	public void paint(Graphics g){
		g.drawImage(backgroundImg, 0, 0, null);
		plane.drawSelf(g); //���ɻ�
		
		shell.draw(g); //���ڵ�
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
	}	
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame frame = new GameFrame();
		frame.launchFrame();

	}

}
