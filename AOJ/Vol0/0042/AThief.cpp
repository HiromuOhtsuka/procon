#include <cstdio>
#define MAX_N 1000
#define MAX_W 1000
using namespace std;

static int W, N, Price[MAX_N], Cost[MAX_N];
static int dp[MAX_N][MAX_W + 1];
static int max(int a, int b);
static int min(int a, int b);
static void init_dp(int m, int n);
static int cal();
static int sum_of();

int main(){
  int count = 0;

  while(true){
    scanf("%d", &W);
    if(W == 0){
      break;
    }
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
      scanf("%d,%d", &Price[i], &Cost[i]);
    }
    ++count;
    init_dp(N, W + 1);
    int sum_p = cal();
    int sum_w = sum_of();
    printf("Case %d:\n%d\n%d\n", count, sum_p, sum_w);
  }

  return 0;
}

static int max(int a, int b){
  return a < b ? b : a;
}

static int min(int a, int b){
  return a < b ? a : b;
}

static void init_dp(int m, int n){
  for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j++){
      dp[i][j] = 0;
    }
  }
}

static int cal(){
  for(int w = 0; w <= W; w++){
    if(w >= Cost[0]){
      dp[0][w] = Price[0];
    }
  }
  for(int i = 1; i < N; i++){
    for(int w = 1; w <= W; w++){
      if(w - Cost[i] >= 0){
        dp[i][w] = max(dp[i - 1][w - Cost[i]] + Price[i], dp[i - 1][w]);
      }
      else{
        dp[i][w] = dp[i - 1][w];
      }
    }
  }

  return dp[N - 1][W];
}

static int sum_of(){
  for(int w = 0; w <= W; w++){
    if(dp[N - 1][w] == dp[N - 1][W]){
      return w;
    }
  }
  return -1;
}

