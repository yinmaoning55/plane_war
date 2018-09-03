package com.neusoft.planewar.core;

import java.awt.Graphics;

import com.neusoft.planewar.client.PlanewarSystem;
import com.neusoft.planewar.constant.constants;

public class Bossblood extends Blood {
	public Bossblood() {

	}

	public Bossblood(PlanewarSystem pws, int x, int y) {
		this.pws = pws;
		
		
		this.img = Images.imgs.get("Bossblood");
		

		this.x = constants.GAME_WIDTH / 2 - Images.imgs.get("Boss").getWidth(null);

		this.y = -Images.imgs.get("Boss").getHeight(null) / 2+15;
		
	}
	public void draw(Graphics g) {
		if(!live){
			pws.bbloods.remove(this);
			return;
		}
		move();
		g.drawImage(img, x, y, null);
	}

}
