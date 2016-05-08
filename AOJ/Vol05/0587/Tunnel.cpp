#include <iostream>
#include <algorithm>
#define MAX_N 10000
using namespace std;

int N, M;

int main(){
  cin >> N;
  cin >> M;

  int S = M, max_s = M;
  for(int i = 0; i < N; i++){
    int in, out;
    cin >> in >> out;
    S = S + in - out;
    if(S < 0){
      cout << "0" << endl;
      return 0;
    }
    max_s = max(max_s, S);
  }

  cout << max_s << endl;

  return 0;
}
