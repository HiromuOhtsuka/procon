#include <cstdio>
#include <cmath>
using namespace std;

static int N, M;

int main(){
  scanf("%d %d", &N, &M);

  double theta_n = (N % 12) * 30 + 30 * ((double)M / 60),
         theta_m = M * 6;

  double theta = abs(theta_n - theta_m);
  if(theta > 180){
    theta = 360 - theta;
  }

  printf("%.4lf\n", theta);

  return 0;
}
