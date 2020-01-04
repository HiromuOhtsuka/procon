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

ll gcd(ll x, ll y){
  return y ? gcd(y, x % y) : x;
}

void swap(ll *a, ll *b){
  ll tmp = *a;
  *a = *b;
  *b = tmp;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  ll a, b;
  cin >> a >> b;

  if(a > b) swap(&a, &b);

  vector< ll > c;
  for(ll i = 1; i * i <= a; i++){
    if(a % i != 0) continue;
    ll j = a / i;
    if(b % i == 0) c.push_back(i);
    if(i != j && b % j == 0) c.push_back(j);
  }

  sort(c.begin(), c.end());

  // debug
  //for(ll i: c) cout << i << endl;

  int i = 1;
  while(i < c.size()){
    vector< int > r;
    for(int j = i + 1; j < c.size(); j++){
      if(c[j] % c[i] == 0) r.push_back(j);
    }
    int k = 0;
    for(int j: r){
      c.erase(c.begin() + j - k);
      ++k;
    }
    ++i;
  }

  cout << c.size() << endl;

  return 0;
}
