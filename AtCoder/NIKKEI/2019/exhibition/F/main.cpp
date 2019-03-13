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

ll a[1001];

int f(ll x){
  ll result = 0;
  if(x >= 1e16 || x <= 1) result = 0;
  else if(x % 2 == 0) result = f(x / 2) + 1;
  else result = f(3l * x + 1) + 1;
  a[result] = x;
  return result;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int p;
  cin >> p;

  f(1789997546303l);

  cout << a[p] << endl;

  return 0;
}
