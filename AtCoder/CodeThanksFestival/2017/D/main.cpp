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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  ll n, m;
  cin >> n >> m;

  ll c = gcd(n, m);
  if(n % m == 0){
    cout << 0 << endl;
  }
  else if(c == 1){
    cout << (m - 1) << endl;
  }
  else if(m % n == 0){
    cout << (m - n) << endl;
  }
  else{
    cout << c * (m / c - 1) << endl;
  }

  return 0;
}
