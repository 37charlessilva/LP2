package figures;

import java.awt.*;

public class Text extends Figure{
    private String m;
    private int x, y;
    private int cr, cg, cb;

    public Text (String m,int x, int y, int cr, int cg, int cb)
    {
        this.m = m;
        this.x = x;
        this.y = y;
        this.cr = cr;
        this.cg = cg;
        this.cb = cb;
    }

    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(this.cr, this.cg, this.cb));
        g2d.drawString(this.m, this.x, this.y);
    }
}
