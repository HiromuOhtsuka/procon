/* ダイクストラ法を応用して各バス停からの最短距離を求め，
 * それらの最大値が最小となるスタート点を引っ越し先とすればよい。
 */

#include <stdio.h>
#include <limits.h>

#define N 300 + 1
#define M 1000*44850

int a[N][N];

int srcMaxLen(int start, int num){
  int max, len[N], flag[N], i, j, min, k;

  // initial
  for(i=1; i<=num; i++){
    len[i] = M;
    flag[i] = 0;
  }

  len[start] = 0;
  // num回繰り返す。
  for(i=1; i<=num; i++){
    // 最もコストが少ない頂点を探す。
    min = M;
    for(j=1; j<=num; j++){
      if(!flag[j] && len[j] < min){
        k = j;
        min = len[j];
      }
    }
    // 最小頂点確定
    flag[k] = 1;
    // 最もコストが少ない頂点周辺の点の距離を更新する。
    for(j=1; j<=num; j++){
      if(( a[k][j] + len[k]) < len[j]){
        len[j] = a[k][j] + len[k];
      }
    }
  }
  max = 0;
  for(i=1; i<=num; i++){
    if(max < len[i]){
      max = len[i];
    }
  }
  return max;
}

int main(void){
  int n, m, i, j, k, w, min, tmp;

  for(i=0; i<N; i++){
    for(j=0; j<N; j++){
      a[i][j] = M;
    }
  }

  scanf("%d %d", &n,  &m);
  for(k=0; k<m; k++){
    scanf("%d %d %d", &i, &j, &w);
    a[i][j] = a[j][i] = w;
  }

  min = M;
  for(i=1; i<=n; i++){
    tmp = srcMaxLen(i, n);
    if(min > tmp){
      min = tmp;
    }
  }
  printf("%d\n", min);

  return 0;
}
