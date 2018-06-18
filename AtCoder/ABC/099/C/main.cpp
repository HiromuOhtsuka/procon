#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;

  int dp[n + 1];
  fill(dp, dp + n + 1, 0);

  for(int i = 1; i <= n; i++){
    dp[i] = dp[i - 1] + 1;
    int base = 6;
    while(i - base >= 0){
      dp[i] = min(dp[i], dp[i - base] + 1);
      base *= 6;
    }
    base = 9;
    while(i - base >= 0){
      dp[i] = min(dp[i], dp[i - base] + 1);
      base *= 9;
    }
  }

  cout << dp[n] << endl;

  return 0;
}
