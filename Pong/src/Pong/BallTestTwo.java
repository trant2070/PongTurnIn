package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable
{
        private static final long serialVersionUID = 1L;
	private Ball1 ball;

	public BallTestTwo()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//instantiate a new Ball
                ball = new Ball1();
                
                ball = new Ball1(100, 90);
                
                ball = new Ball1(100, 100, 30, 50, Color.blue);
                
                ball = new Ball1 ( 100, 100, 30, 50, Color.blue, 5, 6);
                

		//test the Ball thoroughly
		

		//test all constructors


		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);

		if(!(ball.getX()>=10 && ball.getX()<=550))
		{
			ball.setXSpeed(-ball.getX());
		}

		if(!(ball.getY()>=10 && ball.getY()<=450))
		{
			ball.setYSpeed(-ball.getY());
		}
	}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
                    Thread.currentThread();
   		   Thread.currentThread().sleep(19);
                   
            repaint();
         }
      }catch(Exception e)
      {
          System.out.println("oops");
      }
  	}	
}