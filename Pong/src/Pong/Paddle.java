package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10);
      speed =5;
   }


   //add the other Paddle constructors
   public Paddle (int x, int y)
   {
       super(x, y);
       setSpeed(5);
   }
   public Paddle (int x, int y, int s)
   {
       super(x, y);
       setSpeed(s);
   }
   public Paddle (int x, int y, int w, int h, int s)
   {
       super(x, y, w, h);
       setSpeed(s);
   }
   public Paddle (int x, int y, int w, int h, Color col, int s)
   {
       super(x, y, w, h, col);
       setSpeed(s);
   }
   









   public void moveUpAndDraw(Graphics window)
   {
       Color temp = getColor();
       draw(window, Color.white);
       setY(getY()-speed);
       draw(window, temp);

   }

   public void moveDownAndDraw(Graphics window)
   {
       Color temp = getColor();
       draw(window, Color.white);
       setY(getY()+speed);
       draw(window, temp);
       

   }
   public boolean equals(Object obj)
   {
       Paddle other = (Paddle) obj;
       return super.equals(other) && this.getSpeed() == other.getSpeed();
       
   }

   //add get methods
   /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
   
   //add a toString() method
    public String toString()
    {
        return super.toString() + " " + getSpeed();
    }
    
}