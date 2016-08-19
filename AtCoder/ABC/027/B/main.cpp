#include <cstdio>
#define MAX_N 100

static int N;
static int a[MAX_N];

int main(void){
  scanf("%d", &N);
  int sum = 0;
  for(int i = 0; i < N; ++i){
    scanf("%d", &a[i]);
    sum += a[i];
  }

  if(sum % N != 0){
    printf("-1\n");
    return 0;
  }

  const int ave = sum / N;
  int count = 0, sp = 0;
  while(sp < N){
    if(a[sp] == ave){
      ++sp;
      continue;
    }
    sum = a[sp];
    int diff = 1;
    while(sp + diff < N){
      sum += a[sp + diff];
      if(sum % (diff + 1) == 0 && sum / (diff + 1) == ave){
        break;
      }
      ++diff;
    }
    count += diff;
    sp += diff + 1;
  }

  printf("%d\n", count);

  return 0;
}
