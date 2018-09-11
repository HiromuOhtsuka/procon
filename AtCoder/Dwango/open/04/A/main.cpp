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

  int h, m, s;
  cin >> h >> m >> s;
  int c1, c2;
  cin >> c1 >> c2;

  h = h % 12;
  ll pi2 = 360 * 120;

  ll ds = pi2 / 60.0;
  ll dm = pi2 / (60 * 60);
  ll dh = pi2 / (12 * 60 * 60);

  ll t = 3600 * h + 60 * m + s;
  ll count = 0;
  ll t1 = INF_INT, t2 = -1;
  while(true){
    ll ss = (t % 60) * ds;
    ll mm = (t % 3600) * dm;
    ll hh = t * dh;
    //    cout << hh << ":" << mm << ":" << ss << endl;
    //    cout << c1 << ":" << c2 << endl;
    //    cout << t << endl;
    ++t;
    ++count;
    ll sss = ss + ds;
    ll mmm = mm + dm;
    ll hhh = hh + dh;
    if(ss <= mm && sss > mmm) --c1;
    if(mm <= hh && mmm > hhh) --c2;
    if(c1 < 0 || c2 < 0) break;
    if(c1 == 0 && c2 == 0 && 
        sss % pi2 != mmm % pi2 &&
        mmm % pi2 != hhh % pi2){
      t1 = min(t1, count);
      t2 = max(t2, count);
    }
    t %= (12 * 60 * 60);
  }

  if(t1 != INF_INT) cout << t1 << " " << t2 << endl;
  else cout << -1 << endl;

  return 0;
}
