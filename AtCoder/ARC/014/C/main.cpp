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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  string s;
  cin >> n;
  cin >> s;

  deque< char > d;
  d.push_back(s[0]);
  for(int i = 1; i < s.length(); i++){
    if(d.front() == s[i]) d.push_front(s[i]);
    else if(d.back() == s[i]) d.push_back(s[i]);
    else if(i + 1 < s.length()){
      if(s[i + 1] == d.front()) d.push_back(s[i]);
      else if(s[i + 1] == d.back()) d.push_front(s[i]);
      else d.push_back(s[i]);
    }
    else{
      d.push_back(s[i]);
    }
    if(d.size() >= 2 && d[0] == d[1]){
      d.pop_front();  d.pop_front();
    }
    if(d.size() >= 2 && d[d.size() - 1] == d[d.size() - 2]){
      d.pop_back(); d.pop_back();
    }
  }

  cout << d.size() << endl;

  return 0;
}

