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

  int n, m;
  cin >> n >> m;
  int r[m];
  for(int i = 0; i < m; i++) cin >> r[i];

  double a[n + 1];
  a[0] = a[1] = log10(1);
  for(int i = 2; i <= n; i++){
    a[i] = (log10(1) - log10(i)) + a[i - 1];
  }

  double p = (double)n * (log10(1.0) - log10(m));
  int sum = 0;
  for(int i = 0; i < m; i++){
    int x = n - sum;
    int y = r[i];
    p += (-a[x] + a[y] + a[x - y]);
    sum += r[i];
  }

  printf("%d\n", -(int)floor(p));

  return 0;
}
