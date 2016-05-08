#include <iostream>
using namespace std;

long long  N, M, P;

long long pow_mod(long long n, long long p, long long m){
  long long ret = 1;
  for( ; p > 0; p >>= 1){
    if(p & 1){
      ret = ret * n % m;
    }
    n = (n * n) % m;
  }
  return ret;
}

int main(){
  cin >> N >> M >> P;
  
  long long ans = pow_mod(N, P, M);
  cout << ans << endl;

  return 0;
}
