#include <cstdio>
#include <algorithm>
#define MAX_N 100
#define MAX_W 10000
using namespace std;

static int N, W, v[MAX_N], w[MAX_N];
static int dp[MAX_N][MAX_W + 1];

int main(){
  scanf("%d %d", &N, &W);
  for(int i = 0; i < N; i++){
    scanf("%d %d", &v[i], &w[i]);
  }
  for(int j = 0; j <= W; j++){
    if(w[0] <= j){
      dp[0][j] = v[0];
    }
    else{
      dp[0][j] = 0;
    }
  }
  for(int i = 1; i < N; i++){
    for(int j = 0; j <= W; j++){
      if(j - w[i] >= 0){
        dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
      }
      else{
        dp[i][j] = dp[i - 1][j];
      }
    }
  }
  printf("%d\n", dp[N - 1][W]);

  return 0;
}
