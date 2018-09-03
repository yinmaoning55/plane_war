package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.util.Random;

import com.neusoft.planewar.client.PlanewarSystem;
import com.neusoft.planewar.constant.constants;
import com.neusoft.planewar.util.GameUtil;

public class Bullet extends PlanewarObject {

	public PlanewarSystem pws;
	Direction dir;

	public int speed;
	public boolean good;

	public Bullet() {

	}

	/*
	 * public Bullet(PlanewarSystem pws,int x, int y,String imgpath) {
	 * this.pws=pws; this.x=x; this.y=y; this.img=GameUtil.getImage(imgpath);
	 * this.dir=Direction.DOWN;
	 * 
	 * }
	 */
	public Bullet(PlanewarSystem pws, int x, int y, Image img, Direction dir, int speed, boolean good) {
		this.pws = pws;
		this.x = x;
		this.y = y;
		this.img = img;
		this.dir = dir;
		this.speed = speed;
		this.good = good;
		this.live = true;

	}

	public boolean live;

	@Override
	public void move() {
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
		default:
			break;

		}
		if (this.x <= 0 || this.x >= constants.GAME_WIDTH - this.img.getWidth(null) || this.y <= 40
				|| this.y >= constants.GAME_HEIGHT - this.img.getHeight(null)) {
			pws.bullets.remove(this);
		}
	}

	@Override
	public void draw(Graphics g) {
		if (!live) {
			pws.bullets.remove(this);
			return;
		}

		move();
		g.drawImage(img, x, y, null);

	}

	public Random r = new Random();

	// 我方飞机
	public boolean hitPlane(Plane p) {
		if (this.live && p.live && this.getRectangle().intersects(p.getRectangle()) && p.good != this.good) {
			this.live = false;
			if (p.good) {
				p.blood -= 10;
				if (p.blood <= 0) {
					p.live = false;
					creatExplode(p);
				}

			} else {
				creatExplode(p);
				if (r.nextInt(100) > 20) {
					Blood blood = new Blood(pws, p.x, p.y);
					pws.bloods.add(blood);
				}
			}

			return true;

		}
		return false;
	}

	public boolean hitBoss(Boss boss) {
		if (this.live && boss.live && this.getRectangle().intersects(boss.getRectangle()) && boss.good != this.good) {
			this.live = false;
			boss.bblood-=1;
			if(boss.bblood<=0){
				boss.live=false;
				bcreatExplode(boss);
			}
			

			return true;

		}
		return false;
	}

	public void creatExplode(Plane p) {
		int x = p.x + p.img.getWidth(null) / 2 - Images.imgs.get("bullet01").getWidth(null) / 2;
		
		int y = p.y + p.img.getHeight(null) / 2 - Images.imgs.get("bullet01").getHeight(null) / 2;

		Explode e = new Explode(pws, x, y, null);
		pws.explode.add(e);

	}
	public void bcreatExplode(Boss b) {
		int x = b.x + b.img.getWidth(null) / 2 - Images.imgs.get("bullet01").getWidth(null) / 2;
		System.out.println(x);
		int y = b.y + b.img.getHeight(null) / 2 - Images.imgs.get("bullet01").getHeight(null) / 2;

		Explode e = new Explode(pws, x, y, null);
		pws.explode.add(e);

	}

	

	// 敌方飞机
	public boolean hitPlane(List<Enemyplane> enemyplanes) {
		for (int i = 0; i < enemyplanes.size(); i++) {
			Enemyplane enemyPlane = enemyplanes.get(i);

			if (this.hitPlane(enemyPlane)) {
				enemyPlane.live = false;
				return true;

			}
		}

		return false;
	}

}
