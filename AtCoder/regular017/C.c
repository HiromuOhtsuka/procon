#include <stdio.h>
#define N 32

int ans;

void sort(int left, int a[], int right);
void back_track(int a[], int x, int n, int w);

int main(void){
  int n, x, i;
  int w[N];

  scanf("%d %d", &n, &x);
  for(i=0; i<n; ++i){
    scanf("%d", &w[i]);
  }

  sort(0, w, n-1);

  /*putchar('{');
  for(i=0; i<n; ++i){
    printf("%d ", w[i]);
  }
  putchar('}');
  */
  ans = 0;
  back_track(w, x, n, 0);

  printf("%d\n", ans);

  return 0;
}

void back_track(int a[], int x, int n, int w){
  int i;

  if(w > x){
    return;
  }
  if(w == x){
    ++ans;
    return;
  }

  for(i=0; i<n; ++i){
    printf("x : %d n : %d w : %d w + a[%d] : %d\n", x, n, w, i, w+a[i]);
    back_track(a, x, n, w+a[i]);
  }

}

void sort(int left, int a[], int right){
  int base, mid_i, i, j, tmp;

  if(left >= right){
    return;
  }

  mid_i = (left + right) / 2;
  base = a[mid_i];
  i = left;
  j = right;

  while(i < j){
    while(a[i] <= base){
      ++i;
    }
    while(a[j] >= base){
      --j;
    }
    if(i < j){
      tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
      ++i, --j;
    }
  }

  if(i == j){
    if(a[i] <= base){
      ++i;
    }
    if(a[j] >= base){
      --j;
    }
  }

  sort(left, a, j);
  sort(i, a, right);
}
