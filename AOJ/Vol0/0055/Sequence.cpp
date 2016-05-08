#include <cstdio>
using namespace std;

static double A;

int main(){

  while(scanf("%lf", &A) != EOF){
    double sum = A;
    for(int i = 2; i <= 10; i++){
      if(i % 2 == 0){
        A *= 2;
      }
      else{
        A /= 3;
      }
      sum += A;
    }
    printf("%.8lf\n", sum);
  }

  return 0;
}
