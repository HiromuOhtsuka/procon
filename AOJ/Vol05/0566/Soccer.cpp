#include <iostream>
#include <map>
#include <algorithm>
#define MAX_N 100
using namespace std;

typedef pair<int, int > P;

int N;
P score[MAX_N];
int rank[MAX_N];

int main(){
  cin >> N;
  for(int i = 0; i < N * (N - 1) / 2; i++){
    int a, b, c, d;
    cin >> a >> b >> c >> d;
    a--, b--;
    if(c > d){
      score[a] = P(score[a].first + 3, a);
      score[b] = P(score[b].first + 0, b);
    }
    else if(c < d){
      score[a] = P(score[a].first + 0, a);
      score[b] = P(score[b].first + 3, b);
    }
    else{
      score[a] = P(score[a].first + 1, a);
      score[b] = P(score[b].first + 1, b);
    }
  }

  sort(score, score + N);
  rank[score[N - 1].second] = 1;
  int r = 1, count = 0;
  for(int i = N - 2; i >= 0; i--){
    if(score[i].first == score[i + 1].first){
      count++;
    }
    else{
      r += count + 1;
      count = 0;
    }
    rank[score[i].second] = r;
  }

  for(int i = 0; i < N; i++){
    cout << rank[i] << endl;
  }

  return 0;
}
