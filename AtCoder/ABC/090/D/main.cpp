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

int validate(int n, int b, int k){
  int count = 0;
  for(int a = 1; a <= n; a++){
    if(a % b >= k){
      ++count;
    }
  }
  return count;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, k;
  cin >> n >> k;

  ll sum = 0;
  for(int b = max(k, 1); b <= n; b++){
    ll d = (b - k) * (n / b);
    if(n % b >= k) d += (n - (b * (n / b)) - k + 1);
    sum += d;
  }

  if(k == 0) sum -= n;

  cout << sum << endl;

  return 0;
}
