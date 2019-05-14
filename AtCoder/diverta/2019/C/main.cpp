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
  vector< string > s(n);
  for(int i = 0; i < n; i++) cin >> s[i];

  int ca = 0, cb = 0, cba = 0;
  for(int i = 0; i < n; i++){
    char s0 = s[i][0];
    char sl = s[i][s[i].length() - 1];
    if(s0 == 'B' && sl != 'A') ++cb;
    else if(s0 != 'B' && sl == 'A') ++ca;
    else if(s0 == 'B' && sl == 'A') ++cba;
  }

  int count = 0;
  for(int i = 0; i < n; i++){
    for(int j = 0; j + 1 < s[i].length(); j++){
      if(s[i][j] == 'A' && s[i][j + 1] == 'B') ++count;
    }
  }

  if(cba > 0) count += cba - 1;
  if(cba > 0 && (ca > 0 || cb > 0)) ++count;
  count += min(ca, cb);

  cout << count << endl;

  return 0;
}
