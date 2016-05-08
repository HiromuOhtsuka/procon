#include <iostream>
using namespace std;

int main(){
  int N;
  int num[] = {1, 2, 4, 8};
  int m[4] = {0};
  int sum = 0;

  cin >> N;

  for(int i = 3; i >= 0; i--){
    if(N / num[i]){
      ++sum;
      m[i] = N / num[i];
      N -= num[i] * (N / num[i]);
    }
  }

  cout << sum << endl;
  for(int i = 0; i < 4; i++){
    if(m[i]){
      for(int j = 0; j < m[i]; j++){
        cout << num[i] << endl;
      }
    }
  }

  return 0;
}

