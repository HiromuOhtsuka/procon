#include <cstdio>
#define MAX_N 1000000
using namespace std;

static int N;
static unsigned long long dp[21][MAX_N + 1];
static void init_dp(){
  for(int i = 0; i < 21; i++){
    for(int j = 0; j <= MAX_N; j++){
      dp[i][j] = 0;
    }
  }
}

int main(){
  while(scanf("%d", &N) != EOF){
    for(int i = 0; i <= N; i++){
      dp[0][i] = 1;
    }
    for(int i = 0; i < 21; i++){
      dp[i][0] = 1;
    }
    int i;
    for(i = 1; (1 << i) <= N; i++){
      for(int j = 1; j <= N; j++){
        if(j - (1 << i) >= 0){
          dp[i][j] = (dp[i][j - (1 << i)] + dp[i - 1][j]) % 1000000000ul;
        }
        else{
          dp[i][j] = dp[i - 1][j] % 1000000000ul;
        }
      }
    }
    printf("%llu\n", dp[i - 1][N] % 1000000000ul);
    init_dp();
  }

  return 0;
}
