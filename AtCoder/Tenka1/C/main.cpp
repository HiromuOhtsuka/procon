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

  ll m;
  cin >> m;

  for(ll n = 1; n <= 3500; n++){
    for(ll h = 1; h <= 3500; h++){
      if(4 * h * n - m * n - m * h <= 0) continue;
      if((m * h * n) % (4 * h * n - m * n - m * h) != 0)
        continue;
      ll w = (m * h * n) / (4 * h * n - m * n - m * h);
      if(w < 0 || w > 3500) continue;
      cout << to_string(n) + " " + to_string(h) + " "
        + to_string(w) << endl;
        return 0;
    }
  }

  return 0;
}
