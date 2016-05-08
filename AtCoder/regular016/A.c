#include <stdio.h>

int main(void){
  int n, m, i;

  scanf("%d %d", &n, &m);

  for(i=1; i<=n; i++){
    if(i != m){
      printf("%d\n", i);
      break;
    }
  }

  return 0;
}
