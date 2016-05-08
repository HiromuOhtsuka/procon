#include <cstdio>
#include <algorithm>
#include <climits>
#define MAX_N 50
#define MAX_W 10000
#define MAX_K 50
#define MAX_B 100
using namespace std;

static int W, N, K, A[MAX_N], B[MAX_N];
static int dp[MAX_N][MAX_N * MAX_B + 1][MAX_K + 1];

int main(){
  for(int i = 0; i < MAX_N; i++){
    for(int j = 0; j <= MAX_N * MAX_B; j++){
      for(int k = 0; k <= MAX_K; k++){
        dp[i][j][k] = MAX_W + 1;
      }
    }
  }
  scanf("%d %d %d", &W, &N, &K);
  for(int i = 0; i < N; i++){
    scanf("%d %d", &A[i], &B[i]);
  }
  for(int k = 1; k <= K; k++){
    dp[0][B[0]][k] = A[0];
  }
  for(int i = 0; i < N; i++){
    for(int k = 0; k <= K; k++){
      dp[i][0][k] = 0;
    }
  }
  for(int i = 1; i < N; i++){
    for(int j = 0; j <= N * MAX_B; j++){
      for(int k = 1; k <= K; k++){
        if(j - B[i] >= 0){
          dp[i][j][k] = 
            min(dp[i - 1][j][k], dp[i - 1][j - B[i]][k - 1] + A[i]);
        }
        else{
          dp[i][j][k] = dp[i - 1][j][k];
        }
      }
    }
  }
  for(int j = N * MAX_B; j >= 0; j--){
    if(dp[N - 1][j][K] <= W){
      printf("%d\n", j);
      return 0;
    }
    //printf("j%d, min:%d\n", j, dp[N - 1][j][K]);
  }
  printf("0\n");
  return 0;
}
