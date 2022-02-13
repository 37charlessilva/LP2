import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp2 {
    public static void main (String[] args) {
        Hello2DFrame2 frame = new Hello2DFrame2();
    }
}

class Hello2DFrame2 extends JFrame {
    public Hello2DFrame2 () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.getContentPane().setBackground(new Color(92,64,51));
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.blue);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
        
        g2d.setPaint(new Color(0,0,156));

        g2d.fillRect(10, 135, 120, 82);
        g2d.fillRect(219, 135, 120, 82);

        g2d.setColor(Color.black);
        g2d.drawArc(130, 150, 89, 100, 5, 170);

        g2d.fillOval(130, 230, 89, 100);
    }
}