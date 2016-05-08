#include <cstdio>
#include <algorithm>
#define MAX_N 50000
#define MAX_M 20
#define MAX_V 10000
using namespace std;

static int N, M;
static int c[MAX_M];
static int dp[MAX_M][MAX_N + 1];

int main(){
  scanf("%d %d", &N, &M);
  for(int i = 0; i < M; i++){
    scanf("%d", &c[i]);
  }
  for(int j = 1; j <= N; j++){
    if(j % c[0] == 0){
      dp[0][j] = j / c[0];
    }
    else{
      dp[0][j] = MAX_V + 1;
    }
  }
  dp[0][0] = 0;
  for(int i = 1; i < M; i++){
    for(int j = 0; j <= N; j++){
      if(j - c[i] >= 0){
        dp[i][j] = min(dp[i - 1][j], dp[i][j - c[i]] + 1);
      }
      else{
        dp[i][j] = dp[i - 1][j];
      }
    }
  }
  printf("%d\n", dp[M - 1][N]);

  return 0;
}
