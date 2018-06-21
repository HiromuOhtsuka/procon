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

int digit_sum(int n){
  int sum = 0;
  while(n != 0){
    sum += n % 10;
    n /= 10;
  }
  return sum;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;

  int ans = INF_INT;
  for(int a = 1; a < n; a++){
    int b = n - a;
    ans = min(ans, digit_sum(a) + digit_sum(b));
  }

  cout << ans << endl;

  return 0;
}
