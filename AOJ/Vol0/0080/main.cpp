nclude <cstdio>
#include <cmath>
using namespace std;

static int Q;

int main(){
  while(true){
    scanf("%d", &Q);

    if(Q == -1){
      return 0;
    }

    double x1 = ((double)Q / 2.0), x2;
    while(abs(x1 * x1 * x1 - (double)Q) >= (0.00001 * (double)Q)){
      x2 = x1 - ((x1 * x1 * x1 - (double)Q) / (3 * x1 * x1));
      x1 = x2;
    }

    printf("%.6lf\n", x1);
  }
  return 0;
}
