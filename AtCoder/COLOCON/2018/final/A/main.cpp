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
  string s;
  cin >> s;

  int len = s.length();

  ll sum = 0;
  ll k = 0;
  bool f = false;
  for(int i = 0; i < len; i++){
    if(s[i] == 'A') sum += ++k;
    else{
      f = true;
      k = 0;
    }
  }

  ll score;
  if(!f){
    score = n * len * (1 + n * len) / 2;
  }
  else if(s[0] == 'A' && s[0] == s[len - 1]){
    ll i = 0;
    while(i < len && s[0] == s[i]){
      ++i;
    }
    score = sum + (sum + k * i) * (n - 1);
  }
  else{
    score = sum * n;
  }

  cout << score << endl;

  return 0;
}

