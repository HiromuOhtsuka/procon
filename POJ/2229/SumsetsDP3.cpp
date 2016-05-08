#include <cstdio>
#define MAX_N 1000000
using namespace std;

static int N;
static int dp[MAX_N];
static void init_dp(){
  for(int i = 0; i <= N; i++){
    dp[i] = 0;
  }
}

int main(){
  while(scanf("%d", &N) != EOF){
    for(int i = 0; i <= N; i++){
      dp[i] = 1;
    }
    int count = 0;
    for(int i = 1; (1 << i) <= N; i++){
      for(int j = (1 << i); j <= N; j++){
        ++count;
        dp[j] = (dp[j - (1 << i)] + dp[j]) % 1000000000;
      }
    }
    printf("%d\n", dp[N] % 1000000000);
    printf("%d\n", count);
    init_dp();
  }

  return 0;
}
