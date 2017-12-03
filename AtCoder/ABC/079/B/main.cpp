#include <iostream>
#define MAX_N 86
using namespace std;

int main(){
  int n;
  cin >> n;
  long long l[MAX_N + 1];
  l[0] = 2;
  l[1] = 1;
  for(int i = 2; i <= MAX_N; i++){
    l[i] = l[i - 1] + l[i - 2];
  }
  cout << l[n] << endl;
  return 0;
}
