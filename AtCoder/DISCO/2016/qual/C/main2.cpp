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
#define MAX_N 200000
using namespace std;

typedef long long ll;
typedef pair< int, int > pii;

int n, k;
int a[MAX_N];

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

bool is_prime(int i){
  for(int j = 2; j * j <= i; j++){
    if(i % j == 0) return false;
  }
  return true;
}

int pow(int x, int y){
  int result = 1;
  for(int i = 0; i < y; i++){
    result *= x;
  }
  return result;
}

void backtrack(vector< int >& ps, int i, int t,
    map< int, int >& c, map< int, int >& count){
  if(i == ps.size()){
    for(int j = 0; j < n; j++){
      if(a[j] % t == 0) count[t]++;
    }
    return;
  }
  for(int j = 0; j <= c[ps[i]]; j++){
    backtrack(
        ps, i + 1, t * pow(ps[i], j), c, count);
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> k;
  for(int i = 0; i < n; i++) cin >> a[i];

  if(k == 1){
    cout << ((ll)n * (n - 1) / 2) << endl;
    return 0;
  }

  set< int > intersects;
  map< int, int > count;
  for(int i = 0; i < n; i++){
    int m = gcd(k, a[i]);
    intersects.insert(m);
    count[m]++;
  }

  ll sum = 0;
  for(int i: intersects){
    for(int j: intersects){
      if(((ll)i * j) % k == 0){
        sum += count[i] * count[j];
        if(i == j) sum -= count[i];
      }
    }
  }
  sum /= 2;

  cout << sum << endl;

  return 0;
}
