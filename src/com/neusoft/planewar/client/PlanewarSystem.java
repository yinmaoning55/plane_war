package com.neusoft.planewar.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.neusoft.planewar.constant.constants;
import com.neusoft.planewar.core.BackGround;
import com.neusoft.planewar.core.Blood;
import com.neusoft.planewar.core.Boss;
import com.neusoft.planewar.core.Bossblood;
import com.neusoft.planewar.core.Bullet;
import com.neusoft.planewar.core.Enemyplane;
import com.neusoft.planewar.core.Explode;
import com.neusoft.planewar.core.Images;
import com.neusoft.planewar.core.Plane;
import com.neusoft.planewar.core.superBullet;
import com.neusoft.planewar.util.MyFrame;

public class PlanewarSystem extends MyFrame {

	/**
	 * 
	 */
	
	
	public List<superBullet> superBullets=new ArrayList<>();
	public Plane myplane = new Plane(this, 100, 900, Images.imgs.get("myplane01"));
	
	
	public List<Enemyplane> enemies=new ArrayList<>();
	
	
	public List<Bullet> bullets = new ArrayList<>();
	public List<Explode> explode=new ArrayList<>();
	public List<Blood> bloods=new ArrayList<>();
	public List<Bossblood> bbloods=new ArrayList<>();

	public Boss boss=new Boss(this);
	public Blood blood=new Blood(this,300,500);

	
	@Override
	public void launchFrame() {

		super.launchFrame();
		this.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				myplane.Keypressed(e);

			}

			@Override
			public void keyReleased(KeyEvent e) {

				super.keyReleased(e);
				myplane.keyReleased(e);
			}

		});
		Timer t = new Timer();
		t.schedule(new MyTask(this), 10, 1000);
		
		 
		
	}
     BackGround bg=new BackGround();
	public void paint(Graphics g) {
		
		bg.draw(g);
		boss.draw(g);
		
		
	
		for (int i = 0; i <bloods.size(); i++) {
			Blood blood=bloods.get(i);
			blood.draw(g);
		}

		
		myplane.eatItem(bloods);
		
		
		
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet=bullets.get(i);
			bullet.draw(g);
			bullet.hitPlane(enemies);
			bullet.hitPlane(myplane);
			bullet.hitBoss(boss);
		}
		for (int i = 0; i < superBullets.size(); i++) {
			superBullet sbullet=superBullets.get(i);
			sbullet.draw(g);
			
			sbullet.hitPlane(enemies);
			
			sbullet.hitBullet(bullets);
			
		}
		
			
		Color c=g.getColor();
		g.setColor(Color.white);
				
		
		Font f=g.getFont();	
		g.setFont(new Font("Î¢ÈíÑÅ°×",Font.BOLD,10));
	    g.drawString("bullets:"+bullets.size(), 50, 70);
	    g.drawString("blood:"+myplane.blood, 50, 80);
	    g.drawString("enemies:"+enemies.size(), 50, 90);
	    g.drawString("explodes:"+explode.size(), 50, 100);
		g.setFont(f);
		
		
		
		for (int i = 0; i < enemies.size(); i++) {
			Enemyplane enemyplane=enemies.get(i);
			enemyplane.draw(g);	
		}
		for (int i = 0; i < explode.size(); i++) {
			Explode e=explode.get(i);
			e.draw(g);
			
		}
		myplane.draw(g);
	}

	public static void main(String[] args) {	
		new PlanewarSystem().launchFrame();
		
		

		
		}
	class MyTask extends TimerTask {
		PlanewarSystem pws;

		public MyTask(PlanewarSystem pws) {
			this.pws = pws;
		}

		@Override
		public void run() {
			
			Random r = new Random();
			int x = r.nextInt(constants.GAME_WIDTH - Images.imgs.get("enemyplane01").getWidth(null));
			Enemyplane enemy = new Enemyplane(pws, x, -100, Images.imgs.get("enemyplane01"));
			enemies.add(enemy);
			
		}
	}

	}

