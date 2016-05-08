#include <cstdio>
#include <cmath>
using namespace std;

static int N;
static double xa, ya, ra, xb, yb, rb;

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    scanf("%lf %lf %lf %lf %lf %lf", &xa, &ya, &ra, &xb, &yb, &rb);

    double diff = (xb - xa)*(xb - xa) + (yb - ya)*(yb - ya);
    double rr = (ra + rb)*(ra + rb);
    if(diff > rr){
      printf("0\n");
    }
    else if(sqrt(diff) + ra < rb){
      printf("-2\n");
    }
    else if(sqrt(diff) + rb < ra){
      printf("2\n");
    }
    else{
      printf("1\n");
    }
  }

  return 0;
}
