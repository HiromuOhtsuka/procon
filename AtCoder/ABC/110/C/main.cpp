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

  string s, t;
  cin >> s >> t;

  vector< int > a[26], b[26];
  for(int i = 0; i < s.length(); i++){
    a[t[i] - 'a'].push_back(i);
    b[s[i] - 'a'].push_back(i);
  }

  bool ans = true;
  for(int i = 0; i < 26; i++){
    if(a[i].empty()) continue;
    if(a[i].size() != b[s[a[i][0]] - 'a'].size()){
      ans = false;
      break;
    }
    for(int j = 0; j < a[i].size(); j++){
      if(a[i][j] != b[s[a[i][0]] - 'a'][j]){
        ans = false;
      }
    }
  }

  if(ans) cout << "Yes" << endl;
  else cout << "No" << endl;

  return 0;
}
