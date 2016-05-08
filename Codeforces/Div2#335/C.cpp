#include <iostream>
#include <queue>
#define MAX_N 100000
using namespace std;

int N;

int main(){
  queue< int > que;

  cin >> N;
  for(int i = 0; i < N; i++){
    int p;
    cin >> p;
    que.push(p);
  }

  int count = 0, rank = 1;
  while(!que.empty()){
    int p = que.front(); que.pop();
    if(p > rank){
      ++count;
      que.push(p);
    }
    else{
      rank++;
    }
  }

  cout << count << endl;

  return 0;
}
