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

ll ceil(ll x, ll y){
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

  ll h, w, k;
  cin >> h >> w >> k;
  ll r[k], c[k];
  for(int i = 0; i < k; i++){
    cin >> r[i] >> c[i];
    --r[i]; --c[i];
  }

  ll x[w], y[h];
  fill(x, x + w, h);
  fill(y, y + h, w);
  for(int i = 0; i < k; i++){
    x[c[i]]--; y[r[i]]--;
  }

  ll s = 0;
  int xm = 0;
  for(; xm < w; xm++){
    s += x[xm];
    if(2 * s >= (w * h - k)) break;
  }
  s = 0;
  int ym = 0;
  for(; ym < h; ym++){
    s += y[ym];
    if(2 * s >= (w * h - k)) break;
  }

  ll sum = 0;
  for(int i = 0; i < w; i++){
    sum += x[i] * abs(xm - i);
  }
  for(int i = 0; i < h; i++){
    sum += y[i] * abs(ym - i);
  }

  cout << sum << endl;

  return 0;
}
