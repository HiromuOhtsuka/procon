#include <stdio.h>

double toF(int n){
  return (9.0 / 5.0 * n) + 32.0;
}

int main(void){
  int n;

  scanf("%d", &n);

  printf("%lf\n", toF(n));

  return 0;
}
