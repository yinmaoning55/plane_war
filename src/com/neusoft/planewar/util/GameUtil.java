package com.neusoft.planewar.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * ��ȡ��Ϸ��Ŀ��ͼƬ����������������Դ�ļ��Ĺ�����
 * �������еķ������Ǿ�̬����
 * @author SomnusԶ��
 *
 */
public class GameUtil {
	/**
	 * ����ͼƬ·����ȡͼƬ����
	 * @param imgPath
	 * @return
	 */
	public static Image getImage(String imgPath) {
		URL u = GameUtil.class.getClassLoader().getResource(imgPath);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
}
