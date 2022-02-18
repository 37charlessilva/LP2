public class RectApp {
    public static void main(String[] args){
        Rect r1 = new Rect(2, 2, 9, 9);
        r1.area();
        System.out.format("Area = %d\n", r1.area());

        r1.print();
        r1.drag(3, 8);
        r1.print();
        r1.drag(5, 9);
        r1.print();
        r1.drag(- 5, - 9);
        r1.print();
    }
}

class Rect{
    int x, y;
    int w, h;

    Rect(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print(){
    System.out.format("Retangulo de tamanho (%d, %d) na posicao (%d, %d).\n",
    this.w, this.h, this.x, this.y);
    }

    int area(){
        return this.x * this.w;
    }

    void drag (int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
}