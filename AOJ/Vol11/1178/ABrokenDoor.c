#include <stdio.h>
#define MAX_W 30
#define MAX_H 30

struct room {
  char l, r, u, d;
};

struct room table[MAX_H][MAX_W];
int w, h;

int backTrack(int x, int y){
  int n = 0;
  printf("(%d, %d)", x, y);
  if(x == w-1 && y == h-1){
    return 1;
  }
  if(table[y][x].r){
    n++;
    n += backTrack(x+1, y);
  }
  else if(table[y][x].d){
    n++;
    n += backTrack(x, y+1);
  }
  else{
    return 0;
  }
  return n;
}

int main(void){
  int i, j;

  for(;;){
    scanf("%d %d", &h, &w);
    if(h == 0 && w == 0){
      break;
    }
    // initial
    for(i=0; i<w; i++){
      table[0][i].u = 0;
      table[h-1][i].d = 0;
    }
    for(i=0; i<h; i++){
      table[i][0].l = 0;
      table[i][w-1].r = 0;
    }

    // input
    for(i=0; i<h-1; i++){
      for(j=0; j<w-1; j++){
        scanf("%d", &table[i][j].l);
        table[i][j].r = table[i][j+1].l;
      }
        for(j=0; j<w; j++){
          scanf("%d", &table[i][j].d);
          table[i][j].u = table[i+1][j].d;
        }
    }
    for(j=0; j<w-1; j++){
      scanf("%d", &table[i][j].l);
      table[i][j].r = table[i][j].l;
    }
    printf("%d\n", backTrack(0, 0));
  }

  return 0;
}

