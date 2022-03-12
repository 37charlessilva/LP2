package figures;

import java.awt.*;

public class Arc extends Figure{
    private int sa, aa;

    public Arc(int x, int y, int w, int h, int sa, int aa, int cr, int cg, int cb, int fr, int fg, int fb){

        super(x, y, w, h, cr, cg, cb, fr, fg, fb);
        this.sa = sa;
        this.aa = aa;
    }

    public void print(){
        System.out.format("Arco de tamanho (%d, %d) na posicao (%d, %d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(this.cr, this.cg, this.cb));
        g2d.drawArc(this.x, this.y, this.w, this.h, this.sa, this.aa);
        
        g.setColor(new Color(this.fr, this.fg, this.fb));
        g2d.fillArc(this.x, this.y, this.w, this.h, this.sa, this.aa);
    }
}
