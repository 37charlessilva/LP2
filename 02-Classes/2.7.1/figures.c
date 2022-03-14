#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}
///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
    int sa, aa;
} Arc;

void Arc_print(Arc * this){
    Figure * sup = (Figure*) this;
    printf("Arco de tamanho (%d, %d) na posicao (%d, %d) com agulo inicial e final(%d, %d).\n", this->w, this->h, sup->x, sup->y, this->sa, this->aa);
}

Arc * Arc_new (int x, int y, int w, int h, int sa, int aa){
    Arc * this = malloc(sizeof(Arc));
    Figure * sup = (Figure*) this;
    sup->print = (Figure_Print) Arc_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->aa = aa;
    this->sa = sa;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    char m[20];
} Text;

void Text_print (Text* this) {
    Figure * sup = (Figure*) this;
    printf("Texto na posicao (%d, %d) com a menssagem (%s).\n", sup->x, sup->y, this->m);
}

Text * Text_new (char m[20], int x, int y){
    Text * this = malloc(sizeof(Text));
    Figure * sup = (Figure*) this;
    sup->print = (Figure_Print) Text_print;
    strcpy(this->m, m);
    sup->x = x;
    sup->y = y;
}

///////////////////////////////////////////////////////////////////////////////
void main (void) {
    Figure* figs[8] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) Text_new("Hello",150, 90),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) Arc_new(100, 30, 59, 50, 0, 60),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) Arc_new(100, 30, 59, 50, 0, 60),
        (Figure*) Text_new("Word",100, 30)
    };

    ///

    for (int i=0; i<8; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<8; i++) {
        free(figs[i]);
    }
}