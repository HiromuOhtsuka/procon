#include <cstdio>
#include <cmath>
using namespace std;

static double xa, ya, xb, yb, xc, yc, xd, yd;

int main(){

  while(scanf("%lf %lf %lf %lf %lf %lf %lf %lf",
                &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd)
                  != EOF){
    if(fabs((xb - xa) * (xd - xc) + (yb - ya) * (yd - yc)) <= 1e-12){
      printf("YES\n");
    }
    else{
      printf("NO\n");
    }
  }

  return 0;
}
