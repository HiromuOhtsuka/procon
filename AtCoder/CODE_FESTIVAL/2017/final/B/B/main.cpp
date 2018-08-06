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

  string s;
  cin >> s;

  int c[3];
  fill(c, c + 3, 0);
  for(char ch: s){
    c[ch - 'a']++;
  }

  int d = max(abs(c[0] - c[1]), 
      max(abs(c[0] - c[2]), abs(c[1] - c[2])));
  if(d <= 1) cout << "YES" << endl;
  else cout << "NO" << endl;

  return 0;
}
