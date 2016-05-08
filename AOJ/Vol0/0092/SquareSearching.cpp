#include <cstdio>
#include <algorithm>
#define MAX_N 1000
using namespace std;

static int N;
static char table[MAX_N][MAX_N];
static int dp[MAX_N][MAX_N];

int main(){
  for(;;){
    scanf("%d", &N);
    if(N == 0){
      return 0;
    }
    getchar();
    for(int i = 0; i < N; i++){
      for(int j = 0; j <= N; j++){
        int ch = getchar();
        if(ch == '\n'){
          continue;
        }
        table[i][j] = (char)ch;
      }
    }

    for(int j = 0; j < N; j++){
      if(table[0][j] != '*'){
        dp[0][j] = 1;
      }
      else{
        dp[0][j] = 0;
      }

      if(table[j][0] != '*'){
        dp[j][0] = 1;
      }
      else{
        dp[j][0] = 0;
      }
    }

    int max_width = 0;
    for(int i = 1; i < N; i++){
      for(int j = 1; j < N; j++){
        if(table[i][j] != '*'){
          dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1;
          max_width = max(max_width, dp[i][j]);
        }
        else{
          dp[i][j] = 0;
        }
      }
    }

    printf("%d\n", max_width);
  }


  return 0;
}
