#include <cstdio>
#include <stack>
#include <map>
#include <algorithm>
#define MAX_H 500
#define MAX_W 500
using namespace std;

typedef pair< int, int > P;

int W, H;
char table[MAX_H][MAX_W];

int dp[MAX_H][MAX_W + 1];
int rectangular_search(){
  for(int j = 0; j < W; j++){
    if(table[0][j] != '*'){
      dp[0][j] = 1;
    }
    else{
      dp[0][j] = 0;
    }
  }
  for(int i = 1; i < H; i++){
    for(int j = 0; j < W; j++){
      if(table[i][j] == '*'){
        dp[i][j] = 0;
      }
      else{
        dp[i][j] = dp[i - 1][j] + 1;
      }
    }
  }

  int best = 0;
  for(int i = 0; i < H; i++){
    stack< P > st;

    dp[i][W] = 0;
    for(int j = 0; j <= W; j++){
      if(st.empty() || st.top().first < dp[i][j]){
        st.push(P(dp[i][j], j));
        continue;
      }
      else if(st.top().first > dp[i][j]){
        int pos = j;
        while(!st.empty() && st.top().first >= dp[i][j]){
          P p = st.top(); st.pop();
          int s = p.first * (j - p.second);
          best = max(best, s);
          pos = p.second;
        }
        st.push(P(dp[i][j], pos));
      }
    }
  }

  return best;
}

int main(){
  for(;;){
    scanf("%d %d", &H, &W);

    if(H == 0 && W == 0){
      return 0;
    }

    getchar();
    for(int i = 0; i < H; i++){
      for(int j = 0; j <= W; j++){
        int ch = getchar();
        if(ch == '\n'){
          continue;
        }
        table[i][j] = ch;
      }
    }

    int best = rectangular_search();
    printf("%d\n", best);
  }

  return 0;
}
