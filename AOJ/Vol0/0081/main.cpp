nclude <cstdio>
#include <cmath>
using namespace std;

int main(){
  double x1, y1, x2, y2, xq, yq;
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf", 
        &x1, &y1, &x2, &y2, &xq, &yq) != EOF){
    double theta = atan2((y2 - y1), (x2 - x1));
    double xx, yy, tmp;
    xx = (xq - x1) * cos(-theta) - (yq - y1) * sin(-theta);
    yy = (xq - x1) * sin(-theta) + (yq - y1) * cos(-theta);
    yy = -yy;
    tmp = xx;
    xx = xx * cos(theta) - yy * sin(theta) + x1;
    yy = tmp * sin(theta) + yy * cos(theta) + y1;
    printf("%.4lf %.4lf\n", xx, yy);
  }
  return 0;
}
