#include <stdio.h>
#define MAX 10 + 1

int main(void){
  int table[MAX][MAX];
  int n, m;
  int i, j, k, tmp[MAX][MAX], ans[MAX];

  // initial
  for(i=0; i<MAX; ++i){
    for(j=0; j<MAX; ++j){
      table[i][j] = tmp[i][j] = 0;
    }
    ans[i] = 0;
  }

  // input
  scanf("%d %d", &n, &m);
  for(i=0; i<m; ++i){
    int x, y;
    scanf("%d %d", &x, &y);
    table[x][y] = table[y][x] = 1;
  }

  // calc
  for(i=1; i<=n; ++i){
    for(j=1; j<=n; ++j){
      for(k=1; k<=n; ++k){
        tmp[i][j] += table[i][k] * table[k][j];
      }
    }
  }

  // 
  for(i=1; i<=n; ++i){
    for(j=1; j<=n; ++j){
      printf("%d ", tmp[i][j]);
    }
    printf("\n");
  }
  // count
  for(i=1; i<=n; ++i){
    for(j=1; j<=n; ++j){
      if(i != j && !table[i][j] && tmp[i][j]){
        ans[i]++;
      }
    }
  }

  // out
  for(i=1; i<=n; ++i){
    printf("%d\n", ans[i]);
  }

  return 0;
}

