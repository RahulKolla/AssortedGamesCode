import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener, ActionListener
{
	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 54;
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballPosX = 350;
	private int ballPosY = 520;
	private int ballXdir = -3;
	private int ballYdir = -4;
	
	private MapGenerator map;
	
	public GamePlay()
	{
		map = new MapGenerator(6, 9);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
				
	}
	
	public void paint(Graphics g)
	{
		//background
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 692, 592);
		
		//bricks
		map.draw((Graphics2D)g);
		
		// borders
		g.setColor(Color.white);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//scores
		g.setColor(Color.white);
		g.setFont(new Font("sans-serif", Font.BOLD, 25));
		g.drawString(""+score, 590, 30);
		//paddle
		g.setColor(Color.cyan);
		g.fillRect(playerX, 550, 100, 8);
		
		//ball
		g.setColor(Color.pink);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		if(totalBricks <= 0)
		{
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("sans-serif", Font.BOLD, 30));
			g.drawString("You Won!, Score: " + score, 190, 300);
			g.drawString("Press Space to Restart", 190, 350);
		}
		
		if(ballPosY > 570)
		{
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("sans-serif", Font.BOLD, 30));
			g.drawString("Game Over, Score: " + score, 190, 300);
			g.drawString("Press Space to Restart", 190, 350);
		}
		
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		timer.start();
		if(play)
		{
			if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8)))
			{
				ballYdir = -ballYdir;
			}
			
			A: for(int i = 0; i < map.map.length; i++)
			{
				for(int j = 0; j < map.map[0].length; j++)
				{
					if(map.map[i][j] > 0)
					{
						int brickX = j*map.brickW + 80;
						int brickY = i*map.brickH + 50;
						int BrickW = map.brickW;
						int BrickH = map.brickH;
						
						Rectangle rect = new Rectangle(brickX, brickY, BrickW, BrickH);
						Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect))
						{
							map.setBrickV(0, i, j);
							totalBricks--;
							score += 5;
							
							if(ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width)
							{
								ballXdir = -ballXdir;
							}
							else
							{
								ballYdir = -ballYdir;
							}
							
							break A;
						}
								
					}
				}
			}
			
			ballPosX += ballXdir;
			ballPosY+= ballYdir;
			if(ballPosX < 0)
			{
				ballXdir = -ballXdir;
			}
			if(ballPosY < 0)
			{
				ballYdir = -ballYdir;
			}
			if(ballPosX > 670)
			{
				ballXdir = -ballXdir;
			}
		}
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
		
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(!play)
			{
				play = true;
				ballPosX = 350;
				ballPosY = 520;
				ballXdir = -3;
				ballYdir = -4;
				playerX = 310;
				score = 0;
				totalBricks = 54;
				map = new MapGenerator(6, 9);
				
				repaint();
			}
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(playerX >= 600)
			{
				playerX = 600;
			}
			else
			{
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(playerX < 10)
			{
				playerX = 10;
			}
			else
			{
				moveLeft();
			}
		}
	}
	
	public void moveRight()
	{
		play = true;
		playerX += 20;
		
	}
	
	public void moveLeft()
	{
		play = true;
		playerX -= 20;
		
	}
	
}
