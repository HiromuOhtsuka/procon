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
typedef pair< ll, int > pli;

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
  int a[n], b[n];
  for(int i = 0; i < n; i++){
    cin >> a[i] >> b[i];
  }

  priority_queue< pli, vector< pli >, greater< pli > > pq;
  for(int i = 0; i < n; i++){
    pq.push(make_pair(a[i], i));
  }

  ll sum = 0;
  for(int i = 0; i < k; i++){
    pli m = pq.top(); pq.pop();
    sum += m.first;
    pq.push(make_pair(m.first + b[m.second], m.second));
  }

  cout << sum << endl;

  return 0;
}
