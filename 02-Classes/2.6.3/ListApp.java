import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp{
    public static void main (String[] args){
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame{
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame(){
        this.addWindowListener(
            new WindowAdapter(){
                public void windowClosing (WindowEvent e){
                    System.exit(0);
                }
            }
        );

        this.addKeyListener(
            new KeyAdapter(){
                public void keyPressed (KeyEvent evt){
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(100);
                    int h = rand.nextInt(100);
                    int sa = rand.nextInt(50, 360);
                    int aa = rand.nextInt(50, 360);
                    int cr = rand.nextInt(255);
                    int cg = rand.nextInt(255);
                    int cb = rand.nextInt(255);
                    int fr = rand.nextInt(255);
                    int fg = rand.nextInt(255);
                    int fb = rand.nextInt(255);

                    if(evt.getKeyChar() == 'r'){
                        Rect r = new Rect(x, y, w, h, cr, cg, cb, fr, fg, fb);
                        figs.add(r);
                    }
                    else if(evt.getKeyChar() == 'e'){
                        figs.add(new Ellipse(x, y, w, h, cr, cg, cb, fr, fg, fb));
                    }
                    else if(evt.getKeyChar() == 'a'){
                        figs.add(new Arc(x, y, w, h, sa, aa, cr, cg, cb, fr, fg, fb));
                    }
                    else if(evt.getKeyChar() == 't'){
                        figs.add(new Text("Hello", x, y, cr, cg, cb));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g){
        super.paint(g);
        for (Figure fig: this.figs){
            fig.paint(g);
        }
    }
}