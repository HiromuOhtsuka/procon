#include <cstdio>
#define MAX_N 5000
#define NOT (-5000 * 100001)
using namespace std;

static int N;
static int dp[MAX_N][MAX_N];

static int sub_sum(int i, int j){
  if(dp[i][j] != NOT){
    return dp[i][j];
  }
  int k = (i + j) / 2;
  return dp[i][j] = sub_sum(i, k) + sub_sum(k + 1, j);
}

int main(){
  scanf("%d", &N);
  while(N != 0){
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        dp[i][j] = NOT;
      }
    }
    for(int i = 0; i < N; i++){
      scanf("%d", &dp[i][i]);
    }

    int best = dp[0][0];
    for(int i = 0; i < N; i++){
      for(int j = i; j < N; j++){
        int sum = sub_sum(i, j);
        if(sum > best){
          best = sum;
        }
      }
    }

    printf("%d\n", best);

    scanf("%d", &N);
  }

  return 0;
}
