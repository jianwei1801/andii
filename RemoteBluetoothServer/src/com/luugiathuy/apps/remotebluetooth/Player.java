package com.luugiathuy.apps.remotebluetooth;

import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.awt.Robot;
import java.lang.Thread;

public abstract class Player {
  protected int UP;
  protected int DOWN;
  protected int LEFT;
  protected int RIGHT;
  protected int BUTTONA;
  protected int BUTTONB;
  protected int START;
  protected static final int[] CONFIG1 = {KeyEvent.VK_1,KeyEvent.VK_2,KeyEvent.VK_3,KeyEvent.VK_4,KeyEvent.VK_5,KeyEvent.VK_6,KeyEvent.VK_7};
  protected static final int[] CONFIG2 = {KeyEvent.VK_8,KeyEvent.VK_9,KeyEvent.VK_0,KeyEvent.VK_Q,KeyEvent.VK_W,KeyEvent.VK_E,KeyEvent.VK_M};
  protected static final int[] CONFIG3 = {KeyEvent.VK_T,KeyEvent.VK_Y,KeyEvent.VK_U,KeyEvent.VK_I,KeyEvent.VK_O,KeyEvent.VK_P,KeyEvent.VK_N};
  protected static final int[] CONFIG4 = {KeyEvent.VK_V,KeyEvent.VK_D,KeyEvent.VK_F,KeyEvent.VK_G,KeyEvent.VK_H,KeyEvent.VK_J,KeyEvent.VK_K};
  protected static final int[] CONFIGX = {KeyEvent.VK_V,KeyEvent.VK_D,KeyEvent.VK_F,KeyEvent.VK_G,KeyEvent.VK_H,KeyEvent.VK_J,KeyEvent.VK_K};
  protected int[] config;
	protected String bid;
	protected String name;
  protected int playerNum;
	protected float gyro_offsetX;
	protected float gyro_offsetY;
	protected float gyro_offsetZ;
  protected float accl_offsetX;
	protected float accl_offsetY;
	protected float accl_offsetZ;
  protected boolean gyroCallb = false;
  protected boolean acclCallb = false;
  protected Robot player;
  protected Thread thread;

  public Player(String bid, String name, int playerNum) throws AWTException{
    this.player = new Robot();
    switch(playerNum){
      case 1:
        this.config = CONFIG1;
        break;
      case 2:
        this.config = CONFIG2;
        break;
      case 3:
        this.config = CONFIG3;
        break;
      case 4:
        this.config = CONFIG4;
        break;
      default:
        this.config = CONFIGX;
        break;
    }
    this.UP = config[0];
    this.DOWN = config[1];
    this.LEFT = config[2];
    this.RIGHT = config[3];
    this.BUTTONA = config[4];
    this.BUTTONB = config[5];
    this.START = config[6];
    this.bid = bid;
    this.name = name;
    this.playerNum = playerNum;
    this.thread = new Thread();
  }

  protected void setGyroOffset(float offsetX, float offsetY, float offsetZ){
    this.gyro_offsetX = gyro_offsetX;
    this.gyro_offsetY = gyro_offsetY;
    this.gyro_offsetZ = gyro_offsetZ;
    gyroCallb = true;
  }

  protected void setAcclOffset(float offsetX, float offsetY, float offsetZ){
    this.accl_offsetX = accl_offsetX;
    this.accl_offsetY = accl_offsetY;
    this.accl_offsetZ = accl_offsetZ;
    System.out.println("acclset");
    acclCallb = true;
  }
  
  public String previousKey = "";

  protected void pressButton(String key) throws InterruptedException{
    int keyi = 0;
    if (key.equals("up")){
      keyi = UP;
    }else if (key.equals("down")){
      keyi = DOWN;
    }else if (key.equals("left")){
      keyi = LEFT;
    }else if (key.equals("right")){
      keyi = RIGHT;
    }else if (key.equals("buttona")){
      keyi = BUTTONA;
    }else if (key.equals("buttonb")){
      keyi = BUTTONB;
    }else if (key.equals("start")){
      keyi = START;
    }
    player.keyPress(keyi);
    //Thread.sleep(1000);
    //player.keyRelease(keyi);
  }

	protected void updateGyro(float newX, float newY, float newZ){}

	protected void updateAccl(float newX, float newY, float newZ){}

}
