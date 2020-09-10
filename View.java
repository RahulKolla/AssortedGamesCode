import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class View extends JPanel
{

    Model model;//the main screen
    Rectangle bounds;//the bound of the main screen

    public View() 
    {
        setBackground(Color.BLACK); // sets background color
        bounds = new Rectangle(0, 0, 705, 670);//sets bounds of the game so when ball hits it, it is out of bounds and the player gets a point
    }

    public void setModel(Model model) 
    {
        this.model = model;
    }

    public void addKeyBinding(String name, int keyEvent, boolean pressed, AbstractAction action) 
    {
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW); //binds object and key pressed
        ActionMap actionMap = getActionMap(); // locates action where button is pressed

        inputMap.put(KeyStroke.getKeyStroke(keyEvent, 0, !pressed), name); //attachs the object to user keyboard actions
        actionMap.put(name, action); ///adds binding key to action
    }

    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);// draws the object
        //ball,paddle or entire sceen
        if (model.getEntities() != null) //if model contains entities left to draw
        {
        	
            for (Entity entity : model.getEntities()) 
            {
                entity.paint(g);//correctly paints all the objects 
            }
            g.setColor(Color.BLUE);//draws player 1 score and player 2 score at top of screen and increment whenever players score
            g.setFont(new Font("Arial", 1, 20));
            g.drawString(model.getPaddleScore(1) + " : " + model.getPaddleScore(2), 350, 20);
        }
    }

    @Override
    public Rectangle getBounds() 
    {
        return bounds;

    }
}