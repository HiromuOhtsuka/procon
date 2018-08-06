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
#define MAX_H 100
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

  int n, m;
  cin >> n >> m;
  string s[MAX_H];
  for(int i = 0; i < n; i++){
    cin >> s[i];
  }

  int c[26];
  fill(c, c + 26, 0);
  for(int i = 0; i < n; i++){
    for(char ch: s[i]){
      c[ch - 'a']++;
    }
  }

  int sum = 0;
  for(int i = 0; i < 26; i++){
    sum += c[i] / 4;
    c[i] -= 4 * (c[i] / 4);
  }

  int r = (n * m) - (sum * 4);

  if(r <= (m * (n % 2) + n * (m % 2))){
    int t = 0;
    for(int i = 0; i < 26; i++){
      t += c[i] % 2;
    }
    if(t == r % 2) cout << "Yes" << endl;
    else cout << "No" << endl;
  }
  else{
    cout << "No" << endl;
  }

  return 0;
}
