#include <iostream>
#include <climits>
using namespace std;

int T;

int main(){
  cin >> T;
  for(int i = 0; i < T; i++){
    long long n;
    cin >> n;
    long long j;
    for(j = 1; j <= n; j <<= 1);
    cout << (n * (1 + n)) / 2 - 2 * (j - 1) << endl;
  }
  return 0;
}
