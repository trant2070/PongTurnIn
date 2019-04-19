package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
//import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.Font;

import Pong.Ball;
import Pong.Paddle;

//import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	
	
	
	
	
	/**
	 * FOR THE ACCELERATING BALL        TYPE 'a' IN "PLAY" INSTANCE
	 * FOR THE COLOR-CHANGING BALL      TYPE 'c' IN "PLAY" INSTANCE
	 * FOR THE REGULAR BALL             TYPE 'r' IN "PLAY" INSTANCE
	 */
	
	
	char play = 'a';
	 
	
	
	
	
	
	

	
	
	
	//instance variables
	private static final long serialVersionUID = 1L;
	
	private Ball ball;
	
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private Wall wall;
	
	private int timer = 0;
	
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;	

	//starting position of ball
	private static final int BALL_Xi = 380;
	private static final int BALL_Yi = 265;
	
	public Pong()
	{
		createBall();
		
		//set up variables
		leftPaddle = new Paddle(10, 244, 10, 70, Color.YELLOW, 4);
		rightPaddle = new Paddle(760, 244, 10, 70, Color.YELLOW, 4);
		wall = new Wall(0, 770, 10, 550);
		keys = new boolean[4];
		leftScore = 0;
		rightScore = 0;
		
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
	//REFACTORING METHODS
	public void createBall() {
		if(play == 'a') ball = new SpeedUpBall(BALL_Xi, BALL_Yi, 10, 10, Color.BLUE, 1, 1);
		else if(play == 'c') ball = new BlinkyBall(BALL_Xi, BALL_Yi, 10, 10, Color.BLUE, 3, 1);
		else if(play == 'r') ball = new Ball(BALL_Xi, BALL_Yi, 10, 10, Color.BLUE, 3, 1);
	}
	
	public void subIncSpeed() {
		timer++;
		if(timer == 4) {
			((SpeedUpBall)ball).incSpeed();
			timer = 0;
		}
	}
	
	public void update(Graphics window){
		paint(window);
	}

   	public void paint(Graphics window)
   	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		//take a snap shop of the current screen and save it as an image
		//that is the exact same width and height as the current screen
		if(back == null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		

		//draw objects
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		
		//draw lower wall
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawLine(0, wall.getBottom(), 800, wall.getBottom());
		
		//draw scoring
		graphToBack.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		graphToBack.clearRect(52, 556, 708, 248);
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawString("Player 1 Score: "+ leftScore + 
				"                                       " + 
				"Player 2 Score: "+ rightScore, 120, 590);
			
		//IF BALL COLLIDE LEFT WALL
		if(ball.didCollideLeft(wall)) {
			rightScore++;
			
			//RESET BALL *somewhat unnecessary but improves flow of game
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.draw(graphToBack, Color.WHITE);
			ball.setPos(BALL_Xi, BALL_Yi);
			ball.setColor(Color.WHITE);
			
			//RESET PADDLE *somewhat unnecessary but improves flow of game
			leftPaddle.draw(graphToBack, Color.WHITE);
			leftPaddle.setColor(Color.WHITE);
			rightPaddle.draw(graphToBack, Color.WHITE);
			rightPaddle.setColor(Color.WHITE);
			
			//CREATE NEW BALLS AND PADDLES FOR NEXT ROUND
			createBall();
			leftPaddle = new Paddle(10, 244, 10, 70, Color.YELLOW, 4);
			rightPaddle = new Paddle(760, 244, 10, 70, Color.YELLOW, 4);
			
			if(rightScore == 5) {
				System.out.println("RIGHT WINS");
				
				//Terminates the console
				System.exit(0);
			}
		}
			
		//IF BALL COLLIDE RIGHT WALL
		if(ball.didCollideRight(wall)) {
			leftScore++;
			
			//RESET BALL *somewhat unnecessary but improves flow of game
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.draw(graphToBack, Color.WHITE);
			ball.setPos(BALL_Xi, BALL_Yi);
			ball.setColor(Color.WHITE);
			
			//RESET PADDLE *somewhat unnecessary but improves flow of game
			leftPaddle.draw(graphToBack, Color.WHITE);
			leftPaddle.setColor(Color.WHITE);
			rightPaddle.draw(graphToBack, Color.WHITE);
			rightPaddle.setColor(Color.WHITE);
			
			//CREATE NEW BALLS AND PADDLES FOR NEXT ROUND
			createBall();
			leftPaddle = new Paddle(10, 244, 10, 70, Color.YELLOW, 4);
			rightPaddle = new Paddle(760, 244, 10, 70, Color.YELLOW, 4);
			
			if(leftScore == 5) {
				System.out.println("LEFT WINS");
				
				//Terminates the console
				System.exit(0);
			}
		}
			
		//IF BALL COLLIDE WITH TOP AND BOTTOM WALLS
		if(ball.didCollideTop(wall) || ball.didCollideBottom(wall)) {
			ball.setYSpeed(-ball.getYSpeed());
			if(play == 'a') subIncSpeed();
		}

		//IF BALL COLLIDE LEFT PADDLE
		if(ball.getX() <= leftPaddle.getX()+leftPaddle.getWidth()
			&& ball.getY() >= leftPaddle.getY()
			&& (ball.getY() <= leftPaddle.getY()+leftPaddle.getHeight()
			|| ball.getY()+ball.getHeight() >= leftPaddle.getY()
			&& ball.getY()+ball.getHeight() < leftPaddle.getY()+leftPaddle.getHeight()))
		{
			//no idea what this is
			if(ball.getX() <= leftPaddle.getX()+leftPaddle.getWidth()-Math.abs(ball.getXSpeed()))
				ball.setYSpeed(-ball.getYSpeed());
			//make ball bounce
			else
				ball.setXSpeed(-ball.getXSpeed());
			if(play == 'a') subIncSpeed();
		}
			
		//IF BALL COLLIDE RIGHT PADDLE
		if(ball.getX() >= rightPaddle.getX()-rightPaddle.getWidth()
				&& ball.getY() >= rightPaddle.getY()
				&& (ball.getY() <= rightPaddle.getY()+rightPaddle.getHeight()
				|| ball.getY()+ball.getHeight() >= rightPaddle.getY()
				&& ball.getY()+ball.getHeight() < rightPaddle.getY()+rightPaddle.getHeight()))
		{
			//no idea what this is
			if(ball.getX() >= rightPaddle.getX()-rightPaddle.getWidth()+Math.abs(ball.getXSpeed()))
				ball.setYSpeed(-ball.getYSpeed());
			//make ball bounce
			else
				ball.setXSpeed(-ball.getXSpeed());
			if(play == 'a') subIncSpeed();
		}
			
		//MOVEMENT FOR PADDLES
		
		if(keys[0] == true) {//left player
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true) {//left player
			leftPaddle.moveDownAndDraw(graphToBack);
		}
			
		if(keys[2] == true) {//right player
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true) {//right player
			rightPaddle.moveDownAndDraw(graphToBack);
		}
	
		twoDGraph.drawImage(back, null, 0, 0);
   	}
  	
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
   	
   	//PROGRAM RUNNER
  	public void run()
  	{
  		try 
  		{
  			while(true) 
  			{
	  			Thread.currentThread();
				Thread.sleep(8);
				repaint();
	  		}
	  	} catch (Exception e){
	  		System.out.println("oops");
	  	}
    }
}