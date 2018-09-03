package com.neusoft.planewar.core;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import com.neusoft.planewar.client.PlanewarSystem;
import com.neusoft.planewar.constant.constants;
import com.neusoft.planewar.util.GameUtil;

public class Images {
	public static final Map<String, Image> imgs = new HashMap<>();
	public Map<String, String> is = new HashMap<>();

	static {
		imgs.put("myplane01", GameUtil.getImage(constants.IMGPAHT_PRE + "myplane.png"));
		
		imgs.put("enemyplane01", GameUtil.getImage(constants.IMGPAHT_PRE + "enemyplane.png"));
		
		imgs.put("bullet01", GameUtil.getImage(constants.IMGPAHT_PRE + "bullet01.png"));
		imgs.put("enemybullet01", GameUtil.getImage(constants.IMGPAHT_PRE + "enemybullet.png"));
		imgs.put("enemyplane01", GameUtil.getImage(constants.IMGPAHT_PRE + "enemyplane.png"));
		
		imgs.put("blood_back", GameUtil.getImage(constants.IMGPAHT_PRE + "blood_back.png"));

		imgs.put("blood_div", GameUtil.getImage(constants.IMGPAHT_PRE + "blood_div.png"));

		imgs.put("blood_ox", GameUtil.getImage(constants.IMGPAHT_PRE + "blood_ox.png"));

		imgs.put("addblood", GameUtil.getImage(constants.IMGPAHT_PRE + "addblood.png"));
		imgs.put("superBullet", GameUtil.getImage(constants.IMGPAHT_PRE + "superBullet.png"));
		
		imgs.put("Boss", GameUtil.getImage(constants.IMGPAHT_PRE + "boss.png"));
		imgs.put("bg", GameUtil.getImage(constants.IMGPAHT_PRE + "bg.png"));
		imgs.put("Bossblood", GameUtil.getImage(constants.IMGPAHT_PRE + "Bossblood.jpg"));
		imgs.put("bossbullet", GameUtil.getImage(constants.IMGPAHT_PRE + "bossbullet.png"));

	
	}
	
	}
	
	
	

