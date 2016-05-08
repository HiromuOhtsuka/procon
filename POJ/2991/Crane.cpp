#include <cstdio>
#include <cmath>
#ifndef M_PI
#define M_PI 3.14159265
#endif
#define MAX_N 10000
using namespace std;

static int N, C;
static double LEN[MAX_N];
static double VX[2 * MAX_N], VY[2 * MAX_N], ANG[2 * MAX_N], PRE[MAX_N + 1];
static void init(int k, int l, int r){
  ANG[k] = VX[k] = 0;
  if(r - l == 1){
    VY[k] = LEN[l];
    return;
  }
  int mid = (l + r) / 2;
  init(2 * k + 1, l, mid);
  init(2 * k + 2, mid, r);
  double chl_y = VY[2 * k + 1],
         chr_y = VY[2 * k + 2];
  VY[k] = chl_y + chr_y;
}
static void update(int s, double ang, int k, int l, int r){
  if(s <= l){
    return;
  }
  else if(s < r){
    int mid = (l + r) / 2;
    update(s, ang, 2 * k + 1, l, mid);
    update(s, ang, 2 * k + 2, mid, r);
    if(s <= mid){
      ANG[k] += ang;
    }
    double chl_x = VX[2 * k + 1],
           chl_y = VY[2 * k + 1],
           chr_x = VX[2 * k + 2],
           chr_y = VY[2 * k + 2];
    VX[k] = chl_x + (chr_x * cos(ANG[k]) - chr_y * sin(ANG[k]));
    VY[k] = chl_y + (chr_x * sin(ANG[k]) + chr_y * cos(ANG[k]));
  }
}

int main(){
  int count = 0;
  while(true){
    if(scanf("%d %d", &N, &C) == EOF){
      return 0;
    }
    if(count != 0){
      putchar('\n');
    }
    for(int i = 0; i <= N; i++){
      PRE[i] = M_PI;
    }
    for(int i = 0; i < N; i++){
      scanf("%lf", &LEN[i]);
    }
    init(0, 0, N);
    for(int i = 0; i < C; i++){
      int s;
      double ang;
      scanf("%d %lf", &s, &ang);
      ang = ang * M_PI / 360 * 2;

      update(s, ang - PRE[s], 0, 0, N);

      PRE[s] = ang;

      printf("%.2lf %.2lf\n", VX[0], VY[0]);
    }
    ++count;
  }

  return 0;
}


