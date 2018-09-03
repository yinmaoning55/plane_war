package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.neusoft.planewar.client.PlanewarSystem;
import com.neusoft.planewar.constant.constants;

import com.neusoft.planewar.util.GameUtil;

public class Boss extends Enemyplane {
	// public int Bossblood=1000;
	public boolean good;
	public int bblood = 100;

	public static Image[] imgs = { GameUtil.getImage(constants.IMGPAHT_PRE + "boss.png")

	};
	public Image img;

	public Boss(PlanewarSystem pws) {
		this.pws = pws;
		this.good = false;
		this.live=true;

		this.x = constants.GAME_WIDTH / 2 - Images.imgs.get("Boss").getWidth(null);

		this.y = -Images.imgs.get("Boss").getHeight(null) / 2;
		img = Images.imgs.get("Boss");

	}

	public void draw(Graphics g) {
		bbloodBar.draw(g);
		
		int count = 0;
		if (count > imgs.length - 1) {

			return;

		}

		if (live) {
			g.drawImage(imgs[count], x, y, null);
			count++;
			move();
		}
     
	}

	boolean right = true;

	public void move() {
		y += 5;

		if (y > 100) {
			y = 100;
			if (right) {
				x += 10;
			} else {
				x -= 10;
			}
			if (x < 0) {
				right = true;

			}
			if (x > constants.GAME_WIDTH - Images.imgs.get("Boss").getWidth(null)) {
				right = false;
			}

		}
		if (Math.random() * 1000 > 980)
			fire();
	}

	public void fire() {
		int x = this.x + this.img.getWidth(null) / 2 - 21;
		int y = this.y;
		Bullet bb = new Bullet(pws, x, y, Images.imgs.get("bossbullet"), Direction.DOWN,
				constants.ENEMYPLANE_BULLET_SPEED, good);
		pws.bullets.add(bb);
	}

	public BossbloodBar bbloodBar = new BossbloodBar();

	class BossbloodBar {

		public Image BossbloodBarImg;

		public BossbloodBar() {

			this.BossbloodBarImg = Images.imgs.get("Bossblood");

		}

		public void draw(Graphics g) {

			for (int i = 0; i < 100* bblood / 100; i++) {
				g.drawImage(BossbloodBarImg, x + 25 + (BossbloodBarImg.getWidth(null)) * i, y - 10, null);
			}

			if (!live) {
				pws.explode.remove(this);
				return;
			}

		}
	}
	public Rectangle getRectangle(){
		return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
	}
}
