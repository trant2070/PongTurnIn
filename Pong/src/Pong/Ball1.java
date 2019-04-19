package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball1 extends Block1
{
	private int xSpeed;
	private int ySpeed;

	public Ball1()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}
        public Ball1(int x, int y)
	{
		super(x, y);
		xSpeed = 3;
		ySpeed = 1;
	}
        public Ball1(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		setXSpeed(3);
		setYSpeed(1);
	}
        public Ball1(int x, int y, int w, int h, Color col)
	{
		super(x, y, w, h, col);
		setXSpeed(3);
		setYSpeed(1);
	}
        
        public Ball1(int x, int y, int w, int h, Color col, int xS, int yS)
	{
		super(x, y, w, h, col);
		setXSpeed(xS);
		setYSpeed(yS);
	}

	//add the other Ball constructors
	
        
        public void setXSpeed(int xS) {
		xSpeed = xS;
	}
	
	public void setYSpeed(int yS) {
		ySpeed = yS;
	}
	
	//GET METHODS
	public int getXSpeed() {
		return xSpeed;
	}
	
	public int getYSpeed() {
		return ySpeed;
	}

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
       Color temp = getColor();
		draw(window, Color.WHITE);
		setPos(getXSpeed()+xSpeed, getYSpeed()+ySpeed);
		draw(window, temp);
		//setY

		//draw the ball at its new location
   }
   
	public boolean equals(Object obj)
	{
            Ball1 other = (Ball1) obj;
		return super.equals(other) 
				&& this.getXSpeed() == other.getXSpeed()
				&& this.getYSpeed() == other.getYSpeed();



		
	}   

   //add the get methods
        

   //add a toString() method
        public String toString() {
		return super.toString() +" "+ getXSpeed() +" "+ getYSpeed();
	}
}