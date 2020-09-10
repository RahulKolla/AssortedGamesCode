import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Model
{
	/*
	 * The main class in my game
	 * this class combines the paddles with the ball
	 * and assign direction and collision detection to the ball and the paddle
	 */
    Paddle paddle1;
    Paddle paddle2;
    Balls ball;

    static Set<Direction> keys = new HashSet<Direction>(25);
    Timer timer;
    boolean first = false;
    boolean direction = false, axis = false;
    double ballX = 0, ballY = 0;
    double p1X = 0, p1Y = 0;
    double p2X = 0, p2Y = 0;
    double incline = -0.5;
    List<Entity> entities = new ArrayList<Entity>(20); //entities to be assigned to the keyboard values
    View view;

    public Model(View view) 
    {
        this.view = view;
        startTimer();
        view.setModel(this);
    }
    
    

    public void startTimer() 
    {
        timer = new Timer(2, new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                update(view.getBounds()); // when an action is performed
                view.repaint();
            }
        });
        timer.start();
    }

    public void update(Rectangle bounds) 
    {
        if (paddle1 == null || paddle2 == null || ball == null) 
        {
        	/*
        	 *  sets sizes of paddles and ball
        	 *  makes the object attached to a key
        	 */
            paddle1 = new Paddle(1);
            paddle2 = new Paddle(2);
            ball = new Balls();
            ballX = 300;
            ballY = 300;
            p1X = 30;
            p2X = 650;
            p1Y = 350;
            p2Y = 350;
            paddle1.setView(view);
            paddle2.setView(view);
            paddle1.createBindings();//uses view to make keys to certain action
            paddle2.createBindings();
            entities.add(paddle1);//allows the above methods to execute 
            entities.add(paddle2);
            entities.add(ball);
        }


        setDirection(direction, incline);
        bounce();

        // functionality for changing ball location
        //  use collision detection

        /*
         * controls speed of the paddle
         */
        if (keys.contains(Direction.LEFT_UP))
        {
            p1Y -= 3;
        } else if (keys.contains(Direction.LEFT_DOWN))
        {
            p1Y += 3;
        }
        if (keys.contains(Direction.RIGHT_UP)) 
        {
            p2Y -= 3;
        } else if (keys.contains(Direction.RIGHT_DOWN)) 
        {
            p2Y += 3;
        }

        paddle1.setLocation(new Point((int) p1X, (int) p1Y));//sets new location of the paddles
        paddle2.setLocation(new Point((int) p2X, (int) p2Y));//^
        ball.setLocation(new Point((int) ballX, (int) ballY));// creates the new ball inn new game

    }
    

    public Entity[] getEntities() 
    {
        return entities.toArray(new Entity[0]);

    }

    public void bounce() 
    {

        if (ballX < p1X + paddle1.getSize().width && ballY > p1Y && ballY < p1Y + paddle2.getSize().height) 
        {
            direction = true;//makes ball go in correct direction when it hits the paddle
        }

        if (ballX + ball.getSize().width > p2X && ballY > p2Y && ballY < p2Y + paddle1.getSize().height) 
        {
            direction = false;
        }

        /*
         * // if balls passes the bounds add the score to correct player
         */
        if (ballX < view.getBounds().x) 
        {
            paddle2.increaseScore(); 

            direction = !direction;

            ballX = 300;
            ballY = 300;
        }
        if (ball.getLocation().x > view.getBounds().x + view.getBounds().width) 
        {
            paddle1.increaseScore();

            direction = !direction;

            ballX = 300;
            ballY = 300;
        }
        if (ball.getLocation().y < view.getBounds().y)
        {
            ballY++;
            incline *= -1;
            //checks if location of ball is in bounds 
        }
        if (ball.getLocation().y > view.getBounds().height) 
        {
            ballY--;
            incline *= -1;
            //checks if location of ball is in bounds
        }

        //sets bound of the paddle and makes sure paddle can't go outside dimensions of the screen
        //basically the boundaries
        if (paddle1.getLocation().y < view.getBounds().y) 
        {
            p1Y = view.getBounds().x - 1;
        }
        if (paddle1.getLocation().y + paddle1.getSize().height > view.getBounds().height + 22) 
        {
            p1Y = view.getBounds().height - paddle1.getSize().height + 22;
        }

        if (paddle2.getLocation().y < view.getBounds().y) 
        {
            p2Y = view.getBounds().x - 1;
        }
        if (paddle2.getLocation().y + paddle2.getSize().height > view.getBounds().height + 22) 
        {
            p2Y = view.getBounds().height - paddle2.getSize().height + 22;
        }

    }

    public void setDirection(boolean Xdir, double inc) 
    {
    	/*
    	 * sets speed of ball.
    	 */
        ballY += inc;
        if (Xdir) 
        {
            ballX += 1.5;
        } 
        else if (!Xdir) 
        {
            ballX-= 1.5;
        }
    }

    public int getPaddleScore(int paddleNum) 
    {
        if (paddleNum == 1)
            return paddle1.getScore(); //gets score of each player to print out
        else 
        {
            return paddle2.getScore();
        }
    }
}