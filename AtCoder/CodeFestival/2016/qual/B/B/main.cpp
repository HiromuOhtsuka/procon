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

  int n, a, b;
  cin >> n >> a >> b;
  string s;
  cin >> s;

  bool passed[n];
  fill(passed, passed + n, false);
  int j = 0, k = 0;
  for(int i = 0; i < n; i++){
    switch(s[i]){
      case 'a':
        if(j < a + b){
          passed[i] = true;
          ++j;
        }
        break;
      case 'b':
        if(j < a + b && k < b){
          passed[i] = true;
          ++j;
          ++k;
        }
        break;
    }
  }

  string buf;
  for(int i = 0; i < n; i++){
    if(passed[i]) buf += "Yes\n";
    else buf += "No\n";
  }

  cout << buf;

  return 0;
}
