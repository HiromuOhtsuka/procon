#include <stdio.h>
#include <math.h>

#define N 1000

double isLen(int sx, int sy, int ex, int ey){
  return sqrt(((ex - sx)*(ex - sx) + (ey - sy)*(ey - sy)));
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
    if((isLen(txa, tya, x[i], y[i]) + isLen(x[i], y[i], txb, tyb)) <= (t*v)){
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
