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

  string s, t;
  cin >> s;
  cin >> t;

  vector< set< int > > v(26);
  for(int i = 0; i < s.length(); i++){
    v[s[i] - 'a'].insert(i);
  }

  if(v[t[0] - 'a'].empty()){
    cout << -1 << endl;
    return 0;
  }

  int i = 0, p = *(v[t[0] - 'a'].begin());
  bool found = true;
  for(int j = 1; j < t.length(); j++){
    auto it = v[t[j] - 'a'].upper_bound(p);
    if(it != v[t[j] - 'a'].end()){
      p = *it;
    } else {
      it = v[t[j] - 'a'].begin();
      if(it == v[t[j] - 'a'].end()){
        found = false;
        break;
      }
      p = *it;
      ++i;
    }
  }

  ll ans = (ll)i * s.length() + p + 1;
  if(found) cout << ans << endl;
  else cout << -1 << endl;

  return 0;
}
