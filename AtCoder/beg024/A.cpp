#include <cstdio>

int main(){
  int a, b, c, k, s, t;

  scanf("%d %d %d %d", &a, &b, &c, &k);
  scanf("%d %d", &s, &t);

  if((s + t) >= k){
    a -= c;
    b -= c;
  }

  int value = a * s + b * t;
  printf("%d\n", value);

  return 0;
}

