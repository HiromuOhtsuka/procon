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

const int MAX = 100001;
const int MOD = 1000000007;

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

  int a[5];
  for(int i = 0; i < 5; i++){
    cin >> a[i];
  }
  int k;
  cin >> k;

  bool found = false;
  for(int i = 0; i < 5; i++){
    for(int j = i + 1; j < 5; j++){
      if(abs(a[i]- a[j]) > k){
        found = true;
        break;
      }
    }
  }

  if(found) cout << ":(" << endl;
  else cout << "Yay!" << endl;

  return 0;
}
