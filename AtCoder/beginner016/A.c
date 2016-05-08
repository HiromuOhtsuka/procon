#include <stdio.h>

int main(void){
  int m, d;

  scanf("%d %d", &m, &d);
  if(m % d == 0){
    printf("YES\n");
  }
  else{
    printf("NO\n");
  }

  return 0;
}
