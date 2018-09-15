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

ll gcd(ll x, ll y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

ll sum(vector< ll >& a){
  if(a.size() == 0) return 1;
  ll result = 0;

  vector< ll > b;
  vector< ll > c;
  for(int j = 1; j < a.size(); j++){
    if(gcd(a[0], a[j]) == 1){
      b.push_back(a[j]);
    }
    c.push_back(a[j]);
  }

  result += sum(b);
  result += sum(c);

  return result;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  ll a, b;
  cin >> a >> b;

  vector< ll > v;
  for(ll i = a; i <= b; i++){
    v.push_back(i);
  }

  ll ans = sum(v);

  cout << ans << endl;

  return 0;
}
