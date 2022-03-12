package figures;

import java.awt.Graphics;

public abstract class Figure{
    protected int x, y;
    protected int w, h;
    protected int cr, cg, cb, fr, fg, fb;

    public Figure(int x, int y, int w, int h, int cr, int cg, int cb, int fr, int fg, int fb){
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
    public abstract void paint(Graphics g);
}