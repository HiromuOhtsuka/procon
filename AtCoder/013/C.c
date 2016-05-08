#include <stdio.h>

int main(void){
  int n, h, a, b, c, d, e, i, j, day;
  long m;

  scanf("%d %d", &n, &h);
  scanf("%d %d %d %d %d", &a, &b, &c, &d, &e);

  day = 0;
  m = 0;
  while(day != n){
    // debug
    printf("day : %d, h = %d, m = %d\n", day, h, m);
    day++;
    if(h - e > 0){
      h = h - e;
      continue;
    }
    if(day == n){
      h = h + d;
      m = m + c;
      continue;
    }
    if((h + d) / e >= (h + b) / e){
      h = h + d;
      m = m + c;
      continue;
    }
    else{
      h = h + b;
      m = m + a;
    }
  }

  printf("%d\n", m);

  return 0;
}
