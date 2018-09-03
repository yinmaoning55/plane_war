package com.neusoft.planewar.core;

import java.awt.Graphics;

import java.util.List;
import java.util.ArrayList;
import com.neusoft.planewar.client.PlanewarSystem;
import com.neusoft.planewar.constant.constants;

public class superBullet extends Bullet {

	public superBullet(PlanewarSystem pws) {
		this.pws = pws;
		this.x = 0;
		this.y = constants.GAME_HEIGHT;
		this.img = Images.imgs.get("superBullet");
		this.live = true;

	}

	@Override
	public void move() {
		y -= 30;
	}

	@Override
	public void draw(Graphics g) {
		move();
		for (int i = 0; i < 12; i++) {
			g.drawImage(img, x + img.getWidth(null) * i, y, null);
		}

	}

	public boolean hitPlane(List<Enemyplane> enemyplanes) {

		for (int i = 0; i < enemyplanes.size(); i++) {
			Enemyplane enemyPlane = enemyplanes.get(i);
			//if (this.live && enemyPlane.live && this.getRectangle().intersects(enemyPlane.getRectangle())) {
				
				
				enemyPlane.live = false;
				creatExplode(enemyPlane);System.out.println("ssss111ss");
				

			//}


		}
		return true;

	}

	public boolean hitBullet(List<Bullet> bullets) {

		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			//if (this.live && bullet.live && this.getRectangle().intersects(bullet.getRectangle())) {
			System.out.println("ssssfsfds111ss");
				bullet.live = false;
				

			//}

		}

		return true;

	}

	

}
