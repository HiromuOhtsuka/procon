#include <stdio.h>
#define N 300000

int a[N];

int main(void){
  int n, k, i, j, c, s;

  scanf("%d %d", &n, &k);
  for(i=0; i<n; ++i){
    scanf("%d", &a[i]);
  }

  s = 0;
  for(i=0; i<=n-k; ++i){
    c = 0;
    for(j=i; j<i+k-1; ++j){
      if(a[j] < a[j+1]){
        ++c;
      }
      else{
        break;
      }
    }
    if(c == k-1){
      ++s;
    }
  }

  printf("%d\n", s);

  return 0;
}


