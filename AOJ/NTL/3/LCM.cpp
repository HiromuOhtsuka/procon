#include <cstdio>
#include <algorithm>
#define MAX_N 10
using namespace std;

static long long GCD(long long a, long long b){
  if(b == 0){
    return a;
  }
  return GCD(b, a % b);
}

int main(){
  int n;
  scanf("%d", &n);
  long long a0, a1;
  scanf("%llu", &a0);
  long long lcm = 1;
  for(int i = 1; i < n; i++){
    scanf("%llu", &a1);
    long long tmp = (a0 * a1) / GCD(a0, a1);
    lcm = (tmp * lcm) / GCD(tmp, lcm);
    a0 = a1;
  }
  printf("%llu\n", lcm);

  return 0;
}
