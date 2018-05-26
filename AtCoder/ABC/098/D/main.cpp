#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

typedef long long ll;

bool check(int f, int v){
  for(int i = 0; i < 32; i++){
    if((f & (1 << i)) != 0 &&
      (v & (1 << i)) != 0){
      return false;
    }
  }
  return true;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n];
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }

  ll sum = 0;
  int s = 0, t = 0, f = 0;
  while(s < n){
    while(t < n && check(f, a[t])){
      f |= a[t];
      ++t;
    }
    sum += (ll)(t - s);
    f ^= a[s++];
  }

  cout << sum << endl;

  return 0;
}
