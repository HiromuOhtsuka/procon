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

  int n;
  cin >> n;
  ll a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  sort(a, a + n);

  deque< ll > b;
  for(int i = 0; i < n / 2; i++){
    if(i % 2 == 0){
      b.push_front(a[i]);
      b.push_back(a[n - 1 - i]);
    }
    else{
      b.push_back(a[i]);
      b.push_front(a[n - 1 - i]);
    }
  }
  if(n % 2 == 1){
    if(abs(a[n / 2] - b.front()) > abs(a[n / 2] - b.back())){
      b.push_front(a[n / 2]);
    }
    else{
      b.push_back(a[n / 2]);
    }
  }

  ll sum = 0;
  for(int i = 0; i + 1 < n; i++){
    sum += abs(b[i] - b[i + 1]);
  }

  cout << sum << endl;

  return 0;
}
