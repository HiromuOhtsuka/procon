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

bool palindrome(string& s){
  for(int i = 0; i < s.length() / 2; i++){
    if(s[i] != s[s.length() - i - 1]){
      return false;
    }
  }
  return true;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  string s;
  cin >> s;

  if(palindrome(s)){
    cout << 0 << endl;
    return 0;
  }

  string t;
  for(int i = 0; i < s.length(); i++){
    if(s[i] != 'x') t.push_back(s[i]);
  }

  if(!palindrome(t)){
    cout << -1 << endl;
    return 0;
  }

  int count = 0;
  int i = 0, j = s.length() - 1;
  while(i < j){
    if(s[i] == s[j]){
      ++i;  --j;
    }
    else{
      ++count;
      if(s[j] == 'x') --j;
      else ++i;
    }
  }

  cout << count << endl;

  return 0;
}
