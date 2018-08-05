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

  int k, t;
  cin >> k >> t;
  int a[t];
  for(int i = 0; i < t; i++) cin >> a[i];

  int count = 0;
  int b = -1;
  for(int i = 0; i < k; i++){
    int m = -1;
    for(int j = 0; j < t; j++){
      if(j == b || a[j] <= 0) continue;
      if(m == -1 || a[m] <= a[j]) m = j;
    }
    if(m == -1){
      m = b;
      ++count;
    }
    a[m]--;
    b = m;
  }

  cout << count << endl;

  return 0;
}
