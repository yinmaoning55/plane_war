package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;

import com.neusoft.planewar.client.PlanewarSystem;
import com.neusoft.planewar.constant.constants;
import com.neusoft.planewar.util.GameUtil;

public class Explode extends PlanewarObject {

	public static Image[] imgs = { GameUtil.getImage(constants.IMGPAHT_PRE + "1.png"),
			GameUtil.getImage(constants.IMGPAHT_PRE + "1.1.png"), GameUtil.getImage(constants.IMGPAHT_PRE + "1.2.png"),
			GameUtil.getImage(constants.IMGPAHT_PRE + "1.3.png"),

			GameUtil.getImage(constants.IMGPAHT_PRE + "2.png"), GameUtil.getImage(constants.IMGPAHT_PRE + "2.1.png"),
			GameUtil.getImage(constants.IMGPAHT_PRE + "2.2.png"), GameUtil.getImage(constants.IMGPAHT_PRE + "2.3.png"),
			GameUtil.getImage(constants.IMGPAHT_PRE + "2.4.png"), GameUtil.getImage(constants.IMGPAHT_PRE + "3.png"),
			GameUtil.getImage(constants.IMGPAHT_PRE + "3.1.png"), GameUtil.getImage(constants.IMGPAHT_PRE + "3.2.png"),
			GameUtil.getImage(constants.IMGPAHT_PRE + "3.3.png"), GameUtil.getImage(constants.IMGPAHT_PRE + "4.png"),
			GameUtil.getImage(constants.IMGPAHT_PRE + "4.1.png"), GameUtil.getImage(constants.IMGPAHT_PRE + "4.2.png"),
			GameUtil.getImage(constants.IMGPAHT_PRE + "4.3.png"),

	};

	public Explode() {

	}

	public Explode(PlanewarSystem pws, int x, int y, Image img) {
		this.pws = pws;
		this.x = x;
		this.y = y;
		this.img = img;

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	public boolean live = true;

	int count = 0;

	@Override
	public void draw(Graphics g) {
		if(!live){
			pws.explode.remove(this);
			return;
		}

		if (count > imgs.length - 1) {
			count = 0;
			live = false;
			return;
		}

		if (live) {
			g.drawImage(imgs[count], x, y, null);
			count++;
		}
	}

}
