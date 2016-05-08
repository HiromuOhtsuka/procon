#include <cstdio>
#include <algorithm>
#define MAX_N 5000
#define MAX_P 5000
#define MAX_B 100
using namespace std;

static int N, P, a[MAX_N], b[MAX_N];
static int dp[MAX_N][MAX_P + MAX_B + 1];

int main(){
  scanf("%d %d", &N, &P);
  for(int i = 0; i < N; i++){
    scanf("%d %d", &a[i], &b[i]);
  }
  dp[0][b[0]] = a[0];
  for(int i = 1; i < N; i++){
    for(int j = 0; j <= P + MAX_B; j++){
      if(j - a[i] >= 0){
        dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - a[i]] + b[i]);
      }
      else{
        dp[i][j] = dp[i - 1][j];
      }
    }
  }
  printf("%d\n", dp[N - 1][P]);
  return 0;
}
