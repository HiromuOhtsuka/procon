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

class mystring{
  public:
    string s;

    mystring(string s){
      this->s = s;
    }

    mystring substr(int i, int d){
      string result = s.substr(i, d);
      return mystring(result);
    }

    int length() const{
      return s.length();
    }

    bool operator<(const mystring& other) const{
      if(s == other.s) return false;
      int d = min(s.length(), other.s.length());
      if(s.substr(0, d) == other.s.substr(0, d))
        return s.length() < other.s.length();
      for(int i = 0; i < d; i++){
        if(s[i] < other.s[i]) return true;
      }
      return false;
    }

    bool operator==(const mystring& other) const{
      return s == other.s;
    }
};

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  string ss;
  cin >> ss;
  mystring s(ss);
  int k;
  cin >> k;

  priority_queue< pair< mystring, int >, vector< pair< mystring, int > >, greater< pair< mystring, int > > > que;
  for(int i = 0; i + 1 <= s.length(); i++){
    que.push(make_pair(s.substr(i, 1), i));
  }

  set< mystring > subs;
  while(!que.empty()){
    pair< mystring, int > p = que.top();
    que.pop();
    subs.insert(p.first);
    if(subs.size() >= k) break;
    int len = p.first.length() + 1;
    if(p.second + len <= s.length())
      que.push(make_pair(s.substr(p.second, len), p.second));
  }

  string ans;
  int c = 0;
  for(mystring sub: subs){
    ++c;
    if(c == k){
      ans = sub.s;
      break;
    }
  }

  cout << ans << endl;

  return 0;
}
