#include <cstdio>
#include <cmath>
#include <algorithm>
using namespace std;

static int C, N, H, R, T;
static double cal(int t){
  if(t < 0.0){
    return H;
  }
  double period = sqrt(2.0 * (double)H / 10.0);
  int n = (int)(T / period);

  if(n % 2 == 0){
    return (double)H - 5.0 *((double)t - (double)n * period) * 
        ((double)t - (double)n * period);
  }
  else{
    return (double)H - 5.0 * ((double)(n + 1) * period - (double)t) * 
      ((double)(n + 1) * period - (double)t);
  }
}

int main(){
  scanf("%d", &C);
  for(int i = 0; i < C; i++){
    scanf("%d %d %d %d", &N, &H, &R, &T);
    double y[N];
    for(int j = 0; j < N; j++){
      y[j] = cal(T - j);
    }
    sort(y, y + N);
    for(int j = 0; j < N; j++){
      printf("%.2f%c", (double)y[j] + (double)(2 * R * j) / 100.0, 
        (j + 1) == N ? '\n' : ' ');
    }
  }

  return 0;
}
