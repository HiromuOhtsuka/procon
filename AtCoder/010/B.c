#include <stdio.h>

int main(void){
  int n, i, h, c;

  scanf("%d", &n);
  c = 0;
  for(i=0; i<n; i++){
    scanf("%d", &h);
    while(!(h%2 == 1 && h%3 != 2)){
      h--;
      c++;
    }
  }

  printf("%d\n", c);

  return 0;
}
