package figures;

import java.awt.*;

public class Arc {
    private int x1, y1;
    private int w, h;
    private int sa, aa;
    int cr, cg, cb, fr, fg, fb;

    public Arc(int x1, int y1, int w, int h, int sa, int aa, int cr, int cg, int cb, int fr, int fg, int fb){
        this.x1 = x1;
        this.y1 = y1;
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

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(this.cr, this.cg, this.cb));
        g2d.drawArc(this.x1, this.y1, this.w, this.h, this.sa, this.aa);
        
        g.setColor(new Color(this.fr, this.fg, this.fb));
        g2d.fillArc(this.x1, this.y1, this.w, this.h, this.sa, this.aa);
    }
}
