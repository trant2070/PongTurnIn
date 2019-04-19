package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
            super(200,200);
            xSpeed = 3;
            ySpeed = 1;
	}

	//add the other Ball constructors
	public Ball(int x, int y)
        {
            super( x, y);
            setXSpeed(3);
            setYSpeed(1);
            
        }
        public Ball(int x, int y, int w, int h)
        {
            super(x, y, w, h);
            setXSpeed(3);
            setYSpeed(1);
        }
        public Ball(int x, int y, int w, int h, Color col)
        {
            super(x, y, w, h, col);
            setXSpeed(3);
            setYSpeed(1);
        }
        public Ball(int x, int y, int w, int h, Color col, int xS, int yS)
        {
            super(x, y, w, h, col);
            setXSpeed(xS);
            setYSpeed(yS);
        }
	
	
	
	
	
	
	
	
	
	
	
	   
   //add the set methods
   

   public void moveAndDraw(Graphics window)
   {
        draw(window, Color.WHITE);
        setPos(getX()+getXSpeed(), getY()+getYSpeed());
        draw(window);



   
   }
   
	public boolean equals(Object obj)
	{
            Ball other = (Ball) obj;
		return super.equals(other) 
				&& this.getXSpeed() == other.getXSpeed()
				&& this.getYSpeed() == other.getYSpeed();



		
	}   

   //add the get methods

   //add a toString() method

    /**
     * @return the xSpeed
     */
    public int getXSpeed() {
        return xSpeed;
    }

    /**
     * @param xSpeed the xSpeed to set
     */
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * @return the ySpeed
     */
    public int getYSpeed() {
        return ySpeed;
    }

    /**
     * @param ySpeed the ySpeed to set
     */
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
    
    public boolean didCollideLeft(Object obj) {
		Wall other = (Wall) obj;
		return this.getX() <= other.getLeft();
	}
	
	public boolean didCollideRight(Object obj) {
		Wall other = (Wall) obj;
		return this.getX() >= other.getRight();
	}
	
	public boolean didCollideTop(Object obj) {
		Wall other = (Wall) obj;
		return this.getY() <= other.getTop();
	}

	public boolean didCollideBottom(Object obj) {
		Wall other = (Wall) obj;
		return this.getY()+9 /*because the bottom wall is screwed up*/ >= other.getBottom();
	}
    
    
}