#include <stdio.h>
#define MaxN 50
#define MaxM 100

int main(void){
  int n, q, m, day, table[MaxN+1][MaxM+1], i, j, k, l, max, count, ans;

  for(;;){
    for(i=0;i<=MaxN;i++)
      for(j=0;j<=MaxM;j++)
        table[i][j]=0;
    scanf("%d %d", &n, &q);
    if(n==0 && q==0)
      break;
    for(k=0;k<n;k++){
      scanf("%d", &m);
      for(l=0;l<m;l++){
        scanf("%d", &day);
        table[k][day]=1;
      }
    }
    ans=max=0;
    for(j=0;j<MaxM;j++){
      count=0;
      for(i=0;i<n;i++){
        if(table[i][j]==1){
          count++;
        }
      }
      if(max<count){
        ans=j;
        max=count;
      }
    }
    if(max>=q){
      printf("%d\n", ans);
    }
    else{
      printf("0\n");
    }
  }

  return 0;
}
