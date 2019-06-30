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

ll gcd(ll x, ll y){
  return y ? gcd(y, x % y) : x;
}

ll lcm(ll x, ll y){
  return x / gcd(x, y) * y;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  ll a, b, c, d;
  cin >> a >> b >> c >> d;

  ll l = lcm(c, d);
  ll r = (b / c) - ((a - 1) / c) + (b / d) - ((a - 1) / d) - ((b / l) - ((a - 1) / l));
  ll ans = (b - a + 1) - r;

  cout << ans << endl;

  return 0;
}
