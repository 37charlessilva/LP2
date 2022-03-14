package figures;

import java.awt.*;

public class Text extends Figure{
    protected String m;

    public Text(String m, int x, int y, int cr, int cg, int cb)
    {
        super(x, y, cr, cg, cb);
        this.m = m;
    }

    public void print(){
        System.out.format("Texto na posicao (%d, %d) com a menssagem (%s).\n", this.x, this.y, this.m);
    }
    
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(this.cr, this.cg, this.cb));
        g2d.drawString(this.m, this.x, this.y);
    }
}
