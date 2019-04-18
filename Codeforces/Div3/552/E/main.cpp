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
#include <tuple>
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
typedef tuple< int, int, int > piii;

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
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  vector< piii > b(n);
  priority_queue< pii > pq;
  for(int i = 0; i < n; i++){
    b[i] = make_tuple(a[i], i - 1, i + 1);
    pq.push(make_pair(a[i], i));
  }

  int ans[n];
  bool exist[n];
  int now = 1;
  fill(ans, ans + n, 0);
  fill(exist, exist + n, true);
  while(!pq.empty()){
    pii p = pq.top(); pq.pop();
    int cur = p.second;
    if(!exist[cur]) continue;
    ans[cur] = now;
    exist[cur] = false;
    int s = cur, t = cur;
    for(int i = 0; i < k; i++){
      if(get< 1 >(b[s]) >= 0){
        s = get< 1 >(b[s]);
        ans[s] = now;
        exist[s] = false;
      }
      if(get< 2 >(b[t]) < n){
        t = get< 2 >(b[t]);
        ans[t] = now;
        exist[t] = false;
      }
    }
    s = get< 1 >(b[s]);
    t = get< 2 >(b[t]);
    if(s >= 0 && t < n){
      b[s] = make_tuple(get< 0 >(b[s]), get< 1 >(b[s]), t);
      b[t] = make_tuple(get< 0 >(b[t]), s, get< 2 >(b[t]));
    }
    else if(s < 0 && t < n){
      b[t] = make_tuple(get< 0 >(b[t]), -1, get< 2 >(b[t]));
    }
    else if(t == n && s >= 0){
      b[s] = make_tuple(get< 0 >(b[s]), get< 1 >(b[s]), n);
    }
    now = (now == 1) ? 2 : 1;
  }

  string buf;
  for(int i = 0; i < n; i++){
    buf += to_string(ans[i]);
  }

  cout << buf << endl;

  return 0;
}
