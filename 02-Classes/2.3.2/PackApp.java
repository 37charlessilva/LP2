import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Arc a1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect(50, 50, 100, 30, 0, 255, 0, 255, 255, 0);
        this.e1 = new Ellipse(50, 100, 100, 30, 100, 255, 0, 255, 30, 0);
        this.a1 = new Arc(100, 200, 150, 150, 0, 180, 50, 0, 255, 150, 0, 255);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.a1.paint(g);
    }
}