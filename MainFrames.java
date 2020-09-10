import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrames extends JFrame
{
    public MainFrames(String title)
    {
        super(title);
        getContentPane().setLayout(new BorderLayout());
        //JButton button = new JButton("Soccer");
        JButton button1 = new JButton("Tank");
        JButton button2 = new JButton("Pong");
        JButton button3 = new JButton("Brick Breaker");
        
        Container c = getContentPane();
        
        //c.add(button, BorderLayout.SOUTH);
        c.add(button1, BorderLayout.NORTH);
        c.add(button2, BorderLayout.EAST);
        c.add(button3, BorderLayout.WEST);
        
        
        /*button.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		 Map map = new Map();
        		
        	}
        });*/
        
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	Tank tank = new Tank();
            }
            
        });
        
        
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                Pong main = new Pong();
                
                
            }
            
        });
        
        
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
              BlockBreaker main = new BlockBreaker();
              
            }
            
        });
        
        
        
        
    }
}
