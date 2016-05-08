#include <cstdio>

int main(void){
  int l1, l2, l3;

  scanf("%d %d %d", &l1, &l2, &l3);

  if(l1 == l2){
    printf("%d\n", l3);
  }
  else if(l2 == l3){
    printf("%d\n", l1);
  }
  else{
    printf("%d\n", l2);
  }

  return 0;
}
