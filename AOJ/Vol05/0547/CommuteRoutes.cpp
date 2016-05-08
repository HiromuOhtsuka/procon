#include <cstdio>
#define MAX_W 100
#define MAX_H 100
using namespace std;

int W, H;
int dp[MAX_H][MAX_W];

int main(){
  for(int i = 0; i < MAX_H; i++){
    dp[i][0] = 1;
  }
  for(int j = 0; j < MAX_W; j++){
    dp[0][j] = 1;
  }
  for(int i = 1; i < MAX_H; i++){
    for(int j = 1; j < MAX_W; j++){
      if(i - 2 >= 0 && j - 2 >= 0){
        dp[i][j] = (dp[i - 2][j] + dp[i - 2][j - 1] + dp[i][j - 2] + dp[i - 1][j - 2]) % 100000;
      }
      else if(i - 2 < 0){
        dp[i][j] = (dp[i][j - 2] + dp[i - 1][j - 2]) % 100000;
      }
      else if(j - 2 < 0){
        dp[i][j] = (dp[i - 2][j] + dp[i - 2][j - 1]) % 100000;
      } 
    }
  }

  for(;;){
    scanf("%d %d", &W, &H);

    if(W == 0 && H == 0){
      return 0;
    }

    printf("%d\n", dp[H - 1][W - 1]);
  }

  return 0;
}
