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

  int n, k;
  cin >> n >> k;
  int b[n];
  for(int i = 0; i < n; i++) cin >> b[i];

  ll dp1[n + 1], dp2[n + 1];

  dp1[n] = dp2[n] = 0;
  for(int i = n - 1; i >= 0; i--){
    dp2[i] = max(dp2[i + 1], b[i] + dp1[i + 1]);
    if(i + k <= n)
      dp1[i] = max(dp2[i + k], b[i] + dp1[i + 1]);
    else
      dp1[i] = b[i] + dp1[i + 1];
  }

  cout << dp1[0] << endl;

  return 0;
}
