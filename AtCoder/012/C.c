#include <stdio.h>

int main(void){
  int sum, n, df, i, j;

  sum = 0;
  for(i=1; i<10; i++){
    for(j=1; j<10; j++){
      sum += i * j;
    }
  }
  
  scanf("%d", &n);
  
  df = sum - n;
  for(i=1; i<10; i++){
    for(j=1; j<10; j++){
      if(i * j == df){
        printf("%d x %d\n", i, j);
      }
    }
  }

  return 0;
}
