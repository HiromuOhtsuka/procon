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
#define MAX_T 300
using namespace std;

const int MAX = 601;
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

int t, a[MAX_T + 1];
ll dp[MAX_T + 1][MAX];

ll solve(int i, int j){
  if(i < 0 || j >= MAX) return 0;
  if(dp[i][j] != -1) return dp[i][j];
  ll sum = 0;
  for(int k = 0; k <= min(a[i], j); k++){
    sum = (sum + solve(i - 1, (j - k) * 2)) % MOD;
  }
  return dp[i][j] = sum;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  for(int i = 0; i <= MAX_T; i++){
    fill(dp[i], dp[i] + MAX, -1);
  }

  cin >> t;
  for(int i = 1; i <= t; i++) cin >> a[i];

  for(int i = 0; i < MAX; i++){
    //if(i > 0 && i <= a[1]) dp[1][i] = 1;
    if(i <= a[1]) dp[1][i] = 1;
    else dp[1][i] = 0;
  }

  ll sum = 0;
  for(int j = 0; j <= 16; j++){
    sum = (sum + solve(t, 1 << j)) % MOD;
  }
  for(int i = 1; i < t; i++){
    sum = (sum + solve(i, 1)) % MOD;
  }

  cout << sum << endl;

  return 0;
}
