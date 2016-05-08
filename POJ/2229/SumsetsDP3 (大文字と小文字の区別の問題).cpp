#include <cstdio>
#define MAX_N 1000000
using namespace std;

static int N;
static int dp[MAX_N + 1];

int main(){
  while(scanf("%d", &N) != EOF){
    for(int i = 0; i <= N; i++){
      dp[i] = 1;
    }
    for(int i = 2; i <= N; i<<=1){
      for(int j = i; j <= N; j++){
        dp[j] = (dp[j - i] + dp[j]) % 1000000000;
      }
    }
    printf("%d\n", dp[N]);
  }

  return 0;
}
