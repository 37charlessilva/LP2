package figures;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

public abstract class Figure{
    public int x, y;
    public int c = 1; // 
    public Color cor_fundo, cor_contorno;

    public Figure(int x, int y, Color cor_fundo, Color cor_contorno){
        this.x = x;
        this.y = y;
        this.cor_fundo = cor_fundo;
        this.cor_contorno = cor_contorno;
    }

    public abstract void paint(Graphics g);
    public abstract int colision(int mx, int my);
    public abstract void rect_paint(Graphics g);
    public abstract void drag(int dx, int y);
}