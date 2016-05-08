#include <stdio.h>

int main(void){
  int n, count;

  scanf("%d", &n);
  count = 0;
  if(n%2){
    count++;
  }
  count += n/2;

  printf("%d\n", count);

  return 0;
}
