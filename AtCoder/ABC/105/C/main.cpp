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

  ll n;
  cin >> n;

  if(n == 0){
    cout << '0' << endl;
    return 0;
  }

  string ans;
  int k1 = -1;
  do{
    int k;
    ll sum = 0, d;
    if(n >= 0){
      d = 1; k = 0;
      while(true){
        sum += d;
        if(sum >= n) break;
        d *= 4l;
        k += 2;
      }
    }
    else{
      d = -2; k = 1;
      while(true){
        sum += d;
        if(sum <= n) break;
        d *= 4l;
        k += 2;
      }
    }

    for(int i = k + 1; i < k1; i++){
      ans.push_back('0');
    }
    ans.push_back('1');
    k1 = k;

    n -= d;
  }while(n != 0);

  if(k1 != 0){
    for(int i = 0; i < k1; i++){
      ans.push_back('0');
    }
  }

  cout << ans << endl;

  return 0;
}
