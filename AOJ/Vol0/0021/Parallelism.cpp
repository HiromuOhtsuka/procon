#include <cstdio>
#include <cmath>
#define _EPS (1e-10)
#define _EQR(a, b) (abs((a) - (b)) < _EPS)
using namespace std;

int main(){
  static int N;
  static double x1, y1, x2, y2, x3, y3, x4, y4;
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    scanf("%lf %lf %lf %lf", &x1, &y1, &x2, &y2);
    scanf("%lf %lf %lf %lf", &x3, &y3, &x4, &y4);
    double dx1 = x2 - x1, dy1 = y2 - y1,
           dx2 = x4 - x3, dy2 = y4 - y3;
    if(_EQR((-dy1) * dx2 - dx1 * (-dy2), 0.0)){
      printf("YES\n");
    }
    else{
      printf("NO\n");
    }
  }

  return 0;
}

