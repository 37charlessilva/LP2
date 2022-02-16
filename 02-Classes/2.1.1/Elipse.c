#include <stdio.h>

typedef struct 
{
    //Rx, Ry, inic, e fim
    int x, y;
    int rx, ry;
    float inic, fim;
} Elipse;

void print (Elipse * e) {
    printf("Elipse de tamanho (%d, %d) na posição (%d, %d) que comeca em %.3f° e termina em %.3f°.\n",
    e->x, e->y, e->rx, e->ry, e->inic, e->fim);
}

void main (void) {
    Elipse e1 = {2, 4, 3, 7, 5, 3};
    print(& e1);
    system("pause");
}