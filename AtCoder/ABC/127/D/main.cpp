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

  int n, m;
  cin >> n >> m;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];
  int b[m], c[m];
  for(int i = 0; i < m; i++) cin >> b[i] >> c[i];

  vector< pii > cb(m);
  for(int i = 0; i < m; i++){
    cb[i] = make_pair(c[i], b[i]);
  }
  sort(cb.begin(), cb.end());

  priority_queue< int, vector< int >, greater< int > > pq;
  for(int i = 0; i < n; i++){
    pq.push(a[i]);
  }

  for(int i = m - 1; i >= 0; i--){
    for(int j = 0; j < cb[i].second && pq.top() < cb[i].first; j++){
      pq.pop();
      pq.push(cb[i].first);
    }
  }

  ll sum = 0;
  while(!pq.empty()){
    sum += pq.top();
    pq.pop();
  }

  cout << sum << endl;

  return 0;
}
