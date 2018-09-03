package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.neusoft.planewar.client.PlanewarSystem;
import com.neusoft.planewar.constant.constants;
import com.neusoft.planewar.util.GameUtil;

public class Plane extends PlanewarObject {
	public PlanewarSystem pws;

	public int speed = constants.MYPLANE01_SPEED;

	public boolean left, up, right, down;

	public Direction dir;
	public boolean good;
	public boolean live = true;
	public int blood = 100;

	public Plane() {

	}

	public Plane(PlanewarSystem pws, int x, int y, String imgpath) {
		this.pws = pws;
		this.x = x;
		this.y = y;
		this.img = GameUtil.getImage(imgpath);
		this.dir = Direction.STOP;

	}

	public Plane(PlanewarSystem pws, int x, int y, Image img) {
		this.pws = pws;
		this.x = x;
		this.y = y;
		this.img = img;
		this.dir = Direction.STOP;
		this.good = true;
	}

	@Override
	public void move() {
		if (left)
			x -= speed;
		if (up)
			y -= speed;
		if (right)
			x += speed;
		if (down)
			y += speed;

		switch (dir) {
		case LEFT:
			x -= speed;
			// left = true;
			break;
		case UP:
			y -= speed;
			// up = true;
			break;
		case RIGHT:
			x += speed;
			// right = true;
			break;
		case DOWN:
			y += speed;
			// down = true;
			break;
		case LEFT_UP:
			x -= speed;
			y -= speed;
			// left = true;
			break;
		case RIGHT_UP:
			y += speed;
			x -= speed;
			// up = true;
			break;
		case RIGHT_DOWN:
			x += speed;
			y += speed;
			// right = true;
			break;
		case LEFT_DOWN:
			y += speed;
			x -= speed;
			// down = true;
			break;
		case STOP:

			// down = true;
			break;
		default:
			break;

		}
		if (this.x <= 0)
			this.x = 0;
		if (this.x >= constants.GAME_WIDTH - this.img.getWidth(null))
			this.x = constants.GAME_WIDTH - this.img.getWidth(null);
		if (this.y <= 40)
			this.y = 40;
		if (this.y >= constants.GAME_HEIGHT - this.img.getHeight(null))
			this.y = constants.GAME_HEIGHT - this.img.getHeight(null);
	}

	@Override
	public void draw(Graphics g) {

		move();
		if (good) {
			bloodBar.draw(g);
		}
		g.drawImage(img, x, y, null);

	}

	public BloodBar bloodBar = new BloodBar();;

	class BloodBar {

		//public Image bloodbarImg;
		public Image blooddivImg;
		public Image bloodoxImg;

		public BloodBar() {

			//this.bloodbarImg = Images.imgs.get("blood_back");
			this.blooddivImg = Images.imgs.get("blood_div");
			this.bloodoxImg = Images.imgs.get("blood_ox");

		}

		public void draw(Graphics g) {
			//g.drawImage(bloodbarImg, x+10 , y-5 , null);
			for (int i = 0; i < 10 * blood /100; i++) {
				g.drawImage(bloodoxImg, x +10+  (bloodoxImg.getWidth(null) ) * i, y-5 , null);
			}
			g.drawImage(blooddivImg,x +10 , y-5 , null);
		}
	}

	public void Keypressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:

			left = true;
			break;
		case KeyEvent.VK_UP:

			up = true;
			break;
		case KeyEvent.VK_RIGHT:

			right = true;
			break;
		case KeyEvent.VK_DOWN:

			down = true;
			break;
		case KeyEvent.VK_J:
			fire();

			break;
		case KeyEvent.VK_L:
			superfire();

			break;
		case KeyEvent.VK_K:
			superBullet s=new superBullet(pws);
             pws.superBullets.add(s);
			break;

		default:
			break;
		}

	}

	@SuppressWarnings("unused")
	public void fire() {
		int x = this.x + this.img.getWidth(null) / 2 - 21;
		int y = this.y;
		Bullet b = new Bullet(pws, x, y, Images.imgs.get("bullet01"), Direction.UP, constants.MYPLANE01_BULLET_SPEED,
				good);
		pws.bullets.add(b);
	}

	public void superfire() {
		Direction[] dirs = Direction.values();
		for (int i = 0; i < dirs.length - 1; i++) {
			Bullet b = new Bullet(pws, x, y, Images.imgs.get("bullet01"), dirs[i], constants.MYPLANE01_BULLET_SPEED,
					good);

			pws.bullets.add(b);
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:

			left = false;
			break;
		case KeyEvent.VK_UP:

			up = false;
			break;
		case KeyEvent.VK_RIGHT:

			right = false;
			break;
		case KeyEvent.VK_DOWN:

			down = false;
			break;
		case KeyEvent.VK_J:

			down = false;
			break;
		case KeyEvent.VK_K:

			down = false;
			break;

		default:
			break;
		}
		confirmDirection();
	}

	public void confirmDirection() {
		if (left && !up && !right && !down) {
			this.dir = Direction.LEFT;
		} else if (!left && up && !right && !down) {
			this.dir = Direction.UP;
		} else if (!left && !up && right && down) {
			this.dir = Direction.RIGHT;
		} else if (!left && !up && !right && down) {
			this.dir = Direction.DOWN;
		} else if (left && up && !right && !down) {
			this.dir = Direction.LEFT_UP;
		} else if (!left && up && right && !down) {
			this.dir = Direction.RIGHT_UP;
		} else if (left && !up && !right && down) {
			this.dir = Direction.LEFT_DOWN;
		} else if (!left && !up && right && down) {
			this.dir = Direction.RIGHT_DOWN;
		} else {
			this.dir = Direction.STOP;
		}
	}

	/**
	 * ³ÔµÀ¾ß
	 */

	public boolean eatItem(Item item) {
		if (this.live && item.live && this.getRectangle().intersects(item.getRectangle())&&this.blood<=70) {
			this.blood = 100;
			item.live=false;
		}
		return false;

	}

	public boolean eatItem(List<Blood> bloods) {
		for (int i = 0; i < bloods.size(); i++) {
			Item item =bloods.get(i);
			if (this.eatItem(item)) {
				return true;
			}
		}
		return false;
	}

	

}
