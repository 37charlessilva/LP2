package figures;

import java.awt.*;

public class Arc {
    private int x1, y1;
    private int w, h;
    private int sa, aa;

    public Arc(int x1, int y1, int w, int h, int sa, int aa){
        this.x1 = x1;
        this.y1 = y1;
        this.w = w;
        this.h = h;
        this.sa = sa;
        this.aa = aa;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawArc(this.x1, this.y1, this.w, this.h, this.sa, this.aa);
    }
}
