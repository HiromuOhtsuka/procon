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

int parse(string& s, int p, string& ans){
  if(isdigit(s[p])){
    while(p < s.length() && 
        s[p] != ')' && s[p] != ','){
      ans.push_back(s[p]);
      ++p;
    }
    return p;
  }

  char op = s[p++];
  ans.push_back(s[p++]);  // (
  while(true){
    p = parse(s, p, ans);
    if(s[p] != ')'){
      ans.push_back(op);
    }
    else break;
    ++p;  // ,
  }
  ans.push_back(s[p++]);  // )

  return p;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  string s;
  cin >> s;

  string ans;
  parse(s, 0, ans);

  cout << ans << endl;

  return 0;
}
