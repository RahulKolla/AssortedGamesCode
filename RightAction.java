import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
/*
 * sets action of right user
 * the up arrow and the down arrow
 * the RIGHT_UP and RIGHT_DOWN
 */
public class RightAction extends AbstractAction 
{
    Direction dir;
    boolean pressed;

    public RightAction(Direction dir, boolean pressed) 
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
    public void actionPerformed(ActionEvent e) 
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