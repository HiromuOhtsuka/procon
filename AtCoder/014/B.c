#include <stdio.h>
#define MAX 20

int main(void){
  int n, x, a[MAX], i, sum, w;

  scanf("%d %d", &n, &x);
  for(i=0; i<n; i++){
    scanf("%d", &a[i]);
  }

  w = 1;
  for(i=0; i<n-1; i++){
    w *= 2;
  }
  i = n-1;
  sum = 0;
  while(w != 0){
    if(w & x){
      sum += a[i];
    }
    i--;
    w = w >> 1;
  }

  printf("%d\n", sum);

  return 0;
}