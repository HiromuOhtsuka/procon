#include <cstdio>
#include <cmath>
using namespace std;

int main(){
  double v;
  while(scanf("%lf", &v) != EOF){
    int n = 1;
    while(2.0 * sqrt(24.5 * (n - 1)) < v){
      n++;
    }
    printf("%d\n", n);
  }

  return 0;
}
