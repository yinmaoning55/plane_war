package com.neusoft.planewar.core;

import java.awt.Graphics;


import com.neusoft.planewar.client.PlanewarSystem;
import com.neusoft.planewar.constant.constants;

public class Blood extends Item {

	public Blood() {

	}

	public Blood(PlanewarSystem pws, int x, int y) {
		this.pws = pws;
		this.x = x;
		this.y = y;
		this.img = Images.imgs.get("addblood");
		
	}
	public double speed=50;
	public double degree=Math.PI/4;
	

	@Override
	public void move() {
		x+=(int)(speed*Math.cos(degree));
		y+=(int)(speed*Math.sin(degree));
		
		if(x<=0||x>=constants.GAME_WIDTH-img.getWidth(null)){
			degree=Math.PI-degree;
		}
		if(y<=32||y>constants.GAME_HEIGHT-img.getHeight(null)){
			degree=-degree;
		}
		

	}

	@Override
	public void draw(Graphics g) {
		if(!live){
			pws.bloods.remove(this);
			return;
		}
		move();
		g.drawImage(img, x, y, null);
	}

}
