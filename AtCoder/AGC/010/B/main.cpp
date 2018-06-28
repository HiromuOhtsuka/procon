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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  ll sum = 0;
  for(int i = 0; i < n; i++){
    sum += a[i];
  }

  if(sum % ((ll)n * (n + 1) / 2) != 0){
    cout << "NO" << endl;
    return 0;
  }

  int k = (int)(sum / ((ll)n * (n + 1) / 2));

  int d[n];
  for(int i = 0; i < n; i++){
    d[i] = a[(i + 1) % n] - a[i] - k;
  }

  bool ans = true;
  for(int i = 0; i < n; i++){
    if(d[i] > 0 || d[i] % n != 0){
      ans = false;
      break;
    }
  }

  if(ans) cout << "YES" << endl;
  else cout << "NO" << endl;

  return 0;
}
