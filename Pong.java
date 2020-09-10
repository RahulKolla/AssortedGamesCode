import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Pong 
{
/*
 * the runner of the program
 * opens game and closes it based on what user clicks
 */
	public Pong()
	{
		JFrame frame = new JFrame();
        View view = new View();
        Model model = new Model(view);

        frame.setSize(750, 750);//the game screen
        frame.getContentPane().add(view);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}