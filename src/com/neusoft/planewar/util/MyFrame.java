
package com.neusoft.planewar.util;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.neusoft.planewar.constant.constants;

/**
 * 使用Java中的java.awt.*包中相关的类，完成GUI中的图形界面 目的：让大家数java中面向对象编程的思维，
 * 为今后使用面接口编程和面向切面编程打好基础 更为后期大数据的学习，打好基础 步骤： 1.让自定义的类继承Frame类 2.重写paint(Graphic
 * g) 3.自定义初始化的窗口
 * 
 * @author Somnus远哥
 *
 */
@SuppressWarnings("all")
public class MyFrame extends Frame {
	@Override
	public void paint(Graphics g) {

	}

	/**
	 * 初始化窗口的方法
	 */
	public void launchFrame() {
		// 窗口大小
		this.setSize(constants.GAME_WIDTH, constants.GAME_HEIGHT);
		// 设置窗口的可变大小（默认是true）
		this.setResizable(false);// 不能最大化
		// 窗口的可见性
		this.setVisible(true);
		// 窗口生成的位置
		// this.setLocation(100, 100);
		// 居中显示:如果传入null值，则相对屏幕居中
		this.setLocationRelativeTo(null);

		// this.setBackground(new Color(57, 50, 99));

		this.setTitle("我的第一个窗口");

		// 关闭窗口的功能，匿名内部类
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 0:关闭窗口
				System.exit(0);
			}
		});
		new MyThread().start();
	}

	Image backImg = null;

	public void update(Graphics g) {
		if (backImg == null) {
			backImg = createImage(constants.GAME_WIDTH, constants.GAME_HEIGHT);
		}
		Graphics backg = backImg.getGraphics();
		Color c = backg.getColor();
		backg.setColor(Color.black);
		backg.fillRect(0, 0, constants.GAME_WIDTH, constants.GAME_HEIGHT);
		backg.setColor(c);
		paint(backg);
		g.drawImage(backImg, 0, 0, null);
	}

	class MyThread extends Thread {
		@Override
		public void run() {
			while (true) {
				repaint();// Frame中的重画方法，会自动调用paint()方法
				try {
					// 根据不同的CPU，为让程序运行更流畅
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
