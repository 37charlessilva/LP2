package figures;

import java.awt.*;

public class Arc extends Figure{
    private int sa, aa;

    public Arc(int x, int y, int w, int h, int sa, int aa, Color cor_fundo, Color cor_contorno){
        super(x, y, w, h, cor_fundo, cor_contorno);
        this.sa = sa;
        this.aa = aa;
    }

    public int colision(int mx, int my){
        if(mx >= this.x && mx <= (this.x + this.w) && my >= this.y && my <= (this.y + this.h))
        {
            return 1;
        }
        else{
            return 0;
        }
    }

    public void print(){
        System.out.format("Arco de tamanho (%d, %d) na posicao (%d, %d) com agulo inicial e final(%d, %d).\n",
            this.w, this.h, this.x, this.y, this.sa, this.aa);
    }
    
    public void drag(int dx, int dy){
        this.x += dx;
        this.y += dx;
    }

    public void rect_paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        g2d.drawRect(this.x ,this.y, this.w, this.h);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        if(c == 1)
        {
            rect_paint(g);
        }

        if(cor_fundo != null)
        {
            g.setColor(this.cor_fundo);
            g2d.fillArc(this.x, this.y, this.w, this.h, this.sa, this.aa);
        }

        g.setColor(this.cor_contorno);
        g2d.drawArc(this.x, this.y, this.w, this.h, this.sa, this.aa);

        c = 0;
    }
}
