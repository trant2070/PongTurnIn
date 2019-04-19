package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables
    private int xSpeed;
    private int ySpeed;
    
   public SpeedUpBall()
   {
       super();

   }

   public SpeedUpBall(int x, int y)
   {
       super(x, y);

   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
       super(x, y);
       setXSpeed(xSpd);
       setYSpeed(ySpd);
       

   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
       super(x, y, wid, ht);
       setXSpeed(xSpd);
       setYSpeed(ySpd);
       setColor(Color.BLUE);

   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
       super(x, y, wid, ht, col, xSpd, ySpd);
       


   }

   public void setXSpeed( int xSpd )
   {
       xSpeed = xSpd;



   }

   public void setYSpeed( int ySpd )
   {
       ySpeed = ySpd;



   }
   public int getXSpeed()
   {
       return xSpeed;
   }
   public int getYSpeed()
   {
       return ySpeed;
   }
   public void incSpeed()
   {
       if (getXSpeed()<0)
       {
           setXSpeed(getXSpeed() -1);
       }else{
           setXSpeed(getXSpeed() + 1);
       }
       if(getYSpeed()< 0)
       {
           setYSpeed(getYSpeed() -1);
           
       }else{
           setYSpeed(getYSpeed() + 1);
       }
       
   }
   public void moveAndDraw(Graphics window)
   {
        draw(window, Color.WHITE);
        setPos(getX()+getXSpeed(), getY()+getYSpeed());
        draw(window);



   }
}

