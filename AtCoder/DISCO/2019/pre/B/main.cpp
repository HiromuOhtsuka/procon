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

double k;
bool in(double x, double y){
  return -x + k >= y && x + k >= y &&
    x - k <= y && -x - k <= y;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;

  k = n / 2.0;
  double l = n;
  double d = 1.0;
  int count = 0;
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      double x0 = i * d, y0 = j * d;
      double x1 = (i + 1) * d, y1 = j * d;
      double x2 = i * d, y2 = (j + 1) * d;
      double x3 = (i + 1) * d, y3 = (j + 1) * d;
      if(in(x0 - k, y0 - k) && in(x1 - k, y1 - k) && 
          in(x2 - k, y2 - k) && in(x3 - k, y3 - k)) ++count;
    }
  }

  cout << count << endl;

  return 0;
}
