package code;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import java.awt.Image;

/**
 * class detail: ���ڼ��ر���ͼƬ��������д�õ�ֱ�ӳ�����
 * @author GJXAIOU
 * @since  2019��3��28��
 */
public class GameUtil {
	//����������ǽ�����������˽��
	private GameUtil () {
		
	}
	
	//����ָ��·���ļ���ͼƬ����
	public static Image getImage(String path) {
		BufferedImage bImage = null;
		try {
			URL url = GameUtil.class.getClassLoader().getResource(path);
			bImage = ImageIO.read(url);
		}catch (IOException exception) {
			exception.printStackTrace();
		}
		return bImage;
	}

}
