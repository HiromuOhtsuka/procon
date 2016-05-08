#include <cstdio>
#define MAX_NUM 100
#define MAX_N 9
#define MAX_S 1000
using namespace std;

int N, S;
int dp[MAX_NUM + 1][MAX_N + 1][MAX_S + 1];

int main(){
  for(int i = 0; i <= MAX_NUM; i++){
    for(int j = 0; j <= 1; j++){
      dp[i][j][0] = 1;
    }
  }
  for(int i = 1; i <= MAX_NUM; i++){
    for(int j = 1; j <= MAX_N && j <= i; j++){
      for(int k = 0; k <= MAX_S; k++){
        if(k - i >= 0){
          dp[i][j][k] = dp[i - 1][j - 1][k - i] + dp[i - 1][j][k];
        }
        else{
          dp[i][j][k] = dp[i - 1][j][k];
        }
      }
    }
  }

  for(int i = 1; i <= 6; i++){
    for(int j = 1; j <= 3; j++){
      for(int k = 0; k <= 6; k++){
        printf("i:%d,j:%d,k:%d : %d\n", i, j, k, dp[i][j][k]);
      }
    }
  }

  for(;;){
    scanf("%d %d", &N, &S);
    if(N == 0 && S == 0){
      return 0;
    }
    printf("%d\n", dp[MAX_NUM][N][S]);
  }

  return 0;
}

