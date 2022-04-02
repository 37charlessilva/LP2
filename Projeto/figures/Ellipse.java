package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure{
    private int w, h;
    private int fr, fg, fb;

    public Ellipse(int x, int y, int w, int h, int cr, int cg, int cb, int fr, int fg, int fb){
        
        super(x, y, cr, cg, cb);
        this.w = w;
        this.h = h;
        this.fr = fr;
        this.fg = fg;
        this.fb = fb;       
    }

    public int colision(int mx, int my){
        if(mx >= this.x && mx <= (this.x + this.w) && my >= this.y && my <= (this.y + this.h))
        {
            return c = 1;
        }
        else{
            return c = 0;
        }
    }
    
    public void print(){
        System.out.format("Elipse de tamanho (%d, %d) na posicao (%d, %d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void rect_paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        g2d.drawRect(this.x ,this.y, this.w, this.h);
    }

    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        if(c == 1)
        {
            rect_paint(g);
        }

        g.setColor(new Color(this.cr, this.cg, this.cb));
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

        c = 0;
        
        //g.setColor(new Color(this.fr, this.fg, this.fb));
        //g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
    }
}