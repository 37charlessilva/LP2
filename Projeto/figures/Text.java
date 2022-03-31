package figures;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.AffineTransform;

public class Text extends Figure{
    protected String m;
    private int c;
    protected int textwidth, textheight;

    public Text(String m, int x, int y, int cr, int cg, int cb)
    {
        super(x, y, cr, cg, cb);
        this.m = m;
    }

    public void print(){
        System.out.format("Texto na posicao (%d, %d) com a menssagem (%s).\n", this.x, this.y, this.m);
    }
    
    public int retun_x() {
        return this.x;
    }

    public int retun_y() {
        return this.y;
    }

    public int colision(int mx, int my){
        
        if(mx >= this.x && mx <= (this.x + textwidth) && my <= this.y && my >= (this.y - textheight))
        {
            return c = 1;
        }
        else{
            return c = 0;
        }
    }

    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Arial", Font.PLAIN, 20);
        FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);

        
        g.setColor(new Color(this.cr, this.cg, this.cb));
        g.setFont(font);
        textwidth = (int)(font.getStringBounds(m, frc).getWidth());
        textheight = (int)(font.getStringBounds(m, frc).getHeight());
        g2d.drawString(this.m, this.x, this.y);

        if(c == 1)
        {
            g.setColor(Color.red);
            g2d.drawRect(this.x ,this.y - textheight, textwidth, textheight);
        }
    }
}
