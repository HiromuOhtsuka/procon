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

ll pow(ll x, int y, ll ub){
  ll r = 1;
  for(int i = 0; i < y; i++){
    r *= x;
    if(r > ub) return -1;
  }
  return r;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  ll n, p;
  cin >> n >> p;

  if(n == 1){
    cout << p << endl;
    return 0;
  }

  if(n >= 40){
    cout << 1 << endl;
    return 0;
  }

  ll ans = 1;
  for(ll i = 2; i * i <= p; i++){
    if(p % i != 0) continue;
    ll tmp = pow(i, (int)n, p);
    if(tmp < 0) break;
    if(p % tmp == 0) ans = max(ans, i);
  }

  cout << ans << endl;

  return 0;
}
