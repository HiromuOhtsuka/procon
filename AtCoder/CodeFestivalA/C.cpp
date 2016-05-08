#include <cstdio>
#include <algorithm>
#define MAX_N 100000
#define MAX_T 1000000001
using namespace std;

static int N, T;
static int A[MAX_N], B[MAX_N + 1];
static int dp[2][MAX_N];

int main(){
  scanf("%d %d", &N, &T);
  for(int i = 0; i < N; i++){
    scanf("%d %d", &A[i], &B[i]);
  }
  for(int j = 0; j <= N; j++){
    dp[1][j] = MAX_T;
  }
  for(int i = 0; i < N; i++){
    for(int j = 1; j <= N; j++){
      dp[i % 2][j] = min(dp[(i + 1) % 2][j] + A[i], dp[(i + 1) % 2][j - 1] + B[i]);
    }
  }
  if(N % 2){
    for(int i = 0; i <= N; i++){
      if(dp[1][i] <= T){
        printf("%d\n", i);
        return 0;
      }
    }
  }
  else{
    for(int i = 0; i <= N; i++){
      if(dp[0][i] <= T){
        printf("%d\n", i);
        return 0;
      }
    }
  }
  printf("-1\n");

  return 0;
}
