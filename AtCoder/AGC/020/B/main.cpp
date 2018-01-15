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

bool validate(int k, ll a[], ll n){
  for(int i = 0; i < k; i++){
    n -= n % a[i];
  }
  return n == 2;
}

int main(){
  int k;
  cin >> k;
  ll a[k];
  for(int i = 0; i < k; i++){
    cin >> a[i];
  }

  ll min = 2, max = 2;
  for(int i = k - 1; i >= 0; i--){
    min = a[i] * ((min + a[i] - 1) / a[i]);
    max = a[i] * (max / a[i]) + a[i] - 1;
  }

  if(validate(k, a, min) && validate(k, a, max)){
    cout << min << " " << max << endl;
  }
  else{
    cout << -1 << endl;
  }

  return 0;
}
