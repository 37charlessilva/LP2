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
    Figure focus = null;
    Random rand = new Random();

    int x, y;

    ListFrame(){
        this.addWindowListener(
            new WindowAdapter(){
                public void windowClosing (WindowEvent e){
                    System.exit(0);
                }
            }
        );
        
        this.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent evt){
                focus = null;
                for(Figure fig: figs) {
                    if(fig.colision(evt.getX(), evt.getY()) == 1){
                        focus = fig;
                        // Fazer outra forma de marcar
                    }
                }
                repaint();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent evt){
                x = evt.getX();
                y = evt.getY();
            }
        });

        this.addKeyListener(
            new KeyAdapter(){
                public void keyPressed (KeyEvent evt){
                    int w = 75;
                    int h = 75;
                    int sa = -45;
                    int aa = 180;
                    int cr = 0;
                    int cg = 0;
                    int cb = 0;
                    int fr = 0;
                    int fg = 0;
                    int fb = 0;

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
                    else if(evt.getKeyCode() == KeyEvent.VK_DELETE){
                        figs.remove(focus);
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