package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import com.neusoft.planewar.client.PlanewarSystem;
import com.neusoft.planewar.constant.constants;
import com.neusoft.planewar.util.GameUtil;

public class Enemyplane extends Plane {


	public static int speed = constants.ENEMYPLANE_SPEED;
	

	
	public Enemyplane() {

	}

	public Enemyplane(PlanewarSystem pws, int x, int y, String imgpath) {
		this.pws = pws;
		this.x = x;
		this.y = y;
		this.img = GameUtil.getImage(imgpath);
		this.dir = Direction.DOWN;
		this.good=false;
	}
		
	public Enemyplane(PlanewarSystem pws, int x, int y, Image img) {
		this.pws = pws;
		this.x = x;
		this.y =y;
		this.img = img;
		this.dir = Direction.DOWN;
		this.good=false;
	}
	/**var y = 0;
	var x=Math.random()*393;//再画布范围里面产生x坐标
	setInterval(function() {
	    ctx.drawImage(bg,0,0);
	    ctx.drawImage(enemy, x, y);
	    y = y + 1;   
	}, 10);**/
	
	@Override
	public void draw(Graphics g) {
		
		
		if(live){
			super.draw(g);
		}
		
		if(!live){
			pws.enemies.remove(this);
		}
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
		if (Math.random() *1000> 980)
			fire();
	}

	//public void draw(Graphics g) {
		//move();
		//g.drawImage(img, x, y, null);

	//}
	public void fire() {
		int x = this.x + this.img.getWidth(null) / 2 - 21;
		int y = this.y;
		Bullet b = new Bullet(pws, x, y, Images.imgs.get("enemybullet01"), Direction.DOWN,constants.ENEMYPLANE_BULLET_SPEED,good);
		pws.bullets.add(b);
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

		default:
			break;
		}

	}

	@SuppressWarnings("unused")
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:

			left = false;
			break;
		case KeyEvent.VK_W:

			up = false;
			break;
		case KeyEvent.VK_D:

			right = false;
			break;
		case KeyEvent.VK_S:

			down = false;
			break;
		case KeyEvent.VK_J:

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

}
