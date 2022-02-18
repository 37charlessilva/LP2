public class PoligonoApp {
    public static void main(String[] args) {
        Poligono p1 = new Poligono(1, 2, 5, 6, 10);
        p1.print();
    }
}

class Poligono {
    int x, y;
    int w, h;
    int c;

    Poligono (int x, int y, int w, int h, int c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
    }
    
    void print() {
        System.out.format("Poligono de tamanho (%d, %d) na posicao (%d, %d) com %d lado(s).\n", this.w, this.h, this.x, this.y, this.c);
    } 
}
