#include <stdio.h>
#define MAX_N 100
#define H 9
int main(void){
  int n, i, j, count, state;
  char table[MAX_N][H];

  scanf("%d", &n);
  for(i=0; i<n; i++){
    for(j=0; j<H; j++){
      scanf("%c", &table[i][j]);
    }
  }

  count = 0;
  for(i=0; i<n; i++){
    for(j=0; j<H; j++){
      if(table[i][j] == 'x'){
        count++;
        state = 0;
      }
      else if(table[i][j] == 'o'){
        if(state){
          count++;
        }
        state = state ? 0 : 1;
      }
    }
  }

  printf("%d\n", count);

  return 0;
}
