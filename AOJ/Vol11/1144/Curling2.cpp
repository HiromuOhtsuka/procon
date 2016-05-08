#include <cstdio>
#define MAX_WH 20
using namespace std;

static int W, H;
static int table[MAX_WH][MAX_WH];
static int best;
static bool search(int sx, int sy, int count);

int main(){
  while(true){
    scanf("%d %d", &W, &H);

    if(W == 0 && H == 0){
      return 0;
    }

    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        scanf("%d", &table[i][j]);
      }
    }

    best = -1;

  }
}

static bool search(int sx, int sy, int count){
  if(!(0 <= sx && sx < W && 0 <= sy && sy < H)){
    return false;
  }
  if(table[sy][sx] == 3){
    if(best > count){
      best = count;
    }
    return true;
  }
  if(table[sy][sx] == 1){
    table[sy][sx] = 0;
    return false;
  }

  bool left = false, right = false, down = false, up = false;
  // Right
  int tmpx = sx, tmpy = sy;
  while(tmpx < W && table[tmpy][tmpx] == 0){
    tmpx++;
  }
  // over
  if(!(0 <= sx && sx < W && 0 <= sy && sy < H)){
    return false;
  }
  right = search(tmpx, tmpy, count + 1);
  // Down
  tmpx = sx, tmpy = sy;
  while(tmpy < H && table[tmpy][tmpx] == 0){
    tmpy++;
  }
  down = search(tmpx, tmpy, count + 1);
  // Up
  tmpx = sx, tmpy = sy;
  while(tmpy >= 0 && table[tmpy][tmpx] == 0){
    tmpy--;
  }
  up = search(tmpx, tmpy, count + 1);
  // Left
  tmpx = sx, tmpy = sy;
  while(tmpx >= 0 && table[tmpy][tmpx] == 0){
    tmpx--;
  }
  left = search(tmpx, tmpy, count + 1);
}
