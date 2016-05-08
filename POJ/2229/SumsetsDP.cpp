#include <cstdio>
#define MAX_N 1000000
using namespace std;

static int N;
static int dp[21][MAX_N + 1];

int main(){
  scanf("%d", &N);
  for(int i = 1; i <= N; i++){
    dp[0][i] = 1;
  }
  int count = 0;
  int i;
  for(i = 1; (1 << i) <= N; i++){
    for(int j = 1; j <= N; j++){
      int sum = dp[i - 1][j];
      for(int k = 1; j - k * (1 << i) >= 0; k++){
        ++count;
        sum += dp[i - 1][j - k * (1 << i)];
      }
      dp[i][j] = sum;
    }
  }
  printf("%d\n", dp[i - 1][N]);
  printf("count:%d\n", count);

  return 0;
}
