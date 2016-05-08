#include <cstdio>

int main(){
  int n, s, t, w;

  scanf("%d %d %d", &n, &s, &t);
  scanf("%d", &w);

  int count = 0;
  if(s <= w && w <= t){
    count++;
  }
  for(int i = 1; i < n; i++){
    int a;
    scanf("%d", &a);
    w += a;
    if(s <= w && w <= t){
      ++count;
    }
  }

  printf("%d\n", count);

  return 0;
}

