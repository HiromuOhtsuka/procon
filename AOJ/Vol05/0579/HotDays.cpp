#include <iostream>
#include <cmath>
#include <algorithm>
#include <climits>
#define MAX_D 200
#define MAX_N 200
using namespace std;

int D, N, T[MAX_D], A[MAX_N], B[MAX_N], C[MAX_N];
int dp[MAX_D + 1][MAX_N];

int main(){
  cin >> D >> N;
  for(int i = 0; i < D; i++){
    cin >> T[i];
  }
  for(int i = 0; i < N; i++){
    cin >> A[i] >> B[i] >> C[i];
  }

  for(int i = 1; i < D; i++){
    for(int j = 0; j < N; j++){
      for(int k = 0; k < N; k++){
        if(A[k] <= T[i] && T[i] <= B[k] && 
            A[j] <= T[i - 1] && T[i - 1] <= B[j]){
          dp[i][k] = max(dp[i][k], dp[i - 1][j] + abs(C[j] - C[k]));
        }
      }
    }
  }

  int ans = INT_MIN;
  for(int i = 0; i < N; i++){
    ans = max(ans, dp[D - 1][i]);
  }

  cout << ans << endl;

  return 0;
}
