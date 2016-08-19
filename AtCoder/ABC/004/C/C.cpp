#include <iostream>
#include <algorithm>
using namespace std;

int N;

int main(){
  cin >> N;

  int c = (N / 5) % 6;
  int tmp[6];
  for(int i = 0; i < 6; i++){
    tmp[i] = ((c + i) % 6) + 1;
  }
  for(int i = 0; i < (N % 5); i++){
    swap(tmp[(i % 5)], tmp[(i % 5) + 1]);
  }

  for(int i = 0; i < 6; i++){
    cout << tmp[i];
  }
  cout << endl;

  return 0;
}
