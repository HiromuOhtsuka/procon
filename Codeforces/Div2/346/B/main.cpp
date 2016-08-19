#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;

int main(){
  int N, M;
  cin >> N >> M;
  vector< pair< int, string > > P[M];
  for(int i = 0; i < N; i++){
    string name;
    int r, score;
    cin >> name >> r >> score;
    --r;
    P[r].push_back(pair< int, string >(score, name));
  }
  for(int i = 0; i < M; i++){
    sort(P[i].begin(), P[i].end());
    int n = P[i].size();
    if(n <= 2 || P[i][n - 2].first > P[i][n - 3].first){
      cout << P[i][n - 1].second << " " << P[i][n - 2].second << endl;
    }
    else{
      cout << "?" << endl;
    }
  }

  return 0;
}
