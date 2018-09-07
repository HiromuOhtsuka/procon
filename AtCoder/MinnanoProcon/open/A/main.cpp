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
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

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

  int dp[n + 1][5];
  for(int i = 0; i <= n; i++){
    fill(dp[i], dp[i] + 5, INF_INT);
  }
  char t[5] = {'y', 'a', 'h', 'o', 'o'};
  dp[0][4] = 0;
  dp[0][0] = 1;
  dp[0][1] = 2;
  dp[0][2] = 3;
  dp[0][3] = 4;
  for(int i = 1; i <= n; i++){
    for(int j = 0; j < 5; j++){
      if(s[i - 1] == t[j]){
        if(j == 0){
          dp[i][j] = i - 1;
        }
        dp[i][j] = min(dp[i][j],
            dp[i - 1][(j - 1 + 5) % 5]);
        for(int k = 0; k < 5; k++){
          dp[i][j] = min(dp[i][j],
              dp[i - 1][k] +
              ((k < j) ? (j - k) : (5 - (k - j))) - 1);
        }
      }
      else{
        if(j == 0) dp[i][j] = i;
        dp[i][j] = min(dp[i][j], dp[i - 1][j] + 1);
        dp[i][j] = min(dp[i][j],
            dp[i - 1][(j - 1 + 5) % 5] + 1);
        for(int k = 0; k < 5; k++){
          dp[i][j] = min(dp[i][j],
              dp[i - 1][k] +
              ((k < j) ? (j - k) : (5 - (k - j))));
          int tmp = k;
          bool found = false;
          while(tmp != j){
            tmp = (tmp + 1) % 5;
            if(s[i - 1] == t[tmp]){
              found = true;
              break;
            }
          }
          if(found){
            dp[i][j] = min(dp[i][j],
                dp[i - 1][k] +
                ((k < j) ? (j - k) : (5 - (k - j))) - 1);
          }
        }
      }
    }
  }

  int ans = n;
  for(int i = 0; i < 5; i++){
    ans = min(ans, dp[n][i] + (5 - i - 1));
  }

  cout << ans << endl;

  return 0;
}
