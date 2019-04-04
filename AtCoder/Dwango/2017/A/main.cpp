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

const int MAX = 100001;
const int MOD = 1000000007;

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

  int k;
  cin >> k;
  string s;
  cin >> s;

  int n = s.length();

  ll dp1[n][n + 1][k + 1], dp2[n][n + 1][k + 1];
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n + 1; j++){
      fill(dp1[i][j], dp1[i][j] + k + 1, -INF_INT);
      fill(dp2[i][j], dp2[i][j]+ k + 1, INF_INT);
    }
  }

  for(int i = 0; i < n; i++){
    if(s[i] != '+' && s[i] != '-'){
      dp1[i][i + 1][0] = s[i] - '0';
      dp2[i][i + 1][0] = s[i] - '0';
    }
    dp1[i][i + 1][1] = 9;
    dp2[i][i + 1][1] = 0;
  }

  for(int d = 3; d <= n; d += 2){
    for(int i = 0; i + d <= n; i++){
      int j = i + d;
      for(int l = 0; l <= k; l++){
        if(s[j - 1] == '+'){
          for(int m = i + 1; m < j; m++){
            for(int o = 0; o <= l; o++){
              dp1[i][j][l] = max(dp1[i][j][l], 
                  dp1[i][m][o] + dp1[m][j - 1][l - o]);
              dp2[i][j][l] = min(dp2[i][j][l], 
                  dp2[i][m][o] + dp2[m][j - 1][l - o]);
              if(l - 1 - o >= 0){
                dp1[i][j][l] = max(dp1[i][j][l], 
                    dp1[i][m][o] - dp2[m][j - 1][l - 1 - o]);
                dp2[i][j][l] = min(dp2[i][j][l], 
                    dp2[i][m][o] - dp1[m][j - 1][l - 1 - o]);
              }
            }
          }
        }
        else if(s[j - 1] == '-'){
          for(int m = i + 1; m < j; m++){
            for(int o = 0; o <= l; o++){
              dp1[i][j][l] = max(dp1[i][j][l], 
                  dp1[i][m][o] - dp2[m][j - 1][l - o]);
              dp2[i][j][l] = min(dp2[i][j][l], 
                  dp2[i][m][o] - dp1[m][j - 1][l - o]);
              if(l - 1 - o >= 0){
                dp1[i][j][l] = max(dp1[i][j][l], 
                    dp1[i][m][o] + dp1[m][j - 1][l - 1 - o]);
                dp2[i][j][l] = min(dp2[i][j][l], 
                    dp2[i][m][o] + dp2[m][j - 1][l - 1 - o]);
              }
            }
          }
        }
        else{
          for(int m = i + 1; m < j; m++){
            for(int o = 0; o <= l - 1; o++){
              dp1[i][j][l] = max(dp1[i][j][l], 
                  dp1[i][m][o] + dp1[m][j - 1][l - 1 - o]);
              dp2[i][j][l] = min(dp2[i][j][l], 
                  dp2[i][m][o] + dp2[m][j - 1][l - 1 - o]);
              dp1[i][j][l] = max(dp1[i][j][l], 
                  dp1[i][m][o] - dp2[m][j - 1][l - 1 - o]);
              dp2[i][j][l] = min(dp2[i][j][l], 
                  dp2[i][m][o] - dp1[m][j - 1][l - 1 - o]);
            }
          }
        }
      }
    }
  }

  if(n % 2 == 0) cout << "NG" << endl;
  else{
    ll ans = dp1[0][n][k];
    for(int i = 0; i < k; i++){
      ans = max(ans, dp1[0][n][i]);
    }
    if(ans <= -10000) cout << "NG" << endl;
    else{
      cout << "OK" << endl;
      cout << ans << endl;
    }
  }

  return 0;
}
