package figures;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.AffineTransform;

public class Text extends Figure{
    protected String m;
    protected int textwidth, textheight;
    
    public Text(String m, int x, int y, int w, int h, Color cor_fundo, Color cor_contorno)
    {
        super(x, y, w, h, cor_fundo, cor_contorno);
        this.m = m;
    }

    public void print(){
        System.out.format("Texto na posicao (%d, %d) com a menssagem (%s).\n", this.x, this.y, this.m);
    }
    
    public void drag(int dx, int dy){
        this.x += dx;
        this.y += dx;
    }
    
    public int colision(int mx, int my){
        
        if(mx >= this.x && mx <= (this.x + textwidth) && my <= this.y && my >= (this.y - textheight))
        {
            return 1;
        }
        else{
            
            return 0;
        }
    }

    public void rect_paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        g2d.drawRect(this.x ,this.y - textheight, textwidth, textheight);
    }

    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Arial", Font.PLAIN, 20);
        FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);

        g.setColor(cor_fundo);
        g.setFont(font);
        textwidth = (int)(font.getStringBounds(m, frc).getWidth());
        textheight = (int)(font.getStringBounds(m, frc).getHeight());
        g2d.drawString(this.m, this.x, this.y);

        if(c == 1)
        {
            rect_paint(g);
        }

        c = 0;
    }
}
