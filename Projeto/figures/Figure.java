package figures;

import java.awt.Graphics;

public abstract class Figure{
    public int x, y, c = 1;
    protected int cr, cg, cb;

    public Figure(int x, int y, int cr, int cg, int cb){
        this.x = x;
        this.y = y;
        this.cr = cr;
        this.cg = cg;
        this.cb = cb;
    }
    public abstract void paint(Graphics g);
    public abstract int colision(int mx, int my);
    public abstract void rect_paint(Graphics g);
}