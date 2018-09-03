package com.neusoft.planewar.core;

import java.awt.Graphics;

public abstract class Item extends PlanewarObject {
	public double speed;
	
	public double degree;
	
	public boolean live=true;

	@Override
	public abstract void move() ;

	@Override
	public abstract void draw(Graphics g) ;

}
