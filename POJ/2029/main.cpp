#include <stdio.h>
#define MaxW 100
#define MaxH 100

int main(void){
  int table[MaxH+1][MaxW+1], i, j, count, max, x, y, W, H, S, T, n, k;

  for(;;){
    scanf("%d", &n);
    if(n==0)
      break;
    for(i=0;i<=MaxH;i++){
      for(j=0;j<=MaxW;j++){
        table[i][j]=0;
      }
    }
    scanf("%d %d", &W, &H);
    for(k=0;k<n;k++){
      scanf("%d %d", &x, &y);
      table[y][x]=1;
    }
    scanf("%d %d", &S, &T);
    max=0;
    for(x=1;x<=W-S+1;x++){
      for(y=1;y<=H-T+1;y++){
        count=0;
        for(j=x;j<x+S;j++){
          for(i=y;i<y+T;i++){
            if(table[i][j]==1){
              count++;
            }
          }
        }
        if(max<count)
          max=count;
      }
    }
    printf("%d\n", max);
  }

  return 0;
}
