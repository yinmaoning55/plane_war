
package com.neusoft.planewar.util;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.neusoft.planewar.constant.constants;

/**
 * ʹ��Java�е�java.awt.*������ص��࣬���GUI�е�ͼ�ν��� Ŀ�ģ��ô����java����������̵�˼ά��
 * Ϊ���ʹ����ӿڱ�̺����������̴�û��� ��Ϊ���ڴ����ݵ�ѧϰ����û��� ���裺 1.���Զ������̳�Frame�� 2.��дpaint(Graphic
 * g) 3.�Զ����ʼ���Ĵ���
 * 
 * @author SomnusԶ��
 *
 */
@SuppressWarnings("all")
public class MyFrame extends Frame {
	@Override
	public void paint(Graphics g) {

	}

	/**
	 * ��ʼ�����ڵķ���
	 */
	public void launchFrame() {
		// ���ڴ�С
		this.setSize(constants.GAME_WIDTH, constants.GAME_HEIGHT);
		// ���ô��ڵĿɱ��С��Ĭ����true��
		this.setResizable(false);// �������
		// ���ڵĿɼ���
		this.setVisible(true);
		// �������ɵ�λ��
		// this.setLocation(100, 100);
		// ������ʾ:�������nullֵ���������Ļ����
		this.setLocationRelativeTo(null);

		// this.setBackground(new Color(57, 50, 99));

		this.setTitle("�ҵĵ�һ������");

		// �رմ��ڵĹ��ܣ������ڲ���
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 0:�رմ���
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
				repaint();// Frame�е��ػ����������Զ�����paint()����
				try {
					// ���ݲ�ͬ��CPU��Ϊ�ó������и�����
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
