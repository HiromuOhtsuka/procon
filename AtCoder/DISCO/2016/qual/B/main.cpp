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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  double r;
  int n, m;
  cin >> r >> n >> m;

  double sum = 0;
  double d = (2 * r) / n;
  for(int i = 0; i < n + m; i++){
    double xi = abs(r - i * d);
    double xm = abs(r - (i - m) * d);
    double yi = (i < n) ? 2.0 * sqrt(r * r - xi * xi) : 0;
    double ym = (i - m >= 0) ? 2.0 * sqrt(r * r - xm * xm) : 0;
    sum += max(yi, ym);
  }

  printf("%.7lf\n", sum);

  return 0;
}
