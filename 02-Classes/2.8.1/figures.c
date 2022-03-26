#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int (* Figure_Area)  (struct Figure*);
typedef int (* Figure_Perimetro)  (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int (* area)  (struct Figure*);
    int (* perimetro) (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d, %d) na posicao (%d, %d), area %d e perimetro %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

int rect_perimetro (Rect* this) {
    Figure* sup = (Figure*) this;
    return 2 * this->w + 2 * this->h;
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area) rect_area,
    (Figure_Perimetro) rect_perimetro
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
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

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d, %d) na posicao (%d, %d) e area %d e perimetro %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int ellipse_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h * 3.14;
}

int ellipse_perimetro (Ellipse * this) {
    Figure* sup = (Figure*) this;
    return 3.14 * (3 *(this->w + this->h) - sqrt((3 * this->w + this->h) * (this->w + 3 *this->h)));
};

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
    (Figure_Perimetro) ellipse_perimetro
};

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
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

void arc_print(Arc * this){
    Figure * sup = (Figure*) this;
    printf("Arco de tamanho (%d, %d) na posicao (%d, %d) com agulo inicial e final(%d, %d) e area %d e perimetro %d.\n", this->w, this->h, sup->x, sup->y, this->sa, this->aa, sup->vtable->area(sup), sup->vtable->perimetro(sup));
}

int arc_area(Rect * this) {
    Figure * sup = (Figure *) this;
    return this->w * this->h;
}

int arc_perimetro(Arc * this) {
    Figure * sup = (Figure *) this;
    return this->w * 3.14 * this->aa;
}

Figure_vtable arc_vtable = {
    (Figure_Print) arc_print,
    (Figure_Area)  arc_area
};

Arc * Arc_new (int x, int y, int w, int h, int sa, int aa){
    Arc * this = malloc(sizeof(Arc));
    Figure * sup = (Figure*) this;
    sup->vtable = &arc_vtable;
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

void text_print (Text* this) {
    Figure * sup = (Figure*) this;
    printf("Texto na posicao (%d, %d) com a menssagem (%s).\n", sup->x, sup->y, this->m);
}

Figure_vtable text_vtable = {
    (Figure_Print) text_print
};

Text * Text_new (char m[20], int x, int y){
    Text * this = malloc(sizeof(Text));
    Figure * sup = (Figure*) this;
    sup->vtable = &text_vtable;
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
    printf("\n");
    for (int i=0; i<8; i++) {
        figs[i]->vtable->print(figs[i]);
    }
    ///
    for (int i=0; i<8; i++) {
        free(figs[i]);
    }
}