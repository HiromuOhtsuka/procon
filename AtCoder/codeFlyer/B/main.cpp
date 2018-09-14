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

  int a, b, n;
  cin >> a >> b >> n;
  string x;
  cin >> x;

  for(int i = 0; i < n; i++){
    switch(x[i]){
      case 'S':
        if(a > 0) --a;
        break;
      case 'C':
        if(b > 0) --b;
        break;
      case 'E':
        if(a == 0 && b == 0) break;
        else if(a >= b) --a;
        else --b;
        break;
    }
  }

  cout << a << endl;
  cout << b << endl;

  return 0;
}
