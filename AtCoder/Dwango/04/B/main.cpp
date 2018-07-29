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

  int n = s.length();

  if(n % 2 == 1 || s[0] != '2' || s[n - 1] != '5'){
    cout << -1 << endl;
    return 0;
  }

  int two = 0;
  int five = 0;
  for(int i = 0; i < n; i++){
    if(s[i] == '2') ++two;
    if(s[i] == '5') ++five;
  }
  if(two != five){
    cout << -1 << endl;
    return 0;
  }

  vector< int > a;
  for(int i = 0; i < n; i++){
    if(s[i] == '2') a.push_back(2);
    if(s[i] == '5') a.push_back(5);
  }

  int count = 0;
  while(true){
    bool update = false;
    bool turn = true;
    for(int i = 0; i < n; i++){
      char ch = s[i];
      if(ch != '0') update = true;
      if(ch == '0') continue;
      if(turn && ch == '2'){
        s[i] = '0';
        turn = !turn;
      }
      else if(!turn && ch == '5'){
        s[i] = '0';
        turn = !turn;
      }
    }
    if(!update) break;
    ++count;
  }

  cout << count << endl;

  return 0;
}
