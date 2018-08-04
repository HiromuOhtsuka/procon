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
  int k;
  cin >> s;
  cin >> k;

  int n = s.length();

  for(int i = 0; i < n && k > 0; i++){
    int d = ('z' - s[i] + 1) % 26;
    if(d <= k){
      s[i] = 'a';
      k -= d;
    }
  }

  s[n - 1] = 'a' + (s[n - 1] - 'a' + (k % 26)) % 26;

  cout << s << endl;

  return 0;
}
