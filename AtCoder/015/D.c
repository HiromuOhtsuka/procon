#include <stdio.h>
#define MAX 50

// 貪欲法
typedef struct _screen_shot {
  int width, price;
} screen_shot;

int W;
int N, K;
screen_shot ss[MAX];
int max;

int cmp1(screen_shot s1, screen_shot s2){
  return s1.price - s2.price;
}

void sort(screen_shot a[], int n, int(*cmp)(screen_shot, screen_shot)){
  int i, j;
  screen_shot tmp;

  for(i=0; i<n; ++i){
    tmp = a[i];
    for(j=i; j-1 >= 0 && cmp(tmp, a[j-1]) >= 0; --j){
      a[j] = a[j-1];
    }
    a[j] = tmp;
  }
}

void search(void){
  int w, i;

  sort(ss, N, cmp1);
  i = -1;
  w = 0;
  max = 0;
  while(1){
    ++i;
    if(i == N){
      break;
    }
    if(w + ss[i].width <= W){
      w += ss[i].width;
      max += ss[i].price;
    }
    else{
      continue;
    }
  }
}

int main(void){
  int i, j;

  scanf("%d", &W);
  scanf("%d %d", &N, &K);
  for(i=0; i<N; ++i){
    scanf("%d %d", &ss[i].width, &ss[i].price);
  }

  search();

  printf("%d\n", max);

  return 0;
}

