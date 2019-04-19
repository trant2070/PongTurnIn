package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;
import java.awt.Color;

class BallTestOne
{
	public static void main( String args[] )
	{
		Ball1 one = new Ball1();
		out.println(one);
		
		Ball1 two = new Ball1(100,90);
		out.println(two);
		
		Ball1 three = new Ball1(100,100,30,50);
		out.println(three);
		
		Ball1 four = new Ball1(100,100,30,50,Color.BLUE);
		out.println(four);
		
		Ball1 five = new Ball1(100,100,30,50,Color.BLUE,5,6);
		out.println(five);
		
									//x, y, wid, ht, color, xSpd, ySpd
		Ball1 six = new Ball1(100,100,30,50,Color.blue,5,6);
		out.println(six);		
		
		out.println(five.equals(four));		
		
		out.println(five.equals(five));										
	}
}
