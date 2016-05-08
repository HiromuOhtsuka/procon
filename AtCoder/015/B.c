#include <stdio.h>
#define MAX 100

double ave(int a[], int n){
  int i;
  double sum = 0;

  for(i=0; i<n; ++i){
    sum += (double)a[i];
  }

  return sum / (double)n;
}

int main(void){
  int a[MAX], n, i;
  double av;

  scanf("%d", &n);
  for(i=0; i<n; ++i){
    scanf("%d", &a[i]);
  }

  av = ave(a, n);
  printf("%d\n", (int)av + 1);

  return 0;
}
