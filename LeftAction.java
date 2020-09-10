import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
/*
 * sets action of left user
 * the "w" and the "s" 
 * the LEFT_UP and LEFT_DOWN
 */
public class LeftAction extends AbstractAction 
{
    Direction dir;
    boolean pressed;

    public LeftAction(Direction dir, boolean pressed) 
    {
        this.dir = dir;
        this.pressed = pressed;
    }
/*
 * (non-Javadoc)
 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
 * checks the user interaction with the program
 * and makes the object "react" to the user interaction
 * up goes up and down goes down
 * 
 */
    @Override
    public void actionPerformed(ActionEvent arg0) 
    {
        if (pressed) 
        {
            Model.keys.add(dir);
        } 
        else 
        {
            Model.keys.remove(dir);
        }
    }

}