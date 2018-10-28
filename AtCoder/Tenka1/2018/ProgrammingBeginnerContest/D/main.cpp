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

  int k = 1;
  while(k * (k - 1) / 2 < n){
    ++k;
  }

  if(k * (k - 1) / 2 != n){
    cout << "No" << endl;
    return 0;
  }

  set< int > g[MAX];
  int count = 1;
  for(int v = 0; v < k; v++){
    for(int w = v + 1; w < k; w++){
      g[v].insert(count);
      g[w].insert(count);
      ++count;
    }
  }

  string buf;
  buf += "Yes\n";
  buf += to_string(k) + "\n";
  for(int i = 0; i < k; i++){
    buf += to_string(g[i].size());
    for(int j: g[i]){
      buf += " " + to_string(j);
    }
    buf += "\n";
  }

  cout << buf;

  return 0;
}
