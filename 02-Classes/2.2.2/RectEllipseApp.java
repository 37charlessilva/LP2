import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Ellipse e1, e2, e3;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
        this.setTitle("Ellipse");
        this.setSize(350, 350);
        this.e1 = new Ellipse(130, 45, 130, 30, 100, 255, 0, 255, 30, 0);
        this.e2 = new Ellipse(100, 90, 90, 45, 255, 0, 40, 200, 255, 255);
        this.e3 = new Ellipse(170, 130, 170, 40, 50, 0, 255, 150, 0, 255);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        g.drawRect(this.x,this.y, this.w,this.h);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    int cr, cg, cb, fr, fg, fb;

    Ellipse (int x, int y, int w, int h, int cr, int cg, int cb, int fr, int fg, int fb) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cr = cr;
        this.cg = cg;
        this.cb = cb;
        this.fr = fr;
        this.fg = fg;
        this.fb = fb;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d, %d) na posicao (%d, %d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(this.cr, this.cg, this.cb));
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

        g.setColor(new Color(this.fr, this.fg, this.fb));
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
    }
}