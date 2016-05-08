#include <iostream>
#include <algorithm>
using namespace std;

int A, D;

int main(){
  cin >> A >> D;

  cout << max((A + 1) * D, A * (D + 1)) << endl;

  return 0;
}
