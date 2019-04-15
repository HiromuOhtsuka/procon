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

  string a;
  cin >> a;

  int n = a.length();

  int count = 0;
  int d[n + 1];
  d[n] = 1;
  int s = 0;
  for(int i = n - 1; i >= 0; i--){
    s |= 1 << (a[i] - 'a');
    if(s == ((1 << 26) - 1)){
      ++count;
      s = 0;
    }
    d[i] = count + 1;
  }

  vector< vector< int > > p(26);
  for(int i = 0; i < n; i++){
    p[a[i] - 'a'].push_back(i);
  }
  for(int i = 0; i < 26; i++){
    sort(p[i].begin(), p[i].end());
  }

  string ans;
  int t = 0;
  while(count >= 0){
    if(count == 0){
      for(char c = 'a'; c <= 'z'; c++){
        auto i = lower_bound(
            p[c - 'a'].begin(), p[c - 'a'].end(), t);
        if(i == p[c - 'a'].end()){
          ans.push_back(c);
          break;
        }
      }
      break;
    }
    for(char c = 'a'; c <= 'z'; c++){
      auto i = lower_bound(
          p[c - 'a'].begin(), p[c - 'a'].end(), t);
      if(i == p[c - 'a'].end()) continue;
      if(d[t] - 1 == d[*i + 1]){
        ans.push_back(c);
        t = *i + 1;
        --count;
        break;
      }
    }
  }

  cout << ans << endl;

  return 0;
}
