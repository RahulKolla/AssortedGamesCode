import javax.swing.JFrame;

public class BlockBreaker 
{
	public BlockBreaker()
	{
		JFrame obj = new JFrame();
		obj.setBounds(10, 10, 700, 600);
		GamePlay gamePlay = new GamePlay();
		obj.setTitle("BrickBreaker");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.add(gamePlay);
	}
	public static void main (String[]args)
	{
	}
}
