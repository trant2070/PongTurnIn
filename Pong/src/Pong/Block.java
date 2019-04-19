package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
            setPos(100, 150);
            setWidth(10);
            setHeight(10);
            setColor(Color.black);

	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y)
        {
            setPos(x,y);
            setWidth(10);
            setHeight(10);
            setColor(Color.black);
            
        }
        public Block(int x, int y, int w, int h)
        {
            setPos(x, y);
            setWidth(w);
            setHeight(h);
            setColor(Color.black);
            
        }
        public Block(int x, int y, int w, int h, Color col)
        {
            setPos(x, y);
            setWidth(w);
            setHeight(h);
            setColor(col);
        }
   //add the other set methods
   public void setPos(int x, int y)
   {
       xPos = x;
       yPos = y;
   }
   
   /**
     * @param xPos the xPos to set
     */
    public void setX(int x) {
        xPos = x;
    }
   /**
     * @param yPos the yPos to set
     */
    public void setY(int y) {
        yPos = y;
    }
    
    
    /**
     * @param height the height to set
     */
    public void setHeight(int h) {
        height = h;
    }
    /**
     * @param width the width to set
     */
    public void setWidth(int w) {
        width = w;
    }
   public void setColor(Color col)
   {
       color = col;

   }

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
       window.setColor(col);
       window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   
	public boolean equals(Object obj)
	{
            Block other = (Block) obj;
            return this.getX() == other.getX() && this.getY() == other.getY() && this.getWidth() == other.getWidth() && this.getHeight() == other.getHeight();
	}   

   //add the other get methods
    

   //add a toString() method  - x , y , width, height, color
    public String toString()
    {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
    }
        
        
    /**
     * @return the xPos
     */
    public int getX() {
        return xPos;
    }

    

    /**
     * @return the yPos
     */
    public int getY() {
        return yPos;
    }

    

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
}