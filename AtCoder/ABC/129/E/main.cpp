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

  string s;
  cin >> s;

  int n = s.length();

  ll dp[n + 1];
  dp[0] = 1;
  dp[1] = 3;
  for(int i = 2; i <= n; i++){
    dp[i] = (3 * dp[i - 1]) % MOD;
  }

  ll sum = 1;
  for(int i = n - 1; i >= 0; i--){
    if(s[i] == '1') sum = (dp[n - i - 1] + 2 * sum) % MOD;
  }

  cout << sum << endl;

  return 0;
}
