#include <cstdio>
#include <cmath>
using namespace std;

int main(){
  while(true){
    double x, h;
    scanf("%lf %lf", &x, &h);
    if(x == 0.0 && h == 0.0){
      return 0;
    }
    printf("%.6f\n", x * sqrt(x * x + 4 * h * h) + x * x);
  }
  return 0;
}
