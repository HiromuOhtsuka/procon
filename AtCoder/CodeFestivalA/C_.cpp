#include <cstdio>
#define MAX_N 100000
using namespace std;

static int N, T;
static int A[MAX_N], B[MAX_N];
static int dp[MAX_N];

int main(){
  scanf("%d %d", &N, &T);
  int sum = 0;
  for(int i = 0; i < N; i++){
    scanf("%d %d", &A[i], &B[i]);
  }
  int count = 0;
  for(int i = 0; i < N; i++){
    if(dp[i - 1] + A[i] > T){
      count++;
      dp[i] = dp[i - 1] + 0;
    }
    else{
      dp[i] = dp[i - 1] + A[i];
    }
  }
  if(dp[N - 1] <= T){
    printf("%d\n", count);
  }
  else{
    printf("-1\n");
  }

  return 0;
}
