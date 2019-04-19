package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

public class BlockTestTwo extends Canvas
{
	public BlockTestTwo()
	{
		setBackground(Color.WHITE);
	}

        @Override
	public void paint(Graphics window)
	{
		Block1 one = new Block1();
		one.draw(window);

		Block1 two = new Block1(50,50,30,30);
		two.draw(window);

		Block1 three = new Block1(350,350,15,15,Color.RED);
		three.draw(window);

		//two.draw(window, Color.white);

		Block1 four = new Block1(450,50,20,60, Color.GREEN);
		four.draw(window);
		
		//add more test cases			
	}
}