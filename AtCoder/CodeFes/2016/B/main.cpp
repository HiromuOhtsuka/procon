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

  int n;
  cin >> n;

  int k = 1;
  while(true){
    if(k * (k + 1) / 2 >= n) break;
    ++k;
  }

  vector< int > p;
  for(int i = 1; i <= k; i++){
    if(i == k * (k + 1) / 2 - n) continue;
    p.push_back(i);
  }

  string buf;
  for(int i: p){
    buf += to_string(i) + "\n";
  }

  cout << buf;

  return 0;
}
