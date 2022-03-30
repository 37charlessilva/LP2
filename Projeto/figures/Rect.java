package figures;

import java.awt.*;

public class Rect extends Figure{
    private int w, h;
    private int fr, fg, fb;
    
    public Rect(int x, int y, int w, int h, int cr, int cg, int cb, int fr, int fg, int fb){
        super(x, y, cr, cg, cb);
        this.w = w;
        this.h = h;
        this.fr = fr;
        this.fg = fg;
        this.fb = fb;
    }

    public int retun_x() {
        return this.x;
    }

    public int retun_y() {
        return this.y;
    }

    public int colision(int mx, int my){
        if(mx >= this.x && mx <= (this.x + this.w) && my >= this.x && my <= (this.y + this.h))
        {
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public void print(){
        System.out.format("Retangulo de tamanho (%d, %d) na posicao (%d, %d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(this.cr, this.cg, this.cb));
        g2d.drawRect(this.x,this.y, this.w,this.h);

        g.setColor(new Color(this.fr, this.fg, this.fb));
        g2d.fillRect(this.x,this.y, this.w,this.h);
    }
}