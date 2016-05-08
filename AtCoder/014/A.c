#include <stdio.h>

int main(void){
  int a, b, c;

  scanf("%d %d", &a, &b);
  
  if(a % b == 0){
    c = 0;
  }
  else{
    c = (a / b + 1) * b - a;
  }

  printf("%d\n", c);

  return 0;
}
