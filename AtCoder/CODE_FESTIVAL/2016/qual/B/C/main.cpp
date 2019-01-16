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

  ll w, h;
  cin >> w >> h;
  ll p[w], q[h];
  for(int i = 0; i < w; i++) cin >> p[i];
  for(int i = 0; i < h; i++) cin >> q[i];

  pll r[2 * MAX];
  for(int i = 0; i < w; i++){
    r[i] = make_pair(p[i], true);
  }
  for(int i = 0; i < h; i++){
    r[i + w] = make_pair(q[i], false);
  }
  sort(r, r + w + h);

  ll x = 0, y = 0;
  ll sum = 0;
  for(int i = 0; i < w + h; i++){
    if(r[i].second){
      sum += (h + 1 - y) * r[i].first;
      ++x;
    }
    else{
      sum += (w + 1 - x) * r[i].first;
      ++y;
    }
  }

  cout << sum << endl;

  return 0;
}
