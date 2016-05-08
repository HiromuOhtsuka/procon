#include <cstdio>
#include <cmath>
using namespace std;

static int N;

int main(){
  while(true){
    double x = 1, y = 0, theta = 0;
    scanf("%d", &N);

    if(N == -1){
      return 0;
    }

    for(int i = 0; i < N - 1; i++){
      double tmp_x = x, tmp_y = y;
      x = tmp_x * cos(-theta) - tmp_y * sin(-theta);
      y = tmp_x * sin(-theta) + tmp_y * cos(-theta);
      y += 1.0;
      double diff = atan2l(y, x);
      tmp_x = x, tmp_y = y;
      x = tmp_x * cos(theta) - tmp_y * sin(theta);
      y = tmp_x * sin(theta) + tmp_y * cos(theta);
      theta += diff;
    }

    printf("%.2lf\n%.2lf\n", x, y);
  }

  return 0;
}
