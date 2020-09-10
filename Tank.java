import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import com.game.src.main.Game;

public class Tank 
{
/*
 * the runner of the program
 * opens game and closes it based on what user clicks
 */
	public Tank()
	{
		JFrame frame = new JFrame();
        Game game = new Game();

        frame.setSize(320, 240);//the game screen
        frame.getContentPane().add(game);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}