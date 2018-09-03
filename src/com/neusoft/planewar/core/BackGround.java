package com.neusoft.planewar.core;

import java.awt.Graphics;

import com.neusoft.planewar.constant.constants;

public class BackGround extends PlanewarObject {
	int y1;
	int y2;
	int speed = 1;

	public BackGround() {
		this.x = 0;
		this.y1 = -175;
		this.y2 = -Images.imgs.get("bg").getHeight(null);
		this.img = Images.imgs.get("bg");

	}

	@Override
	public void move() {
		y1 += speed;
		if (y1 >= constants.GAME_HEIGHT) {
			y1 = -Images.imgs.get("bg").getHeight(null);
		}
		if (y2 >= constants.GAME_HEIGHT) {
			y2 = -Images.imgs.get("bg").getHeight(null);
		}
		y2 += speed;
	}

	@Override
	public void draw(Graphics g) {
		move();
		g.drawImage(img, x, y1, null);
		g.drawImage(img, x, y2, null);

	}

}
