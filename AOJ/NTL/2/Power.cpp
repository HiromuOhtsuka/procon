#include <cstdio>
using namespace std;

int main(){
  int m, n;
  scanf("%d %d", &m, &n);

  long long p = 1, x = m;
  while(n > 0){
    if(n & 1){
      p = p * x % 1000000007;
    }
    x = x * x % 1000000007;
    n >>= 1;
  }
  printf("%llu\n", p);

  return 0;
}
