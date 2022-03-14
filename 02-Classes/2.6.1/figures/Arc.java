package figures;

import java.awt.*;

public class Arc extends Figure{
    private int x, y;
    private int w, h;
    private int sa, aa;
    private int cr, cg, cb, fr, fg, fb;

    public Arc(int x, int y, int w, int h, int sa, int aa, int cr, int cg, int cb, int fr, int fg, int fb){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.sa = sa;
        this.aa = aa;
        this.cr = cr;
        this.cg = cg;
        this.cb = cb;
        this.fr = fr;
        this.fg = fg;
        this.fb = fb;
    }

    public void print(){
        System.out.format("Arco de tamanho (%d, %d) na posicao (%d, %d) com agulo inicial e final(%d, %d).\n",
            this.w, this.h, this.x, this.y, this.sa, this.aa);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(this.cr, this.cg, this.cb));
        g2d.drawArc(this.x, this.y, this.w, this.h, this.sa, this.aa);
        
        g.setColor(new Color(this.fr, this.fg, this.fb));
        g2d.fillArc(this.x, this.y, this.w, this.h, this.sa, this.aa);
    }
}
