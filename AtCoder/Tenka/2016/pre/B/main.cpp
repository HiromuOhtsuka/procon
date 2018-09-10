#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#include <deque>
#include <stack>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

typedef long long ll;
typedef pair< int, int > pii;

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  string s;
  cin >> s;

  int n = s.length();

  int dp[n + 1][n + 1][n];
  for(int i = 0; i <= n; i++){
    for(int j = 0; j <= n; j++){
      fill(dp[i][j], dp[i][j] + n, INF_INT);
    }
  }

  dp[0][0][0] = 0;
  for(int i = 0; i < n; i++){
    for(int j = 0; j <= i; j++){
      for(int k = 0; k <= i; k++){
        if(s[i] == '('){
          dp[i + 1][j + 1][k] = 
            min(dp[i + 1][j + 1][k], dp[i][j][k]);
          if(j - 1 >= 0){
            dp[i + 1][j - 1][i] = 
              min(dp[i + 1][j - 1][i], 
                  dp[i][j][k] + (i - k) + 1);
          }
        }
        else{
          if(j - 1 >= 0){
            dp[i + 1][j - 1][k] = 
              min(dp[i + 1][j - 1][k], dp[i][j][k]);
          }
          dp[i + 1][j + 1][i] = 
            min(dp[i + 1][j + 1][i], 
                dp[i][j][k] + (i - k) + 1);
        }
      }
    }
  }

  int ans = INF_INT;
  for(int k = 0; k < n; k++){
    ans = min(ans, dp[n][0][k]);
  }

  cout << ans << endl;

  //  for(int i = 0; i <= n; i++){
  //    for(int j = 0; j <= i; j++){
  //      for(int k = 0; k <= i; k++){
  //        cout << dp[i][j][k] << endl;
  //      }
  //    }
  //  }

  return 0;
}
