package figures;

import java.awt.*;

public class Rect extends Figure{
    private int w, h;
    
    public Rect(int x, int y, int w, int h, Color cor_fundo, Color cor_contorno){
        
        super(x, y, cor_fundo, cor_contorno);
        this.w = w;
        this.h = h;
    }

    public int colision(int mx, int my){
        if(mx >= this.x && mx <= (this.x + this.w) && my >= this.y && my <= (this.y + this.h))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public void print(){
        System.out.format("Retangulo de tamanho (%d, %d) na posicao (%d, %d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void drag(int dx, int dy){
        this.x += dx;
        this.y += dx;
    }
    
    public void rect_paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        g2d.drawRect(this.x - 1 ,this.y - 1, this.w + 2, this.h + 2);
    }
    
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        if(c == 1)
        {
            rect_paint(g);
        }
        
        if(cor_fundo != null)
        {
            g.setColor(this.cor_fundo);
            g2d.fillRect(this.x, this.y, this.w, this.h);
        }

        g.setColor(this.cor_contorno);
        g2d.drawRect(this.x, this.y, this.w, this.h);

        c = 0;
    }
}