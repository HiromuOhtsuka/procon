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
  ll x[n];
  for(int i = 0; i < n; i++) cin >> x[i];

  ll ans = INF_LONG;
  for(int s = 0; s + k - 1 < n; s++){
    int t = s + k - 1;
    ll tmp;
    if(x[t] <= 0) tmp = -x[s];
    else if(x[s] >= 0) tmp = x[t];
    else tmp = 2l * min(-x[s], x[t]) + max(-x[s], x[t]);
    ans = min(ans, tmp);
  }

  cout << ans << endl;

  return 0;
}
