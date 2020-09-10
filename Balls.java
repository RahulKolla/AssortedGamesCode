import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Balls implements Entity {
    Point location = new Point(0, 0);
    int x = 0, y = 0;// location of Balls

    public Balls() {}
   

    @Override
    public Dimension getSize() 
    {
        return new Dimension(20, 20); // size of Balls
    }

    @Override
    public Point getLocation() 
    {
        return new Point(location);// when player scores the Balls re-spawns in the middle 

    }

    @Override
    public void setLocation(Point p) 
    {
        location = p;
    }

    public void setX(int x) 
    {
        this.x = x;
    }

    public int getX() 
    {
        return x;
    }

    public void setY(int y) 
    {
        this.y = y;
    }

    public int getY() 
    {
        return y;
    }

    @Override
    public void paint(Graphics g) 
    {
        g.setColor(new Color((int) (Math.random()* 255) + 1,(int) (Math.random()* 255) + 1,(int) (Math.random()* 255) + 1));// sets color to Balls, makes it flashing
        g.fillOval(getLocation().x, getLocation().y, getSize().width, getSize().height);// draws the circle(oval)
    }
}