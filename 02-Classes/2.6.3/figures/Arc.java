package figures;

import java.awt.*;

public class Arc extends Figure{
    private int sa, aa;
    private int w, h;
    private int fr, fg, fb;

    public Arc(int x, int y, int w, int h, int sa, int aa, int cr, int cg, int cb, int fr, int fg, int fb){

        super(x, y, cr, cg, cb);
        this.w = w;
        this.h = h;
        this.sa = sa;
        this.aa = aa;
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
