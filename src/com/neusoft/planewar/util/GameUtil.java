package com.neusoft.planewar.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 获取游戏项目中图片、声音、视屏的资源文件的工具类
 * 工具类中的方法都是静态方法
 * @author Somnus远哥
 *
 */
public class GameUtil {
	/**
	 * 根据图片路径获取图片对象
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
