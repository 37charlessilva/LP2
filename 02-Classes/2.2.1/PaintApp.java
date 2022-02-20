import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(90, 50, 130, 30, 0, 255, 0, 255, 255, 0);
        this.r2 = new Rect(60, 100, 90, 45, 255, 0, 0, 0, 255, 255);
        this.r3 = new Rect(30, 150, 170, 40, 0, 0, 255, 255, 0, 255);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    int cr, cg, cb, fr, fg, fb;

    Rect (int x, int y, int w, int h, int cr, int cg, int cb, int fr, int fg, int fb) {
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
        System.out.format("Retangulo de tamanho (%d, %d) na posicao (%d, %d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(this.cr, this.cg, this.cb));
        g2d.drawRect(this.x, this.y, this.w, this.h);

        g.setColor(new Color(this.fr, this.fg, this.fb));
        g2d.fillRect(this.x, this.y, this.w, this.h);
    }
}