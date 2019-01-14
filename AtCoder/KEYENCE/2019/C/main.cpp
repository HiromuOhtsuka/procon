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

  int n;
  cin >> n;
  ll a[n], b[n];
  for(int i = 0; i < n; i++) cin >> a[i];
  for(int i = 0; i < n; i++) cin >> b[i];

  ll sum_a = 0, sum_b = 0;
  for(int i = 0; i < n; i++){
    sum_a += a[i];
    sum_b += b[i];
  }

  if(sum_b > sum_a){
    cout << -1 << endl;
    return 0;
  }

  ll c[n];
  for(int i = 0; i < n; i++){
    c[i] = a[i] - b[i];
  }
  sort(c, c + n);

  int count = 0;
  ll d = 0;
  int i = 0;
  while(i < n && c[i] < 0){
    d += c[i];
    ++count;
    ++i;
  }

  i = n - 1;
  while(i >= 0 && c[i] >= 0 && d < 0){
    d += c[i];
    ++count;
    --i;
  }

  cout << count << endl;

  return 0;
}
