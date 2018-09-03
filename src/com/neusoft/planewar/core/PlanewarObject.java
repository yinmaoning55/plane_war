
package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.neusoft.planewar.client.PlanewarSystem;

public abstract class PlanewarObject implements Drawable, moveable {
	public int x;
	public int y;
	public Image img;
	public PlanewarSystem pws;
	public boolean live;

	@Override
	public abstract void move();

	@Override
	public abstract void draw(Graphics g);
	public Rectangle getRectangle(){
		return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
	}

}
