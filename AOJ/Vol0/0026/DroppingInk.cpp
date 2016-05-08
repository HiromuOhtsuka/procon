#include <cstdio>
#include <cstdlib>
using namespace std;

static int table[10][10];

static void draw(int x, int y){
  if(!(0 <= x && x < 10 && 0 <= y && y < 10)){
    return;
  }
  table[y][x]++;
}

static void draw_small(int x, int y){
  draw(x, y);
  draw(x + 1, y);
  draw(x - 1, y);
  draw(x, y + 1);
  draw(x, y - 1);
}

static void draw_mid(int x, int y){
  draw_small(x, y);
  draw(x - 1, y - 1);
  draw(x - 1, y + 1);
  draw(x + 1, y - 1);
  draw(x + 1, y + 1);
}

static void draw_large(int x, int y){
  draw_mid(x, y);
  draw(x, y - 2);
  draw(x - 2, y);
  draw(x + 2, y);
  draw(x, y + 2);
}

int main(){
  int x, y, size;

  while(true){
    if(scanf("%d,%d,%d", &x, &y, &size) != EOF){
      switch(size){
        case 1 : draw_small(x, y); break;
        case 2 : draw_mid(x, y); break;
        case 3 : draw_large(x, y); break;
        default : exit(1);
      }
    }
    else{
      break;
    }
  }

  int max = 0, count = 0;
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      if(table[i][j] == 0){
        count++;
      }
      if(table[i][j] > max){
        max = table[i][j];
      }
    }
  }
  printf("%d\n%d\n", count, max);

  return 0;
}
