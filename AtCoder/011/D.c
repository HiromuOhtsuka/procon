#include <stdio.h>
#include <math.h>

int N, D, M;
int gx, gy;

int isNear(int bx, int by, int x, int y);
void backTrack(int x, int y, int n);

int main(void){
  double p;

  scanf("%d %d %d %d", &N, &D, &gx, &gy);
  if(D%2 == gx%2 && D%2 == gy%2){
    backTrack(0, 0, 0);
    p = pow(0.25, (double)M);
    printf("M = %d\n", M);
    printf("%lf\n", p);
  }
  else{
    printf("0.0\n");
  }

  return 0;
}

int isNear(int bx, int by, int x, int y){
  int blen, len;

  blen = (gx - bx)*(gx - bx) + (gy - by)*(gy - by);
  len = (gx - x)*(gx - x) + (gy - y)*(gy - y);

  if(len <= blen){
    return 1;
  }
  else{
    return 0;
  }
}

void backTrack(int x, int y, int n){
  if(n > N)
    return;
  if(x == gx && y == gy){
    M++;
    return;
  }
  n++;
  if(isNear(x, y, x+D, y)){
    backTrack(x+D, y, n);
  }
  else if(isNear(x, y, x, y+D)){
    backTrack(x, y+D, n);
  }
  else if(isNear(x, y, x-D, y)){
    backTrack(x-D, y, n);
  }
  else if(isNear(x, y, x, y-D)){
    backTrack(x, y-D, n);
  }
}
