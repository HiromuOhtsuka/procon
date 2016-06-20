#include <cstdio>
#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <set>
using namespace std;

int n;
vector< string > ans;
priority_queue< int, vector< int >, greater< int > > pq;
multiset< int > s;

int main(){
  scanf("%d", &n);

  for(int i = 0; i < n; i++){
    int opNum = 0;
    char tmp[128];
    scanf("%s", tmp);
    string op(tmp);
    if(op.compare("insert") == 0 || op.compare("getMin") == 0){
      scanf("%d", &opNum);
    }
    if(op.compare("insert") == 0){
      pq.push(opNum);
      s.insert(opNum);
      ans.push_back(op + " " + to_string(opNum));
    }
    if(op.compare("removeMin") == 0){
      if(pq.empty()){
        ans.push_back("insert 1");
        ans.push_back("removeMin");
      }
      else{
        s.erase(pq.top());
        pq.pop();
        ans.push_back("removeMin");
      }
    }

    if(op.compare("getMin") == 0){
      if(s.count(opNum) == 0){
        pq.push(opNum);
        s.insert(opNum);
        ans.push_back("insert " + to_string(opNum));
      }
      while(pq.top() != opNum){
        s.erase(pq.top());
        pq.pop();
        ans.push_back("removeMin");
      }
      ans.push_back("getMin " + to_string(opNum));
    }
  }

  cout << ans.size() << endl;
  for(int i = 0; i < ans.size(); i++){
    printf("%s\n", ans[i].c_str());
  }

  return 0;
}
