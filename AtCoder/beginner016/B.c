#include <stdio.h>

int main(void){
  int a, b, c;
  int add, sub;

  scanf("%d %d %d", &a, &b, &c);

  add = sub = 0;
  if(a + b == c){
    add = 1;
  }
  if(a - b == c){
    sub = 1;
  }
  if(add & sub){
    printf("?\n");
  }
  else if(add){
    printf("+\n");
  }
  else if(sub){
    printf("-\n");
  }
  else{
    printf("!\n");
  }

  return 0;
}
