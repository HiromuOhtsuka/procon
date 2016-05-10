#include <cstdio>
#define MAX_M 1000
using namespace std;

static int N;
static int dp[4][4000 + 1];

int main(){
  for(int j = 0; j <= 1000; j++){
    dp[0][j] = 1;
  }
  for(int i = 1; i < 4; i++){
    for(int j = 0; j <= 4000; j++){
      for(int k = 0; k <= 1000 && j - k >= 0; k++){
        dp[i][j] += dp[i - 1][j - k];
      }
    }
  }

  while(scanf("%d", &N) != EOF){
    printf("%d\n", dp[3][N]);
  }

  return 0;
}
