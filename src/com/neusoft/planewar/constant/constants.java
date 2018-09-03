package com.neusoft.planewar.constant;

import java.io.IOException;
import java.util.Properties;

import com.neusoft.planewar.client.PlanewarSystem;

public class constants {
	public static final Properties props=new Properties();
	static {
		try{
		props.load(constants.class.getClassLoader().getResourceAsStream("game.Properties"));
	}catch (IOException e){
		e.printStackTrace();
	}
	}
	
	
	public static final int  GAME_WIDTH=Integer.parseInt(props.getProperty("GAME_WIDTH"));
	public static final int GAME_HEIGHT=Integer.parseInt(props.getProperty("GAME_HEIGHT"));
	public static final int MYPLANE01_SPEED=Integer.parseInt(props.getProperty("MYPLANE01_SPEED"));

	public static final String  IMGPAHT_PRE=props.getProperty("IMGPAHT_PRE");
	public static final int  BULLET_SPEED=Integer.parseInt(props.getProperty("BULLET_SPEED"));
	
	public static final int  ENEMYPLANE_SPEED=Integer.parseInt(props.getProperty("ENEMYPLANE_SPEED"));
	public static final int  ENEMYPLANE_BULLET_SPEED=Integer.parseInt(props.getProperty("ENEMYPLANE_BULLET_SPEED"));
	 public static final int  MYPLANE01_BULLET_SPEED=Integer.parseInt(props.getProperty("MYPLANE01_BULLET_SPEED"));
	
}
