#include <iostream>
using namespace std;

int N;

int main(){
  cin >> N;

  double ave = 0.0, div = (double)(1.0 / N);
  for(int i = 0; i < N; i++){
    ave += (double)(i + 1) * 10000.0 * div;
  }

  cout << (int)ave << endl;

  return 0;
}
