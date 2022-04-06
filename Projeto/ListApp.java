import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

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
    int x, y, x1, y1, a, b;
    Color cor_fundo = null, cor_contorno = Color.black;

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
                // Colar em foco
                for(Figure fig: figs) {
                    if(fig.colision(evt.getX(), evt.getY()) == 1){
                        focus = fig;
                        a = focus.x - evt.getX();
                        b = focus.y - evt.getY();
                        x1 = evt.getX();
                        y1 = evt.getY();
                    }
                }
                if(focus != null)
                {
                    // z-order
                    figs.add(focus);
                    figs.remove(focus);
                }
                repaint();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent evt){
                // Pegar coordenadas do mouse quando ele ta na tela
                x = evt.getX();
                y = evt.getY();
            }

            public void mouseDragged(MouseEvent evt) {
                if (focus != null)
                {
                    if(evt.getX() >= focus.x && evt.getX() <= focus.x + 7 && evt.getY() >= focus.y && evt.getY() <= focus.y + 7){
                        if(x1 - evt.getX() >= 10)
                        {
                            focus.w = x1 - evt.getX();
                            focus.x = evt.getX();
                        }
                        if(y1 - evt.getY() >= 10)
                        {
                            focus.h = y1 - evt.getY();
                            focus.y = evt.getY();
                        }
                    }
                    else{
                        focus.x = evt.getX() + a;
                        focus.y = evt.getY() + b;
                    }
                    repaint();
                }
            }
        });

        this.addKeyListener(
            new KeyAdapter(){
                public void keyPressed (KeyEvent evt){
                    int w = 75;
                    int h = 75;
                    int sa = -45;
                    int aa = 180;

                    // Criar figuras
                    if(evt.getKeyChar() == 'r'){
                        focus = new Rect(x, y, w, h, cor_fundo, cor_contorno);
                        figs.add(focus);
                    }
                    else if(evt.getKeyChar() == 'e'){
                        focus = (new Ellipse(x, y, w, h, cor_fundo, cor_contorno));
                        figs.add(focus);
                    }
                    else if(evt.getKeyChar() == 'a'){
                        focus = (new Arc(x, y, w, h, sa, aa, cor_fundo, cor_contorno));
                        figs.add(focus);
                    }
                    else if(evt.getKeyChar() == 't'){
                        focus = (new Text("Hello", x, y, 0, 0, cor_fundo, cor_contorno));
                        figs.add(focus);
                    }

                     // Remover figura
                    else if(evt.getKeyCode() == KeyEvent.VK_DELETE){
                        figs.remove(focus);
                        focus = null;
                    }
                    
                    // Mover figuras
                    else if(focus != null){

                        if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
                            focus.x += 2;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
                            
                            focus.x -= 2;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_UP){
                            
                            focus.y -= 2;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
                            
                            focus.y += 2;
                        }
                        // Trocar foco com tecla
                        else if(evt.getKeyChar() == 'f'){
                            focus = figs.get(0);
                            figs.add(focus);
                            figs.remove(focus);
                        }
                        // Cor de fundo
                        else if(evt.getKeyCode() == KeyEvent.VK_NUMPAD0){
                            focus.cor_fundo = null;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_NUMPAD1){
                            focus.cor_fundo = Color.black;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_NUMPAD2){
                            focus.cor_fundo = Color.blue;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_NUMPAD3){
                            focus.cor_fundo = Color.CYAN;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_NUMPAD4){
                            focus.cor_fundo = Color.DARK_GRAY;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_NUMPAD5){
                            focus.cor_fundo = Color.GRAY;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_NUMPAD6){
                            focus.cor_fundo = Color.GREEN;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_NUMPAD7){
                            focus.cor_fundo = Color.ORANGE;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_NUMPAD8){
                            focus.cor_fundo = Color.PINK;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_NUMPAD9){
                            focus.cor_fundo = Color.YELLOW;
                        }

                        // Cor de contorno
                        else if(evt.getKeyCode() == KeyEvent.VK_0){
                            focus.cor_contorno = Color.black;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_1){
                            focus.cor_contorno = Color.white;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_2){
                            focus.cor_contorno = Color.blue;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_3){
                            focus.cor_contorno = Color.CYAN;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_4){
                            focus.cor_contorno = Color.DARK_GRAY;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_5){
                            focus.cor_contorno = Color.GRAY;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_6){
                            focus.cor_contorno = Color.GREEN;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_7){
                            focus.cor_contorno = Color.ORANGE;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_8){
                            focus.cor_contorno = Color.PINK;
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_9){
                            focus.cor_contorno = Color.YELLOW;
                        }
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
        
        if(focus != null)
        {
            // Desenhar retangulo na fig em foco
            focus.rect_paint(g);
        }
    }
}