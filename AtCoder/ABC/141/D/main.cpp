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

  ll sum = 0;
  priority_queue< int > pq;
  for(int i = 0; i < n; i++){
    sum += a[i];
    pq.push(a[i]);
  }

  for(int i = 0; i < m; i++){
    int v = pq.top();
    pq.pop();
    sum -= v - (v / 2);
    pq.push(v / 2);
  }

  cout << sum << endl;

  return 0;
}
