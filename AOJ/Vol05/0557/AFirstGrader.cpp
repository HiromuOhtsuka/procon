#include <cstdio>
#define MAX_N 100
using namespace std;

int N, a[MAX_N];
unsigned long long dp[MAX_N][21];

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    scanf("%d", &a[i]);
  }

  dp[0][a[0]] = 1;
  for(int i = 1; i < N - 1; i++){
    for(int j = 0; j <= 20; j++){
      if(j - a[i] >= 0){
        dp[i][j] += dp[i - 1][j - a[i]];
      }
      if(j + a[i] <= 20){
        dp[i][j] += dp[i - 1][j + a[i]];
      }
    }
  }

  int sum = a[N - 1];
  printf("%llu\n", dp[N - 2][sum]);

  return 0;
}
