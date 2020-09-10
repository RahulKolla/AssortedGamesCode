import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class Paddle implements Entity 
{
    int score = 0;//controls score of each player
    int paddleNum; // player 1 and player 2
    int paddleX = 0, paddleY = 0; // player 1 and player 2
    View view; // how the paddle is seen

    Point location = new Point(0, 0); //sets location of each paddle

    public Paddle(int paddleNum) 
    {
        this.paddleNum = paddleNum;
    }

    public void createBindings()
    {
        if (paddleNum == 1) 
        {
        	/*
        	 * sets what the user presses to what the paddle supposed to do
        	 */
            view.addKeyBinding("leftup.pressed", KeyEvent.VK_W, true, new LeftAction(Direction.LEFT_UP, true));
            view.addKeyBinding("leftup.released", KeyEvent.VK_W, false, new LeftAction(Direction.LEFT_UP, false));
            view.addKeyBinding("leftdown.pressed", KeyEvent.VK_S, true, new LeftAction(Direction.LEFT_DOWN, true));
            view.addKeyBinding("leftdown.released", KeyEvent.VK_S, false, new LeftAction(Direction.LEFT_DOWN, false));
        } 
        else 
        {
        	/*
        	 * see above
        	 */
            view.addKeyBinding("rightup.pressed", KeyEvent.VK_UP, true, new RightAction(Direction.RIGHT_UP, true));
            view.addKeyBinding("rightup.released", KeyEvent.VK_UP, false, new RightAction(Direction.RIGHT_UP, false));
            view.addKeyBinding("rightdown.pressed", KeyEvent.VK_DOWN, true, new RightAction(Direction.RIGHT_DOWN, true));
            view.addKeyBinding("rightdown.released", KeyEvent.VK_DOWN, false, new RightAction(Direction.RIGHT_DOWN, false));
        }
    }

    @Override
    public Dimension getSize()
    {
        return new Dimension(25, 100); // size of paddle
    }

    @Override
    public Point getLocation() 
    {
        return new Point(location);
    }

    @Override
    public void setLocation(Point p)
    {
        location = p;
    }

    public void setView(View view) 
    {
        this.view = view;
    }

    public void resetScore() 
    {
        score = 0;
    }

    public void increaseScore() 
    {
    	score++; 
    }

    public int getScore() 
    {
        return score;
    }

    @Override
    public void paint(Graphics g) 
    {
        g.setColor(Color.WHITE);
        g.fillRect(getLocation().x, getLocation().y, getSize().width, getSize().height); // draws each paddle of edges of map
        
        
    }
}