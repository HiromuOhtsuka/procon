#include <cstdio>
using namespace std;

static int a1, m1, a2, m2, a3, m3;
static long long GCD(long long a, long long b){
  if(a == 0){
    return b;
  }
  return GCD(b % a, a);
}

int main(){
  for(;;){
    scanf("%d %d %d %d %d %d", &a1, &m1, &a2, &m2, &a3, &m3);

    if(a1 == 0 && m1 == 0 && a2 == 0 && m2 == 0 &&
        a3 == 0 && m3 == 0){
      return 0;
    }

    long long t1 = 0, t2 = 0, t3 = 0, n;
    n = 1;
    while(true){
      n = (a1 * n) % m1;
      ++t1;
      if(n == 1){
        break;
      }
    }
    n = 1;
    while(true){
      n = a2 * n % m2;
      ++t2;
      if(n == 1){
        break;
      }
    }
    n = 1;
    while(true){
      n = a3 * n % m3;
      ++t3;
      if(n == 1){
        break;
      }
    }

    long long tmp = (t1 * t2) / GCD(t1, t2);
    long long ans = (t3 * tmp) / GCD(t3, tmp);

    printf("%llu\n", ans);
  }

  return 0;
}
