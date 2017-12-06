#include <iostream>
#include <algorithm>
#include <string>
#include <climits>
#define INF (INT_MAX / 2)
using namespace std;

int right_shift(int bit, int n){
  int result = (bit >> 1);
  result |= (((bit & 1) != 0) ? (1 << (n - 1)) : 0);
  return result;
}

int main(){
  string s;
  cin >> s;

  int base = 0;
  for(int i = 0; i < s.length(); i++){
    if(s[i] == 'o'){
      base |= (1 << i);
    }
  }

  int n = s.length();

  int dp[1 << n];
  fill(dp, dp + (1 << n), INF);
  dp[(1 << n) - 1] = 0;
  for(int s = (1 << n) - 2; s >= 0; s--){
    int sh = base;
    for(int i = 0; i < n; i++){
      sh = right_shift(sh, n);
      dp[s] = min(dp[s], dp[s | sh] + 1);
    }
  }

  cout << dp[0] << endl;

  return 0;
}
