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
  int a[n][n - 1];
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n - 1; j++){
      cin >> a[i][j];
    }
  }

  vector< queue< int > > b(n);
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n - 1; j++){
      b[i].push(a[i][j]);
    }
  }

  bool ok = true;
  int i = 0, count = 0;
  set< int > d;
  for(int i = 0; i < n; i++) d.insert(i);
  while(count < n * (n - 1) / 2){
    bool found = false;
    set< int > c;
    int j = 0;
    for(int j: d){
      if(c.find(j) != c.end() || b[j].empty()){
        ++j;
        continue;
      }
      int k = b[j].front() - 1;
      if(c.find(k) != c.end() || b[k].empty()){
        ++j;
        continue;
      }
      if(b[k].front() == j + 1){
        b[j].pop(); b[k].pop();
        found = true;
        c.insert(j);  c.insert(k);
        ++count;
      }
      j++;
    }
    if(!found){
      ok = false;
      break;
    }
    d = c;
    ++i;
  }

  if(ok) cout << i << endl;
  else cout << -1 << endl;

  return 0;
}
