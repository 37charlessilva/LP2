package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure{
    private int x, y;
    private int w, h;
    private int cr, cg, cb, fr, fg, fb;

    public Ellipse (int x, int y, int w, int h, int cr, int cg, int cb, int fr, int fg, int fb){
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

    private void print(){
        System.out.format("Elipse de tamanho (%d, %d) na posicao (%d, %d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(this.cr, this.cg, this.cb));
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

        g.setColor(new Color(this.fr, this.fg, this.fb));
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
    }
}