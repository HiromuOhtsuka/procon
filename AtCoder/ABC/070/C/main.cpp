#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

long long gcd(long long a, long long b){
  if(b == 0){
    return a;
  }
  return gcd(b, a % b);
}

long long lcm(long long a, long long b){
  return a / gcd(a, b) * b;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  long long t[n];
  for(int i = 0; i < n; i++){
    cin >> t[i];
  }

  long long ans = t[0];
  for(int i = 1; i < n; i++){
    ans = lcm(ans, t[i]);
  }

  cout << ans << endl;

  return 0;
}
