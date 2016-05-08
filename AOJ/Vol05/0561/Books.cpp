#include <iostream>
#define MAX_N 2000
#define MAX_K (MAX_N - 1)
#define MAX_G 10
using namespace std;

int N, K, c[MAX_N], g[MAX_N];
int dp[MAX_N][MAX_K + 1], m[MAX_N][MAX_K + 1][MAX_G];

int main(){
  cin >> N >> K;
  for(int i = 0; i < N; i++){
    cin >> c[i] >> g[i];
    g[i]--;
  }

  dp[0][1] = c[0];
  m[0][1][g[0]] = 1;

  for(int i = 1; i < N; i++){
    for(int j = 1; (i + 1) >= j && j <= K; j++){
      int t = m[i - 1][j - 1][g[i]];
      int val = dp[i - 1][j - 1] + c[i] - 
      cout << "i:" << i << ", j:" << j << ", val:" << val;
      cout << ", val(i-1):" << dp[i - 1][j] << endl;
      if(val > dp[i - 1][j]){
        dp[i][j] = val;
        for(int k = 0; k < MAX_G; k++){
          m[i][j][k] = m[i - 1][j - 1][k];
        }
        m[i][j][g[i]] = t + 1;
      }
      else{
        dp[i][j] = dp[i - 1][j];
        for(int k = 0; k < MAX_G; k++){
          m[i][j][k] = m[i - 1][j][k];
        }
      }
    }
  }

  for(int j = 0; j < MAX_G; j++){
    cout << "g[" << j << "]:" << m[N - 1][K][j] << endl;
  }

  cout << dp[N - 1][K] << endl;

  return 0;
}
