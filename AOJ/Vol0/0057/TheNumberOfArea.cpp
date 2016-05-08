#include <cstdio>
#define MAX_N 10000
using namespace std;

static int N;
static int dp[MAX_N + 1];

int main(){
  dp[0] = 1;
  while(scanf("%d", &N) != EOF){
    for(int i = 1; i <= N; i++){
      dp[i] = dp[i - 1] + i;
    }
    printf("%d\n", dp[N]);
  }

  return 0;
}
