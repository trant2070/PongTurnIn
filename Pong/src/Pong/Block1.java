package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import Pong.Locatable1;

public class Block1 implements Locatable1
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block1()
	{
            setPos(100, 150);
            setWidth(10);
            setHeight(10);
            setColor(Color.black);

	}
        public Block1(int x, int y) {
		setPos(x, y);
		setWidth(10);
		setHeight(10);
		setColor(Color.BLACK);
	}
	
	public Block1(int x, int y, int w, int h) {
		setPos(x, y);
		setWidth(w);
		setHeight(h);
		setColor(Color.BLACK);
	}
	
	public Block1(int x, int y, int w, int h, Color col) {
		setPos(x, y);
		setWidth(w);
		setHeight(h);
		setColor(col);
	}

	//add other Block constructors - x , y , width, height, color
       
	
   //add the other set methods
   public void setPos(int x, int y) {
	   xPos = x;
	   yPos = y;
   	}
   
   	public void setX(int x) { 
	   xPos = x;
   	}
   
   	public void setY(int y) {
	   yPos = y;
   	}

	public void setWidth(int w) {
		width = w;
	}

	public void setHeight(int h) {
		height = h;
	}

	public void setColor(Color col)
   	{
   		color = col;
   	}

   	//GET METHODS
   	public int getX() {
   		return xPos;
   	}
   	
   	public int getY() {
   		return yPos;
   	}

	public int getWidth() {
		return width;
	}

   	public int getHeight() {
		return height;
	}
   	
   	public Color getColor() {
   		return color;
   	}
   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
       window.setColor(color);
       window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   
        @Override
	public boolean equals(Object obj)
	{
            Block1 other = (Block1) obj;
   		return this.getX() == other.getX() && this.getY() == other.getY() && this.getWidth() == other.getWidth() && this.getHeight() == other.getHeight();
	}   

   //add the other get methods
    

   //add a toString() method  - x , y , width, height, color
    @Override
    public String toString()
    {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
    }
    
    
}