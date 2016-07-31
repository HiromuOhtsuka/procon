#include <iostream>
#include <algorithm>
#include <vector>
#define MAX_N 12
using namespace std;

int N, M;
vector< int > G[MAX_N];

bool connected(int v, int w){
  for(int i = 0; i < G[v].size(); i++){
    if(G[v][i] == w){
      return true;
    }
  }
  return false;
}

int ret(int v){
  int ans = 0;
  for(int i = 0; i < G[v].size(); i++){
    int w = G[v][i];
    vector< int > tmp;
    tmp.push_back(v), tmp.push_back(w);
    bool flag = true;
    while(flag){
      flag = false;
      for(int j = 0; j < N; j++){
        bool c = false;
        for(int k = 0; k < tmp.size(); k++){
          if(tmp[k] == j){
            c = true;
            break;
          }
        }
        if(c){
          continue;
        }
        bool connect = true;
        for(int k = 0; k < tmp.size(); k++){
          if(!connected(tmp[k], j)){
            connect = false;
            break;
          }
        }
        if(connect){
          tmp.push_back(j);
          flag = true;
        }
      }
    }
    if(ans < tmp.size()){
      ans = tmp.size();
    }
  }

  return ans;
}

int main(){
  cin >> N >> M;

  for(int i = 0; i < M; i++){
    int x, y;
    cin >> x >> y;
    x--, y--;
    G[x].push_back(y);  G[y].push_back(x);
  }

  int ans = 0;
  for(int i = 0; i < N; i++){
    ans = max(ans, ret(i));
  }

  if(M == 0){
    cout << 1 << endl;
  }
  else{
    cout << ans << endl;
  }

  return 0;
}
