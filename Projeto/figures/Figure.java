package figures;

import java.awt.Graphics;

public abstract class Figure{
    protected int x, y;
    protected int cr, cg, cb;

    public Figure(int x, int y, int cr, int cg, int cb){
        this.x = x;
        this.y = y;
        this.cr = cr;
        this.cg = cg;
        this.cb = cb;
    }
    public abstract void paint(Graphics g);
    public abstract int retun_x();
    public abstract int retun_y();
    public abstract int colision(int mx, int my);
}