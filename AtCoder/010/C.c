#include <stdio.h>

#define N 1000

int isInCircle(int mx, int my, int r, int x, int y){
  return ( ((x - mx)*(x - mx) + (y - my)*(y - my)) <= (r*r) );
}

int isOnLine(int sx, int sy, int ex, int ey, int x, int y){
  return ( (y*(ex - sx)) == ((ey - sy)*(x - sx) + sy) );
}

int main(void){
  int txa, tya, txb, tyb, t, v, n, i, x[N], y[N], flag;

  scanf("%d %d %d %d %d %d", &txa, &tya, &txb, &tyb, &t, &v);
  scanf("%d", &n);
  for(i=0; i<n; i++){
    scanf("%d %d", &x[i], &y[i]);
  }

  flag = 0;
  for(i=0; i<n; i++){
    if(isInCircle(txa, tya, t*v, x[i], y[i]) && isOnLine(txa, tya, txb, tyb, x[i], y[i])){
      flag = 1;
      break;
    }
  }

  if(flag){
    printf("YES\n");
  }
  else{
    printf("NO\n");
  }

  return 0;
}
