import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/*
 * interface to simplify the methods
 * reason : makes more sense to us; helps us understand program better
 */
public interface Entity 
{
    public Dimension getSize();

    public Point getLocation();

    public void setLocation(Point p);

    public void paint(Graphics g);
}