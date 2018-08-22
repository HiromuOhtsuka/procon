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

  int n, l, r;
  cin >> n >> l >> r;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  int b[n];
  for(int i = 0; i < n; i++){
    if(a[i] <= l) b[i] = l;
    else if(a[i] >= r) b[i] = r;
    else b[i] = a[i];
  }

  string buf;
  for(int i = 0; i < n; i++){
    buf += to_string(b[i]);
    if(i != n - 1) buf += " ";
  }

  cout << buf << endl;

  return 0;
}
