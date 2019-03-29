package code;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import java.awt.Image;

/**
 * class detail: 用于加载背景图片，该类是写好的直接抄即可
 * @author GJXAIOU
 * @since  2019年3月28日
 */
public class GameUtil {
	//工具类最好是将构造器进行私有
	private GameUtil () {
		
	}
	
	//返回指定路径文件的图片对象
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
