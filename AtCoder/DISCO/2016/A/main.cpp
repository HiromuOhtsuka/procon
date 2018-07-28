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

double dist(double x0, double y0, double x, double y){
  return sqrt(pow(x - x0, 2) + pow(y - y0, 2));
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int r, c;
  cin >> r >> c;

  int count = 0;
  for(int i = 0; (i + 1) * c <= r; i++){
    for(int j = 0; (j + 1) * c <= r; j++){
      int x[4], y[4];
      x[0] = i * c; y[0] = j * c;
      x[1] = (i + 1) * c; y[1] = j * c;
      x[2] = (i + 1) * c; y[2] = (j + 1) * c;
      x[3] = i * c; y[3] = (j + 1) * c;
      bool in = true;
      for(int k = 0; k < 4; k++){
        if(dist(0, 0, x[k], y[k]) > r){
          in = false;
          break;
        }
      }
      if(in) ++count;
    }
  }

  cout << (4 * count) << endl;

  return 0;
}
