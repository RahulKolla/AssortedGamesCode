import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MainFrames("Menu");
                frame.setSize(500, 400);
                frame.setVisible(true);
            }
        });
    }
}
