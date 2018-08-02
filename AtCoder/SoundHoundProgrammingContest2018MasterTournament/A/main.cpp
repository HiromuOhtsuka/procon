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

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

ll min(ll a, ll b){
  return (a < b) ? a : b;
}

ll max(ll a, ll b){
  return (a < b) ? b : a;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  ll c, d;
  cin >> c >> d;

  ll sum = 0;
  for(ll c1 = 140, d1 = 170;
      c1 < d; c1 <<= 1, d1 <<= 1){
    if(d1 < c) continue;
    sum += min(d, d1) - max(c, c1);
  }

  cout << sum << endl;

  return 0;
}
