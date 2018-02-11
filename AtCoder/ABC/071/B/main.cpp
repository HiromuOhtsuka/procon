#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  string s;
  cin >> s;

  bool exist[26];
  fill(exist, exist + 26, false);
  for(char ch: s){
    exist[ch - 'a'] = true;
  }

  for(char ch = 'a'; ch <= 'z'; ch++){
    if(!exist[ch - 'a']){
      cout << ch << endl;
      return 0;
    }
  }

  cout << "None" << endl;

  return 0;
}
