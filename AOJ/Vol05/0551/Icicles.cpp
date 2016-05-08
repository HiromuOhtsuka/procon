#include <iostream>
#include <map>
#include <algorithm>
#include <climits>
#define MAX_N 100000
#define MAX_L 50000
using namespace std;

typedef pair< int, int > P;

int N, L, turara[MAX_N];
P y[MAX_N];
int dp[MAX_N];

int main(){
  cin >> N >> L;
  for(int i = 0; i < N; i++){
    cin >> turara[i];
    y[i] = P(turara[i], i);
  }

  sort(y, y + N);
  dp[y[N - 1].second] = L - y[N - 1].first;
  for(int i = N - 2; i >= 0; i--){
    int l = y[i].second - 1, r = y[i].second + 1;
    if(l >= 0 && r < N && 
      turara[l] > y[i].first && turara[r] > y[i].first){
      dp[y[i].second] = max(dp[l], dp[r]) +
        L - turara[y[i].second];
    }
    else if(l >= 0 && turara[l] > y[i].first){
      dp[y[i].second] = dp[l] + L - turara[y[i].second];
    }
    else if(r < N && turara[r] > y[i].first){
      dp[y[i].second] = dp[r] + L - turara[y[i].second];
    }
    else{
      dp[y[i].second] = L - turara[y[i].second];
    }
  }

  int time = 0;
  for(int i = 0; i < N; i++){
    time = max(time, dp[i]);
  }

  cout << time << endl;

  return 0;
}
