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

  int n, k;
  cin >> n >> k;
  int a[k];
  for(int i = 0; i < k; i++){
    cin >> a[i];
    --a[i];
  }
  vector< string > s(n);
  for(int i = 0; i < n; i++) cin >> s[i];

  bool b[n];
  fill(b, b + n, false);
  for(int i = 0; i < k; i++){
    b[a[i]] = true;
  }

  vector< string > c, d;
  for(int i = 0; i < n; i++){
    if(b[i]) d.push_back(s[i]);
    else c.push_back(s[i]);
  }

  sort(d.begin(), d.end());

  string t = d[0];
  int m = 0;
  while(true){
    m = distance(d.begin(),
        upper_bound(d.begin() + m + 1, d.end(), t));
    if(m == k) break;
    int i = 0;
    while(i < t.length()){
      if(t[i] != d[m][i]) break;
      ++i;
    }
    if(i != t.length()){
      t = t.substr(0, i);
    }
  }

  sort(c.begin(), c.end());

  bool exist = true, first = true;
  string tt = "-1";
  while(true){
    int m = distance(c.begin(),
        lower_bound(c.begin(), c.end(), t));
    if(m < n - k){
      int i = 0;
      while(i < t.length()){
        if(t[i] != c[m][i]) break;
        ++i;
      }
      if(i == t.length()) break;
    }
    tt = t;
    if(t.empty()) break;
    t = t.substr(0, t.length() - 1);
  }

  cout << tt << endl;

  return 0;
}
